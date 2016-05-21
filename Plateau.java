import java.awt.Color;
import java.util.Random;

public class Plateau{ 
	     
	public static String couleur1;
	public static String couleur2;
	public static String couleur3;
	public static String couleur4;
	
	public static int tailleGrille= 13;

	
	public static int ligne1 = 1;
	public static int colonne1 = 1;
	public static int ligne2= 13;
	public static int colonne2 = 13;
	public static int ligne3 = 1;
	public static int colonne3 = 13;
	public static int ligne4= 13;
	public static int colonne4 = 1;
	
	static String grillage [][] = new String [15][16];
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
	public Plateau(){
		for (int ligne=1;ligne<14;ligne++){ 
			for (int colonne=1;colonne<14;colonne++){
				grillage[ligne][colonne]= Random_letter() ; 
			}		
		}
		for (int ligne=1;ligne<14;ligne++){ 
			for (int colonne=14;colonne<16;colonne++){
				grillage[ligne][colonne]= "blanc" ; 
			}		
		}
		grillage[5][15]="i";
		grillage[6][15]="b";
		grillage[7][15]="v";
		grillage[8][15]="j";
		grillage[9][15]="o";
		grillage[10][15]="r";
	}
	
	//Couleur des joueurs
	public String getCouleurJoueur(int ligne, int colonne){
		return grillage [ligne][colonne];
	}
		
	//Création de la grille initiale
	public static void creaGrille(int NBJOUEUR){
		Plateau grillage = new Plateau();
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
				grillage = new Plateau();
			}
		}while((couleur1.equals(couleur2) && NBJOUEUR == 2) ||
				(NBJOUEUR == 3 && (couleur1.equals(couleur2) || couleur2.equals(couleur3) ||couleur1.equals(couleur3) || couleur2.equals(couleur3))) ||
				(NBJOUEUR == 4 && (couleur1.equals(couleur2) || (couleur1.equals(couleur3) || couleur2.equals(couleur3) || couleur3.equals(couleur4) || couleur1.equals(couleur4) || couleur2.equals(couleur4)))));
	
	}
	
	//Affichage du plateau
	public static void affichagePlateau(String[][] grillage, int compteurTour,int NBJOUEUR){
		if ((compteurTour>0 && NBJOUEUR == 2) || (compteurTour>1 && NBJOUEUR == 3) || (compteurTour>2 && NBJOUEUR == 4)){
			affichagePlateauConsole(grillage);
			affichagePlateauGraphique(grillage);
		}
	}
	
	//Affichage console du plateau
	public static void affichagePlateauConsole(String[][] grillage){
		System.out.print("\n");
		for (int ligneBoucle=1;ligneBoucle<14;ligneBoucle++){
			for (int colonneBoucle=1;colonneBoucle<14;colonneBoucle++){
				System.out.print("	|	" + grillage[ligneBoucle][colonneBoucle]);
			}
		System.out.print("\n");
		}
	}
	
	//Affichage graphique du plateau
	public static void affichagePlateauGraphique(String[][] grillage){
		//StdDraw.clear();
		for (int ligneBoucle=1;ligneBoucle<14;ligneBoucle++){
			for (int colonneBoucle=1;colonneBoucle<16;colonneBoucle++){
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
				StdDraw.filledSquare(colonneBoucle, 14-ligneBoucle, 0.4);
			}
		}
		StdDraw.setPenColor(StdDraw.BLACK);
	}
}


