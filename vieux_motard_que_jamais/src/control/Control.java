package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import model.Etat;
import view.Affichage;


public class Control implements KeyListener{
	
	/* --- DECLARATION DE VARIABLES --- */
	
	private Affichage myAffichage;
	private Etat myEtat;
	
	/* --- CONSTRUCTEURS --- */
	
	/** Constructeur initialisant les variables globales de la classe
	 * Lance egalement le thread Avancer */
	public Control(Affichage a, Etat e) {
		this.myAffichage = a;
		this.myEtat = e;
		(new Avancer(e, a)).start();
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            myEtat.setMotoX(10);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        	myEtat.setMotoX(-10);
        }
        myAffichage.repaint();
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
	}
}
