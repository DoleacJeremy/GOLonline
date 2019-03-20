package fenetre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class ParamPanel extends JPanel implements ActionListener {
	private BufferedImage imageBackground;

	private JTextArea texteTaille;
	private JTextArea texteTailleCarrer;
	private JTextArea texteDelay;
	private JCheckBox celluleRandom;

	public ParamPanel() {
		try {
			this.imageBackground = ImageIO.read(new File("resources/background_param.png"));
		} catch (IOException e) {
			System.out.println("[ParamPanel>31]     erreur de recuperation de l'image du background");
		}

		// taille de la fenetre
		this.texteTaille = new JTextArea();
		this.texteTaille.setPreferredSize(new Dimension(50, 20));
		this.texteTaille.setText("600");
		JTextPane infoTaille = new JTextPane();
		infoTaille.setText("taille fenetre (nombre) =>");
		infoTaille.setPreferredSize(new Dimension(200, 20));
		this.add(infoTaille);
		this.add(this.texteTaille);

		// taille d'une cellule aka zoom
		this.texteTailleCarrer = new JTextArea();
		this.texteTailleCarrer.setPreferredSize(new Dimension(50, 20));
		this.texteTailleCarrer.setText("5");
		JTextPane infoTailleCarrer = new JTextPane();
		infoTailleCarrer.setText("niveau de zoom (nombre) =>");
		infoTailleCarrer.setPreferredSize(new Dimension(205, 20));
		this.add(infoTailleCarrer);
		this.add(this.texteTailleCarrer);

		// delay entre deux generation aka vitesse
		this.texteDelay = new JTextArea();
		this.texteDelay.setPreferredSize(new Dimension(50, 20));
		this.texteDelay.setText("50");
		JTextPane infoDelay = new JTextPane();
		infoDelay.setText("delai en ms (nombre) =>");
		infoDelay.setPreferredSize(new Dimension(205, 20));
		this.add(infoDelay);
		this.add(this.texteDelay);

		// generation aleatoire des cellules ou lecture depuis un fichier
		this.celluleRandom = new JCheckBox();
		this.celluleRandom.setSelected(true);
		JTextPane infocasebox = new JTextPane();
		infocasebox.setText("positionement random =>");
		infocasebox.setPreferredSize(new Dimension(180, 20));
		this.add(infocasebox);
		this.add(this.celluleRandom);

		// vide
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(390, 220));
		this.add(panel);

		JPanel panel2 = new JPanel();
		panel2.setOpaque(false);
		panel2.setPreferredSize(new Dimension(260, 10));
		this.add(panel2);

		// bouton valider
		JButton boutonValidation = new JButton();
		boutonValidation.setPreferredSize(new Dimension(100, 30));
		boutonValidation.setText("valider");
		boutonValidation.addActionListener(this);
		this.add(boutonValidation);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imageBackground, 0, 0, 400, 400, null);
	}

	// methode qui intercepte l'appui sur le bouton aka le lancement de la simulation
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int taille = 600;
		int tailleCarrer = 5;
		int delay = 50;
		boolean affichageRandom = this.celluleRandom.isSelected();

		boolean validationLancementFenetre = true;

		// test de la validite des champs
		this.texteTaille.setBackground(Color.WHITE);
		try {
			taille = Integer.parseInt(this.texteTaille.getText());
			if (taille < 400)
				throw new Exception();
		} catch (Exception e) {
			this.texteTaille.setBackground(Color.RED);
			validationLancementFenetre = false;
		}
		this.texteTailleCarrer.setBackground(Color.WHITE);
		try {
			tailleCarrer = Integer.parseInt(this.texteTailleCarrer.getText());
			if (tailleCarrer < 1)
				throw new Exception();
		} catch (Exception e) {
			this.texteTailleCarrer.setBackground(Color.RED);
			validationLancementFenetre = false;
		}
		this.texteDelay.setBackground(Color.WHITE);
		try {
			delay = Integer.parseInt(this.texteDelay.getText());
			if (delay < 15)
				throw new Exception();
		} catch (Exception e) {
			this.texteDelay.setBackground(Color.RED);
			validationLancementFenetre = false;
		}

		if (validationLancementFenetre) {
			SimulationFenetre fenetre = new SimulationFenetre(taille, tailleCarrer, delay, affichageRandom);
			new Thread(fenetre).start();
		}

	}

}