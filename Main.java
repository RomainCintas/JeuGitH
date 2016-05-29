public class Main {
	static int NBJOUEUR = Joueur.NBJOUEUR;
	static int tailleGrille = Plateau.tailleGrille;
	
	public static void main(String[] args) {

		Plateau.initialisationInterfaceGraphique(tailleGrille);
		Menu.menu(NBJOUEUR,tailleGrille);
		
	}
}
