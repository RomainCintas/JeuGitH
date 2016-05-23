import java.awt.Color;
import java.util.Random;

public class Plateau{ 
	     
	public static char couleur1;
	public static char couleur2;
	public static char couleur3;
	public static char couleur4;
	
	public static int tailleGrille = 13;

	public static int ligne1;
	public static int colonne1;
	public static int ligne2;
	public static int colonne2;
	public static int ligne3;
	public static int colonne3;
	public static int ligne4;
	public static int colonne4;
	
	static char[][] grillage;
	public int colonne;
	public int ligne;
	
	//Génération de nombre aléatoire entre min et max
	public static int Alea (int min, int max){
		Random rand = new Random();
		int Alea = rand.nextInt(max - min + 1) + min;
		return Alea;
		
	}
	
	//Génération d'une lettre aléatoire r,o,y,g,b,p
	public static char Random_letter(){
		char alphabet[] = {'r','o','j','v','b','i'};
		return alphabet[Alea(0,5)];
	}
	
	//Génération d'un grillage
	public Plateau(int tailleGrille){
		ligne1 = 1;
		colonne1 = 1;
		ligne2 = tailleGrille;
		colonne2 = tailleGrille;
		ligne3 = 1;
		colonne3 = tailleGrille;
		ligne4 = tailleGrille;
		colonne4 = 1;
		grillage = new char [tailleGrille+2][tailleGrille+3];//par défaut [15][16]
		for (int ligne=1;ligne<tailleGrille+1;ligne++){//par défaut 14
			for (int colonne=1;colonne<tailleGrille+1;colonne++){//par défaut 14
				grillage[ligne][colonne]= Random_letter() ; 
			}		
		}
		for (int ligne=1;ligne<tailleGrille+1;ligne++){ 
			for (int colonne=tailleGrille+1;colonne<tailleGrille+3;colonne++){//par défaut 14 16
				grillage[ligne][colonne]= 'x' ; 
			}		
		}
		grillage[tailleGrille-8][tailleGrille+2]='i';//par défaut [5][15]
		grillage[tailleGrille-7][tailleGrille+2]='b';//par défaut [6][15]
		grillage[tailleGrille-6][tailleGrille+2]='v';//par défaut [7][15]
		grillage[tailleGrille-5][tailleGrille+2]='j';//par défaut [8][15]
		grillage[tailleGrille-4][tailleGrille+2]='o';//par défaut [9][15]
		grillage[tailleGrille-3][tailleGrille+2]='r';//par défaut [10][15]
	}
	
	//Couleur des joueurs
	public char getCouleurJoueur(int ligne, int colonne){
		return grillage [ligne][colonne];
	}
		
	//Création de la grille initiale
	public static void creaGrille(int NBJOUEUR, int tailleGrille){
		Plateau grillage = new Plateau(tailleGrille);
		do{
			couleur1 = grillage.getCouleurJoueur(ligne1,colonne1);
			couleur2 = grillage.getCouleurJoueur(ligne2,colonne2);
			System.out.print(" Couleur 1 : " + couleur1 + " Couleur 2 : " + couleur2);
			couleur3 = '3';
			couleur4 = '4';
			if (NBJOUEUR == 3 || NBJOUEUR == 4){
				couleur3 = grillage.getCouleurJoueur(ligne3,colonne3);
				if (NBJOUEUR == 4){
					couleur4 = grillage.getCouleurJoueur(ligne4, colonne4);
				}
			}
			if((couleur1 == couleur2 && NBJOUEUR == 2) ||
					(NBJOUEUR == 3 && (couleur1 == couleur2 || couleur2 == couleur3 ||couleur1 == couleur3 || couleur2 == couleur3)) ||
					(NBJOUEUR == 4 && (couleur1 == couleur2 || couleur1 == couleur3 || couleur2 == couleur3 || couleur3 == couleur4 || couleur1 == couleur4 || couleur2 == couleur4))){
				grillage = new Plateau(tailleGrille);
			}
		}while((couleur1 == couleur2 && NBJOUEUR == 2) ||
				(NBJOUEUR == 3 && (couleur1 == couleur2 || couleur2 == couleur3 ||couleur1 == couleur3 || couleur2 == couleur3)) ||
				(NBJOUEUR == 4 && (couleur1 == couleur2 || couleur1 == couleur3 || couleur2 == couleur3 || couleur3 == couleur4 || couleur1 == couleur4 || couleur2 == couleur4)));
	
	}
	
