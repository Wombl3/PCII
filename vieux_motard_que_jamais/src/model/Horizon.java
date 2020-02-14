package model;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import view.Affichage;

public class Horizon {
	
	/* --- DECLARATION DE VARIABLES --- */
	
	private ArrayList<Point> Horizon = new ArrayList<Point>();//notre horizon, pour construire les montagnes
	private static Random rand = new Random();//utilisee pour la generation random de points
	private Parcours myParc = new Parcours();//un Parcours
	
	private int maxOrd = Affichage.horiY - Affichage.ecranH/8;//la taille maximale autorisee en Y
	private int minOrd = Affichage.ecranH/8;//la taille minimale autorisee en Y
	
	private int maxAbs = Affichage.ecranL/6;//la taille maximale autorisee en X
	private int minAbs = Affichage.ecranL/10;//la taille minimale autorisee en X
	
	

	/* --- CONSTRUCTEURS --- */
	
	public ArrayList<Point> getHorizon(Parcours p){
		myParc = p;
		int abs = -Affichage.ecranL;
		ArrayList<Point> horiBis = new ArrayList<Point>();
		int i = 0;
		int x,y;
		while(abs < 2*Affichage.ecranH) {
			x = rand.nextInt(maxAbs) + minAbs;
			y = rand.nextInt(maxOrd) + minOrd; 
			horiBis.add(new Point(x, y));
			i++;
		}
		return horiBis;
	}
	
}
