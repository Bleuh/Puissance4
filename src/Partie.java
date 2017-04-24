
public class Partie {
	private Joueur[] joueurs = new Joueur[2];
	private Jeu jeu;

	public Partie(Joueur joueur1, Joueur joueur2) {
		joueurs[0] = joueur1;
		joueurs[1] = joueur2;
		jeu = new Jeu();
	}

	public void joue() {
		int vainqueur = -1;
	    int cJoueur = 0;

	    while (vainqueur==-1 && !jeu.estPlein()) {
	      joueurs[cJoueur].joue(jeu);
	      if (jeu.estPlein()) {
	        vainqueur = -1;
	      }

	      // Si 4 pions sont alignés, on a un vainqueur
	      // (même si le jeu est plein!)

	      if (jeu.cherche4()) {
	    	  vainqueur = cJoueur;
	      }

	      // On change de joueur pour l'itération suivante
	      cJoueur++;
	      cJoueur %= 2;
	    }
	    
	    if (vainqueur == -1) {
	      this.jeu.finDuJeu("Match nul");
	    } else {
	      this.jeu.finDuJeu("Le vainqueur est " + joueurs[vainqueur].getNom());
	    }
	}
}
