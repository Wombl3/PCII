package model;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import view.Affichage;

public class Parcours {
	
	/* --- DECLARATION DE VARIABLES --- */
	
	private ArrayList<Point> route = new ArrayList<Point>();//va contenir les points de la route
	public static final int largeurRoute = Affichage.ecranL/7;//largeur de la route
	
	private static Random rand = new Random();//rand utilisé lors de la generation
	private int distRouteMax = (Affichage.ecranH - Affichage.horiY)/2;//distance max avant un nouveau tournant (VERT)
	private int distRouteMin = (Affichage.ecranH - Affichage.horiY)/8;//distance min avant un nouveau tournant (VERT)
	
	private int absRouteMin = Affichage.ecranH/4;//distance min de la taille du virage (HORI)
	private int absRouteMax = Affichage.ecranH * 3/4 - absRouteMin;//distance max de la taille du virage (HORI)
	
	private int position = 0;//la position de la moto, c egalement ce qu'on utilise pour le score
	private int incrPos = 10;//vitesse de base du jeu

	/* --- CONSTRUCTEURS --- */
	
	/** Constructeur intialisant les attributs de la classe (remplissage des premiers points visibles de la route) */
	public Parcours() {
		 //CREATION PTS 1
		 int x = (Affichage.ecranL - largeurRoute)/2;
		 int y = Affichage.ecranH;
		 route.add(new Point(x, y));//ajout du point
		 //CREATION PTS 2 (celui qui s'arrete a la fin de l'ecran)
		 x = (Affichage.ecranL - largeurRoute)/2;
		 y = 0;
		 route.add(new Point(x, y));
		 //CREATION PTS 3 (celui qui est en dehors de l'ecran)
		 x = rand.nextInt(absRouteMax) + absRouteMin;
		 y = route.get(route.size()-1).y - (rand.nextInt(distRouteMax) + distRouteMin);
		 route.add(new Point(x, y));
	}
	
	/* --- GETTERS --- */
	
	/** Methode permettant une generation infinie de points
	 * en prenant en compte "l'avancee" du joueur 
	 * @return Un ArrayList de points: notre route*/
	public ArrayList<Point> getParcours() {
		ArrayList<Point> routeBis = new ArrayList<Point>();
		
		//ENLEVE LES POINTS INUTILES (BAS DE L'ECRAN)
		if (route.get(0).y + position > Affichage.ecranH) {//si jamais le point est en dehors de l'ecran...
			if (route.get(1).y + position >= Affichage.ecranH) route.remove(0); //... et que le suivant l'est aussi, on retire
		}
		
		//RAJOUTE LES POINTS TELS QUELS
		for(int i = 0; i < route.size(); i++) {
			routeBis.add(new Point(route.get(i).x, route.get(i).y + position));
		}
		
		//GENERATION DU POINT EN DEHORS DE L'ECRAN (HAUT DE L'ECRAN)
		if(route.get(route.size()-1).y + position > 0) {//si le dernier point se trouve dans notre zone visible, on doit en creer un nouveau
			int last = route.get(route.size()-1).y;//on recupere la valeur du dernier point
			int x = rand.nextInt(absRouteMax) + absRouteMin;
			int y = last - (rand.nextInt(distRouteMax) + distRouteMin);//on creer un nouveau point en prenant en compte la distance
			
			//AJOUT AUX 2 ARRAYLIST
			route.add(new Point(x, y));
			routeBis.add(new Point(x, y));
		}
		return routeBis;
	}
	
	/** Methode renvoyant la valeur de la position 
	 * @return un int: la position*/
	public int getPos() {
		return position;
	}
	
	/* --- PROCEDURES --- */
	
	/** Procedure incrementant la position, simulant une avancee du joueur */
	public void incrPos() {
		position+=incrPos;
	}
	
	

}
