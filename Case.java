import java.util.Scanner;

public class Case {

	public int colonne;
	public int ligne;
	String couleur;
	
	public Case (int colonne, int ligne, String couleur){//coordonnées et couleur d'une case
		this.colonne = colonne;
		this.ligne = ligne;
		this.couleur = couleur;
	}
	
	//Choix de la couleur
	public static String choixCouleur(Joueur joueur, Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4, int NBJOUEUR){
		String couleurChoisie = "couleur choisie";
		
		do{ //boucle de choix de la couleur
			
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.rectangle(6.65, 15, 15, 0.01);
			StdDraw.setPenColor(StdDraw.BLACK);
			
			System.out.println("C'est à " + joueur.nom + " de jouer, veuillez choisir une couleur différente de ");
			
			if (NBJOUEUR == 2){
				System.out.println(joueur1.couleur + " et " + joueur2.couleur + ".");
				StdDraw.text(7, 14.8, "C'est à " + joueur.nom + " de jouer, veuillez choisir une couleur différente de " + joueur1.couleur + " et " + joueur2.couleur + ".");
				System.out.println("Score de " + joueur1.nom + " : " + joueur1.caseControl.size() + "  Score de " + joueur2.nom + " : " + joueur2.caseControl.size());
				StdDraw.text(6.65, 15.2, "Score de " + joueur1.nom + " : " + joueur1.caseControl.size() + "  Score de " + joueur2.nom + " : " + joueur2.caseControl.size());
			}
			else{
				if(NBJOUEUR==3){
					System.out.println(joueur1.couleur + ", " + joueur2.couleur + " et " + joueur3.couleur + ".");
					StdDraw.text(7, 14.8, "C'est à " + joueur.nom + " de jouer, veuillez choisir une couleur différente de " + joueur1.couleur + ", " + joueur2.couleur + " et " + joueur3.couleur + ".");
					System.out.println("Score de " + joueur1.nom + " : " + joueur1.caseControl.size() + "  Score de " + joueur2.nom + " : " + joueur2.caseControl.size() + "  Score de " + joueur3.nom + " : " + joueur3.caseControl.size());
					StdDraw.text(6.65, 15.2, "Score de " + joueur1.nom + " : " + joueur1.caseControl.size() + "  Score de " + joueur2.nom + " : " + joueur2.caseControl.size() + "  Score de " + joueur3.nom + " : " + joueur3.caseControl.size());
				}
				else{
					System.out.println(joueur1.couleur + ", " + joueur2.couleur + ", " + joueur3.couleur + " et " + joueur4.couleur + ".");
					StdDraw.text(7, 14.8, "C'est à " + joueur.nom + " de jouer, veuillez choisir une couleur différente de " + joueur1.couleur + ", " + joueur2.couleur + ", " + joueur3.couleur + " et " + joueur4.couleur + ".");
					System.out.println("Score de " + joueur1.nom + " : " + joueur1.caseControl.size() + "  Score de " + joueur2.nom + " : " + joueur2.caseControl.size() + "  Score de " + joueur3.nom + " : " + joueur3.caseControl.size() + "  Score de " + joueur4.nom + " : " + joueur4.caseControl.size());
					StdDraw.text(6.65, 15.2, "Score de " + joueur1.nom + " : " + joueur1.caseControl.size() + "  Score de " + joueur2.nom + " : " + joueur2.caseControl.size() + "  Score de " + joueur3.nom + " : " + joueur3.caseControl.size() + "  Score de " + joueur4.nom + " : " + joueur4.caseControl.size());
				}
			}
			
			if (joueur.humain == true){
				//(1) sélection de la couleur en mode graphique (avec la souris)
				couleurChoisie = selectionCouleurGraphique(joueur.couleur, joueur1.couleur, joueur2.couleur, joueur3.couleur, joueur4.couleur, NBJOUEUR);

				//(2) sélection de la couleur en mode console
				//couleurChoisie = selectionCouleurConsole(joueur.couleur, joueur1.couleur, joueur2.couleur, joueur3.couleur, joueur4.couleur, NBJOUEUR);
			}
			else{// sélection de la couleur par l'IA
				couleurChoisie = Plateau.Random_letter();
			}
			
		}while(couleurChoisie.equals(joueur1.couleur) || couleurChoisie.equals(joueur2.couleur) || couleurChoisie.equals(joueur3.couleur) || couleurChoisie.equals(joueur4.couleur));
		joueur.couleur = couleurChoisie; //prise en compte de la couleur choisie
		
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.rectangle(6.65, 14, 15, 0.01);
		StdDraw.setPenColor(StdDraw.BLACK);
		
		return couleurChoisie;
	}
	
