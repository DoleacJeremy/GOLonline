package elements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AmmasCellulaire {
	// utilisation de la map pour les key, facilite folle pour retrouver lescellules
	private HashMap<String, Cellule> cellules;

	public AmmasCellulaire() {
		this.cellules = new HashMap<String, Cellule>();
	}

	// permet de calculer la generation suivante
	public boolean generationSuivante() {
		boolean finAjout = false;
		boolean finRetrait = false;

		// recuperation des cellules a garde ou supprimer
		List<Cellule> cellulesARetirer = this.getCellulesARetirer();
		List<Cellule> cellulesAAjouter = this.getCelluleAAjouter();

		// application du resultat
		finAjout = this.ajouterCellules(cellulesAAjouter);
		finRetrait = this.retirerCellules(cellulesARetirer);

		return (finAjout && finRetrait);
	}

	// obtiens le nombre de voisines existantes dans la liste de cellule
	private int getNbVoisines(Cellule c) {
		int nbVoisines = 0;

		for (Cellule cell : c.getVoisines())
			if (this.cellules.containsKey(cell.getClef()))
				nbVoisines++;

		return (nbVoisines);
	}

	private boolean existeDejaCellule(Cellule c) {
		return (this.cellules.containsKey(c.getClef()));
	}

	public List<Cellule> getCellules() {
		List<Cellule> retour = new LinkedList<Cellule>();

		for (Cellule c : this.cellules.values())
			retour.add(c);

		return (retour);
	}

	
	
	
	
	
	
	
	// obtiens la liste des cellules a retirer pour cette generation
	private List<Cellule> getCellulesARetirer() {
		List<Cellule> cellulesARetirer = new LinkedList<Cellule>();

		for (Cellule c : this.cellules.values()) {
			if (this.vasMourir(c))
				cellulesARetirer.add(c);
		}

		return (cellulesARetirer);
	}

	private boolean vasMourir(Cellule c) {
		int voisines = this.getNbVoisines(c);
		return (voisines != 2 && voisines != 3);
	}

	// retire de la liste toutes les cellules a retirer pour cette generation
	private boolean retirerCellules(List<Cellule> cellulesARetirer) {
		for (Cellule c : cellulesARetirer) {
			this.cellules.remove(c.getClef());
		}
		return (cellulesARetirer.isEmpty());
	}

	
	
	
	
	
	
	
	// obtiens la liste des cellules a ajouter pour cette generation
	private List<Cellule> getCelluleAAjouter() {
		List<Cellule> cellulesAAjouter = new LinkedList<Cellule>();

		// parcours de toutes les cellules
		for (Cellule c : this.cellules.values()) {
			// parcours des voisines de chaque cellule
			for (Cellule cell : c.getVoisines()) {
				if (!this.existeDejaCellule(cell) && this.getNbVoisines(cell) == 3) {
					cellulesAAjouter.add(cell);
				}
			}
		}

		return (cellulesAAjouter);
	}

	// ajoute a la liste toutes les cellules a ajoute pour cette generation
	private boolean ajouterCellules(List<Cellule> cellulesAAjouter) {
		for (Cellule cell : cellulesAAjouter) {
			this.ajouteCellule(cell);
		}
		return (cellulesAAjouter.isEmpty());
	}

	// ajoute une seule cellule
	public void ajouteCellule(Cellule cell) {
		this.cellules.put(cell.getClef(), cell);
	}

}
