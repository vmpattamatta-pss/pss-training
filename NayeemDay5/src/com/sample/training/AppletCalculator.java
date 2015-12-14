package com.sample.training;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppletCalculator extends Applet implements ActionListener {

	private static final long serialVersionUID = -5650197398305180504L;
	Label lblInpA = new Label("First Number");
	Label lblInpB = new Label("Second Number");
	TextField txtInpA = new TextField();
	TextField txtInpB = new TextField();
	Label lblOp = new Label("Select Operation");
	Choice chOp = new Choice();
	Label lblRes = new Label("Result");
	TextField txtRes = new TextField();
	Button btnCalc = new Button("Calculate");
	Button btnHide = new Button("Hide Result");

	@Override
	public void init() {
		chOp.add("1-Add");
		chOp.add("2-Sub");
		chOp.add("3-Mul");
		chOp.add("4-Div");
		chOp.add("5-Mod");
		btnCalc.addActionListener(this);
		btnHide.addActionListener(this);
		setLayout(new GridLayout(5, 2));
		add(lblInpA);
		add(txtInpA);
		add(lblInpB);
		add(txtInpB);
		add(lblOp);
		add(chOp);
		add(btnCalc);
		add(btnHide);
		setVisible(true);
		setSize(300, 300);
		super.init();
	}

	@Override
	public void start() {
		super.start();
	}

	@Override
	public void stop() {
		super.stop();
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Calculate")) {
			Calculator calc = new Calculator(Integer.parseInt(txtInpA.getText()), Integer.parseInt(txtInpB.getText()),
					Integer.parseInt(chOp.getSelectedItem().split("-")[0]));
			txtRes.setText(String.valueOf(calc.calculate()));
			add(lblRes);
			add(txtRes);
			repaint();
		} else if (e.getActionCommand().equalsIgnoreCase("Hide Result")) {
			remove(lblRes);
			remove(txtRes);
			repaint();
		}
	}

}
