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

	// permet d'obtenir une liste de positions de cellules par rapport au niveau de zoom choisi
	public LinkedList<Position> getPosition(List<Cellule> cellules) {

		LinkedList<Position> positions = new LinkedList<Position>();

		for (Cellule cell : cellules) {
			Position positionCell = new Position(cell.getPosition().getX() * this.tailleCarrer,
					cell.getPosition().getY() * this.tailleCarrer);

			if (this.apparaitDansFenetre(positionCell)) {
				positions.add(positionCell);
			}
		}

		return (positions);
	}
	// permet de dire si la position est affichage toujours en prenant en compte le zoom
	private boolean apparaitDansFenetre(Position p) {
		boolean apparaitDansX = p.getX() <= this.tailleFenetre && p.getX() >= 0;
		boolean apparaitDansY = p.getY() <= this.tailleFenetre && p.getY() >= 0;

		return (apparaitDansX && apparaitDansY);
	}

	// converti une position traditionnelle en nouvelle position par rapport au niveau de zoom
	public Position getPositionGrille(Position p) {
		Position positionAvecZoom = new Position((p.getX() / this.tailleCarrer), (p.getY() / this.tailleCarrer));
		return (positionAvecZoom);
	}

}