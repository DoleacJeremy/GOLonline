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
	private BufferedImage backgroundImage;

	private JTextArea texteTaille;
	private JTextArea texteTailleCarrer;
	private JTextArea texteDelay;
	private JCheckBox casebox;

	private JButton bouton;

	public ParamPanel() {
		try {
			this.backgroundImage = ImageIO.read(new File("resources/background_param.png"));
		} catch (IOException e) {
			System.out.println("erreur de recuperation de l'image du background");
		}

		declarationComposants();

		// vide
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(390, 220));
		this.add(panel);

		JPanel panel2 = new JPanel();
		panel2.setOpaque(false);
		panel2.setPreferredSize(new Dimension(260, 10));
		this.add(panel2);

		// bouton
		this.bouton = new JButton();
		this.bouton.setPreferredSize(new Dimension(100, 30));
		this.bouton.setText("valider");
		this.bouton.addActionListener(this);
		this.add(this.bouton);

	}

	// cree et met le texte des composants qui sont dans la fenetre
	private void declarationComposants() {
		// taille
		this.texteTaille = new JTextArea();
		this.texteTaille.setPreferredSize(new Dimension(50, 20));
		this.texteTaille.setText("600");
		
		JTextPane infoTaille = new JTextPane();
		infoTaille.setText("taille fenetre (nombre) =>");
		infoTaille.setPreferredSize(new Dimension(200, 20));
		
		this.add(infoTaille);
		this.add(this.texteTaille);

		// molecule
		this.texteTailleCarrer = new JTextArea();
		this.texteTailleCarrer.setPreferredSize(new Dimension(50, 20));
		this.texteTailleCarrer.setText("5");
		JTextPane infoTailleCarrer = new JTextPane();
		infoTailleCarrer.setText("niveau de zoom (nombre) =>");
		infoTailleCarrer.setPreferredSize(new Dimension(205, 20));
		this.add(infoTailleCarrer);
		this.add(this.texteTailleCarrer);

		// delay
		this.texteDelay = new JTextArea();
		this.texteDelay.setPreferredSize(new Dimension(50, 20));
		this.texteDelay.setText("50");
		JTextPane infoDelay = new JTextPane();
		infoDelay.setText("delai en ms (nombre) =>");
		infoDelay.setPreferredSize(new Dimension(205, 20));
		this.add(infoDelay);
		this.add(this.texteDelay);

		// situation generer aleatoirement ou predefinie (fichier)
		this.casebox = new JCheckBox();
		this.casebox.setSelected(true);
		JTextPane infocasebox = new JTextPane();
		infocasebox.setText("positionement random =>");
		infocasebox.setPreferredSize(new Dimension(180, 20));
		this.add(infocasebox);
		this.add(this.casebox);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.backgroundImage, 0, 0, 400, 400, null);
	}

	// methode qui intercepte l'appui sur le bouton aka le lancement de la simulation
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int taille = 600;
		int tailleCarrer = 5;
		int delay = 50;
		boolean affichageRandom = this.casebox.isSelected();

		boolean validationLancementFenetre = true;

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
			String infos = this.texteTaille.getText() + "\n";
			infos += this.texteTailleCarrer.getText() + " molecules\n";
			infos += this.texteDelay.getText() + " delai en ms\n";
			infos += "affichage simpliste : " + this.casebox.isSelected();

			System.out.println("infos recueillies : \n" + infos);

			SimulationFenetre fenetre = new SimulationFenetre(taille, tailleCarrer, delay, affichageRandom);
			new Thread(fenetre).start();
		}

	}

}