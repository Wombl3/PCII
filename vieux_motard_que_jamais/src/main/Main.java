package main;


import javax.swing.JFrame;


import view.Affichage;
/** Classe qui lance le jeu */
public class Main {

	private static Affichage view = new Affichage();

	/** Fonction Main initialisant notre JFrame avec notre vue */
	public static void main(String [] args) {
		JFrame fenetre = new JFrame("Vieux Motard que Jamais");
		fenetre.add(view);//rajoute la "vue" a notre fenetre
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
