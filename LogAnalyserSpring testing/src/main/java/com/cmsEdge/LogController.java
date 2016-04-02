package com.cmsEdge;

import java.io.FileOutputStream;
import java.util.ArrayList;
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

@Controller
public class LogController {
	@Autowired
	private  LogProccess vgnVcmLogLogProccessImpl;
	@Autowired
	private ErrorViewer errorViewerImpl;
	@Autowired
	private InsertLogRecordsImpl insertLogRecordsImpl;

	private static Logger logger = Logger.getLogger(LogController.class.getName());

	@RequestMapping(value = "log", method = RequestMethod.GET)
	public ModelAndView getLog() {
		logger.info("home page is loaded successfully");
		return new ModelAndView("home");
	}

	@RequestMapping(value = "LogProccess", method = RequestMethod.POST)
	public ModelAndView getLogproccess(@ModelAttribute LogProccessBean proccessBean, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			String error="Some error has been occured. Please resubmit form values";
			return new ModelAndView("home","error",error);
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
		String errFile = vgnVcmLogLogProccessImpl.execute(proccessBean.getDtUploadFile());
		ModelAndView modelAndView = new ModelAndView("viewAllErrors");
		modelAndView.addObject("errFile", errFile);
		return modelAndView;

	}
	@RequestMapping(value="insert")
	public ModelAndView insertRecords(){
		ArrayList<String> RecordsList = errorViewerImpl.execute();
		insertLogRecordsImpl.insertLog(RecordsList);
		
		return new ModelAndView("success");

		
	}

	@RequestMapping("pdf")
	public ModelAndView pdfResponse() {
		ArrayList<String> tokenList = errorViewerImpl.execute();
		logger.info("pdf proccess has been started");

		return new ModelAndView("pdf", "tokentlist", tokenList);
	}

	@RequestMapping("excel")
	public ModelAndView excelResponse() {
		ArrayList<String> tokenList = errorViewerImpl.execute();
		logger.info("Excel proccess has been started");
		return new ModelAndView("excel", "tokentlist", tokenList);
	}

	public InsertLogRecordsImpl getInsertLogRecordsImpl() {
		return insertLogRecordsImpl;
	}

	public void setInsertLogRecordsImpl(InsertLogRecordsImpl insertLogRecordsImpl) {
		this.insertLogRecordsImpl = insertLogRecordsImpl;
	}

}
