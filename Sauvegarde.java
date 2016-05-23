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
	
	public static void sauvegardePartie(Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4, char[][] grillage, int NBJOUEUR, int tailleGrille, boolean MULTIJOUEUR, int compteurTour){
    
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
		  oos.writeObject(new Joueur(joueur1.nom, joueur1.couleur, joueur1.colonne, joueur1.ligne, joueur1.tour, joueur1.tourInitialisation, joueur1.caseControl, joueur1.humain));
		  oos.writeObject(new Joueur(joueur2.nom, joueur2.couleur, joueur2.colonne, joueur2.ligne, joueur2.tour, joueur2.tourInitialisation, joueur2.caseControl, joueur2.humain));
		  oos.writeObject(new Joueur(joueur3.nom, joueur3.couleur, joueur3.colonne, joueur3.ligne, joueur3.tour, joueur3.tourInitialisation, joueur3.caseControl, joueur3.humain));
		  oos.writeObject(new Joueur(joueur4.nom, joueur4.couleur, joueur4.colonne, joueur4.ligne, joueur4.tour, joueur4.tourInitialisation, joueur4.caseControl, joueur4.humain));
		  for (int i=0;i<joueur1.caseControl.size();++i){
			  oos.writeObject(new Case(joueur1.caseControl.get(i).colonne,joueur1.caseControl.get(i).ligne,joueur1.caseControl.get(i).couleur));
		  }
		  for (int i=0;i<joueur2.caseControl.size();++i){
			  oos.writeObject(new Case(joueur2.caseControl.get(i).colonne,joueur2.caseControl.get(i).ligne,joueur2.caseControl.get(i).couleur));
		  }
		  for (int i=0;i<joueur3.caseControl.size();++i){
			  oos.writeObject(new Case(joueur3.caseControl.get(i).colonne,joueur3.caseControl.get(i).ligne,joueur3.caseControl.get(i).couleur));
		  }
		  for (int i=0;i<joueur4.caseControl.size();++i){
			  oos.writeObject(new Case(joueur4.caseControl.get(i).colonne,joueur4.caseControl.get(i).ligne,joueur4.caseControl.get(i).couleur));
		  }
      
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
        dos.writeBoolean(MULTIJOUEUR);
        dos.writeInt(NBJOUEUR);
        dos.writeInt(tailleGrille);
        dos.writeInt(compteurTour);
        dos.writeInt(joueur1.caseControl.size());
        dos.writeInt(joueur2.caseControl.size());
        dos.writeInt(joueur3.caseControl.size());
        dos.writeInt(joueur4.caseControl.size());
        for (int ligneBoucle=1;ligneBoucle<tailleGrille+1;ligneBoucle++){//par défaut 14
    		for (int colonneBoucle=1;colonneBoucle<tailleGrille+1;colonneBoucle++){//par défaut 14
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
  
  
  
  
  
  //------------------------------------------------------------------------------------------------------------
  
  
  
  
  //Chargement
  public static void chargerPartie(){
	  String nomdufichier = "partie-" + jour + "." + mois + "." + annee + "-" + heure + "." + minute + "." + seconde + ".txt";
	  //Nous déclarons nos objets en dehors du bloc try/catch
	    ObjectInputStream ois;
	    DataInputStream dis;
	    //Données de type primitif
        boolean MULTIJOUEUR;
        int NBJOUEUR;
        int tailleGrille = 0;
        int compteurTour;
	    int caseControl1Size = 0;
        int caseControl2Size = 0;
        int caseControl3Size = 0;
        int caseControl4Size = 0;
	    char[][] grillage;
        
	    try {
	        
	        //On récupère maintenant les données !
	        dis = new DataInputStream(
	                new BufferedInputStream(
	                  new FileInputStream(
	                    new File(nomdufichier))));
	        System.out.println("Affichage des données de type primitif :");
	        System.out.println("*************************\n");     
	        MULTIJOUEUR = dis.readBoolean();
	        NBJOUEUR = dis.readInt();
	        tailleGrille = dis.readInt();
	        compteurTour = dis.readInt();
	        caseControl1Size = dis.readInt();
	        caseControl2Size = dis.readInt();
	        caseControl3Size = dis.readInt();
	        caseControl4Size = dis.readInt();
	        for (int ligneBoucle=1;ligneBoucle<tailleGrille+1;ligneBoucle++){//par défaut 14
	        	for (int colonneBoucle=1;colonneBoucle<tailleGrille+1;colonneBoucle++){//par défaut 14
//	        		grillage[ligneBoucle][colonneBoucle] = dis.readChar();
	        	}
	        }
	         	
	      }
	    
	    catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    
	    //Données objet
	    Joueur joueur1;
	    Joueur joueur2;
	    Joueur joueur3;
	    Joueur joueur4;
	    
	    try {
 	
	      //On récupère maintenant les données !
	      ois = new ObjectInputStream(
	              new BufferedInputStream(
	                new FileInputStream(
	                  new File(nomdufichier))));
	            
	      try {
	        System.out.println("Affichage des données objets :");
	        System.out.println("*************************\n");
	        System.out.println("Joueur 1 :\n" + ((Joueur)ois.readObject()).toString());
	        System.out.println("Joueur 2 :\n" + ((Joueur)ois.readObject()).toString());
	        System.out.println("Joueur 3 :\n" + ((Joueur)ois.readObject()).toString());
	        System.out.println("Joueur 4 :\n" + ((Joueur)ois.readObject()).toString());
	        for (int i=0;i<caseControl1Size;++i){
	            System.out.println("Case contrôlée par le joueur 1\n" + ((Case)ois.readObject()).toString());
	        }
	        for (int i=0;i<caseControl2Size;++i){
	        	System.out.println("Case contrôlée par le joueur 2\n" + ((Case)ois.readObject()).toString());
	        }
	        for (int i=0;i<caseControl3Size;++i){
	        	System.out.println("Case contrôlée par le joueur 3\n" + ((Case)ois.readObject()).toString());
	        }
	        for (int i=0;i<caseControl4Size;++i){
	        	System.out.println("Case contrôlée par le joueur4\n" + ((Case)ois.readObject()).toString());
	        }

        
	      } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	      }
		
	      ois.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	      } catch (IOException e) {
	        e.printStackTrace();
	      }  
	    

	    
	  }
  //new java.util.Date().getTime()
}