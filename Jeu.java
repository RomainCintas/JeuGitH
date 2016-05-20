import java.util.ArrayList;

public class Jeu {
	
	//mode un joueur (jouer contre l'IA)
	public static void unJoueur(int NBJOUEUR){
		boolean HUMAIN = false;
		jeu(NBJOUEUR,HUMAIN);
	}
	
	//mode multijoueur (classique)
	public static void multijoueur(int NBJOUEUR){
		Menu.menuMultijoueur();
		boolean HUMAIN = true;
		jeu(NBJOUEUR,HUMAIN);
	}
	
	//jeu
	public static void jeu(int NBJOUEUR, boolean HUMAIN){
		ArrayList <Case> caseControl = null;
		
		//choix des pseudos des joueurs
		Joueur.choixPseudoJoueur(NBJOUEUR, HUMAIN);
		
		//création de la grille initiale
		Plateau.creaGrille(NBJOUEUR);
		String[][] grillage = Plateau.grillage;
		
		//Création des joueurs
		Joueur joueur;
		Joueur joueur1 = new Joueur(Joueur.nom1,Plateau.couleur1,Plateau.colonne1,Plateau.ligne1,0,caseControl,true);
		
		boolean humain;
		
		if (HUMAIN == true){
			humain = true;
		}
		else{
			humain = false;
		}
		
		Joueur joueur2 = new Joueur(Joueur.nom2,Plateau.couleur2,Plateau.colonne2,Plateau.ligne2,1,caseControl,humain);
		Joueur joueur3 = new Joueur(Joueur.nom3,Plateau.couleur3,Plateau.colonne3,Plateau.ligne3,2,caseControl,humain);
		Joueur joueur4 = new Joueur(Joueur.nom4,Plateau.couleur4,Plateau.colonne4,Plateau.ligne4,3,caseControl,humain);

		
		
		//Affiche la position des joueurs
		Joueur.positionJoueur(joueur1.nom, joueur2.nom, joueur3.nom, joueur4.nom);
		
		//Attribution des tours initiaux
		joueur1.tour = true;
		joueur2.tour = false;
		joueur3.tour = false;
		joueur4.tour = false;
		
		//pour compter le nombre de tour
		int compteurTour = 0;
		
		//Début de la boucle du jeu (1 boucle = 1 tour)
		while (true){
			
			//Attribution des variables spécifiques au tour au joueur concerné
			joueur = Joueur.debutTourJoueur(joueur1, joueur2, joueur3, joueur4, compteurTour);
			
			// Début de la boucle pour les tours joués (après l'initialisation)
			if ((compteurTour>1 && NBJOUEUR == 2) || (compteurTour>2 && NBJOUEUR == 3) || (compteurTour>3 && NBJOUEUR == 4)){
				
				//Choix de la couleur
				joueur.couleur = Case.choixCouleur(joueur,joueur1, joueur2, joueur3, joueur4, NBJOUEUR);
				
				//Coloration des cases déjà contrôlées
				grillage = Case.colorationCaseControl(joueur, grillage); 
			}
			
			//Détection des cases voisines de la même couleur
			Case.verifCaseVoisine(joueur, grillage);
			
			//Affichage du plateau
			Plateau.affichagePlateau(grillage, compteurTour, NBJOUEUR);
			
			//Récupération des variables spécifiques au tour par le joueur concerné
			Joueur.finTourJoueur(joueur, joueur1, joueur2, joueur3, joueur4);
			
			//Rotation du tour des joueurs
			Joueur.rotationTourJoueur(joueur1, joueur2, joueur3, joueur4, NBJOUEUR);
			
			compteurTour++; //Compteur de tour
		} //Fin de la boucle du jeu (1 boucle = 1 tour)
	}
	
	
	
	
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	//conditions de victoire (ne semble pas fonctionner)
	
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	//conditions de victoire (ne semble pas fonctionner)
	public static void conditionVictoire(int compteurTour, Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4, int NBJOUEUR){
		
		//Conditions de victoire pour une partie à 2 joueurs
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
		}
		
		//Conditions de victoire pour une partie à 3 joueurs
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
		}
		
		//Conditions de victoire pour une partie à 4 joueurs
		if (compteurTour != 0 && compteurTour != 1 && compteurTour != 2 && compteurTour != 3 && NBJOUEUR == 4 && (joueur1.caseControl.size()>84 ||joueur2.caseControl.size()>84 || joueur3.caseControl.size()>84 || joueur4.caseControl.size()>84)){ 
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
		}
		// ^ conditions de victoire
	}
}
