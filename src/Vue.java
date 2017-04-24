import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Vue extends JFrame{
	JPanel layout = new JPanel();
	private int taille;
	private CirclePanel[][] grille;
	public final static ActionListener clic = new ClicEvent();;

    public Vue(int taille)
    {
        super("Puissance4");
        this.taille = taille;
        layout.setLayout(new GridLayout(this.taille + 1,this.taille));

	    grille = new CirclePanel[taille][taille];
 
	    for (int ligne = taille - 1; ligne >= 0; --ligne) {
	        for (int col = 0; col < taille; col++) {
	    		CirclePanel circle = new CirclePanel(Color.white);
	    		grille[col][ligne] = circle;
	    		layout.add(grille[col][ligne]);
	    	}
	    }
        
        for (int button = 0; button < taille; button++){
        	JButton but=new JButton(button+"");
            but.addActionListener(clic);
    		layout.add(but);
        }
 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(layout);
        pack(); //permet de mettre une bonne dimension a la fenetre
        setVisible(true);
    }
    
    public void changeGrilleColor(int x, int y, int color){
    	switch (color) {
	        case Jeu.ROUGE:
	    	  grille[x][y].changeColor(Color.red);
	          break;
	        case Jeu.BLEU:
	      	  grille[x][y].changeColor(Color.blue);
	          break;
        }
    	actualiser();
    }
    
    public void actualiser(){
	    layout.repaint();
    }
    
    public void finDePartie(String message){
    	JOptionPane.showMessageDialog(null, message, "La partie est finie.", JOptionPane.INFORMATION_MESSAGE);
    	setVisible(false); //you can't see me!
    	dispose(); //Destroy the JFrame object
    }
    
    public class CirclePanel extends JPanel {
    	private Color color;
    	
    	public CirclePanel(Color color){
    		this.color = color;
    	}
    	
    	public void changeColor(Color color){
    		this.color = color;
    	}

        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(this.color);
            g.fillOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
        }
    }

}
