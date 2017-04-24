import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Puissance4 {
	protected static Scanner scanner = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object[] options = {"Seul contre l'ordinateur", "Joueur contre joueur"};
		int n = JOptionPane.showOptionDialog(new JFrame(), "Selectionnionner votre mode de jeux.", "Bienvenue sur Puissance 4", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
		Partie p = null;
		if(n == 0){
			String nom = (String)JOptionPane.showInputDialog(new JFrame(),"Votre nom de joueur.", "Inscription", JOptionPane.PLAIN_MESSAGE);
			if(nom != null){
				p = new Partie(new Ordinateur(Jeu.BLEU), new Humain(nom, Jeu.ROUGE));
			}
		}
		else if(n==1){
			String nom =  (String)JOptionPane.showInputDialog(new JFrame(),"Votre nom de joueur 1.", "Inscription 1", JOptionPane.PLAIN_MESSAGE);
			if(nom != null){
				String nom2 =  (String)JOptionPane.showInputDialog(new JFrame(),"Votre nom de joueur 2.", "Inscription 2", JOptionPane.PLAIN_MESSAGE);
				if(nom2 != null){
					p = new Partie(new Humain(nom, Jeu.BLEU), new Humain(nom2, Jeu.ROUGE));
				}
			}
		}
		if(p != null){
			p.joue();
		}
	}

}
