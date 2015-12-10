package com.sample.training;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingCalculator extends JFrame implements ActionListener {

	private static final long serialVersionUID = 7615159940148598073L;

	Label lblInpA = new Label("First Number");
	JLabel lblInpB = new JLabel("Second Number");
	JTextField txtInpA = new JTextField();
	TextField txtInpB = new TextField();
	JLabel lblOp = new JLabel("Select Operation");
	JComboBox<String> chOp = new JComboBox<String>();
	JLabel lblRes = new JLabel("Result");
	JTextField txtRes = new JTextField();
	JButton btnCalc = new JButton("Calculate");
	JButton btnHide = new JButton("Hide Result");

	public SwingCalculator() throws HeadlessException {
		super();
		chOp.addItem("1-Add");
		chOp.addItem("2-Sub");
		chOp.addItem("3-Mul");
		chOp.addItem("4-Div");
		chOp.addItem("5-Mod");
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
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("Close Event");
				System.exit(0);
			}

		});
	}

	public static void main(String[] args) {
		new SwingCalculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Calculate")) {
			Calculator calc = new Calculator(Integer.parseInt(txtInpA.getText()), Integer.parseInt(txtInpB.getText()),
					Integer.parseInt(chOp.getSelectedItem().toString().split("-")[0]));
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
