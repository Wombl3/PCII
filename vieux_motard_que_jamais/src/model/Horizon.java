package model;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import view.Affichage;

public class Horizon {
	
	private ArrayList<Point> Horizon = new ArrayList<Point>();
	private static Random rand = new Random();
	private int maxOrd = Affichage.horiY - Affichage.ecranH/8;
	private int minOrd = Affichage.ecranH/8;
	private int maxAbs = Affichage.ecranL/6;
	private int minAbs = Affichage.ecranL/10;
	private Parcours myParc = new Parcours();

	
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
