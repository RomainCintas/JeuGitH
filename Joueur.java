import java.util.ArrayList;
import java.util.Scanner;

public class Joueur{
	
	String nom;
	String couleur;
	int colonne;
	int ligne;
	boolean tour;
	int tourInitialisation;
	ArrayList <Case> caseControl;
	static int NBJOUEUR = 2;
	static Scanner scan = new Scanner(System.in);
	static Scanner scan1 = new Scanner(System.in);
	static Scanner scan2 = new Scanner(System.in);
	static Scanner scan3 = new Scanner(System.in);
	static Scanner scan4 = new Scanner(System.in);
	static String nom1 = null;
	static String nom2 = null;
	static String nom3 = null;
	static String nom4 = null;

	public Joueur (String nom, String couleur, int colonne, int ligne, int tourInitialisation, ArrayList <Case> caseControl){//Nom, couleur et tour
		this.nom = nom;
		this.couleur = couleur;
		this.colonne = colonne;
		this.ligne = ligne;
		this.tourInitialisation = tourInitialisation;
		this.caseControl = caseControl;
	}
	
	public static int choixNbJoueur(){
		do{
			System.out.println("Combien de joueurs voulez-vous ?");
			StdDraw.text(7, 14, "Combien de joueurs voulez-vous ?");
			NBJOUEUR = scan.nextInt();
			if (NBJOUEUR != 2 && NBJOUEUR != 3 && NBJOUEUR != 4){
				System.out.println("VEUILLEZ CHOISIR DEUX, TROIS OU QUATRE JOUEURS");
				StdDraw.text(7, 13, "VEUILLEZ CHOISIR DEUX, TROIS OU QUATRE JOUEURS");
			}
		}while (NBJOUEUR != 2 && NBJOUEUR != 3 && NBJOUEUR != 4);
		return NBJOUEUR;
	}
	
	
	public static void unJoueur(int NBJOUEUR){
		
	}
	
	public static void multijoueur(int NBJOUEUR){
		System.out.println("Entrer le pseudo du Joueur 1");
		StdDraw.text(7, 12, "Entrer le pseudo du Joueur 1");
		nom1 = scan1.nextLine();
		System.out.println("Entrer le pseudo du Joueur 2");
		StdDraw.text(7, 11, "Entrer le pseudo du Joueur 2");
		nom2 = scan2.nextLine();
		
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
	}
		
	public static void positionJoueur(String nom1, String nom2, String nom3, String nom4){
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
	}
	
	public static Joueur tourJoueur(Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4, int compteurTour){
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
		if (compteurTour == joueur.tourInitialisation){
				joueur.caseControl= new ArrayList<Case>();//liste qui stocke les cases adjacentes
				joueur.caseControl.add(new Case(joueur.colonne,joueur.ligne,joueur.couleur));
		}
		return joueur;
	}
}
