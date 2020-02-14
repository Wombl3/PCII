package model;

import java.awt.Point;
import java.util.ArrayList;

import view.Affichage;

/** Classe qui s'occupe de tout ce qui est modifications de l'environnement (variables) 
 * contient toujours des methodes pour pouvoir acceder aux variables*/
public class Etat {
	
	/* --- DECLARATION DE VARIABLES --- */
	
	private int motoX = 0;//position de notre moto (pas literalement, notre moto reste au centre, mais ca sert a gerer le deplacement/gauche droite)
	private int motoY = Affichage.motoY;//position de notre moto (meme fonctionnement que dessus)

	
	private static final int vitX = 10;//vitesse de deplacement de gauche/droite
	private static final int vitY = 10;//vitesse de deplacement haut/bas
	
	Parcours parcours = new Parcours();
	private ArrayList<Point> route = parcours.getParcours();//ArrayList contenant les points utilises pour dessiner la route
	
	/* --- GETTERS --- */
	
	/** Methode renvoyant la position de notre moto en x
	 *@return  motoX, un int */
	public int getMotoX() {
		return motoX;
	}
	
	/** Methode renvoyant la position de notre moto en y
	 *@return  motoY, un int */
	public int getMotoY() {
		return motoY;
	}
	
	/** Methode renvoyant notre route generee aleatoirement
	 *@return  route, un ArrayList de Points */
	public ArrayList<Point> getRoute() {
		return route;
	}
	
	/* --- PROCEDURES --- */
	
	/** Procedure permettant de simuler un deplacement gauche/droite de notre affichage (utilisee dans Control.java) */
	public void setMotoX(int x) {
		motoX = motoX + x;
	}
	
	/** Procedure permettant de simuler un deplacement haut/bas de notre affichage (utilisee dans Control.java) */
	public void setMotoY(int y) {
		motoX = motoY + y;
	}
	
	/** Procedure permettant de simuler un avancement de la route (defile du haut vers le bas) */
	public void avancer() {
		parcours.incrPos();
		route = parcours.getParcours();
	}
	
}