	//Sélection de la couleur en mode graphique (avec la souris)
	public static String selectionCouleurGraphique(String couleur, String couleur1, String couleur2, String couleur3, String couleur4, int NBJOUEUR){
		String couleurChoisie = "couleur choisie";
		double x = 0;
		double y = 0;
		int xPos = 0;
		int yPos = 0;
		while(!(xPos == 15 && (yPos == 4 || yPos == 5 || yPos == 6 || yPos == 7 || yPos == 8 || yPos == 9))){
			while(!StdDraw.mousePressed()) {
				x = StdDraw.mouseX();
				y = StdDraw.mouseY();
				xPos = (int) Math.round(x);
				yPos = (int) Math.round(y);
			}
			x = StdDraw.mouseX();
			y = StdDraw.mouseY();
			xPos = (int) Math.round(x);
			yPos = (int) Math.round(y);
		}
		if(yPos == 4){
			couleurChoisie = "r";
		}
		if(yPos == 5){
			couleurChoisie = "o";
		}
		if(yPos == 6){
			couleurChoisie = "j";
		}
		if(yPos == 7){
			couleurChoisie = "v";
		}
		if(yPos == 8){
			couleurChoisie = "b";
		}
		if(yPos == 9){
			couleurChoisie = "i";
		}
		couleurChoisie = verifCouleurChoisie(couleurChoisie, couleur, couleur1, couleur2, couleur3, couleur4, NBJOUEUR);
		return couleurChoisie;
	}
	
	//Sélection de la couleur en mode console
	public static String selectionCouleurConsole(String couleur, String couleur1, String couleur2, String couleur3, String couleur4, int NBJOUEUR){
		Scanner scan = new Scanner(System.in);
		String couleurChoisie = scan.nextLine().toLowerCase(); //demande de la couleur choisie au joueur
		couleurChoisie = verifCouleurChoisie(couleurChoisie, couleur, couleur1, couleur2, couleur3, couleur4, NBJOUEUR);
		return couleurChoisie;
	}
	
	//Vérification si la couleur choisie n'est pas déjà prise
	public static String verifCouleurChoisie(String couleurChoisie, String couleur, String couleur1, String couleur2, String couleur3, String couleur4, int NBJOUEUR){
		if (couleur1.equals(couleurChoisie) || couleur2.equals(couleurChoisie) || couleur3.equals(couleurChoisie) || couleur4.equals(couleurChoisie)){
			
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.rectangle(6.65, 14, 15, 0.01);
			StdDraw.setPenColor(StdDraw.BLACK);
			
			if (couleurChoisie.equals(couleur)){
				System.out.println("VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE LA VÔTRE");
				StdDraw.text(7, 14.2, "VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE LA VÔTRE");
			}
			else{
				if (NBJOUEUR == 2){
					System.out.println("VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE CELLE DE VOTRE ADVERSAIRE");
					StdDraw.text(7, 13.8, "VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE CELLE DE VOTRE ADVERSAIRE");
				}
				else{
					System.out.println("VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE CELLES DE VOS ADVERSAIRES");
					StdDraw.text(7, 13.8, "VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE CELLES DE VOS ADVERSAIRES");
				}
			}
		}
		return couleurChoisie;
	}
	
	//Coloration des cases déjà contrôlées
	public static String[][] colorationCaseControl(Joueur joueur, String[][] grillage){
		for (int i=0;i<joueur.caseControl.size();++i){
			int colonne = joueur.caseControl.get(i).colonne;
			int ligne = joueur.caseControl.get(i).ligne;
			grillage[ligne][colonne]=joueur.couleur.toUpperCase();
			i++;
		}
		return grillage;
	}
	
	//Détection des cases voisines de la même couleur
	public static void verifCaseVoisine(Joueur joueur, String[][] grillage){
		for (int i=0;i<joueur.caseControl.size();++i){
			//Boucle pour ajouter à la liste les cases de même couleur et les mettre en majuscule
			int colonne = joueur.caseControl.get(i).colonne;
			int ligne = joueur.caseControl.get(i).ligne;
			if (joueur.couleur.equals(grillage[ligne][colonne+1])){//Vérification à droite
				//On met en majuscule + changement de couleur
				grillage[ligne][colonne+1]=joueur.couleur.toUpperCase();
				joueur.caseControl.add(new Case(colonne+1,ligne,joueur.couleur));
			}
			if (joueur.couleur.equals(grillage[ligne+1][colonne])){//Vérification en bas
				//On met en majuscule + changement de couleur
				grillage[ligne+1][colonne]=joueur.couleur.toUpperCase();
				joueur.caseControl.add(new Case(colonne,ligne+1,joueur.couleur));
			}
			if (joueur.couleur.equals(grillage[ligne-1][colonne])){//Vérification en haut
				//On met en majuscule + changement de couleur
				grillage[ligne-1][colonne]=joueur.couleur.toUpperCase();
				joueur.caseControl.add(new Case(colonne,ligne-1,joueur.couleur));
			}
			if (joueur.couleur.equals(grillage[ligne][colonne-1])){//Vérification à gauche
				//On met en majuscule + changement de couleur
				grillage[ligne][colonne-1]=joueur.couleur.toUpperCase();
				joueur.caseControl.add(new Case(colonne-1,ligne,joueur.couleur));
			}

			grillage[ligne][colonne]=joueur.couleur.toUpperCase();
			
		}
	}
	
}
