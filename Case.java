
public class Case {

	int colonne;
	int ligne;
	String couleur;
	
	public Case (int colonne, int ligne, String couleur){//coordonnées et couleur d'une case
		this.colonne = colonne;
		this.ligne = ligne;
		this.couleur = couleur;
	}
	
	public static String selectionCase(String couleurChoisie){
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
		return couleurChoisie;
	}

}
