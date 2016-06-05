import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class Joueur{
	
	String nom;
	char couleur;
	int colonne, ligne;
	boolean tour;
	int tourInitialisation;
	ArrayList <Case> caseControl;
	boolean humain;
	
	static Scanner scan = new Scanner(System.in);
	static Scanner scan1 = new Scanner(System.in);
	static Scanner scan2 = new Scanner(System.in);
	static Scanner scan3 = new Scanner(System.in);
	static Scanner scan4 = new Scanner(System.in);
	public static String nom1 = "Joueur 1";
	public static String nom2 = "Joueur 2";
	public static String nom3 = "Joueur 3";
	public static String nom4 = "Joueur 4";

	public Joueur (String nom, char couleur, int colonne, int ligne, boolean tour, int tourInitialisation, ArrayList <Case> caseControl, boolean humain){//Nom, couleur et tour
		this.nom = nom;
		this.couleur = couleur;
		this.colonne = colonne;
		this.ligne = ligne;
		this.tour = tour;
		this.tourInitialisation = tourInitialisation;
		this.caseControl = caseControl;
		this.humain = humain;
	}
	
	//Choix du nombre de joueurs en mode console
	public static int choixNbJoueur(){
		do{
			System.out.println("Combien de joueurs voulez-vous ?");
			StdDraw.text(8, 7, "Nombre de joueurs");
			Jeu.NBJOUEUR = scan.nextInt();
			if (Jeu.NBJOUEUR != 2 && Jeu.NBJOUEUR != 3 && Jeu.NBJOUEUR != 4){
				System.out.println("VEUILLEZ CHOISIR DEUX, TROIS OU QUATRE JOUEURS");
				StdDraw.text(8, 13, "VEUILLEZ CHOISIR DEUX, TROIS OU QUATRE JOUEURS");
			}
		}while (Jeu.NBJOUEUR != 2 && Jeu.NBJOUEUR != 3 && Jeu.NBJOUEUR != 4);
		return Jeu.NBJOUEUR;
	}
	
	//choix des pseudos des joueurs
	public static void choixPseudoJoueur(){
		
		Menu.menuPseudo();	
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-4, 2, 0.01);//8, 9
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-4, 2, 0.01);//8, 9
		StdDraw.setPenColor(StdDraw.BLACK);
		
		System.out.println("Entrer le pseudo du Joueur 1");
		StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-4, "Entrer le pseudo du Joueur 1");
		
		nom1 = scan1.nextLine();
			
		if (Jeu.MULTIJOUEUR == true){
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-4, 2, 0.01);//8, 9
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-4, 2, 0.01);//8, 9
			StdDraw.setPenColor(StdDraw.BLACK);
			
			System.out.println("Entrer le pseudo du Joueur 2");
			StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-4, "Entrer le pseudo du Joueur 2");
				
			nom2 = scan2.nextLine();

			if (Jeu.NBJOUEUR == 3 || Jeu.NBJOUEUR == 4){
				
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-4, 2, 0.01);
				StdDraw.setPenColor(StdDraw.YELLOW);
				StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-4, 2, 0.01);
				StdDraw.setPenColor(StdDraw.BLACK);
					
				System.out.println("Entrer le pseudo du Joueur 3");
				StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-4, "Entrer le pseudo du Joueur 3");
				nom3 = scan3.nextLine();
				if (Jeu.NBJOUEUR == 4){
						
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-4, 2, 0.01);
					StdDraw.setPenColor(StdDraw.YELLOW);
					StdDraw.rectangle(Jeu.tailleGrille-5, Jeu.tailleGrille-4, 2, 0.01);
					StdDraw.setPenColor(StdDraw.BLACK);
						
					System.out.println("Entrer le pseudo du Joueur 4");
					StdDraw.text(Jeu.tailleGrille-5, Jeu.tailleGrille-4, "Entrer le pseudo du Joueur 4");
					nom4 = scan4.nextLine();
				}
			}
		}
		else{
			pseudoIA();
		}
		
		StdDraw.clear();
	}
	
	//Attribution de pseudo par défaut à l'IA
	public static void pseudoIA(){

		nom2 = "IA 1";
		if (Jeu.NBJOUEUR == 3 || Jeu.NBJOUEUR == 4){
			nom3 = "IA 2";
			if (Jeu.NBJOUEUR == 4){
				nom4 = "IA 3";
			}
		}

	}
	
	//Affiche la position des joueurs
	public static void positionJoueur(String nom1, String nom2, String nom3, String nom4){
		System.out.println(nom1 + " est en haut à gauche");
		StdDraw.text(Jeu.tailleGrille-6, Jeu.tailleGrille+3.8, nom1 + " est en haut à gauche");//par défaut 7, 16.8
		System.out.println(nom2 + " est en bas à droite");
		StdDraw.text(Jeu.tailleGrille-6, Jeu.tailleGrille+3.4, nom2 + " est en bas à droite");//par défaut 7, 16.4
		if (Jeu.NBJOUEUR == 3 || Jeu.NBJOUEUR == 4){
			System.out.println(nom3 + " est en haut à droite");
			StdDraw.text(Jeu.tailleGrille-6, Jeu.tailleGrille+3, nom3 + " est en haut à droite");//par défaut 7, 16
			if (Jeu.NBJOUEUR == 4){
				System.out.println(nom4 + " est en bas à gauche");
				StdDraw.text(Jeu.tailleGrille-6, Jeu.tailleGrille+2.6, nom4 + " est en bas à gauche");//par défaut 7, 15.6
				
			}
		}
	}
	
	//Attribution des variables spécifiques au tour au joueur concerné en début de tour
	public static Joueur debutTourJoueur(Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4){
		Joueur joueur = null;
		if (joueur1.tour == true){
			joueur = joueur1;
			}
		if (joueur2.tour == true){
			joueur = joueur2;
			}
		if (joueur3.tour == true){
			joueur = joueur3;
			}
		if (joueur4.tour == true){
			joueur = joueur4;
			}
		if (Jeu.compteurTour == joueur.tourInitialisation){
				joueur.caseControl = new ArrayList<Case>();//liste qui stocke les cases adjacentes
				joueur.caseControl.add(new Case(joueur.colonne,joueur.ligne,joueur.couleur));
		}
		return joueur;
	}
	
	//Récupération des variables spécifiques au tour par le joueur concerné en fin de tour
	public static void finTourJoueur(Joueur joueur, Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4){
		if (joueur1.tour == true){
			joueur1 = joueur;
		}
		if (joueur2.tour == true){
			joueur2 = joueur;
		}
		if (joueur3.tour == true){
			joueur3 = joueur;
		}
		if (joueur4.tour == true){
			joueur4 = joueur;
		}
	}
	
	//Rotation du tour des joueurs
	public static void rotationTourJoueur(Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4){
		boolean tour;
		if (Jeu.NBJOUEUR == 2){
			tour = joueur2.tour;
			joueur2.tour = joueur1.tour;
			joueur1.tour = tour;
		}
		else{
			if (Jeu.NBJOUEUR == 4){
				tour = joueur4.tour;
				joueur4.tour = joueur3.tour;
				joueur3.tour = joueur2.tour;
				joueur2.tour = joueur1.tour;
				joueur1.tour = tour;
			}
			else{
				tour = joueur3.tour;
				joueur3.tour = joueur2.tour;
				joueur2.tour = joueur1.tour;
				joueur1.tour = tour;
			}
		}
		//System.out.println("Joueur 1 : " + joueur1.tour + "Joueur 2 : " + joueur2.tour + "Joueur 3 : " + joueur3.tour + "Joueur 4 : " + joueur4.tour);
	}
	
}
