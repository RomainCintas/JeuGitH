import java.util.ArrayList;

public class Jeu {
	
	public static int NBJOUEUR = 2;
	public static boolean MULTIJOUEUR = true;
	public static int compteurTour = 0; //pour compter le nombre de tour
	public static int tailleGrille = 13;
	
	//lance le jeu
	public static void lancementJeu(){
		ArrayList <Case> caseControl = null;
		
		System.out.println("Choix du pseudo : " + Menu.choixPseudo);
		//choix du pseudos du joueur (si demandé
		if(Menu.choixPseudo == true){
			Joueur.choixPseudoJoueur();
		}
		else{
			if (Jeu.MULTIJOUEUR == false){
				Joueur.pseudoIA();
			}
		}

		//création de la grille initiale
		Plateau.creaGrille();
		char[][] grillage = Plateau.grillage;
		
		//Création des joueurs
		Joueur joueur1 = new Joueur(Joueur.nom1,Plateau.couleur1,Plateau.colonne1,Plateau.ligne1,true,0,caseControl,true);
		
		boolean humain;
		
		if (Jeu.MULTIJOUEUR == true){
			humain = true;
		}
		else{
			humain = false;
		}
		
		Joueur joueur2 = new Joueur(Joueur.nom2,Plateau.couleur2,Plateau.colonne2,Plateau.ligne2,false,1,caseControl,humain);
		Joueur joueur3 = new Joueur(Joueur.nom3,Plateau.couleur3,Plateau.colonne3,Plateau.ligne3,false,2,caseControl,humain);
		Joueur joueur4 = new Joueur(Joueur.nom4,Plateau.couleur4,Plateau.colonne4,Plateau.ligne4,false,3,caseControl,humain);
		
		//Attribution des tours initiaux
		joueur1.tour = true;
		joueur2.tour = false;
		joueur3.tour = false;
		joueur4.tour = false;
		
		jeu(joueur1, joueur2, joueur3, joueur4, grillage);
		
	}
	
	
	
