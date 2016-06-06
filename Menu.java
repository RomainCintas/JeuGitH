import java.awt.Color;
//import java.util.Scanner;
import java.io.File;

public class Menu {
		
	public static boolean choixPseudo = false;
	
	//Menu principal
	public static void menu(){
		
		System.out.println("Le jeu des Six couleurs");
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille+2, 5, 0.01);//par défaut 8, 15
		
		System.out.println("1. Un joueur");
		StdDraw.setPenColor(new Color(255, 127, 0));
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-2, 2, 0.01);//par défaut 8, 11
		
		System.out.println("2. Multijoueur");
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-4, 2, 0.01);//par défaut 8, 9
		
		System.out.println("3. Charger une partie");//non fonctionnel
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-6, 2, 0.01);//par défaut 8, 7
		
		System.out.println("4. Options");
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-8, 2, 0.01);//par défaut 8, 5
		
		System.out.println("5. Quitter");
		StdDraw.setPenColor(StdDraw.MAGENTA);
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-10, 2, 0.01);//par défaut 8, 3
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille+2, "Le jeu des Six couleurs");//par défaut 8, 15
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-2, "Un joueur");//par défaut 8, 11
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-4, "Multijoueur");//par défaut 8, 9
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-6, "Charger une partie");//par défaut 8, 7
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-8, "Options");//par défaut 8, 5
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-10, "Quitter");//par défaut 8, 3
		
		int menu = 0;

		//mode graphique
		double x = 0;
		double y = 0;
		int xPos = 0;
		int yPos = 0;
		
		while (StdDraw.mousePressed()){//si problème d'inversement de la souris
//			System.out.println("Souris : " + StdDraw.mousePressed());
		}
		
		while (menu == 0 ){
			while(!StdDraw.mousePressed()) {
				x = StdDraw.mouseX();
				y = StdDraw.mouseY();
			}
			xPos = (int) Math.round(x);
			yPos = (int) Math.round(y);

			if (xPos > 5 && xPos <11){
				if(yPos == Jeu.tailleGrille-2){//par défaut 11
					menu = 1;
				}
				else if(yPos == Jeu.tailleGrille-4){//par défaut 9
					menu = 2;
				}
				else if(yPos == Jeu.tailleGrille-6){//par défaut 7
					menu = 3;
				}
				else if(yPos == Jeu.tailleGrille-8){//par défaut 5
					menu = 4;
				}
				else if(yPos == Jeu.tailleGrille-10){// par défaut 3
					menu = 5;
				}
				else{
					System.out.println("Erreur");
					menu();
				}
			}
		}
	
		//mode console
		//Scanner scan = new Scanner(System.in);
		//menu = scan.nextInt();
		
		StdDraw.clear();
		switch (menu){
		
		  case 1:
		    System.out.println("Un joueur");
		    Jeu.MULTIJOUEUR = false;
		    Jeu.lancementJeu();
		    break;
		  case 2:
		    System.out.println("Multijoueur");
		    Jeu.MULTIJOUEUR = true;
		    Jeu.lancementJeu();
		    break;
		  case 3:
		    System.out.println("Charger une partie");
		    menuSauvegarde();
		    break;
		  case 4:
			System.out.println("Options");
			menuOptions();
			break;
		  case 5:
			System.out.println("Quitter");
			break;
		  default:
		    System.out.println("Erreur");
		}
	}
	
	//Menu des options
	public static void menuOptions(){
		StdDraw.clear();
		System.out.println("Le jeu des Six couleurs");
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille+2, 5, 0.01);//par défaut 8, 15
			
		System.out.println("1. Retour");
		StdDraw.setPenColor(new Color(255, 127, 0));//orange
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-3, 2, 0.01);//par défaut 8, 10
			
		System.out.println("2. Options");
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-4, 2, 0.01);//par défaut 8, 9
			
		System.out.println("3. Nombre de joueurs");
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-6, 2, 0.01);//par défaut 8, 7
		
		StdDraw.setPenColor(new Color(20, 148, 20));
		StdDraw.square(Jeu.tailleGrille-7, Jeu.tailleGrille-7, 0.1);//par défaut 6, 6
		StdDraw.square(Jeu.tailleGrille-5, Jeu.tailleGrille-7, 0.1);//par défaut 8, 6
		StdDraw.square(Jeu.tailleGrille-3, Jeu.tailleGrille-7, 0.1);//par défaut 10, 6
			
		System.out.println("4. Taille de la grille");
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-8, 2, 0.01);//par défaut 8, 5
			
		StdDraw.setPenColor(StdDraw.CYAN);//indigo foncé
		StdDraw.square(Jeu.tailleGrille-7, Jeu.tailleGrille-9, 0.1);//par défaut 6, 4
		StdDraw.square(Jeu.tailleGrille-5, Jeu.tailleGrille-9, 0.1);//par défaut 8, 4
		StdDraw.square(Jeu.tailleGrille-3, Jeu.tailleGrille-9, 0.1);//par défaut 10, 4
		
		System.out.println("5. Choisir les pseudos");
		StdDraw.setPenColor(StdDraw.MAGENTA);
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-10, 2, 0.01);//par défaut 8, 3
		
		StdDraw.setPenColor(new Color(46, 0, 108));
		StdDraw.square(Jeu.tailleGrille-6, Jeu.tailleGrille-11, 0.1);//par défaut 7, 2
		StdDraw.square(Jeu.tailleGrille-4, Jeu.tailleGrille-11, 0.1);//par défaut 9, 2
		
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille+2, "Le jeu des Six couleurs");//par défaut 8, 15
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-3, "Retour");//par défaut 8, 10
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-4, "Options");;		//par défaut 8, 9	
		
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-6, "Nombre de joueurs");//par défaut 8, 7
		StdDraw.text(Jeu.tailleGrille-7, Jeu.tailleGrille-7, "2");//par défaut 6, 6
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-7, "3");//par défaut 8, 6
		StdDraw.text(Jeu.tailleGrille-3, Jeu.tailleGrille-7, "4");//par défaut 10, 6
		
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-8, "Taille de la grille");//par défaut 8, 5
		StdDraw.text(Jeu.tailleGrille-7, Jeu.tailleGrille-9, "13");//par défaut 6, 4
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-9, "15");//par défaut 8, 4
		StdDraw.text(Jeu.tailleGrille-3, Jeu.tailleGrille-9, "20");//par défaut 10, 4
		
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-10, "Choisir les pseudos");//par défaut 8, 5
		StdDraw.text(Jeu.tailleGrille-6, Jeu.tailleGrille-11, "Oui");//par défaut 8, 4
		StdDraw.text(Jeu.tailleGrille-4, Jeu.tailleGrille-11, "Non");//par défaut 10, 4
		
			
		//mode graphique
		double x = 0;
		double y = 0;
		int xPos = 0;
		int yPos = 0;
		while(true){
			while(!StdDraw.mousePressed()) {
				x = StdDraw.mouseX();
				y = StdDraw.mouseY();
			}
			xPos = (int) Math.round(x);
			yPos = (int) Math.round(y);
			//Retour
			if (xPos > 5 && xPos <11 && yPos == Jeu.tailleGrille-3){
				break;
			}
			
			//Sélection du nombre de joueurs
			else if (yPos == Jeu.tailleGrille-7){//par défaut 6
				if (xPos == Jeu.tailleGrille-7){//par défaut 6
					Jeu.NBJOUEUR = 2;
					break;
				}
				else if (xPos == Jeu.tailleGrille-5){//par défaut 8
					Jeu.NBJOUEUR = 3;
					break;
				}
				else if (xPos == Jeu.tailleGrille-3){//par défaut 10
					Jeu.NBJOUEUR = 4;
					break;
				}

			}
			
			//Sélection de la taille de la grille
			else if(yPos == Jeu.tailleGrille-9){//par défaut 4
				if (xPos == Jeu.tailleGrille-7){//par défaut 6
					Jeu.tailleGrille = 13;
					Plateau.initialisationInterfaceGraphique();
					break;
				}
				else if (xPos == Jeu.tailleGrille-5){//par défaut 8
					Jeu.tailleGrille = 15;
					Plateau.initialisationInterfaceGraphique();
					break;
				}
				else if (xPos == Jeu.tailleGrille-3){//par défaut 10
					Jeu.tailleGrille = 20;
					Plateau.initialisationInterfaceGraphique();
					break;
				}
			}
			
			else if(yPos == Jeu.tailleGrille-11){//par défaut 2
				if (xPos == Jeu.tailleGrille-6){
					choixPseudo = true;
					break;					
				}
				else if(xPos == Jeu.tailleGrille-4){
					choixPseudo = false;
					break;
				}
			}
		}
		StdDraw.clear();
		menu();
			
	}
	
	//Menu pseudo
	public static void menuPseudo(){
		StdDraw.clear();
		System.out.println("Le jeu des Six couleurs");
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille+2, 5, 0.01);//par défaut 8 ,15
		
		StdDraw.setPenColor(new Color(255, 127, 0));
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-2, 2, 0.01);//par défaut 8, 11
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille+2, "Le jeu des Six couleurs");//par défaut 8, 15
		
		if (Jeu.MULTIJOUEUR == false){
			System.out.println("1. Un joueur");
			StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-2, "Un joueur");//par défaut 8, 11
		}
		
		else{
			System.out.println("2. Multijoueur");
			StdDraw.text(Jeu.tailleGrille-5,Jeu.tailleGrille-2, "Multijoueur");//par défaut 8, 11
		}
		
		
	}
	
	//Menu sauvegarde
	public static void menuSauvegarde(){
		StdDraw.clear();
		
		System.out.println("Le jeu des Six couleurs");
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille+2, 5, 0.01);//par défaut 8, 15
				
		System.out.println("1. Retour");
		StdDraw.setPenColor(new Color(255, 127, 0));//orange
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-3, 2, 0.01);//par défaut 8, 10
				
		System.out.println("2. Parties sauvegardées");
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-4, 2, 0.01);//par défaut 8, 9
		
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille+2, "Le jeu des Six couleurs");//par défaut 8, 15
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-3, "Retour");//par défaut 8, 10
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-4, "Parties sauvegardées");//par défaut 8, 9	
		File Sauvegardes = new File("Sauvegardes");
		Sauvegarde.listerRepertoire(Sauvegardes);
				
		StdDraw.clear();
		menu();
				
	}	
	
}
