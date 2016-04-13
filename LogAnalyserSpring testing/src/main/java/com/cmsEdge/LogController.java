package com.cmsEdge;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cmsEdge.Beans.LogProccessBean;
import com.cmsEdge.Dao.InsertLogRecordsImpl;
import com.cmsEdge.LogProccess.LogProccess;
import com.cmsEdge.Util.LogUtil;
import com.cmsEdge.view.ErrorViewer;
import com.cmsEdge.view.MyDbPdfView;

import net.sf.jasperreports.engine.JRResultSetDataSource;

@Controller
public class LogController {
	@Autowired
	private LogProccess vgnVcmLogLogProccessImpl;
	@Autowired
	private ErrorViewer errorViewerImpl;
	@Autowired
	private InsertLogRecordsImpl insertLogRecordsImpl;
	@Autowired
	private MyDbPdfView retrieve;
	private static Logger logger = Logger.getLogger(LogController.class.getName());

	@RequestMapping(value = "log", method = RequestMethod.GET)
	public ModelAndView getLog() {
		logger.info("home page is loaded successfully");
		return new ModelAndView("home");
	}

	@RequestMapping(value = "LogProccess", method = RequestMethod.POST)
	public ModelAndView getLogproccess(@Valid @ModelAttribute LogProccessBean proccessBean, BindingResult bindingResult, HttpSession session) {
		if (bindingResult.hasErrors()) {
			String error = "Some error has been occured. Please resubmit form values";
			return new ModelAndView("home", "error", error);
		}

		if (proccessBean.getUploadFile().getSize() != 0) {
			try {
				@SuppressWarnings("resource")
				FileOutputStream fileOutputStream = new FileOutputStream(
						"E:/upload/" + proccessBean.getUploadFile().getOriginalFilename());
				fileOutputStream.write(proccessBean.getUploadFile().getBytes());
				logger.info("File has been uploaded succeessfully");
			} catch (Exception e) {
				logger.error("Error occured in file uploding proccess", e);
			}
		}
		LogUtil.getLogBean().setSourceFileName(proccessBean.getUploadFile().getOriginalFilename());
		String logname=proccessBean.getLogname();
		session.setAttribute("logname", logname);

		String errFile = vgnVcmLogLogProccessImpl.execute(proccessBean.getDtUploadFile(), proccessBean.getLogname());
		ModelAndView modelAndView = new ModelAndView("viewAllErrors");
		modelAndView.addObject("errFile", errFile);
		return modelAndView;

	}

	@RequestMapping(value = "insert")
	public ModelAndView insertRecords(HttpSession session) {
		ArrayList<String> RecordsList = errorViewerImpl.execute(session);
		insertLogRecordsImpl.insertLog(RecordsList,session);

		return new ModelAndView("success");

	}

	@RequestMapping("retrieve")
	public ModelAndView retrieveRecords(HttpServletResponse response,HttpSession session)throws Exception {
		JRResultSetDataSource ds=null;
		Map map=null;
		try {
			MyDbPdfView m=	new MyDbPdfView();
			 ds=m.readDbLogs(response,session);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("pdfReport","ds",ds);

	}

	@RequestMapping("pdf")
	public ModelAndView pdfResponse(HttpSession session) {
		ArrayList<String> tokenList = errorViewerImpl.execute(session);
		logger.info("pdf proccess has been started");

		return new ModelAndView("pdf", "tokentlist", tokenList);
	}

	/*@RequestMapping("vgninstpdf")
	public ModelAndView vgninstpdfpdfResponse() {
		ArrayList<String> tokenList = errorViewerImpl.execute();
		logger.info("pdf proccess has been started");

		return new ModelAndView("vgninstpdf", "tokentlist", tokenList);
	}*/

	/*@RequestMapping("excel")
	public ModelAndView excelResponse() {
		ArrayList<String> tokenList = errorViewerImpl.execute();
		logger.info("Excel proccess has been started");
		return new ModelAndView("excel", "tokentlist", tokenList);
	}*/

	public InsertLogRecordsImpl getInsertLogRecordsImpl() {
		return insertLogRecordsImpl;
	}

	public void setInsertLogRecordsImpl(InsertLogRecordsImpl insertLogRecordsImpl) {
		this.insertLogRecordsImpl = insertLogRecordsImpl;
	}

	public MyDbPdfView getRetrieve() {
		return retrieve;
	}

	public void setRetrieve(MyDbPdfView retrieve) {
		this.retrieve = retrieve;
	}

}