	//coeur du jeu
	public static void jeu(Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4, char[][] grillage){
		
		//initialisation du joueur
		Joueur joueur;
		
		//Affiche la position des joueurs
		Joueur.positionJoueur(joueur1.nom, joueur2.nom, joueur3.nom, joueur4.nom);
			
		//Début de la boucle du jeu (1 boucle = 1 tour)
		boolean jeu = true;
		while (jeu == true){
			
			//Attribution des variables spécifiques au tour au joueur concerné
			joueur = Joueur.debutTourJoueur(joueur1, joueur2, joueur3, joueur4);
			
			// Début de la boucle pour les tours joués (après l'initialisation)
			if ((compteurTour>1 && NBJOUEUR == 2) || (compteurTour>2 && NBJOUEUR == 3) || (compteurTour>3 && NBJOUEUR == 4)){
				
				//Choix de la couleur
				joueur.couleur = Case.choixCouleur(joueur,joueur1, joueur2, joueur3, joueur4, grillage);
				
				//Coloration des cases déjà contrôlées
				grillage = Case.colorationCaseControl(joueur, grillage); 
			}
			
			//Détection des cases voisines de la même couleur
			Case.verifCaseVoisine(joueur, grillage);
			
			//Affichage du plateau
			Plateau.affichagePlateau(grillage);
			
			//Récupération des variables spécifiques au tour par le joueur concerné
			Joueur.finTourJoueur(joueur, joueur1, joueur2, joueur3, joueur4);
			
			//Vérification des conditions de victoire
			conditionVictoire(joueur1, joueur2, joueur3, joueur4);
			jeu = conditionVictoire(joueur1, joueur2, joueur3, joueur4);
			
			//Rotation du tour des joueurs
			Joueur.rotationTourJoueur(joueur1, joueur2, joueur3, joueur4);
			
			compteurTour++; //Compteur de tour
			
			
		} //Fin de la boucle du jeu (1 boucle = 1 tour)
	}
	
	
	
	
	//Arrête le jeu si les conditions de victoire sont atteintes
	public static boolean conditionVictoire(Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4){
		
		//Conditions de victoire pour une partie à 2 joueurs
		if (compteurTour > 1 && NBJOUEUR == 2 && (joueur1.caseControl.size()>Math.pow(tailleGrille, 2)/2 || joueur2.caseControl.size()>Math.pow(tailleGrille, 2)/2
		|| joueur1.caseControl.size()+joueur2.caseControl.size() == Math.pow(tailleGrille, 2))){ // Conditions de victoire pour une partie à 2 joueurs
		

			StdDraw.clear();
			
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.rectangle(tailleGrille-5, tailleGrille+2, 5, 0.01);//par défaut 8, 15
			
			System.out.println("Le jeu des Six couleurs");
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.rectangle(tailleGrille-5, tailleGrille+2, 5, 0.01);//par défaut 8, 15
			
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(tailleGrille-5, tailleGrille+2, "Le jeu des Six couleurs");//par défaut 8, 15
			
			if (joueur1.caseControl.size()>joueur2.caseControl.size()){
				System.out.println("Victoire de " + joueur1.nom + " !!!");
				StdDraw.text(tailleGrille-5, tailleGrille, "Victoire de " + joueur1.nom + " !!!");//par défaut 8, 13
			}
			else
			{	
				if (joueur1.caseControl.size() == joueur2.caseControl.size()){
					System.out.println("Dans le doute, on va dire que Timothée a gagné");
					StdDraw.text(tailleGrille-5, tailleGrille, "Dans le doute, on va dire que Timothée a gagné");//par défaut 8, 13
				}
				else {
					System.out.println("Victoire de " + joueur2.nom + " !!!");
					StdDraw.text(tailleGrille-5, tailleGrille, "Victoire de " + joueur2.nom + " !!!");//par défaut 8, 13
				}
			}
			System.out.println("Nombre de cases possédées par " + joueur1.nom + " : " + joueur1.caseControl.size());
			StdDraw.text(tailleGrille-5, tailleGrille-1, "Nombre de cases possédées par " + joueur1.nom + " : " + joueur1.caseControl.size());//par défaut 8, 12
			System.out.println("Nombre de cases possédées par " + joueur2.nom + " : " + joueur2.caseControl.size());
			StdDraw.text(tailleGrille-5, tailleGrille-2, "Nombre de cases possédées par " + joueur2.nom + " : " + joueur2.caseControl.size());//par défaut 8, 11
			return false;
		}
		
		//Conditions de victoire pour une partie à 3 joueurs
		if (compteurTour > 2 && NBJOUEUR == 3 && (joueur1.caseControl.size()>Math.pow(tailleGrille, 2)/2 || joueur2.caseControl.size()>Math.pow(tailleGrille, 2)/2 || joueur3.caseControl.size()>Math.pow(tailleGrille, 2)/2
		|| joueur1.caseControl.size()+joueur2.caseControl.size()+joueur3.caseControl.size() == Math.pow(tailleGrille, 2))){ // Conditions de victoire pour une partie à 3 joueurs

			StdDraw.clear();
			
			System.out.println("Le jeu des Six couleurs");
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.rectangle(tailleGrille-5, tailleGrille+2, 5, 0.01);//par défaut 8, 15
			
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(tailleGrille-5, tailleGrille+2, "Le jeu des Six couleurs");//par défaut 8, 15
			
			if (joueur1.caseControl.size()>joueur2.caseControl.size()){
				if(joueur1.caseControl.size()>joueur3.caseControl.size()){
					System.out.println("Victoire de " + joueur1.nom + " !!!");
					StdDraw.text(tailleGrille-5, tailleGrille, "Victoire de " + joueur1.nom + " !!!");//par défaut 8, 13
				}
				else{
					if(joueur1.caseControl.size()==joueur3.caseControl.size()){
						System.out.println("Dans le doute, on va dire que Timothée a gagné");
						StdDraw.text(tailleGrille-5, tailleGrille, "Dans le doute, on va dire que Timothée a gagné");//par défaut 8, 13
					}
					else{
						System.out.println("Victoire de " + joueur3.nom + " !!!");
						StdDraw.text(tailleGrille-5, tailleGrille, "Victoire de " + joueur3.nom + " !!!");//par défaut 8, 13
					}
				}
			}
			else
			{	
				if(joueur2.caseControl.size()>joueur3.caseControl.size()){
					if(joueur1.caseControl.size()==joueur2.caseControl.size()){
						System.out.println("Dans le doute, on va dire que Timothée a gagné");
						StdDraw.text(tailleGrille-5, tailleGrille, "Dans le doute, on va dire que Timothée a gagné");//par défaut 8, 13
					}
					else {
						System.out.println("Victoire de " + joueur2.nom + " !!!");
						StdDraw.text(tailleGrille-5, tailleGrille, "Victoire de " + joueur2.nom + " !!!");//par défaut 8, 13
					}
				}
				else{
					if (joueur2.caseControl.size() == joueur3.caseControl.size()){
						System.out.println("Dans le doute, on va dire que Timothée a gagné");
						StdDraw.text(tailleGrille-5, tailleGrille, "Dans le doute, on va dire que Timothée a gagné");//par défaut 8, 13
					}
					else{
						System.out.println("Victoire de " + joueur3.nom + " !!!");
						StdDraw.text(tailleGrille-5, tailleGrille, "Victoire de " + joueur3.nom + " !!!");//par défaut 8, 13
					}
				}
			}
			System.out.println("Nombre de cases possédées par " + joueur1.nom + " : " + joueur1.caseControl.size());
			StdDraw.text(tailleGrille-5, tailleGrille-1, "Nombre de cases possédées par " + joueur1.nom + " : " + joueur1.caseControl.size());//par défaut 8, 12
			System.out.println("Nombre de cases possédées par " + joueur2.nom + " : " + joueur2.caseControl.size());
			StdDraw.text(tailleGrille-5, tailleGrille-2, "Nombre de cases possédées par " + joueur2.nom + " : " + joueur2.caseControl.size());//par défaut 8, 11
			System.out.println("Nombre de cases possédées par " + joueur3.nom + " : " + joueur3.caseControl.size());
			StdDraw.text(tailleGrille-5, tailleGrille-3, "Nombre de cases possédées par " + joueur3.nom + " : " + joueur3.caseControl.size());//par défaut 8, 10
			return false;
		}
		
		//Conditions de victoire pour une partie à 4 joueurs
		if (compteurTour >3 && NBJOUEUR == 4 && (joueur1.caseControl.size()>Math.pow(tailleGrille, 2)/2 || joueur2.caseControl.size()>Math.pow(tailleGrille, 2)/2 || joueur3.caseControl.size()>Math.pow(tailleGrille, 2)/2 || joueur4.caseControl.size()>Math.pow(tailleGrille, 2)/2
			|| joueur1.caseControl.size()+joueur2.caseControl.size()+joueur3.caseControl.size()+joueur4.caseControl.size() == Math.pow(tailleGrille, 2))){ 

			StdDraw.clear();
			
			System.out.println("Le jeu des Six couleurs");
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.rectangle(tailleGrille-5, tailleGrille+2, 5, 0.01);//par défaut 8, 15
			
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(tailleGrille-5, tailleGrille+2, "Le jeu des Six couleurs");//par défaut 8, 15
			
			if (joueur1.caseControl.size()>joueur2.caseControl.size()){
				if(joueur1.caseControl.size()>joueur3.caseControl.size()){
					if(joueur1.caseControl.size()>joueur4.caseControl.size()){
						System.out.println("Victoire de " + joueur1.nom + " !!!");
						StdDraw.text(tailleGrille-5, tailleGrille, "Victoire de " + joueur1.nom + " !!!");//par défaut 8, 13
					}
					else{
						if (joueur1.caseControl.size()==joueur4.caseControl.size()){
							System.out.println("Dans le doute, on va dire que Timothée a gagné");
							StdDraw.text(tailleGrille-5, tailleGrille, "Dans le doute, on va dire que Timothée a gagné");//par défaut 8, 13
						}
						else{
							System.out.println("Victoire de " + joueur4.nom + " !!!");
							StdDraw.text(tailleGrille-5, tailleGrille, "Victoire de " + joueur4.nom + " !!!");//par défaut 8, 13
						}
					}
				}
				else{
					if (joueur3.caseControl.size()>joueur4.caseControl.size()){
						System.out.println("Victoire de " + joueur3.nom + " !!!");
						StdDraw.text(tailleGrille-5, tailleGrille, "Victoire de " + joueur3.nom + " !!!");//par défaut 8, 13
					}
					else{
						if(joueur3.caseControl.size()==joueur4.caseControl.size()){
							System.out.println("Dans le doute, on va dire que Timothée a gagné");
							StdDraw.text(tailleGrille-5, tailleGrille, "Dans le doute, on va dire que Timothée a gagné");//par défaut 8, 13
						}
						else{
							System.out.println("Victoire de " + joueur4.nom + " !!!");
							StdDraw.text(tailleGrille-5, tailleGrille, "Victoire de " + joueur4.nom + " !!!");//par défaut 8, 13
						}
					}
					
				}
			}
			else //si 2=<1
			{	
				if(joueur2.caseControl.size()>joueur3.caseControl.size()){
					if(joueur2.caseControl.size()>joueur4.caseControl.size()){
						if (joueur1.caseControl.size()==joueur2.caseControl.size()){
							System.out.println("Dans le doute, on va dire que Timothée a gagné");
							StdDraw.text(tailleGrille-5, tailleGrille, "Dans le doute, on va dire que Timothée a gagné");//par défaut 8, 13
						}
						else{
							System.out.println("Victoire de " + joueur2.nom + " !!!");
							StdDraw.text(tailleGrille-5, tailleGrille, "Victoire de " + joueur2.nom + " !!!");//par défaut 8, 13
						}
					}
					else{ // si 4=<2
						if (joueur2.caseControl.size()==joueur4.caseControl.size()){
							System.out.println("Dans le doute, on va dire que Timothée a gagné");
							StdDraw.text(tailleGrille-5, tailleGrille, "Dans le doute, on va dire que Timothée a gagné");//par défaut 8, 13
						}
						else{
							System.out.println("Victoire de " + joueur2.nom + " !!!");
							StdDraw.text(tailleGrille-5, tailleGrille, "Victoire de " + joueur2.nom + " !!!");//par défaut 8, 13
						}
					}
				}
				
				else{ // si 3=<2
					if (joueur3.caseControl.size() > joueur4.caseControl.size()){
						if(joueur2.caseControl.size() == joueur3.caseControl.size()){
							System.out.println("Dans le doute, on va dire que Timothée a gagné");
							StdDraw.text(tailleGrille-5, tailleGrille, "Dans le doute, on va dire que Timothée a gagné");//par défaut 8, 13
						}
						else{
							System.out.println("Victoire de " + joueur3.nom + " !!!");
							StdDraw.text(tailleGrille-5, tailleGrille, "Victoire de " + joueur3.nom + " !!!");//par défaut 8, 13
						}
					}
					else{ //si 4>=3
						if(joueur1.caseControl.size() == joueur2.caseControl.size()){
							System.out.println("Dans le doute, on va dire que Timothée a gagné");
							StdDraw.text(tailleGrille-5, tailleGrille, "Dans le doute, on va dire que Timothée a gagné");//par défaut 8, 13
						}
						else{
							System.out.println("Victoire de " + joueur4.nom + " !!!");
							StdDraw.text(tailleGrille-5, tailleGrille, "Victoire de " + joueur4.nom + " !!!");//par défaut 8, 13
						}
					}
				}
			}
			System.out.println("Nombre de cases possédées par " + joueur1.nom + " : " + joueur1.caseControl.size());
			StdDraw.text(tailleGrille-5, tailleGrille-1, "Nombre de cases possédées par " + joueur1.nom + " : " + joueur1.caseControl.size());//par défaut 8, 12
			System.out.println("Nombre de cases possédées par " + joueur2.nom + " : " + joueur2.caseControl.size());
			StdDraw.text(tailleGrille-5, tailleGrille-2, "Nombre de cases possédées par " + joueur2.nom + " : " + joueur2.caseControl.size());//par défaut 8, 11
			System.out.println("Nombre de cases possédées par " + joueur3.nom + " : " + joueur3.caseControl.size());
			StdDraw.text(tailleGrille-5, tailleGrille-3, "Nombre de cases possédées par " + joueur3.nom + " : " + joueur3.caseControl.size());//par défaut 8, 10
			System.out.println("Nombre de cases possédées par " + joueur4.nom + " : " + joueur4.caseControl.size());
			StdDraw.text(tailleGrille-5, tailleGrille-4, "Nombre de cases possédées par " + joueur4.nom + " : " + joueur4.caseControl.size());//par défaut 8, 9
			return false;
		}
		return true;
	}
}
