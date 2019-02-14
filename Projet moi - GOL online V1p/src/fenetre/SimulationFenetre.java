package fenetre;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;
import elements.AJoutCellule;
import elements.AmmasCellulaire;

@SuppressWarnings("serial")
public class SimulationFenetre extends JFrame implements Runnable {
	private SimulationPannel panel;
	private int delayMS;

	public SimulationFenetre(int tailleFenetre, int tailleCarrer, int delay, boolean celluleRandomDebut) {
		super();
		this.delayMS = delay;

		AmmasCellulaire listeCellule = new AmmasCellulaire();
		if (celluleRandomDebut) {
			AJoutCellule.random(listeCellule, tailleFenetre, tailleCarrer);
			System.out.println("affichage random choisi");
		} else {
			try {
				AJoutCellule.recuperationFichier(listeCellule);
			} catch (IOException e) {
				System.out.println("ici on fait de la politique, vous avez choisi \"pas random\" mais y'a pas. \n\tdonc ca seras random");
				AJoutCellule.random(listeCellule, tailleFenetre, tailleCarrer);
			}
		}

		creationFenetre(tailleFenetre, tailleCarrer, listeCellule);
	}

	// permet d'alleger le constructeur
	private void creationFenetre(int tailleFenetre, int tailleCarrer, AmmasCellulaire listeCellule) {
		this.panel = new SimulationPannel(listeCellule, tailleFenetre, tailleCarrer);
		this.panel.setPreferredSize(new Dimension(tailleFenetre, tailleFenetre));
		this.panel.setBackground(Color.WHITE);
		this.setContentPane(this.panel);

		this.setResizable(false);
		// this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("GOL online - simulation");
		this.setSize(new Dimension(tailleFenetre, tailleFenetre));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	// lance l'animation en boucle avec le delai choisi jusqu'a ce que plus aucune cellule ne bouge
	private void lancerAnimation() throws InterruptedException {
		boolean fin = false;
		int toursExecution = 0;

		while (!fin) {
			fin = this.panel.bouger();

			toursExecution++;
			this.setTitle("GOL online - simulation - " + toursExecution);
			Thread.sleep(this.delayMS);
			this.panel.repaint();
		}
		this.setTitle("GOL online - simulation - fini - " + toursExecution);
		System.out.println("fin de la simulation, et merci d'avoir lance le programme dans la console !");
	}

	// lancement de la simulation avec le thread
	public void run() {
		try {this.lancerAnimation();} catch (InterruptedException e) {}
	}
}