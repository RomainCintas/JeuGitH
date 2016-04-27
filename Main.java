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
		
		if (joueur1.tour != 0){
			joueur = joueur1;
			couleur = couleur1;
			nom = nom1;
		}
		else{
			joueur = joueur2;
			couleur = couleur2;
			nom = nom2;
		}
		
		if(joueur1.couleur != joueur2.couleur){
			
			Case case1 = new Case(c1,l1,couleur);//Première case que le joueur possède
			
			ArrayList <Case> caseverif= new ArrayList<Case>();//liste qui stocke les cases adjacentes
			caseverif.add(new Case(c1,l1,couleur));
			
			
			
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
				for (int l2=1;l2<14;l2++){ //Affichage du nouveau grillage
					for (int c2=1;c2<14;c2++){
						System.out.print("	|	" + generation_grillage.grillage[l2][c2]);
					}
				System.out.print("\n");
				}
				
				i++;
				System.out.println(i);

			}while(i<caseverif.size());
			
		}
		
		joueur1.tour = 0;
		joueur2.tour = 1;
		System.out.println("C'est à " + joueur.nom + " de jouer, veuillez choisir une couleur.");
		String i = scan.nextLine(); 
		joueur.couleur = i;

			
			/*if(joueur1.couleur != joueur2.couleur & joueur2.tour != 0) {
					System.out.println("C'est à " + joueur2.nom + " de jouer, veuillez choisir une couleur.");
					String i = scan.nextLine(); 
					joueur2.couleur = i ;
					
					String couleur = couleur2;
					Case case1 = new Case(c,l,couleur2);
					
					ArrayList <Case> caseverif2= new ArrayList<Case>(); //liste qui stocke les cases adjacentes

					for (int i1 = 0; i1<1 + caseverif2.size(); i1++ ){//défilement des cases adjacentes

						joueur2.couleur = joueur2.couleur.toUpperCase();
						generation_grillage.grillage[l][c]=joueur2.couleur;
					

						if (joueur1.couleur.toLowerCase() == generation_grillage.grillage[l][c+1]){//Vérification à droite
							//On met en majuscule + changement de couleur
							generation_grillage.grillage[l][c+1]=joueur1.couleur;
							caseverif2.add(new Case(c+1,l,couleur));
							//Case case2 = new Case(c+1,l,couleur1);
						}
						if (joueur1.couleur.toLowerCase() == generation_grillage.grillage[l+1][c]){//Vérification en bas
							//On met en majuscule + changement de couleur
							generation_grillage.grillage[l+1][c]=joueur1.couleur;
							caseverif2.add(new Case(c,l+1,couleur));
						}
						if (joueur1.couleur.toLowerCase() == generation_grillage.grillage[l-1][c]){//Vérification en haut
							//On met en majuscule + changement de couleur
							generation_grillage.grillage[l-1][c]=joueur1.couleur;
							caseverif2.add(new Case(c,l-1,couleur));
						}
						if (joueur1.couleur.toLowerCase() == generation_grillage.grillage[l][c-1]){//Vérification à gauche
							//On met en majuscule + changement de couleur
							generation_grillage.grillage[l][c-1]=joueur1.couleur;
							caseverif2.add(new Case(c-1,l,couleur));
						}
						joueur1.tour = 1;
						joueur2.tour = 0;
					}
				}*/
			}
		}



	
	
	
		//boolean continuer=true;
		//while(continuer){
			//joueur1.couleur != joueur2.couleur;
			//joueur1.tour != 0;
	
		//}


