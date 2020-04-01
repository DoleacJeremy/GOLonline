package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import elements.AmmasCellulaire;
import elements.Cellule;
import math_util.Position;

public class AmmasCellulaire_test {

	@Test
	public void testRetraitCellulesAppliquer() {
		List<Cellule> cellulesARetirerAtendues = new LinkedList<Cellule>();
		List<Cellule> cellulesARetirerObtenues = new LinkedList<Cellule>();
		List<Cellule> cellulesANePasRetirerAtendues = new LinkedList<Cellule>();
		AmmasCellulaire ammas = new AmmasCellulaire();

		// structure stable
		Cellule c1 = new Cellule(new Position(1, 3));
		cellulesANePasRetirerAtendues.add(c1);
		ammas.ajouteCellule(c1);
		Cellule c2 = new Cellule(new Position(2, 2));
		cellulesANePasRetirerAtendues.add(c2);
		ammas.ajouteCellule(c2);
		Cellule c3 = new Cellule(new Position(2, 4));
		cellulesANePasRetirerAtendues.add(c3);
		ammas.ajouteCellule(c3);
		Cellule c4 = new Cellule(new Position(3, 3));
		cellulesANePasRetirerAtendues.add(c4);
		ammas.ajouteCellule(c4);

		Cellule c5 = new Cellule(new Position(800, 800));
		cellulesARetirerAtendues.add(c5);
		ammas.ajouteCellule(c5);
		Cellule c6 = new Cellule(new Position(14, 14));
		cellulesARetirerAtendues.add(c6);
		ammas.ajouteCellule(c6);

		cellulesARetirerObtenues = ammas.getCellulesARetirer();

		for (Cellule c : cellulesANePasRetirerAtendues) {
			assertFalse(cellulesARetirerObtenues.contains(c));
		}

		for (Cellule c : cellulesARetirerAtendues) {
			assertTrue(cellulesARetirerObtenues.contains(c));
		}

	}

	@Test
	public void testRetraitCellule() {
		List<Cellule> cellulesAAjouter = new LinkedList<Cellule>();
		List<Cellule> cellulesANePasAjouter = new LinkedList<Cellule>();
		List<Cellule> cellulesAAjouterObtenues = new LinkedList<Cellule>();
		AmmasCellulaire ammas = new AmmasCellulaire();

		// structure de base
		Cellule c1 = new Cellule(new Position(1, 3));
		cellulesANePasAjouter.add(c1);
		ammas.ajouteCellule(c1);
		Cellule c2 = new Cellule(new Position(2, 2));
		cellulesANePasAjouter.add(c2);
		ammas.ajouteCellule(c2);
		Cellule c3 = new Cellule(new Position(2, 4));
		cellulesANePasAjouter.add(c3);
		ammas.ajouteCellule(c3);
		Cellule c4 = new Cellule(new Position(3, 3));
		cellulesANePasAjouter.add(c4);
		ammas.ajouteCellule(c4);
		Cellule c5 = new Cellule(new Position(3, 1));
		cellulesANePasAjouter.add(c5);
		ammas.ajouteCellule(c5);
		Cellule c6 = new Cellule(new Position(3, 5));
		cellulesANePasAjouter.add(c6);
		ammas.ajouteCellule(c6);

		// cellule a ajoute
		Cellule c7 = new Cellule(new Position(3, 2));
		cellulesAAjouter.add(c7);
		Cellule c8 = new Cellule(new Position(3, 4));
		cellulesAAjouter.add(c8);

		cellulesAAjouterObtenues = ammas.getCelluleAAjouter();

		for (Cellule c : cellulesAAjouter) {
			assertTrue(cellulesAAjouterObtenues.contains(c));
		}
		for (Cellule c : cellulesANePasAjouter) {
			System.out.println(c);
			assertFalse(cellulesAAjouterObtenues.contains(c));
		}

	}
}
