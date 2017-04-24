
public class Jeu {
	public final static int VIDE = 0;
	public final static int BLEU = 1;
	public final static int ROUGE = 2;

	private int taille;
	private int[][] grille;

	public Jeu(int taille) {
		initJeu(taille);
	}

	public Jeu() {
		initJeu(8);
	}

	private void initJeu(int taille) {
	    this.taille = taille;
	    grille = new int[taille][taille];
	    for (int col = 0; col < taille ; col++) {
	    	for (int row = 0; row < taille; row++) {
	    		grille[col][row] = VIDE;
	    	}
	    }
	}

	public boolean joueCoup(int col, int joueur) {
	    if ((col < 0) || (col >= taille)) {
	    	return false;
	    }

	    // Trouve la première place vide dans la colonne
	    for (int ligne = 0; ligne < taille; ligne++) {
	    	if (grille[col][ligne] == VIDE) {
		        grille[col][ligne] = joueur;
		        return true;
	    	}
	    }

	    // La colonne est pleine
	    return false;
	}

  /**
   * Cette méthode vérifie toutes les lignes, colonnes et diagonales pour une série de 4 pions
   * de la même couleur. Si une telle série existe, retourne true.
   *
   * Notez qu'il n'est pas nécessaire de retourner la couleur des 4 pions alignés,
   * puisqu'il s'agit de celle de celui qui vient de jouer.
   * @return true si le jeu contient 4 pions alignés
   */
	public boolean cherche4() {
	    // Vérifie les horizontales ( - )
	    for (int ligne = 0; ligne < taille; ligne++) {
	    	if (cherche4alignes(0, ligne, 1, 0)) {
	    		return true;
	    	}
	    }

    // Vérifie les verticales ( ¦ )
    for (int col = 0; col < taille; col++) {
    	if (cherche4alignes(col, 0, 0, 1)) {
    		return true;
    	}
    }

    // Diagonales (cherche depuis la ligne du bas)
    for (int col = 0; col < taille; col++) {
		  // Première diagonale ( / )
		  if (cherche4alignes(col, 0, 1, 1)) {
			  return true;
		  }
		  // Deuxième diagonale ( \ )
		  if (cherche4alignes(col, 0, -1, 1)) {
			  return true;
		  }
    }

    // Diagonales (cherche depuis les colonnes gauches et droites)
    for (int ligne = 0; ligne < taille; ligne++) {
	    // Première diagonale ( / )
    	if (cherche4alignes(0, ligne, 1, 1)) {
    		return true;
	    }
	    // Deuxième diagonale ( \ )
	    if (cherche4alignes(taille - 1, ligne, -1, 1)) {
	    	return true;
	    }
    }

    // On n'a rien trouvé
    return false;
  }

  /**
   * Cette méthode cherche 4 pions alignés sur une ligne. Cette ligne est définie par
   * le point de départ, ou origine de coordonnées (oCol,oLigne), et par le déplacement
   * delta (dCol,dLigne). En utilisant des valeurs appropriées pour dCol et dLigne
   * on peut vérifier toutes les directions:
   * - horizontale:    dCol = 0, dLigne = 1
   * - vérticale:      dCol = 1, dLigne = 0
   * - 1ère diagonale: dCol = 1, dLigne = 1
   * - 2ème diagonale: dCol = 1, dLigne = -1
   *
   * @param oCol   Colonne d'origine de la recherche
   * @param oLigne Ligne d'origine de la recherche
   * @param dCol   Delta de déplacement sur une colonne
   * @param dLigne Delta de déplacement sur une ligne
   * @return true si on trouve un alignement
   */
	private boolean cherche4alignes(int oCol, int oLigne, int dCol, int dLigne) {
		int couleur = VIDE;
	    int compteur = 0;
	
	    int curCol = oCol;
	    int curRow = oLigne;

	    while ((curCol >= 0) && (curCol < taille) && (curRow >= 0) && (curRow < taille)) {
	      if (grille[curRow][curCol] != couleur) {
		        // Si la couleur change, on réinitialise le compteur
		        couleur = grille[curRow][curCol];
		        compteur = 1;
	      } else {
		        // Sinon on l'incrémente
		        compteur++;
	      }
	
	      // On sort lorsque le compteur atteint 4
	      if ((couleur != VIDE) && (compteur == 4)) {
	    	  return true;
	      }
	
	      // On passe à l'itération suivante
	      curCol += dCol;
	      curRow += dLigne;
	    }

	    // Aucun alignement n'a été trouvé
	    return false;
	}

  /**
   * Vérifie s'il est encore possible de placer des pions
   * @return true si le tableau est plein
   */
  public boolean estPlein() {
    // On cherche une case vide. S'il n'y en a aucune, le tableau est plein
    for (int col = 0; col < taille; col++) {
	      for (int ligne = 0; ligne < taille; ligne++) {
		        if (grille[col][ligne] == VIDE) {
		        	return false;
		        }
	      }
    }

    return true;
  }

  public int getTaille() {
	  return taille;
  }

  public void afficher() {
    for (int ligne = taille - 1; ligne >= 0; --ligne) {
      for (int col = 0; col < taille; col++) {
        switch (grille[col][ligne]) {
        case VIDE:
          System.out.print('0');
          break;
        case ROUGE:
          System.out.print('R');
          break;
        case BLEU:
          System.out.print('B');
          break;
        }
      }
      System.out.println();
    }

    for (int i = 0; i < taille; ++i) {
      System.out.print('-');
    }
    System.out.println();
    for (int i = 1; i <= taille; ++i) {
      System.out.print(i);
    }
    System.out.println();
  }
}
