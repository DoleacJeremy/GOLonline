package com.JD.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.JD.mathUtil.Position;

public class AJoutCellule {

	// cree un poisson de qualite
	public static void poisson(AmmasCellulaire a, int positionBase) {
		a.ajouteCellule(new Cellule(new Position(positionBase, positionBase)));
		a.ajouteCellule(new Cellule(new Position(positionBase + 2, positionBase)));
		a.ajouteCellule(new Cellule(new Position(positionBase + 3, positionBase)));

		a.ajouteCellule(new Cellule(new Position(positionBase + 1, positionBase + 1)));
		a.ajouteCellule(new Cellule(new Position(positionBase + 4, positionBase + 1)));

		a.ajouteCellule(new Cellule(new Position(positionBase, positionBase + 2)));
		a.ajouteCellule(new Cellule(new Position(positionBase + 2, positionBase + 2)));
		a.ajouteCellule(new Cellule(new Position(positionBase + 3, positionBase + 2)));

		for (Cellule c : a.getCellules()) {
			System.out.println("[AjoutCellule>27]   "+c.getPosition().getX() + ":" + c.getPosition().getY());
		}
	}

	// cree un papillon tout aussi qualitatif
	public static void papillon(AmmasCellulaire a, int positionBase) {
		a.ajouteCellule(new Cellule(new Position(positionBase + 3, positionBase + 2)));
		a.ajouteCellule(new Cellule(new Position(positionBase + 4, positionBase + 2)));
		a.ajouteCellule(new Cellule(new Position(positionBase + 6, positionBase + 2)));
		a.ajouteCellule(new Cellule(new Position(positionBase + 7, positionBase + 2)));

		a.ajouteCellule(new Cellule(new Position(positionBase + 3, positionBase + 1)));
		a.ajouteCellule(new Cellule(new Position(positionBase + 7, positionBase + 1)));

		a.ajouteCellule(new Cellule(new Position(positionBase + 4, positionBase)));
		a.ajouteCellule(new Cellule(new Position(positionBase + 5, positionBase)));
		a.ajouteCellule(new Cellule(new Position(positionBase + 6, positionBase)));
	}

	public static void interesantI(AmmasCellulaire a) {
		a.ajouteCellule(new Cellule(new Position(22, 21)));
		a.ajouteCellule(new Cellule(new Position(28, 31)));
		a.ajouteCellule(new Cellule(new Position(25, 25)));
		a.ajouteCellule(new Cellule(new Position(27, 29)));
		a.ajouteCellule(new Cellule(new Position(28, 24)));
		a.ajouteCellule(new Cellule(new Position(30, 24)));
		a.ajouteCellule(new Cellule(new Position(29, 26)));
		a.ajouteCellule(new Cellule(new Position(30, 31)));
		a.ajouteCellule(new Cellule(new Position(30, 25)));
		a.ajouteCellule(new Cellule(new Position(30, 27)));
		a.ajouteCellule(new Cellule(new Position(22, 25)));
		a.ajouteCellule(new Cellule(new Position(27, 20)));
		a.ajouteCellule(new Cellule(new Position(25, 23)));
		a.ajouteCellule(new Cellule(new Position(20, 21)));
		a.ajouteCellule(new Cellule(new Position(23, 22)));
		a.ajouteCellule(new Cellule(new Position(29, 20)));
		a.ajouteCellule(new Cellule(new Position(26, 24)));
		a.ajouteCellule(new Cellule(new Position(25, 28)));
		a.ajouteCellule(new Cellule(new Position(25, 23)));
		a.ajouteCellule(new Cellule(new Position(28, 27)));
		a.ajouteCellule(new Cellule(new Position(24, 30)));
		a.ajouteCellule(new Cellule(new Position(27, 26)));
		a.ajouteCellule(new Cellule(new Position(24, 24)));
		a.ajouteCellule(new Cellule(new Position(26, 20)));
		a.ajouteCellule(new Cellule(new Position(20, 24)));
		a.ajouteCellule(new Cellule(new Position(24, 30)));
		a.ajouteCellule(new Cellule(new Position(29, 25)));
		a.ajouteCellule(new Cellule(new Position(28, 26)));
		a.ajouteCellule(new Cellule(new Position(30, 23)));
		a.ajouteCellule(new Cellule(new Position(26, 25)));
		a.ajouteCellule(new Cellule(new Position(27, 27)));
		a.ajouteCellule(new Cellule(new Position(23, 31)));
		a.ajouteCellule(new Cellule(new Position(23, 29)));
		a.ajouteCellule(new Cellule(new Position(24, 23)));
		a.ajouteCellule(new Cellule(new Position(23, 22)));
		a.ajouteCellule(new Cellule(new Position(28, 22)));
		a.ajouteCellule(new Cellule(new Position(31, 28)));
		a.ajouteCellule(new Cellule(new Position(31, 22)));
		a.ajouteCellule(new Cellule(new Position(31, 30)));
		a.ajouteCellule(new Cellule(new Position(26, 23)));
		a.ajouteCellule(new Cellule(new Position(20, 22)));
		a.ajouteCellule(new Cellule(new Position(20, 20)));
		a.ajouteCellule(new Cellule(new Position(26, 30)));
		a.ajouteCellule(new Cellule(new Position(23, 21)));
		a.ajouteCellule(new Cellule(new Position(30, 31)));
		a.ajouteCellule(new Cellule(new Position(24, 28)));
		a.ajouteCellule(new Cellule(new Position(22, 21)));
		a.ajouteCellule(new Cellule(new Position(29, 27)));
	}

