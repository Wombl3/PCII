package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

import control.Control;
import model.Etat;
import model.Parcours;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;


public class Affichage extends JPanel {

	/* --- DECLARATION DE VARIABLES --- */
	
	public static final int ecranH = 1000;//hauteur de notre ecran
	public static final int ecranL = 1000;//largeur de notre ecran
	
	public static final int motoX = ecranH/2;//position de la moto (initiale) en X
	public static final int motoY = ecranL/2;//position de la moto (intiale) en Y
	
	public static final int horiY = ecranH/3;//position de notre trait d'horizon
	
	private Etat etat = new Etat();
	



	public Affichage() {
		this.setFocusable(true);
		setPreferredSize(new Dimension(ecranL, ecranH));
		this.addKeyListener(new Control(this, this.etat));

	}

	/**Fonction paint qui dessine un ovale avec les variables ci-dessus et qui le
	 * remplacera lors du prochain appel de la fonction*/
	@Override
	public void paint(Graphics g) {
		int rGaucheX0, rGaucheX1, rGaucheY0, rGaucheY1;//points pour le cote gauche
		int rDroiteX0, rDroiteX1, rDroiteY0, rDroiteY1;//points pour le cote droite
		g.clearRect(0, 0, ecranL + 20, ecranH + 20);// efface la fenetre
		g.drawLine(0, horiY, ecranL, horiY); //dessine notre trait d'horizon
		for(int i = 0; i < etat.getRoute().size()-1; i++) {//dessin de la route
			//points cote gauche
			rGaucheX0 = etat.getRoute().get(i).x - etat.getMotoX();
			rGaucheY0 = etat.getRoute().get(i).y;
			rGaucheX1 = etat.getRoute().get(i+1).x - etat.getMotoX();
			rGaucheY1 = etat.getRoute().get(i+1).y;
			
			//points cote droit
			rDroiteX0 = etat.getRoute().get(i).x + Parcours.largeurRoute - etat.getMotoX();
			rDroiteY0 = etat.getRoute().get(i).y;
			rDroiteX1 = etat.getRoute().get(i+1).x + Parcours.largeurRoute - etat.getMotoX();
			rDroiteY1 =  etat.getRoute().get(i+1).y;
			
			//route 1 (trait a gauche)
			g.drawLine(rGaucheX0, rGaucheY0, rGaucheX1, rGaucheY1);
			//route 2 (trait a droite)
			g.drawLine(rDroiteX0, rDroiteY0, rDroiteX1, rDroiteY1);
		}
		
		g.drawOval(ecranH/2-7,  ecranL/2, 15, 15);//dessin de la moto
	}
	

}
