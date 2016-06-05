import java.awt.Color;
import java.util.Random;

public class Plateau{ 
	     
	public static char couleur1;
	public static char couleur2;
	public static char couleur3;
	public static char couleur4;

	public static int ligne1 = 1;
	public static int colonne1 = 1;
	public static int ligne2 = Jeu.tailleGrille;
	public static int colonne2 = Jeu.tailleGrille;
	public static int ligne3 = 1;
	public static int colonne3 = Jeu.tailleGrille;
	public static int ligne4 = Jeu.tailleGrille;
	public static int colonne4 = 1;
	
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
	public Plateau(){
		ligne2 = Jeu.tailleGrille;
		colonne2 = Jeu.tailleGrille;
		colonne3 = Jeu.tailleGrille;
		ligne4 = Jeu.tailleGrille;

		grillage = new char [Jeu.tailleGrille+2][Jeu.tailleGrille+3];//par défaut [15][16]
		for (int ligne=0;ligne<Jeu.tailleGrille+2;ligne++){ 
			for (int colonne=0;colonne<Jeu.tailleGrille+3;colonne++){//par défaut 14 16
				grillage[ligne][colonne]= 'x' ; 
			}		
		}
		for (int ligne=1;ligne<Jeu.tailleGrille+1;ligne++){//par défaut 14
			for (int colonne=1;colonne<Jeu.tailleGrille+1;colonne++){//par défaut 14
				grillage[ligne][colonne]= Random_letter() ; 
			}		
		}

		
		grillage[Jeu.tailleGrille-9][Jeu.tailleGrille+2]='s';//par défaut [4][15]
		grillage[Jeu.tailleGrille-8][Jeu.tailleGrille+2]='i';//par défaut [5][15]
		grillage[Jeu.tailleGrille-7][Jeu.tailleGrille+2]='b';//par défaut [6][15]
		grillage[Jeu.tailleGrille-6][Jeu.tailleGrille+2]='v';//par défaut [7][15]
		grillage[Jeu.tailleGrille-5][Jeu.tailleGrille+2]='j';//par défaut [8][15]
		grillage[Jeu.tailleGrille-4][Jeu.tailleGrille+2]='o';//par défaut [9][15]
		grillage[Jeu.tailleGrille-3][Jeu.tailleGrille+2]='r';//par défaut [10][15]

	}
	
	//Couleur des joueurs
	public char getCouleurJoueur(int ligne, int colonne){
		return grillage [ligne][colonne];
	}
		
	//Création de la grille initiale
	public static void creaGrille(){
		ligne2 = Jeu.tailleGrille;
		colonne2 = Jeu.tailleGrille;
		colonne3 = Jeu.tailleGrille;
		ligne4 = Jeu.tailleGrille;
		Plateau grillage = new Plateau();
		do{
			couleur1 = grillage.getCouleurJoueur(ligne1,colonne1);
			couleur2 = grillage.getCouleurJoueur(ligne2,colonne2);
			couleur3 = '3';
			couleur4 = '4';
			if (Jeu.NBJOUEUR == 3 || Jeu.NBJOUEUR == 4){
				couleur3 = grillage.getCouleurJoueur(ligne3,colonne3);
				if (Jeu.NBJOUEUR == 4){
					couleur4 = grillage.getCouleurJoueur(ligne4, colonne4);
				}
			}
			if((couleur1 == couleur2 && Jeu.NBJOUEUR == 2) ||
					(Jeu.NBJOUEUR == 3 && (couleur1 == couleur2 || couleur2 == couleur3 ||couleur1 == couleur3 || couleur2 == couleur3)) ||
					(Jeu.NBJOUEUR == 4 && (couleur1 == couleur2 || couleur1 == couleur3 || couleur2 == couleur3 || couleur3 == couleur4 || couleur1 == couleur4 || couleur2 == couleur4))){
				grillage = new Plateau();
			}
		}while((couleur1 == couleur2 && Jeu.NBJOUEUR == 2) ||
				(Jeu.NBJOUEUR == 3 && (couleur1 == couleur2 || couleur2 == couleur3 ||couleur1 == couleur3 || couleur2 == couleur3)) ||
				(Jeu.NBJOUEUR == 4 && (couleur1 == couleur2 || couleur1 == couleur3 || couleur2 == couleur3 || couleur3 == couleur4 || couleur1 == couleur4 || couleur2 == couleur4)));
	
	}
	
