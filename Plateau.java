import java.util.Random;

public class Plateau extends Main{ 
	
	//public static void main(String[] args){
	  //}       
	public char couleur1;
	public char couleur2;
	char grillage [][] = new char [13][13];
	
	public Plateau(){	
		for (int l=0;l<13;l++){ //Génération grillage
			for (int c=0;c<13;c++){
				grillage[l][c]= Random_letter() ; 
			}		
		}

		for (int l=0;l<13;l++){ //Affichage du grillage
			for (int c=0;c<13;c++){
				System.out.print("	|	" + grillage[l][c]);
			}
		System.out.print("\n");
		}
		
		//char couleur1 = grillage [0][0];
		//char couleur2 = grillage [13][13];
	}
	
	public char couleur_joueur(int i, int j){//Couleur des joueurs
		return grillage [i][j];
	}
	
	public char Random_letter(){//Génération d'une lettre aléatoire r,o,y,g,b,p
		char alphabet[] = {'r','o','j','v','b','i'};
		return alphabet[Alea(0,5)];
	}
	
	public int Alea (int min, int max){//Génération de nombre aléatoire entre min et max
		Random rand = new Random();
		int Alea = rand.nextInt(max - min + 1) + min;
		return Alea;
		
	}
	
	
		  

}


