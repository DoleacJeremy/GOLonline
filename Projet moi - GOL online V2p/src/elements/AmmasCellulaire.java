package elements;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AmmasCellulaire implements Runnable {
	private HashMap<String, Cellule> listeCellule;

	public AmmasCellulaire() {
		this.listeCellule = new HashMap<String, Cellule>();
	}

	// permet de calculer la generation suivante
	public boolean generationSuivante() {
		// recuperation des cellules a garder ou supprimer
		List<Cellule> cellulesARetirer = this.getCellulesARetirer();
		List<Cellule> cellulesAAjouter = this.getCelluleAAjouter();

		// application du resultat
		boolean finAjout = this.ajouterCellules(cellulesAAjouter);
		boolean finRetrait = this.retirerCellules(cellulesARetirer);
		
		return (finAjout && finRetrait);
	}

	// obtiens le nombre de voisines existantes dans la liste de cellule
	private int getNbVoisines(Cellule c) {
		int nbVoisines = 0;

		try {
			for (Cellule cell : c.getVoisines())
				if (this.contiensCellule(cell))
					nbVoisines++;
		} catch (ConcurrentModificationException e) {
			try {Thread.sleep(20);} catch (InterruptedException e1) {}
			nbVoisines = this.getNbVoisines(c);
		}

		return (nbVoisines);
	}

	// recupere la liste de cellules
	public LinkedList<Cellule> getCellules() {
		LinkedList<Cellule> retour = new LinkedList<Cellule>();

		try {
			for (Cellule c : this.listeCellule.values())
				retour.add(c);
		} catch (ConcurrentModificationException e) {
			try {Thread.sleep(20);} catch (InterruptedException e1) {}
			retour = this.getCellules();
		}

		return (retour);
	}

	// permet de dire si une cellule existe deja
	public boolean contiensCellule(Cellule c) {
		boolean retour = false;
		try {
			retour = this.listeCellule.containsKey(c.generationClef());
		} catch (ConcurrentModificationException e) {
			try {Thread.sleep(20);} catch (InterruptedException e1) {}
			retour = this.contiensCellule(c);
		}
		return (retour);
	}

	// obtiens la liste des cellules a retirer pour cette generation
	public List<Cellule> getCellulesARetirer() {
		List<Cellule> cellulesARetirer = new LinkedList<Cellule>();
		LinkedList<Cellule> cellules = this.getCellules();

		for (Cellule c : cellules) {
			if (this.vasMourir(c))
				cellulesARetirer.add(c);
		}

		return (cellulesARetirer);
	}

	// permet de savoir si une cellule va mourir
	private boolean vasMourir(Cellule c) {
		int voisines = this.getNbVoisines(c);
		return (voisines != 2 && voisines != 3);
	}

	// retire de la liste toutes les cellules qui doivent mourir
	private boolean retirerCellules(List<Cellule> cellulesARetirer) {
		for (Cellule c : cellulesARetirer) {
			this.retirer(c);
		}
		return (cellulesARetirer.isEmpty());
	}

	// obtiens la liste des cellules a ajouter pour cette generation
	public List<Cellule> getCelluleAAjouter() {
		List<Cellule> cellulesAAjouter = new LinkedList<Cellule>();
		LinkedList<Cellule> cellules = this.getCellules();

		for (Cellule c : cellules) {
			this.ajouterVoisines(cellulesAAjouter, c.getVoisines());
		}

		return (cellulesAAjouter);
	}

	// ajoute toutes les voisines (potentielle apparition de nouvelles cellules) de la cellule passe en parametre
	private void ajouterVoisines(List<Cellule> cellulesAAjouter, List<Cellule> cellulesVoisines) {
		try {
			for (Cellule cell : cellulesVoisines) {
				if (!this.contiensCellule(cell) && this.getNbVoisines(cell) == 3) {
					
					cellulesAAjouter.add(cell);
				}
			}
		} catch (ConcurrentModificationException e) {
			try {Thread.sleep(20);} catch (InterruptedException e1) {}
			this.ajouterVoisines(cellulesAAjouter, cellulesVoisines);
		}

	}

	// ajoute a la liste toutes les cellules a ajoute
	private boolean ajouterCellules(List<Cellule> cellulesAAjouter) {
		for (Cellule cell : cellulesAAjouter) {
			this.ajouteCellule(cell);
		}
		return (cellulesAAjouter.isEmpty());
	}

	// ajoute une seule cellule
	public void ajouteCellule(Cellule c) {
		if(!this.contiensCellule(c)){
			try {
				this.listeCellule.put(c.generationClef(), c);
			} catch (ConcurrentModificationException e) {
				try {Thread.sleep(20);} catch (InterruptedException e1) {}
				this.ajouteCellule(c);
			}
		}
	}

	// retire une cellule
	public void retirer(Cellule c) {
		try {
			this.listeCellule.remove(c.generationClef());
		} catch (ConcurrentModificationException e) {
			try {Thread.sleep(20);} catch (InterruptedException e1) {}
			this.retirer(c);
		}
	}

	@Override
	public void run() {
		this.generationSuivante();
	}

}
