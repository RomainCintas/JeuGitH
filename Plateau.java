import java.util.Random;

public class Plateau{ 
	     
	public String couleur1;
	public String couleur2;
	public String couleur3;
	public String couleur4;
	String grillage [][] = new String [15][16];
	public int colonne;
	public int ligne;
	
	//Génération du grillage
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
	
	//Génération d'une lettre aléatoire r,o,y,g,b,p
	public String Random_letter(){
		String alphabet[] = {"r","o","j","v","b","i"};
		return alphabet[Alea(0,5)];
	}
	
	//Génération de nombre aléatoire entre min et max
	public int Alea (int min, int max){
		Random rand = new Random();
		int Alea = rand.nextInt(max - min + 1) + min;
		return Alea;
		
	}
	
	//Affichage console du plateau
	public static void affichagePlateauConsole(Plateau grillage){
		System.out.print("\n");
		for (int ligneBoucle=1;ligneBoucle<14;ligneBoucle++){
			for (int colonneBoucle=1;colonneBoucle<14;colonneBoucle++){
				System.out.print("	|	" + grillage.grillage[ligneBoucle][colonneBoucle]);
			}
		System.out.print("\n");
		}
	}
	
	//Affichage graphique du plateau
	public static void affichagePlateauGraphique(Plateau grillage){
		StdDraw.clear();
		for (int ligneBoucle=1;ligneBoucle<14;ligneBoucle++){
			for (int colonneBoucle=1;colonneBoucle<16;colonneBoucle++){
				StdDraw.setPenColor(StdDraw.GRAY);
				if (grillage.grillage[ligneBoucle][colonneBoucle].toLowerCase().equals("r")){
					StdDraw.setPenColor(StdDraw.RED);
				}
				if (grillage.grillage[ligneBoucle][colonneBoucle].toLowerCase().equals("o")){
					StdDraw.setPenColor(StdDraw.ORANGE);
				}
				if (grillage.grillage[ligneBoucle][colonneBoucle].toLowerCase().equals("j")){
					StdDraw.setPenColor(StdDraw.YELLOW);
				}
				if (grillage.grillage[ligneBoucle][colonneBoucle].toLowerCase().equals("v")){
					StdDraw.setPenColor(StdDraw.GREEN);
				}
				if (grillage.grillage[ligneBoucle][colonneBoucle].toLowerCase().equals("b")){
					StdDraw.setPenColor(StdDraw.BLUE);
				}
				if (grillage.grillage[ligneBoucle][colonneBoucle].toLowerCase().equals("i")){
					StdDraw.setPenColor(StdDraw.MAGENTA);
				}
				if (grillage.grillage[ligneBoucle][colonneBoucle].toLowerCase().equals("blanc")){
				}
				StdDraw.filledSquare(colonneBoucle, 14-ligneBoucle, 0.4);
			}
		}
	}
}


