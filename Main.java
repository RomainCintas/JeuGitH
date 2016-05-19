import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	static int NBJOUEUR = Joueur.NBJOUEUR;
	
	public static void affichagePlateauConsole(Plateau grillage){
		Plateau.affichagePlateauConsole(grillage);
	}
	
	public static void affichagePlateauGraphique(Plateau grillage){
		Plateau.affichagePlateauGraphique(grillage);
	}
	
	public static String selectionCase(String couleurChoisie){
		couleurChoisie = Case.selectionCase(couleurChoisie);
		return couleurChoisie;
	}
	
	public static void main(String[] args) {
		
		//initialisation interface graphique
		StdDraw.setCanvasSize(1000, 1000);//initialisation de la feuille de dessin
		StdDraw.setPenRadius(0.1);//définition de la taille du pinceau
		StdDraw.setXscale(0, 16);//redéfinition de la grille sur le graphique
		StdDraw.setYscale(0, 16);
		StdDraw.setScale(0, 16);
		
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
		
		do{
			System.out.println("Combien de joueurs voulez-vous ?");
			StdDraw.text(7, 14, "Combien de joueurs voulez-vous ?");
			NBJOUEUR = scan.nextInt();
			if (NBJOUEUR != 2 && NBJOUEUR != 3 && NBJOUEUR != 4){
				System.out.println("VEUILLEZ CHOISIR DEUX, TROIS OU QUATRE JOUEURS");
				StdDraw.text(7, 13, "VEUILLEZ CHOISIR DEUX, TROIS OU QUATRE JOUEURS");
			}
		}while (NBJOUEUR != 2 && NBJOUEUR != 3 && NBJOUEUR != 4);
		
		System.out.println("Entrer le pseudo du Joueur 1");
		StdDraw.text(7, 12, "Entrer le pseudo du Joueur 1");
		String nom1 = scan1.nextLine();
		System.out.println("Entrer le pseudo du Joueur 2");
		StdDraw.text(7, 11, "Entrer le pseudo du Joueur 2");
		String nom2 = scan2.nextLine();
		
		if (NBJOUEUR == 3 || NBJOUEUR == 4){
			System.out.println("Entrer le pseudo du Joueur 3");
			StdDraw.text(7, 10, "Entrer le pseudo du Joueur 3");
			nom3 = scan3.nextLine();
			if (NBJOUEUR == 4){
				System.out.println("Entrer le pseudo du Joueur 4");
				StdDraw.text(7, 9, "Entrer le pseudo du Joueur 4");
				nom4 = scan4.nextLine();
			}
		}
		
		System.out.println(nom1 + " commence en haut à gauche");
		//StdDraw.text(7, 15, nom1 + " commence en haut à gauche");
		System.out.println(nom2 + " commence en bas à droite");
		//StdDraw.text(7, 14.7, nom2 + " commence en bas à droite");
		if (NBJOUEUR == 3 || NBJOUEUR == 4){
			System.out.println(nom3 + " commence en haut à droite");
			//StdDraw.text(7, 14.7, nom3 + " commence en haut à droite");
			if (NBJOUEUR == 4){
				System.out.println(nom4 + " commence en bas à gauche");
				//StdDraw.text(7, 14.7, nom4 + " commence en bas à gauche");
			}
		}
		
		System.out.println("\n");
		
		Plateau grillage = new Plateau();
		
		String couleur = null;
		String couleur1;
		String couleur2;
		String couleur3 = "couleur 3";
		String couleur4 = "couleur 4";
		int colonne = 0;
		int ligne = 0;
		int ligne1 = 1;
		int colonne1 = 1;
		int ligne2= 13;
		int colonne2 = 13;
		int ligne3 = 1;
		int colonne3 = 13;
		int ligne4= 13;
		int colonne4 = 1;
		ArrayList <Case> caseControl = null;
		ArrayList <Case> caseControl1 = null;
		ArrayList <Case> caseControl2 = null;
		ArrayList <Case> caseControl3 = null;
		ArrayList <Case> caseControl4 = null;
		
		do{
			couleur1 = grillage.getCouleurJoueur(ligne1,colonne1);
			couleur2 = grillage.getCouleurJoueur(ligne2,colonne2);
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
		
		Joueur joueur = new Joueur(nom,couleur,colonne,ligne,caseControl);
		Joueur joueur1 = new Joueur(nom1,couleur1,colonne1,ligne1,caseControl1);
		Joueur joueur2 = new Joueur(nom2,couleur2,colonne2,ligne2,caseControl2);
		Joueur joueur3 = new Joueur(nom3,couleur3,colonne3,ligne3,caseControl3);
		Joueur joueur4 = new Joueur(nom4,couleur4,colonne4,ligne4,caseControl4);
		
		joueur1.tour = true;
		joueur2.tour = false;
		joueur3.tour = false;
		joueur4.tour = false;
		
		int compteurTour = 0; //pour compter le nombre de tour
		
		while (true){ //Début de la boucle du jeu (1 boucle = 1 tour)
			StdDraw.setPenColor(StdDraw.BLACK);
			if (joueur1.tour == true){ // Tour du joueur 1
				joueur = joueur1;
				if (compteurTour == 0){
					joueur1.caseControl= new ArrayList<Case>();//liste qui stocke les cases adjacentes
					joueur1.caseControl.add(new Case(joueur.colonne,joueur.ligne,joueur1.couleur));
				}
				caseControl=joueur1.caseControl;
			}
			if (joueur2.tour == true) { // Tour du joueur 2
				joueur = joueur2;
				if (compteurTour == 1){
					joueur2.caseControl= new ArrayList<Case>();//liste qui stocke les cases adjacentes
					joueur2.caseControl.add(new Case(joueur.colonne,joueur.ligne,joueur2.couleur));
				}
				caseControl=joueur2.caseControl;
			}
			
			if (joueur3.tour == true && (NBJOUEUR == 3 || NBJOUEUR == 4)) { // Tour du joueur 3
				joueur = joueur3;
				if (compteurTour == 2){
					joueur3.caseControl= new ArrayList<Case>();//liste qui stocke les cases adjacentes
					joueur3.caseControl.add(new Case(joueur.colonne,joueur.ligne,joueur3.couleur));
				}
				caseControl=joueur3.caseControl;
			}
			
			if (joueur4.tour == true && NBJOUEUR == 4){ // Tour du joueur 4
				joueur = joueur4;
				if (compteurTour == 3){
					joueur4.caseControl= new ArrayList<Case>();//liste qui stocke les cases adjacentes
					joueur4.caseControl.add(new Case(joueur.colonne,joueur.ligne,joueur4.couleur));
				}
				caseControl=joueur4.caseControl;
			}
			
			// Début de la boucle pour les tours joués (pas durant l'initialisation)
			if ((compteurTour>1 && NBJOUEUR == 2) || (compteurTour>2 && NBJOUEUR == 3) || (compteurTour>3 && NBJOUEUR == 4)){
				String couleurChoisie = "couleur choisie";
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
					
					//1) mode souris
					couleurChoisie = selectionCase(couleurChoisie);
					
					//2) mode console
					//couleurChoisie = scan5.nextLine().toLowerCase(); //demande de la couleur choisie au joueur
				
					if (joueur1.couleur.equals(couleurChoisie) || joueur2.couleur.equals(couleurChoisie) || joueur3.couleur.equals(couleurChoisie) || joueur4.couleur.equals(couleurChoisie)){
						if (couleurChoisie.equals(joueur.couleur)){
							System.out.println("VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE LA VÔTRE");
							StdDraw.text(7, 14, "VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE LA VÔTRE");
						}
						else{
							if (NBJOUEUR == 2){
								System.out.println("VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE CELLE DE VOTRE ADVERSAIRE");
								StdDraw.text(7, 13.7, "VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE CELLE DE VOTRE ADVERSAIRE");
							}
							else{
								System.out.println("VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE CELLES DE VOS ADVERSAIRES");
								StdDraw.text(7, 13.7, "VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE CELLES DE VOS ADVERSAIRES");
							}
						}
					}
				}while(couleurChoisie.equals(joueur1.couleur) || couleurChoisie.equals(joueur2.couleur) || couleurChoisie.equals(joueur3.couleur) || couleurChoisie.equals(joueur4.couleur));
				joueur.couleur = couleurChoisie; //prise en compte de la couleur choisie
				
				int j=0;
				do{
					colonne = caseControl.get(j).colonne;
					ligne = caseControl.get(j).ligne;
					grillage.grillage[ligne][colonne]=joueur.couleur.toUpperCase();
					j++;
				}while (j<caseControl.size());
			} // Fin de la boucle pour les tours joués (pas durant l'initialisation)
			
			int i = 0;
			do{ //Boucle pour ajouter à la liste les cases de même couleur et les mettre en majuscule

				colonne = caseControl.get(i).colonne;
				ligne = caseControl.get(i).ligne;
				System.out.println(" Couleur de la case : " + grillage.grillage[ligne][colonne+1]);
				System.out.println(" Couleur du joueur : " + joueur.couleur);
				if (joueur.couleur.equals(grillage.grillage[ligne][colonne+1])){//Vérification à droite
					//On met en majuscule + changement de couleur
					grillage.grillage[ligne][colonne+1]=joueur.couleur.toUpperCase();
					caseControl.add(new Case(colonne+1,ligne,joueur.couleur));
				}
				if (joueur.couleur.equals(grillage.grillage[ligne+1][colonne])){//Vérification en bas
					//On met en majuscule + changement de couleur
					grillage.grillage[ligne+1][colonne]=joueur.couleur.toUpperCase();
					caseControl.add(new Case(colonne,ligne+1,joueur.couleur));
				}
				if (joueur.couleur.equals(grillage.grillage[ligne-1][colonne])){//Vérification en haut
					//On met en majuscule + changement de couleur
					grillage.grillage[ligne-1][colonne]=joueur.couleur.toUpperCase();
					caseControl.add(new Case(colonne,ligne-1,joueur.couleur));
				}
				if (joueur.couleur.equals(grillage.grillage[ligne][colonne-1])){//Vérification à gauche
					//On met en majuscule + changement de couleur
					grillage.grillage[ligne][colonne-1]=joueur.couleur.toUpperCase();
					caseControl.add(new Case(colonne-1,ligne,joueur.couleur));
				}
	
				grillage.grillage[ligne][colonne]=joueur.couleur.toUpperCase();
				i++;
				
			}while(i<caseControl.size()); //Fin de la boucle pour ajouter à la liste les cases de même couleur et les mettre en majuscule
				
			if ((compteurTour>0 && NBJOUEUR == 2) || (compteurTour>1 && NBJOUEUR == 3) || (compteurTour>2 && NBJOUEUR == 4)){
				
				affichagePlateauConsole(grillage);
				affichagePlateauGraphique(grillage);
				
			}
			
			if (joueur1.tour == true){
				joueur1.caseControl = caseControl;
				couleur1 = couleur;
			}
			if (joueur2.tour == true){
				joueur2.caseControl = caseControl;
				couleur2 = couleur;
			}
			if (joueur3.tour == true){
				joueur3.caseControl = caseControl;
				couleur3 = couleur;
			}
			if (joueur4.tour == true){
				joueur4.caseControl = caseControl;
				couleur4 = couleur;
			}
			
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
