import java.awt.Color;
//import java.util.Scanner;

public class Menu {
	
	public static void menuMultijoueur(){
		StdDraw.clear();
		System.out.println("Le jeu des Six couleurs");
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.rectangle(8.5, 15, 5, 0.01);
		
		System.out.println("1. Retour");
		StdDraw.setPenColor(new Color(255, 127, 0));
		StdDraw.rectangle(8.5, 11, 2, 0.01);
		
		System.out.println("2. Multijoueur");
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.rectangle(8.5, 9, 2, 0.01);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(8.5, 15, "Le jeu des Six couleurs");
		StdDraw.text(8.5, 11, "Retour");
		StdDraw.text(8.5, 9, "Multijoueur");
		
		//Retour par mode graphique
//		double x = 0;
//		double y = 0;
//		int xPos = 0;
//		int yPos = 0;
//		while(!((xPos == 6 || xPos == 7 || xPos == 8 || xPos == 9 || xPos == 10 || xPos == 11) && yPos == 11)){
//			while(!StdDraw.mousePressed()) {
//				x = StdDraw.mouseX();
//				y = StdDraw.mouseY();
//				xPos = (int) Math.round(x);
//				yPos = (int) Math.round(y);
//			}
//			x = StdDraw.mouseX();
//			y = StdDraw.mouseY();
//			xPos = (int) Math.round(x);
//			yPos = (int) Math.round(y);
//		}
//		if (yPos == 11){
//			menu(Joueur.NBJOUEUR);
//		}
	}
	
	public static void menu(int NBJOUEUR){
		
		System.out.println("Le jeu des Six couleurs");
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.rectangle(8.5, 15, 5, 0.01);
		
		System.out.println("1. Un joueur");//non fonctionnel (pas d'IA)
		StdDraw.setPenColor(new Color(255, 127, 0));
		StdDraw.rectangle(8.5, 11, 2, 0.01);
		
		System.out.println("2. Multijoueur");
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.rectangle(8.5, 9, 2, 0.01);
		
		System.out.println("3. Parties enregistrées");//non fonctionnel
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.rectangle(8.5, 7, 2, 0.01);
		
		System.out.println("4. Options");
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.rectangle(8.5, 5, 2, 0.01);
		
		System.out.println("5. Quitter");
		StdDraw.setPenColor(StdDraw.MAGENTA);
		StdDraw.rectangle(8.5, 3, 2, 0.01);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(8.5, 15, "Le jeu des Six couleurs");
		StdDraw.text(8.5, 11, "Un joueur");
		StdDraw.text(8.5, 9, "Multijoueur");
		StdDraw.text(8.5, 7, "Parties enregistrées");
		StdDraw.text(8.5, 5, "Options");
		StdDraw.text(8.5, 3, "Quitter");
		
		int menu = 0;
		
		//mode graphique
		double x = 0;
		double y = 0;
		int xPos = 0;
		int yPos = 0;
		while(!((xPos == 6 || xPos == 7 || xPos == 8 || xPos == 9 || xPos == 10 || xPos == 11) && (yPos == 11 || yPos == 9 || yPos == 7 || yPos == 5 || yPos == 3))){
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
		
		switch (yPos){
			case 11:
				menu = 1;
				break;
			case 9:
				menu = 2;
				break;
			case 7:
				menu = 3;
				break;
			case 5:
				menu = 4;
				break;
			case 3:
				menu = 5;
				break;
			default:
				System.out.println("Erreur");
				break;
		}
	
		//mode console
		//Scanner scan = new Scanner(System.in);
		//menu = scan.nextInt();
		
		switch (menu){
		
		  case 1:
		    System.out.println("Un joueur");
		    Jeu.unJoueur(NBJOUEUR);
		    break;
		  case 2:
		    System.out.println("Multijoueur");
			Jeu.multijoueur(NBJOUEUR);
		    break;
		  case 3:
		    System.out.println("Parties enregistrées");
		    break;
		  case 4:
			System.out.println("Options");
			NBJOUEUR = Joueur.choixNbJoueur();
			break;
		  case 5:
			System.out.println("Quitter");
			break;
		  default:
		    System.out.println("Erreur");
		}
	}
}
