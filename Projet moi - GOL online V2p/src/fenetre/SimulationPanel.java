package fenetre;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import elements.AmmasCellulaire;
import elements.Cellule;
import elements.GrilleFenetre;
import math_util.Position;

@SuppressWarnings("serial")
public class SimulationPanel extends JPanel implements Runnable, MouseListener {
	private AmmasCellulaire groupe;
	private BufferedImage background;
	private BufferedImage boutonPausePlay;
	private int tailleFenetre;
	private int tailleCarrer;
	private boolean fin = false;
	private boolean pause = false;

	public SimulationPanel(AmmasCellulaire a, int tailleFenetre, int tailleCarrer) {
		this.groupe = a;
		this.tailleFenetre = tailleFenetre;
		this.tailleCarrer = tailleCarrer;
		this.addMouseListener(this);

		try {
			this.background = ImageIO.read(new File("resources/background.png"));
			this.modifierAffichageBouton();
		} catch (IOException e) {
			System.out.println("[SimulationPanel>39]  aucune image");
		}

	}

	// modifie l'image a afficher pour le bouton en haut a gauche aka bouton pause/play
	private void modifierAffichageBouton() {
		try {
			if (this.pause) {
				this.boutonPausePlay = ImageIO.read(new File("resources/boutonplay.png"));
			} else {
				this.boutonPausePlay = ImageIO.read(new File("resources/boutonpause.png"));
			}
		} catch (IOException e) {
			System.out.println("[SimulationPanel>53]  aucune image");
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.background, 0, 0, this.tailleFenetre, this.tailleFenetre, null);

		LinkedList<Cellule> cellulesAAfficher = this.getGroupeCellule();
		GrilleFenetre grille = new GrilleFenetre(this.tailleFenetre, this.tailleCarrer);
		LinkedList<Position> positionsAAfficher = grille.getPositionAAfficher(cellulesAAfficher);

		for (Position p : positionsAAfficher) {
			g.setColor(Color.BLACK);
			g.fillRect(p.getX(), p.getY(), this.tailleCarrer, this.tailleCarrer);
		}
		g.drawImage(this.boutonPausePlay, 0, 0, this.boutonPausePlay.getWidth(), this.boutonPausePlay.getHeight(),null);

	}

	// permet de recuperer toute les Cellules en prenant compte des probleme de concurrence d'acces aux donnees
	private LinkedList<Cellule> getGroupeCellule() {
		LinkedList<Cellule> groupeCellules = null;
		try {
			groupeCellules = this.groupe.getCellules();
		} catch (ConcurrentModificationException e) {
			try {Thread.sleep(20);} catch (Exception e1) {}
			this.getGroupeCellule();
		}
		return (groupeCellules);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (this.clickZoneBoutons(e)) {
			this.pause = !this.pause;
			this.modifierAffichageBouton();
		} else {
			Position nouvelleCellulePosition = this.getPositionDepuisSouris(e);

			GrilleFenetre g = new GrilleFenetre(this.tailleFenetre, this.tailleCarrer);
			Cellule c = new Cellule(g.getPositionGrille(nouvelleCellulePosition));

			if (this.groupe.contiensCellule(c))
				this.groupe.retirer(c);
			else
				this.groupe.ajouteCellule(c);

			this.repaint();
		}
	}

	// transforme l'evenement MouseEvent en position pour la cellule
	private Position getPositionDepuisSouris(MouseEvent e) {
		int x = (int) e.getPoint().getX();
		int y = (int) e.getPoint().getY();
		return (new Position(x, y));
	}

	// permet d'intercepter un click de souris
	private boolean clickZoneBoutons(MouseEvent e) {
		boolean x = e.getPoint().getX() <= this.boutonPausePlay.getWidth() && e.getPoint().getX() >= 0;
		boolean y = e.getPoint().getY() <= this.boutonPausePlay.getHeight() && e.getPoint().getY() >= 0;

		return (x && y);
	}

	// permet de bouger une fois toutes les cellules
	public void bouger() {
		boolean etatSimulation = this.groupe.generationSuivante();
		this.repaint();
		this.fin = etatSimulation;
	}

	public boolean getFin() {
		return (this.fin);
	}

	@Override
	public void run() {
		if (!this.pause) {
			this.bouger();
		} else {
			while (this.pause)
				try {Thread.sleep(20);} catch (InterruptedException e) {}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
