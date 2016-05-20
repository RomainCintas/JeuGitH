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
			if (couleurChoisie.equals(couleur)){
				System.out.println("VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE LA VÔTRE");
				StdDraw.text(7, 14, "VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE LA VÔTRE");
			}
			else{
				if (NBJOUEUR == 2){
					System.out.println("VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE CELLE DE VOTRE ADVERSAIRE");
					StdDraw.text(7, 13.7, "VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE CELLE DE VOTRE ADVERSAIRE");
				}
				else{
					System.out.println("VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE CELLES DE VOS ADVERSAIRES");
					StdDraw.text(7, 13.7, "VEUILLEZ CHOISIR UNE COULEUR DIFFÉRENTE DE CELLES DE VOS ADVERSAIRES");
				}
			}
		}
		return couleurChoisie;
	}
}