	//Affichage du plateau
	public static void affichagePlateau(char[][] grillage){
		if ((Jeu.compteurTour>0 && Jeu.NBJOUEUR == 2) || (Jeu.compteurTour>1 && Jeu.NBJOUEUR == 3) || (Jeu.compteurTour>2 && Jeu.NBJOUEUR == 4)){
			affichagePlateauConsole(grillage);
			affichagePlateauGraphique(grillage);
		}
	}
	
	//Affichage console du plateau
	public static void affichagePlateauConsole(char[][] grillage){
		System.out.print("\n");
		for (int ligneBoucle=1;ligneBoucle<Jeu.tailleGrille+1;ligneBoucle++){//par défaut 14
			for (int colonneBoucle=1;colonneBoucle<Jeu.tailleGrille+1;colonneBoucle++){//par défaut 14
				System.out.print("	|	" + grillage[ligneBoucle][colonneBoucle]);
			}
			System.out.print("\n");
		
		}
		
	}
	
	//Affichage graphique du plateau
	public static void affichagePlateauGraphique(char[][] grillage){
		//StdDraw.clear();
		for (int ligneBoucle=1;ligneBoucle<Jeu.tailleGrille+1;ligneBoucle++){//par défaut 14
			for (int colonneBoucle=1;colonneBoucle<Jeu.tailleGrille+3;colonneBoucle++){//par défaut 16
				StdDraw.setPenColor(StdDraw.GRAY);
				if (Character.toLowerCase(grillage[ligneBoucle][colonneBoucle]) == 'r'){
					StdDraw.setPenColor(StdDraw.RED);
				}
				else if (Character.toLowerCase(grillage[ligneBoucle][colonneBoucle]) == 'o'){
					StdDraw.setPenColor(new Color(255, 127, 0));//Orange
				}
				else if (Character.toLowerCase(grillage[ligneBoucle][colonneBoucle]) == 'j'){
					StdDraw.setPenColor(StdDraw.YELLOW);
				}
				else if (Character.toLowerCase(grillage[ligneBoucle][colonneBoucle]) == 'v'){
					StdDraw.setPenColor(StdDraw.GREEN);
				}
				else if (Character.toLowerCase(grillage[ligneBoucle][colonneBoucle]) == 'b'){
					StdDraw.setPenColor(StdDraw.BLUE);
				}
				else if (Character.toLowerCase(grillage[ligneBoucle][colonneBoucle]) == 'i'){
					StdDraw.setPenColor(StdDraw.MAGENTA);//Violet
				}
				else if (Character.toLowerCase(grillage[ligneBoucle][colonneBoucle]) == 'x'){
					StdDraw.setPenColor(StdDraw.WHITE);
				}
				StdDraw.filledSquare(colonneBoucle, Jeu.tailleGrille+1-ligneBoucle, 0.4);//par défaut 14
				
				if (Character.toLowerCase(grillage[ligneBoucle][colonneBoucle]) == 's'){
					StdDraw.setPenColor(StdDraw.RED);//rouge
					StdDraw.rectangle(colonneBoucle, Jeu.tailleGrille+1-ligneBoucle, 0.1, 0.1);//par défaut 14
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.text(colonneBoucle, Jeu.tailleGrille+1-ligneBoucle, "S");
				}
			}
		}
		StdDraw.setPenColor(StdDraw.BLACK);
	}
	
	//initialisation interface graphique
	public static void initialisationInterfaceGraphique(){
		StdDraw.setCanvasSize(1000, 1000);//initialisation de la feuille de dessin
		StdDraw.setPenRadius(0.1);//définition de la taille du pinceau
		StdDraw.setScale(0, Jeu.tailleGrille+4);//redéfinition de la grille sur le graphique
	}
}