	public static void interesantII(AmmasCellulaire a) {
		a.ajouteCellule(new Cellule(new Position(22, 31)));
		a.ajouteCellule(new Cellule(new Position(27, 22)));
		a.ajouteCellule(new Cellule(new Position(23, 31)));
		a.ajouteCellule(new Cellule(new Position(30, 21)));
		a.ajouteCellule(new Cellule(new Position(22, 29)));
		a.ajouteCellule(new Cellule(new Position(29, 30)));
		a.ajouteCellule(new Cellule(new Position(31, 25)));
		a.ajouteCellule(new Cellule(new Position(23, 26)));
		a.ajouteCellule(new Cellule(new Position(21, 20)));
		a.ajouteCellule(new Cellule(new Position(23, 22)));
		a.ajouteCellule(new Cellule(new Position(29, 21)));
		a.ajouteCellule(new Cellule(new Position(24, 24)));
		a.ajouteCellule(new Cellule(new Position(24, 30)));
		a.ajouteCellule(new Cellule(new Position(20, 25)));
		a.ajouteCellule(new Cellule(new Position(30, 21)));
		a.ajouteCellule(new Cellule(new Position(21, 23)));
		a.ajouteCellule(new Cellule(new Position(28, 23)));
		a.ajouteCellule(new Cellule(new Position(26, 31)));
		a.ajouteCellule(new Cellule(new Position(24, 25)));
		a.ajouteCellule(new Cellule(new Position(31, 20)));
		a.ajouteCellule(new Cellule(new Position(23, 30)));
		a.ajouteCellule(new Cellule(new Position(31, 29)));
		a.ajouteCellule(new Cellule(new Position(25, 24)));
		a.ajouteCellule(new Cellule(new Position(26, 21)));
		a.ajouteCellule(new Cellule(new Position(21, 23)));
		a.ajouteCellule(new Cellule(new Position(24, 25)));
		a.ajouteCellule(new Cellule(new Position(22, 31)));
		a.ajouteCellule(new Cellule(new Position(30, 25)));
		a.ajouteCellule(new Cellule(new Position(31, 25)));
		a.ajouteCellule(new Cellule(new Position(21, 22)));
		a.ajouteCellule(new Cellule(new Position(29, 24)));
		a.ajouteCellule(new Cellule(new Position(26, 25)));
		a.ajouteCellule(new Cellule(new Position(28, 25)));
		a.ajouteCellule(new Cellule(new Position(28, 21)));
		a.ajouteCellule(new Cellule(new Position(24, 28)));
		a.ajouteCellule(new Cellule(new Position(21, 23)));
		a.ajouteCellule(new Cellule(new Position(26, 21)));
		a.ajouteCellule(new Cellule(new Position(31, 23)));
		a.ajouteCellule(new Cellule(new Position(25, 28)));
		a.ajouteCellule(new Cellule(new Position(26, 30)));
		a.ajouteCellule(new Cellule(new Position(25, 25)));
		a.ajouteCellule(new Cellule(new Position(31, 24)));
		a.ajouteCellule(new Cellule(new Position(27, 31)));
		a.ajouteCellule(new Cellule(new Position(26, 31)));
		a.ajouteCellule(new Cellule(new Position(31, 26)));
		a.ajouteCellule(new Cellule(new Position(21, 26)));
		a.ajouteCellule(new Cellule(new Position(21, 27)));
		a.ajouteCellule(new Cellule(new Position(30, 27)));
	}

