
public class Humain extends Joueur {
	public Humain(String nom,int couleur) {
		super(nom, couleur);
	}
	
	static int colSelected;

	public void joue(Jeu jeu) {
	    boolean valide;
		int col = 0;
		synchronized (Vue.clic) {

			try {
				Vue.clic.wait();
			    valide = jeu.joueCoup(colSelected, this.getCouleur());
			    if (valide == false) {
			    	joue(jeu);
			    }
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
