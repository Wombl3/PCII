package model;

import java.awt.Point;
import java.util.ArrayList;

import view.Affichage;

/** Classe qui s'occupe de tout ce qui est modifications de l'environnement (variables) 
 * contient toujours des methodes pour pouvoir acceder aux variables*/
public class Etat {
	
	/* --- DECLARATION DE VARIABLES --- */
	
	private int motoX = 0;//position de notre moto (pas literalement, notre moto reste au centre,
	//mais ca sert a gerer le deplacement/gauche droite)
	private int motoY = Affichage.motoY;//position de notre moto (meme fonctionnement que dessus)

	
	private static final int vitX = 10;//vitesse de deplacement de gauche/droite
	private static final int vitY = 10;//vitesse de deplacement haut/bas
	
	Parcours parcours = new Parcours();
	
	private ArrayList<Point> route = parcours.getParcours();
	
	/* --- GETTERS --- */
	
	/* Methode renvoyant la position de notre moto
	 * @return motoX, un int */
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
