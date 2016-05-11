import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		 
		Scanner scan = new Scanner(System.in);
		System.out.println("Bonjour");
		String nom = null;
		System.out.println("Joueur 1 veuillez entrer votre pseudo s'il vous plaît.");
		String nom1 = scan.nextLine();
		System.out.println("Joueur 2 veuillez entrer votre pseudo s'il vous plaît.");
		String nom2 = scan.nextLine();
		
		System.out.println("Bonjour " + nom1 + " vous commencez en haut à gauche" + " et " + nom2 + " vous comencez en bas à droite.");

		System.out.println("\n");
		
		Plateau generation_grillage = new Plateau();
		
		String couleur = null;
		String couleur1;
		String couleur2;
		
		do{
		couleur1 = generation_grillage.get_couleur_joueur(1,1);
		couleur2 = generation_grillage.get_couleur_joueur(13, 13);
		}while(couleur1 == couleur2);
		
		//System.out.println("Hello !");
		 
		Joueur joueur = new Joueur(nom,couleur);
		Joueur joueur1 = new Joueur(nom1,couleur1);
		Joueur joueur2 = new Joueur(nom2,couleur2);
		
		joueur1.tour = 1;
		joueur2.tour = 0;
		
		int c1 = 1;
		int l1 = 1;
		int c2 = 14;
		int l2= 14;
		int colonne;
		int ligne;
		ArrayList <Case> caseverif;
		ArrayList <Case> caseverif1;
		ArrayList <Case> caseverif2;
		
		int compteur = 0; //compteur pour finir la boucle de jeu (temporaire)
		
		while (true){
			if (joueur1.tour != 0){
				joueur = joueur1;
				couleur = couleur1;
				nom = nom1;
				colonne = c1;
				ligne = l1;
				//Case case1 = new Case(colonne,ligne,couleur);//Première case que le joueur possède
				caseverif1= new ArrayList<Case>();//liste qui stocke les cases adjacentes
				caseverif1.add(new Case(colonne,ligne,couleur));
				caseverif=caseverif1;
			}
			else{
				joueur = joueur2;
				couleur = couleur2;
				nom = nom2;
				colonne = c2;
				ligne = l2;
				//Case case2 = new Case(colonne,ligne,couleur);//Première case que le joueur possède
				caseverif2= new ArrayList<Case>();//liste qui stocke les cases adjacentes
				caseverif2.add(new Case(colonne,ligne,couleur));
				caseverif=caseverif2;
			}
			
			if(joueur1.couleur != joueur2.couleur){
				
				if (compteur !=0 && compteur !=1){
					System.out.println("C'est à " + joueur.nom + " de jouer, veuillez choisir une couleur.");
					String i = scan.nextLine();
					joueur.couleur = i;
				}
				
				int i = 0;
				do{
					int c = caseverif.get(i).c;
					int l = caseverif.get(i).l;
					
					if (joueur.couleur == generation_grillage.grillage[l][c+1]){//Vérification à droite
						//On met en majuscule + changement de couleur
						generation_grillage.grillage[l][c+1]=joueur.couleur.toUpperCase();
						caseverif.add(new Case(c+1,l,couleur));
						System.out.println("un");
					} 
					if (joueur.couleur == generation_grillage.grillage[l+1][c]){//Vérification en bas
						//On met en majuscule + changement de couleur
						generation_grillage.grillage[l+1][c]=joueur.couleur.toUpperCase();
						caseverif.add(new Case(c,l+1,couleur));
						System.out.println("deux");
					}
					if (joueur.couleur == generation_grillage.grillage[l-1][c]){//Vérification en haut
						//On met en majuscule + changement de couleur
						generation_grillage.grillage[l-1][c]=joueur.couleur.toUpperCase();
						caseverif.add(new Case(c,l-1,couleur));
						System.out.println("trois");
					}
					if (joueur.couleur == generation_grillage.grillage[l][c-1]){//Vérification à gauche
						//On met en majuscule + changement de couleur
						generation_grillage.grillage[l][c-1]=joueur.couleur.toUpperCase();
						caseverif.add(new Case(c-1,l,couleur));
						System.out.println("quatre");
					}
	
					generation_grillage.grillage[l][c]=joueur.couleur.toUpperCase();
					
					System.out.print("\n");
					for (int ligneBoucle=1;ligneBoucle<14;ligneBoucle++){ //Affichage du nouveau grillage
						for (int colonneBoucle=1;colonneBoucle<14;colonneBoucle++){
							System.out.print("	|	" + generation_grillage.grillage[ligneBoucle][colonneBoucle]);
						}
					System.out.print("\n");
					}
					
					i++;
					System.out.println(i);
	
				}while(i<caseverif.size());
				
			}
			
			if (joueur1.tour != 0){
				caseverif1 = caseverif;
			}
			else{
				caseverif2 = caseverif;
			}
			
			int joueur1Temporaire = joueur1.tour;
			joueur1.tour = joueur2.tour;
			joueur2.tour = joueur1Temporaire;
			
			compteur++; //compteur pour finir la boucle de jeu (temporaire)
			if (compteur == 3){
				break;
			}
			
			
		}
			
	}
}