	//Affichage du plateau
	public static void affichagePlateau(char[][] grillage, int compteurTour,int NBJOUEUR, int tailleGrille){
		if ((compteurTour>0 && NBJOUEUR == 2) || (compteurTour>1 && NBJOUEUR == 3) || (compteurTour>2 && NBJOUEUR == 4)){
			affichagePlateauConsole(grillage, tailleGrille);
			affichagePlateauGraphique(grillage, tailleGrille);
		}
	}
	
	//Affichage console du plateau
	public static void affichagePlateauConsole(char[][] grillage, int tailleGrille){
		System.out.print("\n");
		for (int ligneBoucle=1;ligneBoucle<tailleGrille+1;ligneBoucle++){//par défaut 14
			for (int colonneBoucle=1;colonneBoucle<tailleGrille+1;colonneBoucle++){//par défaut 14
				System.out.print("	|	" + grillage[ligneBoucle][colonneBoucle]);
			}
		System.out.print("\n");
		}
	}
	
	//Affichage graphique du plateau
	public static void affichagePlateauGraphique(char[][] grillage, int tailleGrille){
		//StdDraw.clear();
		for (int ligneBoucle=1;ligneBoucle<tailleGrille+1;ligneBoucle++){//par défaut 14
			for (int colonneBoucle=1;colonneBoucle<tailleGrille+3;colonneBoucle++){//par défaut 16
				StdDraw.setPenColor(StdDraw.GRAY);
				if (Character.toLowerCase(grillage[ligneBoucle][colonneBoucle]) == 'r'){
					StdDraw.setPenColor(StdDraw.RED);
				}
				if (Character.toLowerCase(grillage[ligneBoucle][colonneBoucle]) == 'o'){
					StdDraw.setPenColor(new Color(255, 127, 0));//Orange
				}
				if (Character.toLowerCase(grillage[ligneBoucle][colonneBoucle]) == 'j'){
					StdDraw.setPenColor(StdDraw.YELLOW);
				}
				if (Character.toLowerCase(grillage[ligneBoucle][colonneBoucle]) == 'v'){
					StdDraw.setPenColor(StdDraw.GREEN);
				}
				if (Character.toLowerCase(grillage[ligneBoucle][colonneBoucle]) == 'b'){
					StdDraw.setPenColor(StdDraw.BLUE);
				}
				if (Character.toLowerCase(grillage[ligneBoucle][colonneBoucle]) == 'i'){
					StdDraw.setPenColor(StdDraw.MAGENTA);//Violet
				}
				if (Character.toLowerCase(grillage[ligneBoucle][colonneBoucle]) == 'x'){
					StdDraw.setPenColor(StdDraw.WHITE);
				}
				StdDraw.filledSquare(colonneBoucle, tailleGrille+1-ligneBoucle, 0.4);//par défaut 14
			}
		}
		StdDraw.setPenColor(StdDraw.BLACK);
	}
	
	//initialisation interface graphique
	public static void initialisationInterfaceGraphique(int tailleGrille){
		StdDraw.setCanvasSize(1000, 1000);//initialisation de la feuille de dessin
		StdDraw.setPenRadius(0.1);//définition de la taille du pinceau
		StdDraw.setXscale(0, tailleGrille+4);//redéfinition de la grille sur le graphique
		StdDraw.setYscale(0, tailleGrille+4);
		StdDraw.setScale(0, tailleGrille+4);
	}
}


