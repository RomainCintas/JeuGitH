//Packages à importer afin d'utiliser l'objet File
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sauvegarde {
  
	Date date = new Date();
	static Calendar cal = new GregorianCalendar();
	static int seconde = cal.get(Calendar.SECOND);
	static int minute = cal.get(Calendar.MINUTE);
	static int heure = cal.get(Calendar.HOUR);
	static int jour = cal.get(Calendar.DATE);
	static int mois = cal.get(Calendar.MONTH);
	static int annee = cal.get(Calendar.YEAR);
	
	public static void sauvegardePartie(Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4, char[][] grillage, int NBJOUEUR, int tailleGrille, int compteurTour){
    
	  String nomdufichier = "partie-" + jour + "." + mois + "." + annee + "-" + heure + "." + minute + "." + seconde + ".txt";
	  //Nous déclarons nos objets en dehors du bloc try/catch
	  ObjectOutputStream oos;
	  DataOutputStream dos;
    
	  //Données objet
	  try {
		  oos = new ObjectOutputStream(
              new BufferedOutputStream(
                new FileOutputStream(
                  new File(nomdufichier))));
            
		  //Nous allons écrire chaque objet Game dans le fichier
		  oos.writeObject(new String(joueur1.nom));
		  oos.writeObject(new String(joueur2.nom));
		  oos.writeObject(new String(joueur3.nom));
		  oos.writeObject(new String(joueur4.nom));
      
		  //Ne pas oublier de fermer le flux !
		  oos.close();

	  } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }  
    
	  //Données de type primitif
    
    
	  try {
		  dos = new DataOutputStream(
				  new BufferedOutputStream(
						  new FileOutputStream(
								  new File(nomdufichier))));

        	//Nous allons écrire chaque type primitif
        	dos.writeInt(NBJOUEUR);
        	dos.writeInt(tailleGrille);
        	dos.writeInt(compteurTour);
        	dos.writeChar(joueur1.couleur);
        	dos.writeChar(joueur2.couleur);
        	dos.writeChar(joueur3.couleur);
        	dos.writeChar(joueur4.couleur);
        	dos.writeBoolean(joueur1.tour);
        	dos.writeBoolean(joueur2.tour);
        	dos.writeBoolean(joueur3.tour);
        	dos.writeBoolean(joueur4.tour);
        	dos.writeInt(joueur1.caseControl.size());
        	dos.writeInt(joueur2.caseControl.size());
    		for (int i=0;i<joueur1.caseControl.size();++i){
    			dos.writeInt(joueur1.caseControl.get(i).colonne);
    			dos.writeInt(joueur1.caseControl.get(i).ligne);
    		}
    		for (int i=0;i<joueur2.caseControl.size();++i){
    			dos.writeInt(joueur2.caseControl.get(i).colonne);
    			dos.writeInt(joueur2.caseControl.get(i).ligne);
    		}

        	if (NBJOUEUR>2){
        		dos.writeInt(joueur3.caseControl.size());
        		for (int i=0;i<joueur3.caseControl.size();++i){
        			dos.writeInt(joueur3.caseControl.get(i).colonne);
        			dos.writeInt(joueur3.caseControl.get(i).ligne);
        		}
        		if (NBJOUEUR>3){
        			dos.writeInt(joueur4.caseControl.size());
            		for (int i=0;i<joueur4.caseControl.size();++i){
            			dos.writeInt(joueur4.caseControl.get(i).colonne);
            			dos.writeInt(joueur4.caseControl.get(i).ligne);
            		}
        		}
        	}
        	
    		dos.writeBoolean(joueur1.humain);
    		dos.writeBoolean(joueur2.humain);
        	dos.writeBoolean(joueur3.humain);
        	dos.writeBoolean(joueur4.humain);
    	
    		System.out.print("\n");
    		for (int ligneBoucle=0;ligneBoucle<tailleGrille+2;ligneBoucle++){//par défaut 14
				for (int colonneBoucle=0;colonneBoucle<tailleGrille+3;colonneBoucle++){//par défaut 14
					System.out.print("	|	" + grillage[ligneBoucle][colonneBoucle]);
				}
			System.out.print("\n");
			}
    	
    		for (int ligneBoucle=0;ligneBoucle<tailleGrille+2;ligneBoucle++){//par défaut 14
    			for (int colonneBoucle=0;colonneBoucle<tailleGrille+3;colonneBoucle++){//par défaut 14
    				dos.writeChar(grillage[ligneBoucle][colonneBoucle]);
    			}
          	}
        	dos.close();
          	
      	}
    
    	catch (FileNotFoundException e) {
    	e.printStackTrace();
    	} catch (IOException e) {
    	e.printStackTrace();
    	}
	}
	
	
	
	
	
	
	
	
	
	public static void listerRepertoire(File repertoire, int tailleGrille){ 

		String [] listefichiers; 
		listefichiers=repertoire.list();
		//affichage
		for(int i=0;i<listefichiers.length;i++){ 
			if(listefichiers[i].endsWith(".txt")){ 
				System.out.println(listefichiers[i].substring(0,listefichiers[i].length()));// on choisit la sous chaine ".txt" 
				StdDraw.text(tailleGrille-5-i, tailleGrille-6-i, "Nombre de joueurs");//par défaut 8-i, 7-i
			} 
		} 
	
		//sélection en mode graphique
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
			
			for(int i=0;i<listefichiers.length;i++){
				if (yPos == tailleGrille-6-i){
					if(listefichiers[i].endsWith(".txt")){
						chargerPartie(listefichiers[i].substring(0,listefichiers[i].length()));
						//jeu()
					}
				}
			}
		}
	}
  
  
  
  
  
  //------------------------------------------------------------------------------------------------------------
  
  
  
  
  // Chargement
  public static void chargerPartie(String nomdufichier){
	  //Nous déclarons nos objets en dehors du bloc try/catch
	    ObjectInputStream ois;
	    DataInputStream dis;
	    //Données de type primitif
        int NBJOUEUR;
        int tailleGrille = 0;
        int compteurTour;
    	char couleur1 = '1';
    	char couleur2 = '2';
    	char couleur3 = '3';
    	char couleur4 = '4';
    	boolean tour1 = true;
    	boolean tour2 = false;
    	boolean tour3 = false;
    	boolean tour4 = false;
	    int caseControl1Size = 0;
        int caseControl2Size = 0;
        int caseControl3Size = 0;
        int caseControl4Size = 0;
    	ArrayList <Case> caseControl1 = new ArrayList<Case>();
    	ArrayList <Case> caseControl2 = new ArrayList<Case>();
    	ArrayList <Case> caseControl3 = new ArrayList<Case>();
    	ArrayList <Case> caseControl4 = new ArrayList<Case>();
    	boolean humain1 = true;
    	boolean humain2 = true;
    	boolean humain3 = true;
    	boolean humain4 = true;
        
	    try {
	        
	        //On récupère maintenant les données !
	        dis = new DataInputStream(
	                new BufferedInputStream(
	                  new FileInputStream(
	                    new File(nomdufichier))));
	        System.out.println("Affichage des données de type primitif :");
	        System.out.println("*************************\n");     
	        NBJOUEUR = dis.readInt();
	        tailleGrille = dis.readInt();
	        compteurTour = dis.readInt();
	        couleur1 = dis.readChar();
	        couleur2 = dis.readChar();
	        couleur3 = dis.readChar();
	        couleur4 = dis.readChar();
	        tour1 = dis.readBoolean();
	        tour2 = dis.readBoolean();
	        tour3 = dis.readBoolean();
	        tour4 = dis.readBoolean();
	        caseControl1Size = dis.readInt();
	        caseControl2Size = dis.readInt();
	      
	        char[][] grillage = new char[tailleGrille+2][tailleGrille+3];
	        
	    	for (int i=0;i<caseControl1Size;++i){
	    		caseControl1.add(new Case(dis.readInt(),dis.readInt(),couleur1));
	    		caseControl1.add(new Case(dis.readInt(),dis.readInt(),couleur1));
	    	}
	    	for (int i=0;i<caseControl2Size;++i){
	    		caseControl2.add(new Case(dis.readInt(),dis.readInt(),couleur2));
	    		caseControl2.add(new Case(dis.readInt(),dis.readInt(),couleur2));
	    	}
	    	
	    	if (NBJOUEUR > 2){
		        caseControl3Size = dis.readInt();
	    		for (int i=0;i<caseControl3Size;++i){
		    		caseControl3.add(new Case(dis.readInt(),dis.readInt(),couleur3));
		    		caseControl3.add(new Case(dis.readInt(),dis.readInt(),couleur3));
		    	}
	    		if (NBJOUEUR >3){
	    			caseControl4Size = dis.readInt();
	    			for (int i=0;i<caseControl4Size;++i){
	    	    		caseControl4.add(new Case(dis.readInt(),dis.readInt(),couleur4));
	    	    		caseControl4.add(new Case(dis.readInt(),dis.readInt(),couleur4));
	    	    	}
	    		}
	    	}
	    	
	    	humain1 = dis.readBoolean();
	    	humain2 = dis.readBoolean();
	    	humain3 = dis.readBoolean();
	    	humain4 = dis.readBoolean();

	    	
	        for (int ligneBoucle=0;ligneBoucle<tailleGrille+2;ligneBoucle++){//par défaut 15
	        	for (int colonneBoucle=0;colonneBoucle<tailleGrille+3;colonneBoucle++){//par défaut 16
	        		//grillage[ligneBoucle][colonneBoucle] =  
	        				System.out.println("Coordonnées : " + ligneBoucle + colonneBoucle + " Couleur : " + dis.readChar());
	        	}
	        }
	         	
	      }
	    
	    catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    
	    //Données objet
	    String pseudo1 = "Joueur 1";
	    String pseudo2= "Joueur 2";
	    String pseudo3= "Joueur 3";
	    String pseudo4 = "Joueur 4";

	    try {
 	
	      //On récupère maintenant les données !
	      ois = new ObjectInputStream(
	              new BufferedInputStream(
	                new FileInputStream(
	                  new File(nomdufichier))));
	            
	      try {
	        System.out.println("Affichage des données objets :");
	        System.out.println("*************************\n");
	        pseudo1 = ((String)ois.readObject()).toString();
	        pseudo2 = ((String)ois.readObject()).toString();
	        pseudo3 = ((String)ois.readObject()).toString();
	        pseudo4 = ((String)ois.readObject()).toString();
	      } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	      }
		
	      ois.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	    
	    Joueur joueur1 = new Joueur(pseudo1,couleur1,1,1,tour1,0,caseControl1,humain1);
	    Joueur joueur2 = new Joueur(pseudo2,couleur2,tailleGrille,tailleGrille,tour2,1,caseControl2,humain2);
	    Joueur joueur3 = new Joueur(pseudo3,couleur3,tailleGrille,1,tour3,2,caseControl3,humain3);
	    Joueur joueur4 = new Joueur(pseudo4,couleur4,1,tailleGrille,tour4,3,caseControl4,humain4);
	    
	  //  jeu(joueur1, joueur2, joueur3, joueur4, grillage, NBJOUEUR, tailleGrille, MULTIJOUEUR, compteurTour);
	  }
}