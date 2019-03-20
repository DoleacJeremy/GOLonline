package elements;

import java.util.LinkedList;
import java.util.List;

import math_util.Position;

public class GrilleFenetre {
	private int tailleFenetre;
	private int tailleCarrer = 1;

	public GrilleFenetre(int tailleFenetre, int tailleCarrer) {
		this.tailleFenetre = tailleFenetre;

		if (this.tailleCarrer > 0)
			this.tailleCarrer = tailleCarrer;
	}

	// permet d'appliquer le zoom (choisi dans la fenetre parametre) a une liste de cellule
	public LinkedList<Position> getPositionAAfficher(List<Cellule> cellules) {

		LinkedList<Position> positionsAAficher = new LinkedList<Position>();

		for (Cellule cell : cellules) {
			Position positionCell = new Position(cell.getPosition().getX() * this.tailleCarrer,
												 cell.getPosition().getY() * this.tailleCarrer);

			if (this.apparaitDansFenetre(positionCell)) {
				positionsAAficher.add(positionCell);
			}
		}

		return (positionsAAficher);
	}

	// permet de dire si la position est afficherdans la fenetre en prenant en compte le zoom
	public boolean apparaitDansFenetre(Position p) {
		boolean apparaitDansX = p.getX() < this.tailleFenetre && p.getX() >= 0;
		boolean apparaitDansY = p.getY() < this.tailleFenetre && p.getY() >= 0;

		return (apparaitDansX && apparaitDansY);
	}

	// converti d'appliquer le zoom (choisi dans la fenetre parametre) a une position
	public Position getPositionGrille(Position p) {
		Position positionAvecZoom = new Position((p.getX() / this.tailleCarrer), (p.getY() / this.tailleCarrer));
		return (positionAvecZoom);
	}

}