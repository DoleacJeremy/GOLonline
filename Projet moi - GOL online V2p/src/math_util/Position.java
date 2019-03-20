package math_util;

import java.util.LinkedList;
import java.util.List;

public class Position {
	private int positionX;
	private int positionY;

	public Position(int x, int y) {
		this.positionX = x;
		this.positionY = y;
	}

	public int getX() {
		return (this.positionX);
	}

	public int getY() {
		return (this.positionY);
	}

	// obtiens la liste des 8 Position voisines a la Positions actuelle
	public List<Position> getVoisines() {
		List<Position> voisines = new LinkedList<Position>();

		for (int i = this.getX() - 1; i < this.getX() + 2; i++)
			for (int j = this.getY() - 1; j < this.getY() + 2; j++)
				if (!(this.positionX == i && this.positionY == j))
					voisines.add(new Position(i, j));

		return (voisines);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + positionX;
		result = prime * result + positionY;
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
		Position other = (Position) obj;
		if (positionX != other.positionX)
			return false;
		if (positionY != other.positionY)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Position [positionX : " + positionX + ", positionY : " + positionY + "]";
	}
}
