import java.awt.Color;
//import java.util.Scanner;

public class Menu {
	
	//Menu pseudo
	public static void menuPseudo(boolean HUMAIN){
		StdDraw.clear();
		System.out.println("Le jeu des Six couleurs");
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.rectangle(8, 15, 5, 0.01);
		
		StdDraw.setPenColor(new Color(255, 127, 0));
		StdDraw.rectangle(8, 11, 2, 0.01);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(8, 15, "Le jeu des Six couleurs");
		
		if (HUMAIN == false){
			System.out.println("1. Un joueur");
			StdDraw.text(8, 11, "Un joueur");
		}
		
		else{
			System.out.println("2. Multijoueur");
			StdDraw.text(8, 11, "Multijoueur");
		}
		
		
	}
	
	//Menu des options
	public static void menuOptions(int NBJOUEUR){
		StdDraw.clear();
		System.out.println("Le jeu des Six couleurs");
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.rectangle(8, 15, 5, 0.01);
		
		System.out.println("1. Retour");
		StdDraw.setPenColor(new Color(255, 127, 0));
		StdDraw.rectangle(8, 10, 2, 0.01);
		
		System.out.println("2. Options");
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.rectangle(8, 9, 2, 0.01);
		
		System.out.println("3. Nombre de joueurs");
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.rectangle(8, 7, 2, 0.01);
		
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.square(6, 6, 0.1);
		StdDraw.square(8, 6, 0.1);
		StdDraw.square(10, 6, 0.1);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(8, 15, "Le jeu des Six couleurs");
		StdDraw.text(8, 10, "Retour");
		StdDraw.text(8, 9, "Options");;			
		StdDraw.text(8, 7, "Nombre de joueurs");
		StdDraw.text(6, 6, "2");
		StdDraw.text(8, 6, "3");
		StdDraw.text(10, 6, "4");
		
		//mode graphique
		double x = 0;
		double y = 0;
		int xPos = 0;
		int yPos = 0;
		while(!((xPos >= 6 && xPos <= 11) && (yPos == 10 || yPos == 6))){
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
		
		if (yPos == 10)
		{
			StdDraw.clear();
			menu(NBJOUEUR);
		}
		else{
			switch (xPos){
				case 6:
					NBJOUEUR = 2;
					break;
				case 8:
					NBJOUEUR = 3;
					break;
				case 10:
					NBJOUEUR = 4;
					break;
				default:
					System.out.println("Erreur");
					break;
			}
		}
		StdDraw.clear();
		menu(NBJOUEUR);
	}
	
	//Menu principal
	public static void menu(int NBJOUEUR){
		
		System.out.println("Le jeu des Six couleurs");
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.rectangle(8, 15, 5, 0.01);
		
		System.out.println("1. Un joueur");//non fonctionnel (pas d'IA)
		StdDraw.setPenColor(new Color(255, 127, 0));
		StdDraw.rectangle(8, 11, 2, 0.01);
		
		System.out.println("2. Multijoueur");
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.rectangle(8, 9, 2, 0.01);
		
		System.out.println("3. Charger une partie");//non fonctionnel
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.rectangle(8, 7, 2, 0.01);
		
		System.out.println("4. Options");
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.rectangle(8, 5, 2, 0.01);
		
		System.out.println("5. Quitter");
		StdDraw.setPenColor(StdDraw.MAGENTA);
		StdDraw.rectangle(8, 3, 2, 0.01);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(8, 15, "Le jeu des Six couleurs");
		StdDraw.text(8, 11, "Un joueur");
		StdDraw.text(8, 9, "Multijoueur");
		StdDraw.text(8, 7, "Charger une partie");
		StdDraw.text(8, 5, "Options");
		StdDraw.text(8, 3, "Quitter");
		
		int i=0;
		
		int menu = 0;

		//mode graphique
		double x = 0;
		double y = 0;
		int xPos = 0;
		int yPos = 0;

		while(!((xPos >= 6 && xPos <= 11) && (yPos == 11 || yPos == 9 || yPos == 7 || yPos == 5 || yPos == 3))){
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
		
		StdDraw.clear();
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
		    System.out.println("Charger une partie");
		    break;
		  case 4:
			System.out.println("Options");
			menuOptions(NBJOUEUR);
			break;
		  case 5:
			System.out.println("Quitter");
			break;
		  default:
		    System.out.println("Erreur");
		}
	}
	
}
