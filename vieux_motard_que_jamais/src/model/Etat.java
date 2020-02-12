package model;

import java.awt.Point;
import java.util.ArrayList;

import view.Affichage;

/** Classe qui s'occupe de tout ce qui est modifications de l'environnement (variables) 
 * contient toujours des methodes pour pouvoir acceder aux variables*/
public class Etat {
	private int motoX = 0;
	private int motoY = Affichage.motoY;

	
	private static final int vitX = 10;
	private static final int vitY = 10;
	
	Parcours parcours = new Parcours();
	
	private ArrayList<Point> route = parcours.getParcours();
	
	public int getMotoX() {
		return motoX;
	}
	
	public int getMotoY() {
		return motoY;
	}
	
	public void setMotoX(int x) {
		motoX = motoX + x;
	}
	
	public void setMotoY(int y) {
		motoX = motoY + y;
	}
	
	public ArrayList<Point> getRoute() {
		return route;
	}
	
	public void avancer() {
		parcours.incrPos();
		route = parcours.getParcours();
	}
	
}