	public static void interesantIII(AmmasCellulaire a) {
		a.ajouteCellule(new Cellule(new Position(23, 28)));
		a.ajouteCellule(new Cellule(new Position(30, 26)));
		a.ajouteCellule(new Cellule(new Position(25, 23)));
		a.ajouteCellule(new Cellule(new Position(27, 20)));
		a.ajouteCellule(new Cellule(new Position(24, 28)));
		a.ajouteCellule(new Cellule(new Position(21, 28)));
		a.ajouteCellule(new Cellule(new Position(21, 29)));
		a.ajouteCellule(new Cellule(new Position(24, 30)));
		a.ajouteCellule(new Cellule(new Position(20, 26)));
		a.ajouteCellule(new Cellule(new Position(21, 26)));
		a.ajouteCellule(new Cellule(new Position(21, 21)));
		a.ajouteCellule(new Cellule(new Position(27, 22)));
		a.ajouteCellule(new Cellule(new Position(21, 23)));
		a.ajouteCellule(new Cellule(new Position(23, 20)));
		a.ajouteCellule(new Cellule(new Position(28, 31)));
		a.ajouteCellule(new Cellule(new Position(20, 21)));
		a.ajouteCellule(new Cellule(new Position(20, 24)));
		a.ajouteCellule(new Cellule(new Position(28, 20)));
		a.ajouteCellule(new Cellule(new Position(24, 30)));
		a.ajouteCellule(new Cellule(new Position(24, 21)));
		a.ajouteCellule(new Cellule(new Position(21, 20)));
		a.ajouteCellule(new Cellule(new Position(22, 30)));
		a.ajouteCellule(new Cellule(new Position(28, 29)));
		a.ajouteCellule(new Cellule(new Position(29, 30)));
		a.ajouteCellule(new Cellule(new Position(25, 30)));
		a.ajouteCellule(new Cellule(new Position(23, 21)));
		a.ajouteCellule(new Cellule(new Position(21, 22)));
		a.ajouteCellule(new Cellule(new Position(22, 29)));
		a.ajouteCellule(new Cellule(new Position(30, 23)));
		a.ajouteCellule(new Cellule(new Position(25, 25)));
		a.ajouteCellule(new Cellule(new Position(26, 30)));
		a.ajouteCellule(new Cellule(new Position(24, 31)));
		a.ajouteCellule(new Cellule(new Position(20, 22)));
		a.ajouteCellule(new Cellule(new Position(28, 26)));
		a.ajouteCellule(new Cellule(new Position(25, 27)));
		a.ajouteCellule(new Cellule(new Position(21, 25)));
		a.ajouteCellule(new Cellule(new Position(30, 20)));
		a.ajouteCellule(new Cellule(new Position(27, 29)));
		a.ajouteCellule(new Cellule(new Position(20, 23)));
		a.ajouteCellule(new Cellule(new Position(23, 21)));
		a.ajouteCellule(new Cellule(new Position(28, 28)));
		a.ajouteCellule(new Cellule(new Position(31, 22)));
		a.ajouteCellule(new Cellule(new Position(28, 26)));
		a.ajouteCellule(new Cellule(new Position(26, 28)));
		a.ajouteCellule(new Cellule(new Position(20, 30)));
		a.ajouteCellule(new Cellule(new Position(31, 25)));
		a.ajouteCellule(new Cellule(new Position(26, 31)));
		a.ajouteCellule(new Cellule(new Position(21, 28)));
	}

