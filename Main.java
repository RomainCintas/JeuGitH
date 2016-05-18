import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		 
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		Scanner scan3 = new Scanner(System.in);
		Scanner scan4 = new Scanner(System.in);
		Scanner scan5 = new Scanner(System.in);
		
		System.out.println("Bonjour");
		String nom = null;
		String nom3 = null;
		String nom4 = null;
		
		int nbJoueur;
		do{
			System.out.println("Combien de joueurs voulez-vous ?");
			nbJoueur = scan.nextInt();
			if (nbJoueur != 2 && nbJoueur != 3 && nbJoueur != 4){
				System.out.println("VEUILLEZ CHOISIR DEUX, TROIS OU QUATRE JOUEURS");
			}
		}while (nbJoueur != 2 && nbJoueur != 3 && nbJoueur != 4);
		
		System.out.println("Entrer le pseudo du Joueur 1");
		String nom1 = scan1.nextLine();
		System.out.println("Entrer le pseudo du Joueur 2");
		String nom2 = scan2.nextLine();
		
		if (nbJoueur == 3 || nbJoueur == 4){
			System.out.println("Entrer le pseudo du Joueur 3");
			nom3 = scan3.nextLine();
			if (nbJoueur == 4){
				System.out.println("Entrer le pseudo du Joueur 4");
				nom4 = scan4.nextLine();
			}
		}
		
		System.out.println(nom1 + " commence en haut à gauche");
		System.out.println(nom2 + " commence en bas à droite");
		
		if (nbJoueur == 3 || nbJoueur == 4){
			System.out.println(nom3 + " commence en haut à droite");
			if (nbJoueur == 4){
				System.out.println(nom4 + " commence en bas à gauche");
			}
		}
		
		System.out.println("\n");
		
		Plateau generation_grillage = new Plateau();
		
		String couleur = null;
		String couleur1;
		String couleur2;
		String couleur3 = "couleur 3";
		String couleur4 = "couleur 4";
		int l1 = 1;
		int c1 = 1;
		int l2= 13;
		int c2 = 13;
		int l3 = 1;
		int c3 = 13;
		int l4= 13;
		int c4 = 1;
		
		do{
			couleur1 = generation_grillage.get_couleur_joueur(l1,c1);
			couleur2 = generation_grillage.get_couleur_joueur(l2,c2);
			if (nbJoueur == 3 || nbJoueur == 4){
				couleur3 = generation_grillage.get_couleur_joueur(l3,c3);
				if (nbJoueur == 4){
					couleur4 = generation_grillage.get_couleur_joueur(l4, c4);
				}
			}
			if(couleur1.equals(couleur2) || couleur2.equals(couleur3) || couleur3.equals(couleur4) || couleur1.equals(couleur4) || couleur2.equals(couleur4) || couleur1.equals(couleur3)){
				generation_grillage = new Plateau();
			}
		}while(couleur1.equals(couleur2) || couleur2.equals(couleur3) || couleur3.equals(couleur4) || couleur1.equals(couleur4) || couleur2.equals(couleur4) || couleur1.equals(couleur3));
				 
		Joueur joueur = new Joueur(nom,couleur);
		Joueur joueur1 = new Joueur(nom1,couleur1);
		Joueur joueur2 = new Joueur(nom2,couleur2);
		Joueur joueur3 = new Joueur(nom3,couleur3);
		Joueur joueur4 = new Joueur(nom4,couleur4);
		
		joueur1.tour = true;
		joueur2.tour = false;
		joueur3.tour = false;
		joueur4.tour = false;
		
		int colonne;
		int ligne;
		ArrayList <Case> caseverif = null;
		ArrayList <Case> caseverif1 = null;
		ArrayList <Case> caseverif2 = null;
		ArrayList <Case> caseverif3 = null;
		ArrayList <Case> caseverif4 = null;
		
		int compteur = 0; //pour compter le nombre de tour
		
		while (true){ //Début de la boucle du jeu (1 boucle = 1 tour)
			if (joueur1.tour == true){ // Tour du joueur 1
				joueur = joueur1;
				couleur = couleur1;
				nom = nom1;
				colonne = c1;
				ligne = l1;
				if (compteur == 0){
					caseverif1= new ArrayList<Case>();//liste qui stocke les cases adjacentes
					caseverif1.add(new Case(colonne,ligne,couleur));
				}
				caseverif=caseverif1;
				System.out.println("Coucou 1 !!!");
			}
			if (joueur2.tour == true) { // Tour du joueur 2
				joueur = joueur2;
				couleur = couleur2;
				nom = nom2;
				colonne = c2;
				ligne = l2;
				if (compteur == 1){
					caseverif2= new ArrayList<Case>();//liste qui stocke les cases adjacentes
					caseverif2.add(new Case(colonne,ligne,couleur));
				}
				caseverif=caseverif2;
				System.out.println("Coucou 2 !!! ");
			}
			
			if (joueur3.tour == true && (nbJoueur == 3 || nbJoueur == 4)) { // Tour du joueur 3
				joueur = joueur3;
				couleur = couleur3;
				nom = nom3;
				colonne = c3;
				ligne = l3;
				if (compteur == 2){
					caseverif3= new ArrayList<Case>();//liste qui stocke les cases adjacentes
					caseverif3.add(new Case(colonne,ligne,couleur));
				}
				caseverif=caseverif3;
				System.out.println(nbJoueur);
				System.out.println("Coucou 3 !!!");
			}
			
			System.out.println(nbJoueur);
			if (joueur4.tour == true && nbJoueur == 4){ // Tour du joueur 4
				joueur = joueur4;
				couleur = couleur4;
				nom = nom4;
				colonne = c4;
				ligne = l4;
				if (compteur == 3){
					caseverif4= new ArrayList<Case>();//liste qui stocke les cases adjacentes
					caseverif4.add(new Case(colonne,ligne,couleur));
				}
				caseverif=caseverif4;
				System.out.println("Coucou 4 !!!");
			}
			
			// Début de la boucle pour les tours joués (pas durant l'initialisation)
			if ((compteur !=0 && compteur !=1) && (nbJoueur == 2 || (compteur !=3 && nbJoueur == 3) || (compteur !=3 && compteur !=4 && nbJoueur == 4))){
				do{
					System.out.println("C'est à " + joueur.nom + " de jouer, veuillez choisir une couleur");
					joueur.couleur = scan5.nextLine().toLowerCase();
					
					if (couleur1.equals(joueur.couleur) || couleur2.equals(joueur.couleur) || couleur3.equals(joueur.couleur) || couleur4.equals(joueur.couleur)){
						if (couleur.equals(joueur.couleur)){
							System.out.println("VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE LA VÔTRE");
						}
						else{
							System.out.println("VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE CELLE DE VOTRE ADVERSAIRE");
						}
					}
				}while(couleur1.equals(joueur.couleur) || couleur2.equals(joueur.couleur) || couleur3.equals(joueur.couleur) || couleur4.equals(joueur.couleur));
				couleur = joueur.couleur;
				
				int j=0;
				do{
					int c = caseverif.get(j).c;
					int l = caseverif.get(j).l;
					generation_grillage.grillage[l][c]=joueur.couleur.toUpperCase();
					j++;
				}while (j<caseverif.size());
			} // Fin de la boucle pour les tours joués (pas durant l'initialisation)
			
			int i = 0;
			do{ //Boucle pour ajouter à la liste les cases de même couleur et les mettre en majuscule

				int c = caseverif.get(i).c;
				int l = caseverif.get(i).l;
				System.out.println("Ligne : " + l + "\nColonne : " + c);
				
				if (joueur.couleur.equals(generation_grillage.grillage[l][c+1])){//Vérification à droite
					//On met en majuscule + changement de couleur
					generation_grillage.grillage[l][c+1]=joueur.couleur.toUpperCase();
					caseverif.add(new Case(c+1,l,couleur));
				}
				if (joueur.couleur.equals(generation_grillage.grillage[l+1][c])){//Vérification en bas
					//On met en majuscule + changement de couleur
					generation_grillage.grillage[l+1][c]=joueur.couleur.toUpperCase();
					caseverif.add(new Case(c,l+1,couleur));
				}
				if (joueur.couleur.equals(generation_grillage.grillage[l-1][c])){//Vérification en haut
					//On met en majuscule + changement de couleur
					generation_grillage.grillage[l-1][c]=joueur.couleur.toUpperCase();
					caseverif.add(new Case(c,l-1,couleur));
				}
				if (joueur.couleur.equals(generation_grillage.grillage[l][c-1])){//Vérification à gauche
					//On met en majuscule + changement de couleur
					generation_grillage.grillage[l][c-1]=joueur.couleur.toUpperCase();
					caseverif.add(new Case(c-1,l,couleur));
				}
	
				generation_grillage.grillage[l][c]=joueur.couleur.toUpperCase();
				i++;
				
			}while(i<caseverif.size()); //Fin de la boucle pour ajouter à la liste les cases de même couleur et les mettre en majuscule
			
			if (compteur != 0){
				//for (int p = 0; p < 50; ++p) System.out.println(); // saut de ligne pour avoir une console plus propre (peu pratique)
				System.out.print("\n"); //Affichage du nouveau grillage
				for (int ligneBoucle=1;ligneBoucle<14;ligneBoucle++){
					for (int colonneBoucle=1;colonneBoucle<14;colonneBoucle++){
						System.out.print("	|	" + generation_grillage.grillage[ligneBoucle][colonneBoucle]);
					}
				System.out.print("\n");
				}
			}
			
			if (joueur1.tour == true){
				caseverif1 = caseverif;
				couleur1 = couleur;
			}
			if (joueur2.tour == true){
				caseverif2 = caseverif;
				couleur2 = couleur;
			}
			if (joueur3.tour == true){
				caseverif3 = caseverif;
				couleur3 = couleur;
			}
			if (joueur4.tour == true){
				caseverif4 = caseverif;
				couleur4 = couleur;
			}
			
			if (compteur != 0 && compteur != 1 && nbJoueur == 2 && (caseverif1.size()>84 || caseverif2.size()>84)){ // Conditions de victoire pour une partie à 2 joueurs
				if (caseverif1.size()>caseverif2.size()){
					System.out.println("Victoire de " + joueur1.nom + " !!!");
				}
				else
				{	
					if (caseverif1.size() == caseverif2.size()){
						System.out.println("Dans le doute, on va dire que Timothée a gagné");
					}
					else {
						System.out.println("Victoire de " + joueur2.nom + " !!!");
					}
				}
				System.out.println("Nombre de cases possédées par " + joueur1.nom + " : " + caseverif1.size());
				System.out.println("Nombre de cases possédées par " + joueur2.nom + " : " + caseverif2.size());
				break;
			}
			
			if (compteur != 0 && compteur != 1 && compteur != 2 && nbJoueur == 3 && (caseverif1.size()>84 || caseverif2.size()>84 || caseverif3.size()>84)){ // Conditions de victoire pour une partie à 3 joueurs
				if (caseverif1.size()>caseverif2.size()){
					if(caseverif1.size()>caseverif3.size()){
						System.out.println("Victoire de " + joueur1.nom + " !!!");
					}
					else{
						if(caseverif1.size()==caseverif3.size()){
							System.out.println("Dans le doute, on va dire que Timothée a gagné");
						}
						else{
							System.out.println("Victoire de " + joueur3.nom + " !!!");
						}
					}
				}
				else
				{	
					if(caseverif2.size()>caseverif3.size()){
						if(caseverif1.size()==caseverif2.size()){
							System.out.println("Dans le doute, on va dire que Timothée a gagné");
						}
						else {
							System.out.println("Victoire de " + joueur2.nom + " !!!");
						}
					}
					else{
						if (caseverif2.size() == caseverif3.size()){
							System.out.println("Dans le doute, on va dire que Timothée a gagné");
						}
						else{
							System.out.println("Victoire de " + joueur3.nom + " !!!");
						}
					}
				}
				System.out.println("Nombre de cases possédées par " + joueur1.nom + " : " + caseverif1.size());
				System.out.println("Nombre de cases possédées par " + joueur2.nom + " : " + caseverif2.size());
				System.out.println("Nombre de cases possédées par " + joueur3.nom + " : " + caseverif3.size());
				break;
			}
			
			if (compteur != 0 && compteur != 1 && compteur != 2 && compteur != 3 && nbJoueur == 4 && (caseverif1.size()>84 || caseverif2.size()>84 || caseverif3.size()>84 || caseverif4.size()>84)){ // Conditions de victoire pour une partie à 4 joueurs
				if (caseverif1.size()>caseverif2.size()){
					if(caseverif1.size()>caseverif3.size()){
						if(caseverif1.size()>caseverif4.size()){
							System.out.println("Victoire de " + joueur1.nom + " !!!");
						}
						else{
							if (caseverif1.size()==caseverif4.size()){
								System.out.println("Dans le doute, on va dire que Timothée a gagné");
							}
							else{
								System.out.println("Victoire de " + joueur4.nom + " !!!");
							}
						}
					}
					else{
						if (caseverif3.size()>caseverif4.size()){
							System.out.println("Victoire de " + joueur3.nom + " !!!");
						}
						else{
							if(caseverif3.size()==caseverif4.size()){
								System.out.println("Dans le doute, on va dire que Timothée a gagné");
							}
							else{
								System.out.println("Victoire de " + joueur4.nom + " !!!");
							}
						}
						
					}
				}
				else //si 2=<1
				{	
					if(caseverif2.size()>caseverif3.size()){
						if(caseverif2.size()>caseverif4.size()){
							if (caseverif1.size()==caseverif2.size()){
								System.out.println("Dans le doute, on va dire que Timothée a gagné");							}
							else{
								System.out.println("Victoire de " + joueur2.nom + " !!!");
							}
						}
						else{ // si 4=<2
							if (caseverif2.size()==caseverif4.size()){
								System.out.println("Dans le doute, on va dire que Timothée a gagné");							}
							else{
								System.out.println("Victoire de " + joueur2.nom + " !!!");
							}
						}
					}
					
					else{ // si 3=<2
						if (caseverif3.size() > caseverif4.size()){
							if(caseverif2.size() == caseverif3.size()){
								System.out.println("Dans le doute, on va dire que Timothée a gagné");
							}
							else{
								System.out.println("Victoire de " + joueur3.nom + " !!!");
							}
						}
						else{ //si 4>=3
							if(caseverif1.size() == caseverif2.size()){
								System.out.println("Dans le doute, on va dire que Timothée a gagné");
							}
							else{
								System.out.println("Victoire de " + joueur4.nom + " !!!");
							}
						}
					}
				}
				System.out.println("Nombre de cases possédées par " + joueur1.nom + " : " + caseverif1.size());
				System.out.println("Nombre de cases possédées par " + joueur2.nom + " : " + caseverif2.size());
				System.out.println("Nombre de cases possédées par " + joueur3.nom + " : " + caseverif3.size());
				System.out.println("Nombre de cases possédées par " + joueur4.nom + " : " + caseverif4.size());
				break;
			}
			
			boolean joueurTemporaire; //Rotation du tour des joueurs
			if (nbJoueur == 2){
				joueurTemporaire = joueur2.tour;
				joueur2.tour = joueur1.tour;
				joueur1.tour = joueurTemporaire;
			}
			else{
				if (nbJoueur == 4){
					joueurTemporaire = joueur4.tour;
					joueur4.tour = joueur3.tour;
					joueur3.tour = joueur2.tour;
					joueur2.tour = joueur1.tour;
					joueur1.tour = joueurTemporaire;
				}
				else{
					joueurTemporaire = joueur3.tour;
					joueur3.tour = joueur2.tour;
					joueur2.tour = joueur1.tour;
					joueur1.tour = joueurTemporaire;
				}
			}
			//System.out.println("Joueur 1 : " + joueur1.tour + "Joueur 2 : " + joueur2.tour + "Joueur 3 : " + joueur3.tour + "Joueur 4 : " + joueur4.tour);
			
			compteur++; //Compteur de tour
		} //Fin de la boucle du jeu (1 boucle = 1 tour)
	}
}

