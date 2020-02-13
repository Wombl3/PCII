package control;

import model.Etat;
import view.Affichage;

public class Avancer extends Thread {
	
	/* --- DECLARATION DE VARIABLES --- */
	
	public static final int sleepTime = 50;//duree ou le Thread va etre en Sleep
	private Etat etatA;
	private Affichage affichageA;
	
	/* --- CONSTRUCTEURS --- */
	
	/** Constructeur initialisant les variables globales de la classe */
	
	public Avancer(Etat e, Affichage a) {
		etatA = e;
		affichageA = a;
	}
	
	@Override 
	public void run() {
		while(true){
			etatA.avancer();//appelle la methode avancer pour faire simuler une avancee du plateau
			affichageA.repaint();//repeint notre fenetre
			try { Thread.sleep(sleepTime); }
		    catch (Exception e) { e.printStackTrace(); }
		}
		
		
	}

}
