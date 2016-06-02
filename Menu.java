import java.awt.Color;
//import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Menu {
		
	//Menu principal
	public static void menu(int NBJOUEUR, int tailleGrille){
		
		System.out.println("Le jeu des Six couleurs");
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.rectangle(tailleGrille-5, tailleGrille+2, 5, 0.01);//par défaut 8, 15
		
		System.out.println("1. Un joueur");//non fonctionnel (pas d'IA)
		StdDraw.setPenColor(new Color(255, 127, 0));
		StdDraw.rectangle(tailleGrille-5, tailleGrille-2, 2, 0.01);//par défaut 8, 11
		
		System.out.println("2. Multijoueur");
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.rectangle(tailleGrille-5, tailleGrille-4, 2, 0.01);//par défaut 8, 9
		
		System.out.println("3. Charger une partie");//non fonctionnel
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.rectangle(tailleGrille-5, tailleGrille-6, 2, 0.01);//par défaut 8, 7
		
		System.out.println("4. Options");
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.rectangle(tailleGrille-5, tailleGrille-8, 2, 0.01);//par défaut 8, 5
		
		System.out.println("5. Quitter");
		StdDraw.setPenColor(StdDraw.MAGENTA);
		StdDraw.rectangle(tailleGrille-5, tailleGrille-10, 2, 0.01);//par défaut 8, 3
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(tailleGrille-5, tailleGrille+2, "Le jeu des Six couleurs");//par défaut 8, 15
		StdDraw.text(tailleGrille-5, tailleGrille-2, "Un joueur");//par défaut 8, 11
		StdDraw.text(tailleGrille-5, tailleGrille-4, "Multijoueur");//par défaut 8, 9
		StdDraw.text(tailleGrille-5, tailleGrille-6, "Charger une partie");//par défaut 8, 7
		StdDraw.text(tailleGrille-5, tailleGrille-8, "Options");//par défaut 8, 5
		StdDraw.text(tailleGrille-5, tailleGrille-10, "Quitter");//par défaut 8, 3
		
		int menu = 0;

		//mode graphique
		double x = 0;
		double y = 0;
		int xPos = 0;
		int yPos = 0;
		
		while (StdDraw.mousePressed()){//si problème d'inversement de la souris
			//System.out.println("Souris : " + StdDraw.mousePressed());
		}
		
		while (menu == 0 ){
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
			
			if(yPos == tailleGrille-2){//par défaut 11
				menu = 1;
			}
			else if(yPos == tailleGrille-4){//par défaut 9
				menu = 2;
			}
			else if(yPos == tailleGrille-6){//par défaut 7
				menu = 3;
			}
			else if(yPos == tailleGrille-8){//par défaut 5
				menu = 4;
			}
			else if(yPos == tailleGrille-10){// par défaut 3
				menu = 5;
			}
			else{
				System.out.println("Erreur");
				menu(NBJOUEUR, tailleGrille);
			}
		}
	
		//mode console
		//Scanner scan = new Scanner(System.in);
		//menu = scan.nextInt();
		
		StdDraw.clear();
		switch (menu){
		
		  case 1:
		    System.out.println("Un joueur");
		    Jeu.lancementJeu(NBJOUEUR,tailleGrille,false);
		    break;
		  case 2:
		    System.out.println("Multijoueur");
		    Jeu.lancementJeu(NBJOUEUR,tailleGrille,true);
		    break;
		  case 3:
		    System.out.println("Charger une partie");
		    menuSauvegarde(NBJOUEUR,tailleGrille);
		    break;
		  case 4:
			System.out.println("Options");
			menuOptions(NBJOUEUR,tailleGrille);
			break;
		  case 5:
			System.out.println("Quitter");
			break;
		  default:
		    System.out.println("Erreur");
		}
	}
	
	//Menu des options
	public static void menuOptions(int NBJOUEUR, int tailleGrille){
		StdDraw.clear();
		System.out.println("Le jeu des Six couleurs");
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.rectangle(tailleGrille-5, tailleGrille+2, 5, 0.01);//par défaut 8, 15
			
		System.out.println("1. Retour");
		StdDraw.setPenColor(new Color(255, 127, 0));//orange
		StdDraw.rectangle(tailleGrille-5, tailleGrille-3, 2, 0.01);//par défaut 8, 10
			
		System.out.println("2. Options");
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.rectangle(tailleGrille-5, tailleGrille-4, 2, 0.01);//par défaut 8, 9
			
		System.out.println("3. Nombre de joueurs");
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.rectangle(tailleGrille-5, tailleGrille-6, 2, 0.01);//par défaut 8, 7
			
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.square(tailleGrille-7, tailleGrille-7, 0.1);//par défaut 6, 6
		StdDraw.square(tailleGrille-5, tailleGrille-7, 0.1);//par défaut 8, 6
		StdDraw.square(tailleGrille-3, tailleGrille-7, 0.1);//par défaut 10, 6
			
		System.out.println("4. Taille de la grille");
		StdDraw.setPenColor(StdDraw.MAGENTA);
		StdDraw.rectangle(tailleGrille-5, tailleGrille-8, 2, 0.01);//par défaut 8, 5
			
		StdDraw.setPenColor(new Color(46, 0, 108));//indigo foncé
		StdDraw.square(tailleGrille-7, tailleGrille-9, 0.1);//par défaut 6, 4
		StdDraw.square(tailleGrille-5, tailleGrille-9, 0.1);//par défaut 8, 4
		StdDraw.square(tailleGrille-3, tailleGrille-9, 0.1);//par défaut 10, 4
			
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(tailleGrille-5, tailleGrille+2, "Le jeu des Six couleurs");//par défaut 8, 15
		StdDraw.text(tailleGrille-5, tailleGrille-3, "Retour");//par défaut 8, 10
		StdDraw.text(tailleGrille-5, tailleGrille-4, "Options");;		//par défaut 8, 9	
		StdDraw.text(tailleGrille-5, tailleGrille-6, "Nombre de joueurs");//par défaut 8, 7
		StdDraw.text(tailleGrille-5, tailleGrille-8, "Taille de la grille");//par défaut 8, 5
		StdDraw.text(tailleGrille-7, tailleGrille-7, "2");//par défaut 6, 6
		StdDraw.text(tailleGrille-5, tailleGrille-7, "3");//par défaut 8, 6
		StdDraw.text(tailleGrille-3, tailleGrille-7, "4");//par défaut 10, 6
		StdDraw.text(tailleGrille-7, tailleGrille-9, "10");//par défaut 6, 4
		StdDraw.text(tailleGrille-5, tailleGrille-9, "13");//par défaut 8, 4
		StdDraw.text(tailleGrille-3, tailleGrille-9, "20");//par défaut 10, 4
			
		//mode graphique
		double x = 0;
		double y = 0;
		int xPos = 0;
		int yPos = 0;
		while(true){
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
			
			if (yPos == tailleGrille-3){
				break;
			}
				
			else if (yPos == tailleGrille-7){//par défaut 6
				if (xPos == tailleGrille-7){//par défaut 6
					NBJOUEUR = 2;
					break;
				}
				else if (xPos == tailleGrille-5){//par défaut 8
					NBJOUEUR = 3;
					break;
				}
				else if (xPos == tailleGrille-3){//par défaut 10
					NBJOUEUR = 4;
					break;
				}

			}
				
			else if(yPos == tailleGrille-9){//par défaut 4
				if (xPos == tailleGrille-7){//par défaut 6
					tailleGrille = 10;
					//Plateau.initialisationInterfaceGraphique(tailleGrille);
					break;
				}
				else if (xPos == tailleGrille-5){//par défaut 8
					tailleGrille = 13;
					Plateau.initialisationInterfaceGraphique(tailleGrille);
					break;
				}
				else if (xPos == tailleGrille-3){//par défaut 10
					tailleGrille = 20;
					Plateau.initialisationInterfaceGraphique(tailleGrille);
					break;
				}
			}
		}
		StdDraw.clear();
		menu(NBJOUEUR, tailleGrille);
			
	}
	
	//Menu pseudo
	public static void menuPseudo(int tailleGrille, boolean MULTIJOUEUR){
		StdDraw.clear();
		System.out.println("Le jeu des Six couleurs");
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.rectangle(tailleGrille-5, tailleGrille+2, 5, 0.01);//par défaut 8 ,15
		
		StdDraw.setPenColor(new Color(255, 127, 0));
		StdDraw.rectangle(tailleGrille-5, tailleGrille-2, 2, 0.01);//par défaut 8, 11
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(tailleGrille-5, tailleGrille+2, "Le jeu des Six couleurs");//par défaut 8, 15
		
		if (MULTIJOUEUR == false){
			System.out.println("1. Un joueur");
			StdDraw.text(tailleGrille-5, tailleGrille-2, "Un joueur");//par défaut 8, 11
		}
		
		else{
			System.out.println("2. Multijoueur");
			StdDraw.text(tailleGrille-5, tailleGrille-2, "Multijoueur");//par défaut 8, 11
		}
		
		
	}
	
	//Menu sauvegarde
	public static void menuSauvegarde(int NBJOUEUR, int tailleGrille){
		StdDraw.clear();
		
		System.out.println("Le jeu des Six couleurs");
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.rectangle(tailleGrille-5, tailleGrille+2, 5, 0.01);//par défaut 8, 15
				
		System.out.println("1. Retour");
		StdDraw.setPenColor(new Color(255, 127, 0));//orange
		StdDraw.rectangle(tailleGrille-5, tailleGrille-3, 2, 0.01);//par défaut 8, 10
				
		System.out.println("2. Parties sauvegardées");
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.rectangle(tailleGrille-5, tailleGrille-4, 2, 0.01);//par défaut 8, 9
		
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(tailleGrille-5, tailleGrille+2, "Le jeu des Six couleurs");//par défaut 8, 15
		StdDraw.text(tailleGrille-5, tailleGrille-3, "Retour");//par défaut 8, 10
		StdDraw.text(tailleGrille-5, tailleGrille-4, "Parties sauvegardées");//par défaut 8, 9	
		File Sauvegardes = new File("Sauvegardes");
		Sauvegarde.listerRepertoire(Sauvegardes, tailleGrille);
				
		StdDraw.clear();
		menu(NBJOUEUR, tailleGrille);
				
	}	
	
}
