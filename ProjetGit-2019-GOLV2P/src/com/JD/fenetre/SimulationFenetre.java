package com.JD.fenetre;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;

import com.JD.core.AJoutCellule;
import com.JD.core.AmmasCellulaire;

@SuppressWarnings("serial")
public class SimulationFenetre extends JFrame implements Runnable {
	private SimulationPanel simulationPanel;
	private int delayMS;

	public SimulationFenetre(int tailleFenetre, int tailleCarre, int delayMiliSecond,
			boolean positionementCelluleRandom) {
		super();
		this.delayMS = delayMiliSecond;
		AmmasCellulaire ammasCellulaire = new AmmasCellulaire();

		// choix de l'option "positionement random"
		if (positionementCelluleRandom) {
			AJoutCellule.positionementRandomCellules(ammasCellulaire, tailleFenetre, tailleCarre);
			System.out.println("[SimulationFenetre>24]  affichage random choisi");
		} else {
			try {
				AJoutCellule.recuperationFichier(ammasCellulaire);
			} catch (IOException e) {
				System.out.println("[SimulationFenetre>29]  ici on fait de la politique, vous avez choisi \"pas random\" mais y'a pas. \n[SimulationFenetre>29]  \tdonc ca sera random");
				AJoutCellule.positionementRandomCellules(ammasCellulaire, tailleFenetre, tailleCarre);
			}
		}

		this.simulationPanel = new SimulationPanel(ammasCellulaire, tailleFenetre, tailleCarre);
		this.simulationPanel.setPreferredSize(new Dimension(tailleFenetre, tailleFenetre));
		this.simulationPanel.setBackground(Color.WHITE);
		this.setContentPane(this.simulationPanel);

		this.setResizable(false);
		// this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("GOL online V2 - simulation");
		this.setSize(new Dimension(tailleFenetre, tailleFenetre));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	// lance l'animation en boucle avec le delai choisi jusqu'a ce que plus aucune cellule ne bouge
	// (ne prend pas en compte les planeur et autre objet stationnaire a plus d'un etat :/)
	private void lancerAnimation() {
		int tours = 0;

		// j'adore les thread
		Thread threadSimulation = null;
		while (!this.simulationPanel.getFin()) {
			threadSimulation = new Thread(this.simulationPanel);
			threadSimulation.start();
			while (threadSimulation.isAlive()) {
				try {Thread.sleep(20);} catch (Exception e1) {}
			}

			tours++;
			this.setTitle("GOL online V2 - simulation - " + tours);
			try {Thread.sleep(this.delayMS);} catch (InterruptedException e) {}
			this.simulationPanel.repaint();
		}
		this.setTitle("GOL online V2 - simulation - fini - " + tours);
		System.out.println("[SimulationFenetre>73]  fin de la simulation, et merci d'avoir lance le programme dans la console !");
	}

	// lancement de la simulation avec le thread
	public void run() {
		this.lancerAnimation();
	}
}