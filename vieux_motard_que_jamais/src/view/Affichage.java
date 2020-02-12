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

	public static final int ecranH = 1000;
	public static final int ecranL = 1000;
	public static final int motoX = ecranH/2;
	public static final int motoY = ecranL/2;
	
	public static final int horiY = ecranH/3;
	
	
	private Etat etat = new Etat();
	



	public Affichage() {
		this.setFocusable(true);
		setPreferredSize(new Dimension(ecranL, ecranH));
		this.addKeyListener(new Control(this, this.etat));

	}

	/**
	 * Fonction paint qui dessine un ovale avec les variables ci-dessus et qui le
	 * remplacera lors du prochain appel de la fonction
	 */
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, ecranL + 20, ecranH + 20);// efface la fenetre
		g.drawLine(0, horiY, ecranL, horiY); 
		for(int i = 0; i < etat.getRoute().size()-1; i++) {
			g.drawLine(etat.getRoute().get(i).x - etat.getMotoX(), etat.getRoute().get(i).y, etat.getRoute().get(i+1).x - etat.getMotoX(), etat.getRoute().get(i+1).y);
			g.drawLine(etat.getRoute().get(i).x + Parcours.largeurRoute - etat.getMotoX(), etat.getRoute().get(i).y, etat.getRoute().get(i+1).x + Parcours.largeurRoute - etat.getMotoX(), etat.getRoute().get(i+1).y);
		}
		
		g.drawOval(ecranH/2-7,  ecranL/2, 15, 15);
	}
	

}
