package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import elements.AmmasCellulaire;
import elements.Cellule;
import math_util.Position;
@SuppressWarnings("unused")


public class AmmasCellulaire_test {

	
	//erreur du a une methode en private que j'ai pas envie de mettre en public mais qui a son piti test quand meme
	/*
	@Test
	public void testRetraitCellulesAppliquer() {
		List<String> cellulesARetirerAtendues = new LinkedList<String>();
		List<String> cellulesARetirerObtenues = new LinkedList<String>();
		List<String> cellulesANePasRetirerAtendues = new LinkedList<String>();
		AmmasCellulaire ammas = new AmmasCellulaire();

		//structure stable
		Cellule c1 = new Cellule(new Position(1,3));
		cellulesANePasRetirerAtendues.add(c1.getClef());
		ammas.ajouteCellule(c1);
		Cellule c2 = new Cellule(new Position(2,2));
		cellulesANePasRetirerAtendues.add(c2.getClef());
		ammas.ajouteCellule(c2);
		Cellule c3 = new Cellule(new Position(2,4));
		cellulesANePasRetirerAtendues.add(c3.getClef());
		ammas.ajouteCellule(c3);
		Cellule c4 = new Cellule(new Position(3,3));
		cellulesANePasRetirerAtendues.add(c4.getClef());
		ammas.ajouteCellule(c4);
		

		Cellule c5 = new Cellule(new Position(800,800));
		cellulesARetirerAtendues.add(c5.getClef());
		ammas.ajouteCellule(c5);
		Cellule c6 = new Cellule(new Position(14,14));
		cellulesARetirerAtendues.add(c6.getClef());
		ammas.ajouteCellule(c6);
		
		//cellulesARetirerObtenues = ammas.getCellulesARetirer();

		

		for(String s : cellulesANePasRetirerAtendues) {
			assertFalse(cellulesARetirerObtenues.contains(s));
		}
		
		for(String s : cellulesARetirerAtendues) {
			assertTrue(cellulesARetirerObtenues.contains(s));
		}
		
				
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
//bon bah pareil
	/*
	@Test
	public void testRetraitCellule() {
		List<Cellule> cellulesAAjouterAtendues = new LinkedList<Cellule>();
		List<Cellule> cellulesANePasAjouterAtendues = new LinkedList<Cellule>();
		List<Cellule> cellulesAAjouterObtenues = new LinkedList<Cellule>();
		AmmasCellulaire ammas = new AmmasCellulaire();

		//structure de base
		Cellule c1 = new Cellule(new Position(1,3));
		cellulesANePasAjouterAtendues.add(c1);
		ammas.ajouteCellule(c1);
		Cellule c2 = new Cellule(new Position(2,2));
		cellulesANePasAjouterAtendues.add(c2);
		ammas.ajouteCellule(c2);
		Cellule c3 = new Cellule(new Position(2,4));
		cellulesANePasAjouterAtendues.add(c3);
		ammas.ajouteCellule(c3);
		Cellule c4 = new Cellule(new Position(3,3));
		cellulesANePasAjouterAtendues.add(c4);
		ammas.ajouteCellule(c4);
		Cellule c5 = new Cellule(new Position(3,1));
		cellulesANePasAjouterAtendues.add(c5);
		ammas.ajouteCellule(c5);
		Cellule c6 = new Cellule(new Position(3,5));
		cellulesANePasAjouterAtendues.add(c6);
		ammas.ajouteCellule(c6);
		
		//cellule a ajoute
		Cellule c7 = new Cellule(new Position(3,2));
		cellulesAAjouterAtendues.add(c7);
		Cellule c8 = new Cellule(new Position(3,4));
		cellulesAAjouterAtendues.add(c8);
		
		
		//cellulesAAjouterObtenues = ammas.getCelluleAAjouter();
		

		for(Cellule c : cellulesAAjouterAtendues) {
			assertTrue(cellulesAAjouterObtenues.contains(c));
		}
		for(Cellule c : cellulesANePasAjouterAtendues) {
			assertFalse(cellulesAAjouterObtenues.contains(c));
		}
				
	}
	*/
}