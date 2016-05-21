public class Main {
	static int NBJOUEUR = Joueur.NBJOUEUR;
	
	public static int choixNbJoueur(){
		NBJOUEUR = Joueur.choixNbJoueur();
		return NBJOUEUR;
	}
	
	public static void unJoueur(int NBJOUEUR){
		Jeu.unJoueur(NBJOUEUR);
	}
	
	public static void multijoueur(int NBJOUEUR){
		Jeu.multijoueur(NBJOUEUR);
	}
	
	public static void main(String[] args) {
		
		//initialisation interface graphique
		StdDraw.setCanvasSize(1000, 1000);//initialisation de la feuille de dessin
		StdDraw.setPenRadius(0.1);//définition de la taille du pinceau
		StdDraw.setXscale(0, 17);//redéfinition de la grille sur le graphique
		StdDraw.setYscale(0, 17);
		StdDraw.setScale(0, 17);
		
		Menu.menu(NBJOUEUR);
	}
}