	public static void interesantIV(AmmasCellulaire a) {
		a.ajouteCellule(new Cellule(new Position(24, 27)));
		a.ajouteCellule(new Cellule(new Position(27, 22)));
		a.ajouteCellule(new Cellule(new Position(30, 30)));
		a.ajouteCellule(new Cellule(new Position(22, 21)));
		a.ajouteCellule(new Cellule(new Position(22, 25)));
		a.ajouteCellule(new Cellule(new Position(20, 23)));
		a.ajouteCellule(new Cellule(new Position(23, 28)));
		a.ajouteCellule(new Cellule(new Position(27, 30)));
		a.ajouteCellule(new Cellule(new Position(25, 23)));
		a.ajouteCellule(new Cellule(new Position(25, 29)));
		a.ajouteCellule(new Cellule(new Position(23, 31)));
		a.ajouteCellule(new Cellule(new Position(25, 30)));
		a.ajouteCellule(new Cellule(new Position(31, 26)));
		a.ajouteCellule(new Cellule(new Position(31, 24)));
		a.ajouteCellule(new Cellule(new Position(28, 23)));
		a.ajouteCellule(new Cellule(new Position(26, 27)));
		a.ajouteCellule(new Cellule(new Position(31, 31)));
		a.ajouteCellule(new Cellule(new Position(29, 20)));
		a.ajouteCellule(new Cellule(new Position(31, 31)));
		a.ajouteCellule(new Cellule(new Position(25, 23)));
		a.ajouteCellule(new Cellule(new Position(28, 28)));
		a.ajouteCellule(new Cellule(new Position(25, 29)));
		a.ajouteCellule(new Cellule(new Position(20, 22)));
		a.ajouteCellule(new Cellule(new Position(21, 25)));
		a.ajouteCellule(new Cellule(new Position(24, 30)));
		a.ajouteCellule(new Cellule(new Position(26, 24)));
		a.ajouteCellule(new Cellule(new Position(25, 26)));
		a.ajouteCellule(new Cellule(new Position(26, 29)));
		a.ajouteCellule(new Cellule(new Position(24, 25)));
		a.ajouteCellule(new Cellule(new Position(22, 20)));
		a.ajouteCellule(new Cellule(new Position(23, 24)));
		a.ajouteCellule(new Cellule(new Position(24, 24)));
		a.ajouteCellule(new Cellule(new Position(26, 25)));
		a.ajouteCellule(new Cellule(new Position(30, 26)));
		a.ajouteCellule(new Cellule(new Position(25, 22)));
		a.ajouteCellule(new Cellule(new Position(31, 29)));
		a.ajouteCellule(new Cellule(new Position(28, 23)));
		a.ajouteCellule(new Cellule(new Position(23, 30)));
		a.ajouteCellule(new Cellule(new Position(20, 31)));
		a.ajouteCellule(new Cellule(new Position(20, 29)));
		a.ajouteCellule(new Cellule(new Position(20, 28)));
		a.ajouteCellule(new Cellule(new Position(28, 30)));
		a.ajouteCellule(new Cellule(new Position(29, 21)));
		a.ajouteCellule(new Cellule(new Position(20, 28)));
		a.ajouteCellule(new Cellule(new Position(23, 22)));
		a.ajouteCellule(new Cellule(new Position(22, 27)));
		a.ajouteCellule(new Cellule(new Position(21, 30)));
		a.ajouteCellule(new Cellule(new Position(31, 23)));
	}

