package com.JD.fenetre;

import java.awt.Dimension;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ParamFenetre extends JFrame {

	public ParamFenetre() {
		ParamPanel paramPanel = new ParamPanel();
		paramPanel.setPreferredSize(new Dimension(400, 400));
		this.setContentPane(paramPanel);

		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("GOL online - parametrage");
		this.setSize(new Dimension(400, 400));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}