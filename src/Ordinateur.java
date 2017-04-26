
public class Ordinateur extends Joueur {
	 public Ordinateur(int couleur) {
	    super("Le programme", couleur);
	  }

	  public void joue(Jeu jeu) {
		  if(jeu.iaPlay(this.getCouleur())){
			  return;
		  }
	  }
}
