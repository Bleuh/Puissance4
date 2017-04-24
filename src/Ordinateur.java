
public class Ordinateur extends Joueur {
	 public Ordinateur(int couleur) {
	    super("Le programme", couleur);
	  }

	  public void joue(Jeu jeu) {
		for (int col = 0; col < jeu.getTaille(); col++) {
		  if (jeu.joueCoup(col, this.getCouleur())) {
//		    System.out.println(this.getNom() + " a joué en " + (col + 1));
		    return;
		  }
		}
	  }
}
