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

public class Sauvegarde {
  public static void sauvegardePartie(Joueur joueur1, Joueur joueur2, Joueur joueur3, Joueur joueur4, String[][] grillage, int NBJOUEUR, int tailleGrille, boolean MULTIJOUEUR, int compteurTour){
    //Nous déclarons nos objets en dehors du bloc try/catch
    //ObjectInputStream ois;
    ObjectOutputStream oos;
    //DataInputStream dis;
    DataOutputStream dos;
    
    //Données objet
    try {
      oos = new ObjectOutputStream(
              new BufferedOutputStream(
                new FileOutputStream(
                  new File("partie.txt"))));
            
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
      for (int ligneBoucle=1;ligneBoucle<tailleGrille+1;ligneBoucle++){//par défaut 14
		for (int colonneBoucle=1;colonneBoucle<tailleGrille+1;colonneBoucle++){//par défaut 14
			oos.writeObject(new String(grillage[ligneBoucle][colonneBoucle]));
		}
      }
      
      //Ne pas oublier de fermer le flux !
      oos.close();
        	
      //On récupère maintenant les données !
//      ois = new ObjectInputStream(
//              new BufferedInputStream(
//                new FileInputStream(
//                  new File("partie.txt"))));
//            
//      try {
//        System.out.println("Affichage des données objets :");
//        System.out.println("*************************\n");
//        System.out.println("Joueur 1 :\n" + ((Joueur)ois.readObject()).toString());
//        System.out.println("Joueur 2 :\n" + ((Joueur)ois.readObject()).toString());
//        System.out.println("Joueur 3 :\n" + ((Joueur)ois.readObject()).toString());
//        System.out.println("Joueur 4 :\n" + ((Joueur)ois.readObject()).toString());
//        for (int i=0;i<joueur1.caseControl.size();++i){
//            System.out.println("Case contrôlée par le joueur 1\n" + ((Case)ois.readObject()).toString());
//        }
//        for (int i=0;i<joueur2.caseControl.size();++i){
//        	System.out.println("Case contrôlée par le joueur 2\n" + ((Case)ois.readObject()).toString());
//        }
//        for (int i=0;i<joueur3.caseControl.size();++i){
//        	System.out.println("Case contrôlée par le joueur 3\n" + ((Case)ois.readObject()).toString());
//        }
//        for (int i=0;i<joueur4.caseControl.size();++i){
//        	System.out.println("Case contrôlée par le joueur4\n" + ((Case)ois.readObject()).toString());
//        }
//        for (int ligneBoucle=1;ligneBoucle<tailleGrille+1;ligneBoucle++){//par défaut 14
//        	for (int colonneBoucle=1;colonneBoucle<tailleGrille+1;colonneBoucle++){//par défaut 14
//        		System.out.println("Grille : " + ((String)ois.readObject()).toString());
//        	}
//        }
//        
//      } catch (ClassNotFoundException e) {
//        e.printStackTrace();
//      }
//	
//      ois.close();
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
                    new File("partie.txt"))));

        //Nous allons écrire chaque type primitif
        dos.writeBoolean(MULTIJOUEUR);
        dos.writeInt(NBJOUEUR);
        dos.writeInt(tailleGrille);
        dos.writeInt(compteurTour);
        dos.close();
        
        //On récupère maintenant les données !
//        dis = new DataInputStream(
//                new BufferedInputStream(
//                  new FileInputStream(
//                    new File("partie.txt"))));
//        System.out.println("Affichage des données de type primitif :");
//        System.out.println("*************************\n");     
//        System.out.println("MUTLIJOUEUR : " + dis.readBoolean());
//        System.out.println("NBJOUEUR : " + dis.readInt());
//        System.out.println("tailleGrille : " + dis.readInt());
//        System.out.println("compteurTour : " + dis.readInt());
          	
      }
    
    catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
  
  //Chargement
  public static void chargerPartie(){
	    //Nous déclarons nos objets en dehors du bloc try/catch
	    ObjectInputStream ois;
	    DataInputStream dis;
	    //Données objet
	    try {

	            
	        	
	      //On récupère maintenant les données !
	      ois = new ObjectInputStream(
	              new BufferedInputStream(
	                new FileInputStream(
	                  new File("partie.txt"))));
	            
	      try {
	        System.out.println("Affichage des données objets :");
	        System.out.println("*************************\n");
	        System.out.println("Joueur 1 :\n" + ((Joueur)ois.readObject()).toString());
	        System.out.println("Joueur 2 :\n" + ((Joueur)ois.readObject()).toString());
	        System.out.println("Joueur 3 :\n" + ((Joueur)ois.readObject()).toString());
	        System.out.println("Joueur 4 :\n" + ((Joueur)ois.readObject()).toString());
//	        for (int i=0;i<joueur1.caseControl.size();++i){
//	            System.out.println("Case contrôlée par le joueur 1\n" + ((Case)ois.readObject()).toString());
//	        }
//	        for (int i=0;i<joueur2.caseControl.size();++i){
//	        	System.out.println("Case contrôlée par le joueur 2\n" + ((Case)ois.readObject()).toString());
//	        }
//	        for (int i=0;i<joueur3.caseControl.size();++i){
//	        	System.out.println("Case contrôlée par le joueur 3\n" + ((Case)ois.readObject()).toString());
//	        }
//	        for (int i=0;i<joueur4.caseControl.size();++i){
//	        	System.out.println("Case contrôlée par le joueur4\n" + ((Case)ois.readObject()).toString());
//	        }
//	        for (int ligneBoucle=1;ligneBoucle<tailleGrille+1;ligneBoucle++){//par défaut 14
//	        	for (int colonneBoucle=1;colonneBoucle<tailleGrille+1;colonneBoucle++){//par défaut 14
//	        		System.out.println("Grille : " + ((String)ois.readObject()).toString());
//	        	}
//	        }
//	        
	      } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	      }
		
	      ois.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	      } catch (IOException e) {
	        e.printStackTrace();
	      }  
	    
	    //Données de type primitif
	    
	    
	    try {
	        
	        //On récupère maintenant les données !
	        dis = new DataInputStream(
	                new BufferedInputStream(
	                  new FileInputStream(
	                    new File("partie.txt"))));
	        System.out.println("Affichage des données de type primitif :");
	        System.out.println("*************************\n");     
	        System.out.println("MUTLIJOUEUR : " + dis.readBoolean());
	        System.out.println("NBJOUEUR : " + dis.readInt());
	        System.out.println("tailleGrille : " + dis.readInt());
	        System.out.println("compteurTour : " + dis.readInt());
	          	
	      }
	    
	    catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    
	  }
  //new java.util.Date().getTime()
}