package elements;

import java.util.LinkedList;
import java.util.List;

import math_util.Position;

public class Cellule {
	private Position position;

	public Cellule(Position p) {
		this.position = p;
	}

	public Position getPosition() {
		return (this.position);
	}

	// permet de recuperer la liste des 8 cellules voisines
	public List<Cellule> getVoisines() {
		List<Cellule>  listeVoisines = new LinkedList<Cellule>();
		List<Position> positionVoisines = this.getPosition().getVoisines();

		for (Position p : positionVoisines)
			listeVoisines.add(new Cellule(p));

		return (listeVoisines);
	}

	// cree une clef unique a chaque cellule
	public String generationClef() {
		return (this.position.toString());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cellule other = (Cellule) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cellule [position=" + this.position + "]";
	}
}
