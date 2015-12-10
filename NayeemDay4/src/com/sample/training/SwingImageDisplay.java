package com.sample.training;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class SwingImageDisplay extends JFrame implements ActionListener {

	private static final long serialVersionUID = -6299511919632872283L;
	JFileChooser choose = new JFileChooser("D:\\");

	public SwingImageDisplay() throws HeadlessException {
		super();
		choose.addActionListener(this);
		choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
		add(choose);
		setVisible(true);
		setSize(300, 300);
	}

	public static void main(String[] args) {
		new SwingImageDisplay();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JFileChooser) {
		}
	}
}
