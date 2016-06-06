import java.util.Scanner;

public class Case{

	public int colonne, ligne;
	char couleur;
	
	public Case (int colonne, int ligne, char couleur){//coordonnées et couleur d'une case
		this.colonne = colonne;
		this.ligne = ligne;
		this.couleur = couleur;
	}
	
	//Choix de la couleur
	public static char choixCouleur(Joueur joueur, Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4, char[][] grillage){
		char couleurChoisie = 'c';
		
		do{ //boucle de choix de la couleur
			
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.rectangle(Jeu.tailleGrille-6.35, Jeu.tailleGrille+2, 15, 0.01);//par défaut 6.65, 15
			StdDraw.setPenColor(StdDraw.BLACK);
			
			System.out.println("C'est à " + joueur.nom + " de jouer, veuillez choisir une couleur différente de ");
			
			if (Jeu.NBJOUEUR == 2){
				System.out.println(joueur1.couleur + " et " + joueur2.couleur + ".");
				StdDraw.text(Jeu.tailleGrille-6, Jeu.tailleGrille+1.8, "C'est à " + joueur.nom + " de jouer, veuillez choisir une couleur différente de " + joueur1.couleur + " et " + joueur2.couleur + ".");//par défaut 7, 14.8
				System.out.println("Score de " + joueur1.nom + " : " + joueur1.caseControl.size() + "  Score de " + joueur2.nom + " : " + joueur2.caseControl.size());
				StdDraw.text(Jeu.tailleGrille-6.35, Jeu.tailleGrille+2.2, "Score de " + joueur1.nom + " : " + joueur1.caseControl.size() + "  Score de " + joueur2.nom + " : " + joueur2.caseControl.size());//par défaut 6.65, 15.2
			}
			else{
				if(Jeu.NBJOUEUR==3){
					System.out.println(joueur1.couleur + ", " + joueur2.couleur + " et " + joueur3.couleur + ".");
					StdDraw.text(Jeu.tailleGrille-6, Jeu.tailleGrille+1.8, "C'est à " + joueur.nom + " de jouer, veuillez choisir une couleur différente de " + joueur1.couleur + ", " + joueur2.couleur + " et " + joueur3.couleur + ".");//par défaut 7, 14.8
					System.out.println("Score de " + joueur1.nom + " : " + joueur1.caseControl.size() + "  Score de " + joueur2.nom + " : " + joueur2.caseControl.size() + "  Score de " + joueur3.nom + " : " + joueur3.caseControl.size());
					StdDraw.text(Jeu.tailleGrille-6.35, Jeu.tailleGrille+2.2, "Score de " + joueur1.nom + " : " + joueur1.caseControl.size() + "  Score de " + joueur2.nom + " : " + joueur2.caseControl.size() + "  Score de " + joueur3.nom + " : " + joueur3.caseControl.size());//par défaut 6.65, 15.2
				}
				else{
					System.out.println(joueur1.couleur + ", " + joueur2.couleur + ", " + joueur3.couleur + " et " + joueur4.couleur + ".");
					StdDraw.text(Jeu.tailleGrille-6, Jeu.tailleGrille+1.8, "C'est à " + joueur.nom + " de jouer, veuillez choisir une couleur différente de " + joueur1.couleur + ", " + joueur2.couleur + ", " + joueur3.couleur + " et " + joueur4.couleur + ".");//par défaut 7, 14.8
					System.out.println("Score de " + joueur1.nom + " : " + joueur1.caseControl.size() + "  Score de " + joueur2.nom + " : " + joueur2.caseControl.size() + "  Score de " + joueur3.nom + " : " + joueur3.caseControl.size() + "  Score de " + joueur4.nom + " : " + joueur4.caseControl.size());
					StdDraw.text(Jeu.tailleGrille-6.35, Jeu.tailleGrille+2.2, "Score de " + joueur1.nom + " : " + joueur1.caseControl.size() + "  Score de " + joueur2.nom + " : " + joueur2.caseControl.size() + "  Score de " + joueur3.nom + " : " + joueur3.caseControl.size() + "  Score de " + joueur4.nom + " : " + joueur4.caseControl.size());//par défaut 6.65, 15.2
				}
			}
			
			if (joueur.humain == true){
				//(1) sélection de la couleur en mode graphique (avec la souris)
				couleurChoisie = selectionCouleurGraphique(joueur.couleur, joueur1, joueur2, joueur3, joueur4, grillage);

				//(2) sélection de la couleur en mode console
				//couleurChoisie = selectionCouleurConsole(joueur.couleur, joueur1.couleur, joueur2.couleur, joueur3.couleur, joueur4.couleur);
			}
			else{// sélection de la couleur par l'IA
				couleurChoisie = Plateau.Random_letter();
			}
			
		}while(couleurChoisie == joueur1.couleur || couleurChoisie == joueur2.couleur || couleurChoisie == joueur3.couleur || couleurChoisie == joueur4.couleur);
		joueur.couleur = couleurChoisie; //prise en compte de la couleur choisie
		
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.rectangle(Jeu.tailleGrille-6.35, Jeu.tailleGrille+1, 15, 0.01);//par défaut 6.65, 14
		StdDraw.setPenColor(StdDraw.BLACK);
		
		return couleurChoisie;
	}
	
