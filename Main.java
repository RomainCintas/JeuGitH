import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	static int NBJOUEUR = Joueur.NBJOUEUR;
	
	public static int choixNbJoueur(){
		NBJOUEUR = Joueur.choixNbJoueur();
		return NBJOUEUR;
	}
	
	public static void unJoueur(int NBJOUEUR){
		Joueur.unJoueur(NBJOUEUR);
	}
	
	public static void multijoueur(int NBJOUEUR){
		Joueur.multijoueur(NBJOUEUR);
	}
	
	public static void creaGrille(int NBJOUEUR){
		Plateau.creaGrille(NBJOUEUR);
	}
	
	public static void affichagePlateauConsole(String[][] grillage){
		Plateau.affichagePlateauConsole(grillage);
	}
	
	public static void affichagePlateauGraphique(String[][] grillage){
		Plateau.affichagePlateauGraphique(grillage);
	}
	
	public static String selectionCouleurGraphique(String couleur, String couleur1, String couleur2, String couleur3, String couleur4, int NBJOUEUR){
		String couleurChoisie = Case.selectionCouleurGraphique(couleur, couleur1, couleur2, couleur3, couleur4, NBJOUEUR);
		return couleurChoisie;
	}
	
	public static String selectionCouleurConsole(String couleur, String couleur1, String couleur2, String couleur3, String couleur4, int NBJOUEUR){
		String couleurChoisie = Case.selectionCouleurConsole(couleur, couleur1, couleur2, couleur3, couleur4, NBJOUEUR);
		return couleurChoisie;
	}
	
	public static void positionJoueur(String nom1, String nom2, String nom3, String nom4){
		Joueur.positionJoueur(nom1, nom2, nom3, nom4);
	}
	
	public static Joueur tourJoueur(Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4, int compteurTour){
		Joueur joueur;
		joueur = Joueur.tourJoueur(joueur1, joueur2, joueur3, joueur4,compteurTour);
		return joueur;
	}
	
	public static void main(String[] args) {
		
		//initialisation interface graphique
		StdDraw.setCanvasSize(1000, 1000);//initialisation de la feuille de dessin
		StdDraw.setPenRadius(0.1);//définition de la taille du pinceau
		StdDraw.setXscale(0, 16);//redéfinition de la grille sur le graphique
		StdDraw.setYscale(0, 16);
		StdDraw.setScale(0, 16);
		
		Scanner scan6 = new Scanner(System.in);
		
		System.out.println("Le jeu des Six couleurs");
		System.out.println("1. Un joueur");//non fonctionnel (pas d'IA)
		System.out.println("2. Multijoueur");
		System.out.println("3. Parties enregistrées");//non fonctionnel
		System.out.println("4. Options");
		System.out.println("5. Quitter");
		int menu = scan6.nextInt();
		
		switch (menu)
		{
		  case 1:
		    System.out.println("Un joueur");
		    unJoueur(NBJOUEUR);
		    break;
		  case 2:
		    System.out.println("Multijoueur");
			multijoueur(NBJOUEUR);
		    break;
		  case 3:
		    System.out.println("Parties enregistrées");
		    break;
		  case 4:
			System.out.println("Options");
			NBJOUEUR = choixNbJoueur();
			break;
		  case 5:
			System.out.println("Quitter");
			break;
		  default:
		    System.out.println("Il faut davantage travailler.");
		}
		
		System.out.println("Bonjour");
		String nom = null;

		String couleur = null;
		int colonne = 0;
		int ligne = 0;
		
		ArrayList <Case> caseControl = null;
		ArrayList <Case> caseControl1 = null;
		ArrayList <Case> caseControl2 = null;
		ArrayList <Case> caseControl3 = null;
		ArrayList <Case> caseControl4 = null;
		
		creaGrille(NBJOUEUR);
		String[][] grillage = Plateau.grillage;

		Joueur joueur;// = new Joueur(nom,couleur,colonne,4,ligne,caseControl);
		Joueur joueur1 = new Joueur(Joueur.nom1,Plateau.couleur1,Plateau.colonne1,Plateau.ligne1,0,caseControl1);
		Joueur joueur2 = new Joueur(Joueur.nom2,Plateau.couleur2,Plateau.colonne2,Plateau.ligne2,1,caseControl2);
		Joueur joueur3 = new Joueur(Joueur.nom3,Plateau.couleur3,Plateau.colonne3,Plateau.ligne3,2,caseControl3);
		Joueur joueur4 = new Joueur(Joueur.nom4,Plateau.couleur4,Plateau.colonne4,Plateau.ligne4,3,caseControl4);
		
		positionJoueur(joueur1.nom, joueur2.nom, joueur3.nom, joueur4.nom);
		
		joueur1.tour = true;
		joueur2.tour = false;
		joueur3.tour = false;
		joueur4.tour = false;
		
		int compteurTour = 0; //pour compter le nombre de tour
		while (true){ //Début de la boucle du jeu (1 boucle = 1 tour)
			StdDraw.setPenColor(StdDraw.BLACK);
			
			joueur = tourJoueur(joueur1, joueur2, joueur3, joueur4, compteurTour);
			caseControl=joueur.caseControl;
			
			// Début de la boucle pour les tours joués (pas durant l'initialisation)
			if ((compteurTour>1 && NBJOUEUR == 2) || (compteurTour>2 && NBJOUEUR == 3) || (compteurTour>3 && NBJOUEUR == 4)){
				String couleurChoisie = "couleur choisie";
				
				//TEMPORAIRE
				do{ //boucle de choix de la couleur
					System.out.println("C'est à " + joueur.nom + " de jouer, veuillez choisir une couleur différente de ");
					System.out.println("C'est à " + joueur.nom + " de jouer, veuillez choisir une couleur différente de ");
					StdDraw.text(6.65, 14.6, "C'est à " + joueur.nom + " de jouer, veuillez choisir une couleur différente de ");
					if (NBJOUEUR == 2){
						System.out.println(joueur1.couleur + " et " + joueur2.couleur + ".");
						StdDraw.text(10.22, 14.6, joueur1.couleur + " et " + joueur2.couleur + ".");
						System.out.println("Score de " + joueur1.nom + " : " + joueur1.caseControl.size() + "  Score de " + joueur2.nom + " : " + joueur2.caseControl.size());
						StdDraw.text(6.65, 14.9, "Score de " + joueur1.nom + " : " + joueur1.caseControl.size() + "  Score de " + joueur2.nom + " : " + joueur2.caseControl.size());
					}
					else{
						if(NBJOUEUR==3){
							System.out.println(joueur1.couleur + ", " + joueur2.couleur + " et " + joueur3.couleur + ".");
							StdDraw.text(10.4, 14.6, joueur1.couleur + ", " + joueur2.couleur + " et " + joueur3.couleur + ".");
							System.out.println("Score de " + joueur1.nom + " : " + joueur1.caseControl.size() + "  Score de " + joueur2.nom + " : " + joueur2.caseControl.size() + "  Score de " + joueur3.nom + " : " + joueur3.caseControl.size());
							StdDraw.text(6.65, 14.9, "Score de " + joueur1.nom + " : " + joueur1.caseControl.size() + "  Score de " + joueur2.nom + " : " + joueur2.caseControl.size() + "  Score de " + joueur3.nom + " : " + joueur3.caseControl.size());
						}
						else{
							System.out.println(joueur1.couleur + ", " + joueur2.couleur + ", " + joueur3.couleur + " et " + joueur4.couleur + ".");
							StdDraw.text(10.4, 14.6, joueur1.couleur + ", " + joueur2.couleur + ", " + joueur3.couleur + " et " + joueur4.couleur + ".");
							System.out.println("Score de " + joueur1.nom + " : " + joueur1.caseControl.size() + "  Score de " + joueur2.nom + " : " + joueur2.caseControl.size() + "  Score de " + joueur3.nom + " : " + joueur3.caseControl.size() + "  Score de " + joueur4.nom + " : " + joueur4.caseControl.size());
							StdDraw.text(6.65, 14.9, "Score de " + joueur1.nom + " : " + joueur1.caseControl.size() + "  Score de " + joueur2.nom + " : " + joueur2.caseControl.size() + "  Score de " + joueur3.nom + " : " + joueur3.caseControl.size() + "  Score de " + joueur4.nom + " : " + joueur4.caseControl.size());
						}
					}
					
					//1) sélection de la couleur en mode graphique (avec la souris)
					couleurChoisie = selectionCouleurGraphique(joueur.couleur, joueur1.couleur, joueur2.couleur, joueur3.couleur, joueur4.couleur, NBJOUEUR);

					//2) sélection de la couleur en mode console
					//couleurChoisie = selectionCouleurConsole(joueur.couleur, joueur1.couleur, joueur2.couleur, joueur3.couleur, joueur4.couleur, NBJOUEUR);
					
				}while(couleurChoisie.equals(joueur1.couleur) || couleurChoisie.equals(joueur2.couleur) || couleurChoisie.equals(joueur3.couleur) || couleurChoisie.equals(joueur4.couleur));
				joueur.couleur = couleurChoisie; //prise en compte de la couleur choisie
				//TEMPORAIRE
				
				int j=0;
				do{
					colonne = caseControl.get(j).colonne;
					ligne = caseControl.get(j).ligne;
					grillage[ligne][colonne]=joueur.couleur.toUpperCase();
					j++;
				}while (j<caseControl.size());
				
			} // Fin de la boucle pour les tours joués (pas durant l'initialisation)
			
			
			
			int i = 0;
			do{ //Boucle pour ajouter à la liste les cases de même couleur et les mettre en majuscule
				System.out.println(caseControl.get(i).colonne);
				System.out.println(caseControl.get(i).ligne);
				colonne = caseControl.get(i).colonne;
				ligne = caseControl.get(i).ligne;
				if (joueur.couleur.equals(grillage[ligne][colonne+1])){//Vérification à droite
					//On met en majuscule + changement de couleur
					grillage[ligne][colonne+1]=joueur.couleur.toUpperCase();
					caseControl.add(new Case(colonne+1,ligne,joueur.couleur));
				}
				if (joueur.couleur.equals(grillage[ligne+1][colonne])){//Vérification en bas
					//On met en majuscule + changement de couleur
					grillage[ligne+1][colonne]=joueur.couleur.toUpperCase();
					caseControl.add(new Case(colonne,ligne+1,joueur.couleur));
				}
				if (joueur.couleur.equals(grillage[ligne-1][colonne])){//Vérification en haut
					//On met en majuscule + changement de couleur
					grillage[ligne-1][colonne]=joueur.couleur.toUpperCase();
					caseControl.add(new Case(colonne,ligne-1,joueur.couleur));
				}
				if (joueur.couleur.equals(grillage[ligne][colonne-1])){//Vérification à gauche
					//On met en majuscule + changement de couleur
					grillage[ligne][colonne-1]=joueur.couleur.toUpperCase();
					caseControl.add(new Case(colonne-1,ligne,joueur.couleur));
				}
	
				grillage[ligne][colonne]=joueur.couleur.toUpperCase();
				i++;
				
			}while(i<caseControl.size()); //Fin de la boucle pour ajouter à la liste les cases de même couleur et les mettre en majuscule
				
			if ((compteurTour>0 && NBJOUEUR == 2) || (compteurTour>1 && NBJOUEUR == 3) || (compteurTour>2 && NBJOUEUR == 4)){
				affichagePlateauConsole(grillage);
				affichagePlateauGraphique(grillage);
			}
			
			if (joueur1.tour == true){
				joueur1=joueur;
				joueur1.caseControl = caseControl;
				System.out.println("Tour du joueur 1" + joueur1.couleur);
			}
			if (joueur2.tour == true){
				joueur2=joueur;
				joueur2.caseControl = caseControl;
				System.out.println("Tour du Joueur 2 " + joueur2.couleur);
			}
			if (joueur3.tour == true){
				joueur3=joueur;
				joueur3.caseControl = caseControl;
			}
			if (joueur4.tour == true){
				joueur4=joueur;
				joueur4.caseControl = caseControl;
			}
			
			//conditions de victoire
			if (compteurTour != 0 && compteurTour != 1 && NBJOUEUR == 2 && (joueur1.caseControl.size()>84 || joueur2.caseControl.size()>84)){ // Conditions de victoire pour une partie à 2 joueurs
				if (joueur1.caseControl.size()>joueur2.caseControl.size()){
					System.out.println("Victoire de " + joueur1.nom + " !!!");
				}
				else
				{	
					if (joueur1.caseControl.size() == joueur2.caseControl.size()){
						System.out.println("Dans le doute, on va dire que Timothée a gagné");
					}
					else {
						System.out.println("Victoire de " + joueur2.nom + " !!!");
					}
				}
				System.out.println("Nombre de cases possédées par " + joueur1.nom + " : " + joueur1.caseControl.size());
				System.out.println("Nombre de cases possédées par " + joueur2.nom + " : " + joueur2.caseControl.size());
				break;
			}
			
			if (compteurTour != 0 && compteurTour != 1 && compteurTour != 2 && NBJOUEUR == 3 && (joueur1.caseControl.size()>84 || joueur2.caseControl.size()>84 || joueur3.caseControl.size()>84)){ // Conditions de victoire pour une partie à 3 joueurs
				if (joueur1.caseControl.size()>joueur2.caseControl.size()){
					if(joueur1.caseControl.size()>joueur3.caseControl.size()){
						System.out.println("Victoire de " + joueur1.nom + " !!!");
					}
					else{
						if(joueur1.caseControl.size()==joueur3.caseControl.size()){
							System.out.println("Dans le doute, on va dire que Timothée a gagné");
						}
						else{
							System.out.println("Victoire de " + joueur3.nom + " !!!");
						}
					}
				}
				else
				{	
					if(joueur2.caseControl.size()>joueur3.caseControl.size()){
						if(joueur1.caseControl.size()==joueur2.caseControl.size()){
							System.out.println("Dans le doute, on va dire que Timothée a gagné");
						}
						else {
							System.out.println("Victoire de " + joueur2.nom + " !!!");
						}
					}
					else{
						if (joueur2.caseControl.size() == joueur3.caseControl.size()){
							System.out.println("Dans le doute, on va dire que Timothée a gagné");
						}
						else{
							System.out.println("Victoire de " + joueur3.nom + " !!!");
						}
					}
				}
				System.out.println("Nombre de cases possédées par " + joueur1.nom + " : " + joueur1.caseControl.size());
				System.out.println("Nombre de cases possédées par " + joueur2.nom + " : " + joueur2.caseControl.size());
				System.out.println("Nombre de cases possédées par " + joueur3.nom + " : " + joueur3.caseControl.size());
				break;
			}
			
			if (compteurTour != 0 && compteurTour != 1 && compteurTour != 2 && compteurTour != 3 && NBJOUEUR == 4 && (joueur1.caseControl.size()>84 ||joueur2.caseControl.size()>84 || joueur3.caseControl.size()>84 || joueur4.caseControl.size()>84)){ // Conditions de victoire pour une partie à 4 joueurs
				if (joueur1.caseControl.size()>joueur2.caseControl.size()){
					if(joueur1.caseControl.size()>joueur3.caseControl.size()){
						if(joueur1.caseControl.size()>joueur4.caseControl.size()){
							System.out.println("Victoire de " + joueur1.nom + " !!!");
						}
						else{
							if (joueur1.caseControl.size()==joueur4.caseControl.size()){
								System.out.println("Dans le doute, on va dire que Timothée a gagné");
							}
							else{
								System.out.println("Victoire de " + joueur4.nom + " !!!");
							}
						}
					}
					else{
						if (joueur3.caseControl.size()>joueur4.caseControl.size()){
							System.out.println("Victoire de " + joueur3.nom + " !!!");
						}
						else{
							if(joueur3.caseControl.size()==joueur4.caseControl.size()){
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
					if(joueur2.caseControl.size()>joueur3.caseControl.size()){
						if(joueur2.caseControl.size()>joueur4.caseControl.size()){
							if (joueur1.caseControl.size()==joueur2.caseControl.size()){
								System.out.println("Dans le doute, on va dire que Timothée a gagné");							}
							else{
								System.out.println("Victoire de " + joueur2.nom + " !!!");
							}
						}
						else{ // si 4=<2
							if (joueur2.caseControl.size()==joueur4.caseControl.size()){
								System.out.println("Dans le doute, on va dire que Timothée a gagné");							}
							else{
								System.out.println("Victoire de " + joueur2.nom + " !!!");
							}
						}
					}
					
					else{ // si 3=<2
						if (joueur3.caseControl.size() > joueur4.caseControl.size()){
							if(joueur2.caseControl.size() == joueur3.caseControl.size()){
								System.out.println("Dans le doute, on va dire que Timothée a gagné");
							}
							else{
								System.out.println("Victoire de " + joueur3.nom + " !!!");
							}
						}
						else{ //si 4>=3
							if(joueur1.caseControl.size() == joueur2.caseControl.size()){
								System.out.println("Dans le doute, on va dire que Timothée a gagné");
							}
							else{
								System.out.println("Victoire de " + joueur4.nom + " !!!");
							}
						}
					}
				}
				System.out.println("Nombre de cases possédées par " + joueur1.nom + " : " + joueur1.caseControl.size());
				System.out.println("Nombre de cases possédées par " + joueur2.nom + " : " + joueur2.caseControl.size());
				System.out.println("Nombre de cases possédées par " + joueur3.nom + " : " + joueur3.caseControl.size());
				System.out.println("Nombre de cases possédées par " + joueur4.nom + " : " + joueur4.caseControl.size());
				break;
			}
			// ^ conditions de victoire
			
			boolean joueurTemporaire; //Rotation du tour des joueurs
			if (NBJOUEUR == 2){
				joueurTemporaire = joueur2.tour;
				joueur2.tour = joueur1.tour;
				joueur1.tour = joueurTemporaire;
			}
			else{
				if (NBJOUEUR == 4){
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
			compteurTour++; //Compteur de tour
		} //Fin de la boucle du jeu (1 boucle = 1 tour)
	}
}
