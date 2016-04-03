import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		 
		Scanner scan = new Scanner(System.in);
		System.out.println("Bonjour");
		System.out.println("Joueur 1 veuillez entrer votre pseudo s'il vous plaît.");
		String nom1 = scan.nextLine();
		System.out.println("Joueur 2 veuillez entrer votre pseudo s'il vous plaît.");
		String nom2 = scan.nextLine();
		
		System.out.println("Bonjour " + nom1 + " vous commencez en haut à gauche" + " et " + nom2 + " vous comencez en bas à droite.");

		System.out.println("\n");
		
		Plateau generation_grillage = new Plateau();

		String couleur1 = generation_grillage.get_couleur_joueur(0,0);
		String couleur2 = generation_grillage.get_couleur_joueur(12, 12);


		
		Joueur joueur1 = new Joueur(nom1, couleur1);
		Joueur joueur2 = new Joueur(nom2,couleur2);
		
		//System.out.println(joueur1.nom);
		//System.out.println(joueur2.couleur);
		
		if(joueur1.couleur != joueur2.couleur & joueur1.tour != 0){
			
			System.out.println("C'est à " + joueur1.nom + " de commencer, veuillez choisir une couleur.");
			String i = scan.toString(); //Methode scan avec un string
			joueur1.couleur = i ;
			
			
			
			/*for (int l=0 ; l<13 ; l+=1){
				for(int c=0; c<13 ; c+=1){
					if (joueur1.couleur == generation_grillage.grillage[l][c+1]){//Vérification à droite
						//On met en majuscule + changement de couleur
					}
					if (joueur1.couleur == generation_grillage.grillage[l+1][c]){//Vérification en bas
						//On met en majuscule + changement de couleur
					}
					if (joueur1.couleur == generation_grillage.grillage[l-1][c]){//Vérification en haut
						//On met en majuscule + changement de couleur
					}
					if (joueur1.couleur == generation_grillage.grillage[l][c-1]){//Vérification à gauche
						//On met en majuscule + changement de couleur
					}
					
					
				}
				joueur1.tour = 0;
				joueur2.tour = 1;
			}*/
			
			int c = 0;
			int l = 0;
			String couleur = couleur1;
			Case case1 = new Case(c,l,couleur1);
			ArrayList <Case> caseverif= new ArrayList<Case>();

			if (joueur1.couleur.toLowerCase() == generation_grillage.grillage[l][c+1]){//Vérification à droite
				//On met en majuscule + changement de couleur
				generation_grillage.grillage[l][c+1]=joueur1.couleur;
				caseverif.add(new Case(c+1,l,couleur));
				//Case case2 = new Case(c+1,l,couleur1);
			}
			if (joueur1.couleur == generation_grillage.grillage[l+1][c]){//Vérification en bas
				//On met en majuscule + changement de couleur
				generation_grillage.grillage[l+1][c]=joueur1.couleur;
				caseverif.add(new Case(c,l+1,couleur));
			}
			if (joueur1.couleur == generation_grillage.grillage[l-1][c]){//Vérification en haut
				//On met en majuscule + changement de couleur
				generation_grillage.grillage[l-1][c]=joueur1.couleur;
				caseverif.add(new Case(c,l-1,couleur));
			}
			if (joueur1.couleur == generation_grillage.grillage[l][c-1]){//Vérification à gauche
				//On met en majuscule + changement de couleur
				generation_grillage.grillage[l][c-1]=joueur1.couleur;
				caseverif.add(new Case(c-1,l,couleur));
			}
			
		}
			
			
		else if(joueur1.couleur != joueur2.couleur & joueur2.tour != 0) {
				System.out.println("C'est à " + joueur2.nom + " de commencer, veuillez choisir une couleur.");
				String i = scan.toString(); //Methode scan avec un char
				joueur2.couleur = i ;
				
				for (int l=0 ; l<13 ; l+=1){
					for(int c=0; c<13 ; c+=1){
						if (joueur2.couleur == generation_grillage.grillage[l][c+1]){//Vérification à droite
							//On met en majuscule + changement de couleur
						}
						if (joueur2.couleur == generation_grillage.grillage[l+1][c]){//Vérification à gauche
							//On met en majuscule + changement de couleur
						}
						if (joueur2.couleur == generation_grillage.grillage[l-1][c]){//Vérification à droite
							//On met en majuscule + changement de couleur
						}
						if (joueur2.couleur == generation_grillage.grillage[l][c-1]){//Vérification à droite
							//On met en majuscule + changement de couleur
						}
					}
					joueur1.tour = 1;
					joueur2.tour = 0;
				}
			}
		}
	
	
	
		//boolean continuer=true;
		//while(continuer){
			//joueur1.couleur != joueur2.couleur;
			//joueur1.tour != 0;
	
		//}
		
		
	}



