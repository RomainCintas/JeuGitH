import java.util.Random;

public class Plateau{ 
	     
	public String couleur1;
	public String couleur2;
	public String couleur3;
	public String couleur4;
	String grillage [][] = new String [15][15];
	public int i;
	public int j;
	
	public Plateau(){	
		for (int l=1;l<14;l++){ //Génération grillage
			for (int c=1;c<14;c++){
				grillage[l][c]= Random_letter() ; 
			}		
		}

//		for (int l=1;l<14;l++){ //Affichage du grillage
//			for (int c=1;c<14;c++){
//				System.out.print("	|	" + grillage[l][c]);
//			}
//		System.out.print("\n");
//		}
		
		//char couleur1 = grillage [0][0];
		//char couleur2 = grillage [13][13];
	}
	
	public String get_couleur_joueur(int i, int j){//Couleur des joueurs
		return grillage [i][j];
	}
	
	
	public String Random_letter(){//Génération d'une lettre aléatoire r,o,y,g,b,p
		String alphabet[] = {"r","o","j","v","b","i"};
		return alphabet[Alea(0,5)];
	}
	
	public int Alea (int min, int max){//Génération de nombre aléatoire entre min et max
		Random rand = new Random();
		int Alea = rand.nextInt(max - min + 1) + min;
		return Alea;
		
	}
	
	
	//public static char toChar(int codeASCII) { //code ASCII d'une lettres
	//	return (char)codeASCII; 
	//} 

	//public static int toASCII(char lettre) { //lettre correspondant à un code ASCII
	//	return (int)lettre; 
	//} 
}