	//Sélection de la couleur en mode graphique (avec la souris)
	public static char selectionCouleurGraphique(char couleur, Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4, char[][] grillage){
		char couleurChoisie = 'c';
		double x = 0;
		double y = 0;
		int xPos = 0;
		int yPos = 0;
		while(couleurChoisie == 'c'){
			while(!StdDraw.mousePressed()) {
				x = StdDraw.mouseX();
				y = StdDraw.mouseY();
			}
			xPos = (int) Math.round(x);
			yPos = (int) Math.round(y);
			
			if (xPos == Jeu.tailleGrille+2){//par défaut 15
				if(yPos == Jeu.tailleGrille-9){//par défaut 4
					couleurChoisie = 'r';
				}
				if(yPos == Jeu.tailleGrille-8){//par défaut 5
					couleurChoisie = 'o';
				}
				if(yPos == Jeu.tailleGrille-7){//par défaut 6
					couleurChoisie = 'j';
				}
				if(yPos == Jeu.tailleGrille-6){//par défaut 7
					couleurChoisie = 'v';
				}
				if(yPos == Jeu.tailleGrille-5){//par défaut 8
					couleurChoisie = 'b';
				}
				if(yPos == Jeu.tailleGrille-4){//par défaut 9
					couleurChoisie = 'i';
				}
				if(yPos == Jeu.tailleGrille-3){//par défaut 10
					Sauvegarde.sauvegardePartie(joueur1, joueur2, joueur3, joueur4, grillage);
				}
			}
		}
		couleurChoisie = verifCouleurChoisie(couleurChoisie, couleur, joueur1.couleur, joueur2.couleur, joueur3.couleur, joueur4.couleur);
		return couleurChoisie;
	}
	
	//Sélection de la couleur en mode console
	public static char selectionCouleurConsole(char couleur, char couleur1, char couleur2, char couleur3, char couleur4){
		Scanner scan = new Scanner(System.in);
		char couleurChoisie = Character.toUpperCase(scan.nextLine().charAt(0)); //demande de la couleur choisie au joueur
		couleurChoisie = verifCouleurChoisie(couleurChoisie, couleur, couleur1, couleur2, couleur3, couleur4);
		return couleurChoisie;
	}
	
	//Vérification si la couleur choisie n'est pas déjà prise et affiche un message d’erreur si elle l’est
	public static char verifCouleurChoisie(char couleurChoisie, char couleur, char couleur1, char couleur2, char couleur3, char couleur4){
		if (couleur1 == couleurChoisie || couleur2 == couleurChoisie || couleur3 == couleurChoisie || couleur4 == couleurChoisie){
			
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.rectangle(Jeu.tailleGrille-6.35, Jeu.tailleGrille+1, 15, 0.01);//par défaut 6.65, 14
			StdDraw.setPenColor(StdDraw.BLACK);
			
			if (couleurChoisie == couleur){
				System.out.println("VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE LA VÔTRE");
				StdDraw.text(Jeu.tailleGrille-6, Jeu.tailleGrille+1.2, "VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE LA VÔTRE");//par défaut 7, 14.2
			}
			else{
				if (Jeu.NBJOUEUR == 2){
					System.out.println("VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE CELLE DE VOTRE ADVERSAIRE");
					StdDraw.text(Jeu.tailleGrille-6, Jeu.tailleGrille+0.8, "VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE CELLE DE VOTRE ADVERSAIRE");//par défaut 7, 13.8
				}
				else{
					System.out.println("VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE CELLES DE VOS ADVERSAIRES");
					StdDraw.text(Jeu.tailleGrille-6, Jeu.tailleGrille+0.8, "VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE CELLES DE VOS ADVERSAIRES");//par défaut 7, 13.8
				}
			}
		}
		return couleurChoisie;
	}
	
	//Coloration des cases déjà contrôlées
	public static char[][] colorationCaseControl(Joueur joueur, char[][] grillage){
		for (int i=0;i<joueur.caseControl.size();++i){
			int colonne = joueur.caseControl.get(i).colonne;
			int ligne = joueur.caseControl.get(i).ligne;
			grillage[ligne][colonne]=Character.toUpperCase(joueur.couleur);
			//i++;
		}
		return grillage;
	}
	
	//Détection des cases voisines de la même couleur
	public static void verifCaseVoisine(Joueur joueur, char[][] grillage){
		for (int i=0;i<joueur.caseControl.size();++i){
			//Boucle pour ajouter à la liste les cases de même couleur et les mettre en majuscule
			int colonne = joueur.caseControl.get(i).colonne;
			int ligne = joueur.caseControl.get(i).ligne;
			if (joueur.couleur == grillage[ligne][colonne+1]){//Vérification à droite
				//On met en majuscule + changement de couleur
				grillage[ligne][colonne+1]=Character.toUpperCase(joueur.couleur);
				joueur.caseControl.add(new Case(colonne+1,ligne,joueur.couleur));
			}
			if (joueur.couleur == grillage[ligne+1][colonne]){//Vérification en bas
				//On met en majuscule + changement de couleur
				grillage[ligne+1][colonne]=Character.toUpperCase(joueur.couleur);
				joueur.caseControl.add(new Case(colonne,ligne+1,joueur.couleur));
			}
			if (joueur.couleur == grillage[ligne-1][colonne]){//Vérification en haut
				//On met en majuscule + changement de couleur
				grillage[ligne-1][colonne]=Character.toUpperCase(joueur.couleur);
				joueur.caseControl.add(new Case(colonne,ligne-1,joueur.couleur));
			}
			if (joueur.couleur == grillage[ligne][colonne-1]){//Vérification à gauche
				//On met en majuscule + changement de couleur
				grillage[ligne][colonne-1]=Character.toUpperCase(joueur.couleur);
				joueur.caseControl.add(new Case(colonne-1,ligne,joueur.couleur));
			}

			grillage[ligne][colonne]=Character.toUpperCase(joueur.couleur);
			
		}
	}
	
}
