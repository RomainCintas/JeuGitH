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
	boolean humain;
	
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

	public Joueur (String nom, String couleur, int colonne, int ligne, int tourInitialisation, ArrayList <Case> caseControl, boolean humain){//Nom, couleur et tour
		this.nom = nom;
		this.couleur = couleur;
		this.colonne = colonne;
		this.ligne = ligne;
		this.tourInitialisation = tourInitialisation;
		this.caseControl = caseControl;
		this.humain = humain;
	}
	
	//Choix du nombre de joueurs
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
	
	//choix des pseudos des joueurs
	public static void choixPseudoJoueur(int NBJOUEUR, boolean HUMAIN){
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.rectangle(8.5, 7, 2, 0.01);
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.rectangle(8.5, 7, 2, 0.01);
		StdDraw.setPenColor(StdDraw.BLACK);
		
		System.out.println("Entrer le pseudo du Joueur 1");
		StdDraw.text(8.5, 7, "Entrer le pseudo du Joueur 1");
		
		nom1 = scan1.nextLine();
		
		if (HUMAIN == true){
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.rectangle(8.5, 7, 2, 0.01);
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.rectangle(8.5, 7, 2, 0.01);
			StdDraw.setPenColor(StdDraw.BLACK);
			
			System.out.println("Entrer le pseudo du Joueur 2");
			StdDraw.text(8.5, 7, "Entrer le pseudo du Joueur 2");
			
			nom2 = scan2.nextLine();

			if (NBJOUEUR == 3 || NBJOUEUR == 4){
				
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.rectangle(8.5, 7, 2, 0.01);
				StdDraw.setPenColor(StdDraw.GREEN);
				StdDraw.rectangle(8.5, 7, 2, 0.01);
				StdDraw.setPenColor(StdDraw.BLACK);
				
				System.out.println("Entrer le pseudo du Joueur 3");
				StdDraw.text(8.5, 7, "Entrer le pseudo du Joueur 3");
				nom3 = scan3.nextLine();
				if (NBJOUEUR == 4){
					
					StdDraw.setPenColor(StdDraw.WHITE);
					StdDraw.rectangle(8.5, 7, 2, 0.01);
					StdDraw.setPenColor(StdDraw.GREEN);
					StdDraw.rectangle(8.5, 7, 2, 0.01);
					StdDraw.setPenColor(StdDraw.BLACK);
					
					System.out.println("Entrer le pseudo du Joueur 4");
					StdDraw.text(8.5, 7, "Entrer le pseudo du Joueur 4");
					nom4 = scan4.nextLine();
				}
			}
		}
		else{
			nom2 = "IA 1";
			if (NBJOUEUR == 3 || NBJOUEUR == 4){
				nom3 = "IA 2";
				if (NBJOUEUR == 4){
					nom4 = "IA 3";
				}
			}
		}
		
		
		StdDraw.clear();
	}
	
	//Affiche la position des joueurs
	public static void positionJoueur(String nom1, String nom2, String nom3, String nom4){
		System.out.println(nom1 + " est en haut à gauche");
		StdDraw.text(7, 16.8, nom1 + " est en haut à gauche");
		System.out.println(nom2 + " est en bas à droite");
		StdDraw.text(7, 16.4, nom2 + " est en bas à droite");
		if (NBJOUEUR == 3 || NBJOUEUR == 4){
			System.out.println(nom3 + " est en haut à droite");
			StdDraw.text(7, 16, nom3 + " est en haut à droite");
			if (NBJOUEUR == 4){
				System.out.println(nom4 + " est en bas à gauche");
				StdDraw.text(7, 15.6, nom4 + " est en bas à gauche");
			}
		}
	}
	
	//Attribution des variables spécifiques au tour au joueur concerné
	public static Joueur debutTourJoueur(Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4, int compteurTour){
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
				joueur.caseControl = new ArrayList<Case>();//liste qui stocke les cases adjacentes
				joueur.caseControl.add(new Case(joueur.colonne,joueur.ligne,joueur.couleur));
		}
		return joueur;
	}
	
	//Récupération des variables spécifiques au tour par le joueur concerné
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
	public static void rotationTourJoueur(Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4, int NBJOUEUR){
		boolean tour;
		if (NBJOUEUR == 2){
			tour = joueur2.tour;
			joueur2.tour = joueur1.tour;
			joueur1.tour = tour;
		}
		else{
			if (NBJOUEUR == 4){
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