	public static void interesantV(AmmasCellulaire a) {
		a.ajouteCellule(new Cellule(new Position(28, 21)));
		a.ajouteCellule(new Cellule(new Position(30, 31)));
		a.ajouteCellule(new Cellule(new Position(22, 23)));
		a.ajouteCellule(new Cellule(new Position(26, 20)));
		a.ajouteCellule(new Cellule(new Position(25, 27)));
		a.ajouteCellule(new Cellule(new Position(21, 25)));
		a.ajouteCellule(new Cellule(new Position(25, 24)));
		a.ajouteCellule(new Cellule(new Position(21, 23)));
		a.ajouteCellule(new Cellule(new Position(27, 30)));
		a.ajouteCellule(new Cellule(new Position(23, 29)));
		a.ajouteCellule(new Cellule(new Position(29, 24)));
		a.ajouteCellule(new Cellule(new Position(28, 23)));
		a.ajouteCellule(new Cellule(new Position(22, 23)));
		a.ajouteCellule(new Cellule(new Position(28, 29)));
		a.ajouteCellule(new Cellule(new Position(25, 27)));
		a.ajouteCellule(new Cellule(new Position(31, 28)));
		a.ajouteCellule(new Cellule(new Position(27, 23)));
		a.ajouteCellule(new Cellule(new Position(22, 26)));
		a.ajouteCellule(new Cellule(new Position(31, 31)));
		a.ajouteCellule(new Cellule(new Position(28, 30)));
		a.ajouteCellule(new Cellule(new Position(22, 28)));
		a.ajouteCellule(new Cellule(new Position(20, 21)));
		a.ajouteCellule(new Cellule(new Position(31, 27)));
		a.ajouteCellule(new Cellule(new Position(25, 21)));
		a.ajouteCellule(new Cellule(new Position(25, 27)));
		a.ajouteCellule(new Cellule(new Position(26, 31)));
		a.ajouteCellule(new Cellule(new Position(23, 31)));
		a.ajouteCellule(new Cellule(new Position(20, 21)));
		a.ajouteCellule(new Cellule(new Position(29, 21)));
		a.ajouteCellule(new Cellule(new Position(20, 28)));
		a.ajouteCellule(new Cellule(new Position(21, 27)));
		a.ajouteCellule(new Cellule(new Position(21, 27)));
		a.ajouteCellule(new Cellule(new Position(23, 31)));
		a.ajouteCellule(new Cellule(new Position(20, 21)));
		a.ajouteCellule(new Cellule(new Position(20, 28)));
		a.ajouteCellule(new Cellule(new Position(26, 24)));
		a.ajouteCellule(new Cellule(new Position(27, 20)));
		a.ajouteCellule(new Cellule(new Position(20, 23)));
		a.ajouteCellule(new Cellule(new Position(22, 27)));
		a.ajouteCellule(new Cellule(new Position(27, 26)));
		a.ajouteCellule(new Cellule(new Position(23, 23)));
		a.ajouteCellule(new Cellule(new Position(28, 30)));
		a.ajouteCellule(new Cellule(new Position(27, 20)));
		a.ajouteCellule(new Cellule(new Position(21, 23)));
		a.ajouteCellule(new Cellule(new Position(25, 31)));
		a.ajouteCellule(new Cellule(new Position(23, 30)));
		a.ajouteCellule(new Cellule(new Position(28, 23)));
		a.ajouteCellule(new Cellule(new Position(31, 31)));
	}

	// cree des cellules de maniere random au centre de la fenetre
	public static void positionementRandomCellules(AmmasCellulaire a, int tailleFenetre, int tailleCarrer) {
		int posX;
		int posY;
		System.out.println("[AjoutCellule>305]  LISTE DES CELLULES COURRANTES (BON FORMAT POUR AJOUT DANS LE FICHIER)");
		int positionBase = (int) ((double) tailleFenetre / 2 - (0.1 * tailleFenetre));

		// remplissage de 30% de l'aire du carre centre, carre qui fait 20% de l'aire de la fenetre
		int coter = (int) (0.2 * tailleFenetre);
		int aire = coter * coter / (tailleCarrer * tailleCarrer);
		int nbCelluleFinal = (int) (aire * 0.3);

		for (int i = 0; i < nbCelluleFinal; i++) {
			posX = (int)(Math.random() * coter + positionBase) / tailleCarrer;
			posY = (int)(Math.random() * coter + positionBase) / tailleCarrer;

			// ajout dans la classe AJoutCellule
				// System.out.println("a.ajouteCellule(new Cellule(new Position("+posX+","+posY+")));");
			// ajout pour lecture dans le fichier
				// System.out.println(posX + ":" + posY);

			a.ajouteCellule(new Cellule(new Position(posX, posY)));
		}

		System.out.println("[AjoutCellule>326]  FIN DE LA LISTE DES CELLULES CHOISIE ALEATOIREMENT");
	}

	// recupere le positionnement des cellules dans un fichier
	public static void recuperationFichier(AmmasCellulaire a) throws IOException {
		File file = new File("resources/cellules.txt");
		BufferedReader lecteurFichier = new BufferedReader(new FileReader(file));

		// lecture du fichier
		String ligneFichier = lecteurFichier.readLine();
		while (ligneFichier != null) {
			String[] coordnneesCellule = ligneFichier.split(":");

			int x = Integer.parseInt(coordnneesCellule[0]);
			int y = Integer.parseInt(coordnneesCellule[1]);
			a.ajouteCellule(new Cellule(new Position(x, y)));

			// ligne suivante
			ligneFichier = lecteurFichier.readLine();
		}
		lecteurFichier.close();
	}

}