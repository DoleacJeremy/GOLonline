package fenetre;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import elements.AmmasCellulaire;
import elements.Cellule;
import elements.GrilleFenetre;
import math_util.Position;

@SuppressWarnings("serial")
public class SimulationPannel extends JPanel {
	private AmmasCellulaire listeCellule;
	private BufferedImage background;
	private int tailleFenetre;
	private int tailleCarrer;

	public SimulationPannel(AmmasCellulaire a, int tailleFenetre, int tailleCarrer) {
		this.listeCellule = a;
		this.tailleFenetre = tailleFenetre;
		this.tailleCarrer = tailleCarrer;

		try {
			this.background = ImageIO.read(new File("resources/background_simulation.png"));
		} catch (IOException e) {
			System.out.println("ha pas image");
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.background, 0, 0, this.tailleFenetre, this.tailleFenetre, null);

		LinkedList<Cellule> cellules = (LinkedList<Cellule>) this.listeCellule.getCellules();

		GrilleFenetre grille = new GrilleFenetre(this.tailleFenetre, this.tailleCarrer);
		LinkedList<Position> positions = grille.getPosition(cellules);

		for (Position p : positions) {
			g.setColor(Color.BLACK);
			g.fillRect(p.getX(), p.getY(), this.tailleCarrer, this.tailleCarrer);
		}
	}

	// permet de creer la generation suivante
	public boolean bouger() {
		boolean retour = this.listeCellule.generationSuivante();
		this.repaint();
		return (retour);
	}
}