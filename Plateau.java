import java.awt.Color;
import java.util.Random;

public class Plateau{ 
	     
	public static String couleur1;
	public static String couleur2;
	public static String couleur3;
	public static String couleur4;
	
	public static int tailleGrille = 13;

	public static int ligne1;
	public static int colonne1;
	public static int ligne2;
	public static int colonne2;
	public static int ligne3;
	public static int colonne3;
	public static int ligne4;
	public static int colonne4;
	
	static String[][] grillage;
	public int colonne;
	public int ligne;
	
	//Génération de nombre aléatoire entre min et max
	public static int Alea (int min, int max){
		Random rand = new Random();
		int Alea = rand.nextInt(max - min + 1) + min;
		return Alea;
		
	}
	
	//Génération d'une lettre aléatoire r,o,y,g,b,p
	public static String Random_letter(){
		String alphabet[] = {"r","o","j","v","b","i"};
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
		grillage = new String [tailleGrille+2][tailleGrille+3];//par défaut [15][16]
		for (int ligne=1;ligne<tailleGrille+1;ligne++){//par défaut 14
			for (int colonne=1;colonne<tailleGrille+1;colonne++){//par défaut 14
				grillage[ligne][colonne]= Random_letter() ; 
			}		
		}
		for (int ligne=1;ligne<tailleGrille+1;ligne++){ 
			for (int colonne=tailleGrille+1;colonne<tailleGrille+3;colonne++){//par défaut 14 16
				grillage[ligne][colonne]= "blanc" ; 
			}		
		}
		grillage[tailleGrille-8][tailleGrille+2]="i";//par défaut [5][15]
		grillage[tailleGrille-7][tailleGrille+2]="b";//par défaut [6][15]
		grillage[tailleGrille-6][tailleGrille+2]="v";//par défaut [7][15]
		grillage[tailleGrille-5][tailleGrille+2]="j";//par défaut [8][15]
		grillage[tailleGrille-4][tailleGrille+2]="o";//par défaut [9][15]
		grillage[tailleGrille-3][tailleGrille+2]="r";//par défaut [10][15]
	}
	
	//Couleur des joueurs
	public String getCouleurJoueur(int ligne, int colonne){
		return grillage [ligne][colonne];
	}
		
	//Création de la grille initiale
	public static void creaGrille(int NBJOUEUR, int tailleGrille){
		Plateau grillage = new Plateau(tailleGrille);
		do{
			couleur1 = grillage.getCouleurJoueur(ligne1,colonne1);
			couleur2 = grillage.getCouleurJoueur(ligne2,colonne2);
			System.out.print(" Couleur 1 : " + couleur1 + " Couleur 2 : " + couleur2);
			couleur3 = "couleur 3";
			couleur4 = "couleur 4";
			if (NBJOUEUR == 3 || NBJOUEUR == 4){
				couleur3 = grillage.getCouleurJoueur(ligne3,colonne3);
				if (NBJOUEUR == 4){
					couleur4 = grillage.getCouleurJoueur(ligne4, colonne4);
				}
			}
			if((couleur1.equals(couleur2) && NBJOUEUR == 2) ||
					(NBJOUEUR == 3 && (couleur1.equals(couleur2) || couleur2.equals(couleur3) ||couleur1.equals(couleur3) || couleur2.equals(couleur3))) ||
					(NBJOUEUR == 4 && (couleur1.equals(couleur2) || (couleur1.equals(couleur3) || couleur2.equals(couleur3) || couleur3.equals(couleur4) || couleur1.equals(couleur4) || couleur2.equals(couleur4))))){
				grillage = new Plateau(tailleGrille);
			}
		}while((couleur1.equals(couleur2) && NBJOUEUR == 2) ||
				(NBJOUEUR == 3 && (couleur1.equals(couleur2) || couleur2.equals(couleur3) ||couleur1.equals(couleur3) || couleur2.equals(couleur3))) ||
				(NBJOUEUR == 4 && (couleur1.equals(couleur2) || (couleur1.equals(couleur3) || couleur2.equals(couleur3) || couleur3.equals(couleur4) || couleur1.equals(couleur4) || couleur2.equals(couleur4)))));
	
	}
	
	//Affichage du plateau
	public static void affichagePlateau(String[][] grillage, int compteurTour,int NBJOUEUR, int tailleGrille){
		if ((compteurTour>0 && NBJOUEUR == 2) || (compteurTour>1 && NBJOUEUR == 3) || (compteurTour>2 && NBJOUEUR == 4)){
			affichagePlateauConsole(grillage, tailleGrille);
			affichagePlateauGraphique(grillage, tailleGrille);
		}
	}
	
	//Affichage console du plateau
	public static void affichagePlateauConsole(String[][] grillage, int tailleGrille){
		System.out.print("\n");
		for (int ligneBoucle=1;ligneBoucle<tailleGrille+1;ligneBoucle++){//par défaut 14
			for (int colonneBoucle=1;colonneBoucle<tailleGrille+1;colonneBoucle++){//par défaut 14
				System.out.print("	|	" + grillage[ligneBoucle][colonneBoucle]);
			}
		System.out.print("\n");
		}
	}
	
	//Affichage graphique du plateau
	public static void affichagePlateauGraphique(String[][] grillage, int tailleGrille){
		//StdDraw.clear();
		for (int ligneBoucle=1;ligneBoucle<tailleGrille+1;ligneBoucle++){//par défaut 14
			for (int colonneBoucle=1;colonneBoucle<tailleGrille+3;colonneBoucle++){//par défaut 16
				StdDraw.setPenColor(StdDraw.GRAY);
				if (grillage[ligneBoucle][colonneBoucle].toLowerCase().equals("r")){
					StdDraw.setPenColor(StdDraw.RED);
				}
				if (grillage[ligneBoucle][colonneBoucle].toLowerCase().equals("o")){
					StdDraw.setPenColor(new Color(255, 127, 0));//Orange
				}
				if (grillage[ligneBoucle][colonneBoucle].toLowerCase().equals("j")){
					StdDraw.setPenColor(StdDraw.YELLOW);
				}
				if (grillage[ligneBoucle][colonneBoucle].toLowerCase().equals("v")){
					StdDraw.setPenColor(StdDraw.GREEN);
				}
				if (grillage[ligneBoucle][colonneBoucle].toLowerCase().equals("b")){
					StdDraw.setPenColor(StdDraw.BLUE);
				}
				if (grillage[ligneBoucle][colonneBoucle].toLowerCase().equals("i")){
					StdDraw.setPenColor(StdDraw.MAGENTA);//Violet
				}
				if (grillage[ligneBoucle][colonneBoucle].toLowerCase().equals("blanc")){
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


