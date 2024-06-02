/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devis;


/**
 *
 * @author akarmann01
 */
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Devis2024 {

    public static void main(String[] args) {
        
        System.out.println("Hello");
        Immeuble Bat7 = new Immeuble("Bat7");


        
        Niveau rezdechausser = new Niveau(0, 3, null);
        Bat7.listeNiveau.add(rezdechausser);
        Appartement appartement = new Appartement(0, 0,null);
        Bat7.listeNiveau.get(0).listeAppart.add(appartement); // Tableau pour stocker les coins
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int n = i * 3 + j ; // Calcul de l'index
                rezdechausser.listeCoins.add(new Coin(n, i*3, j*3)); // Création du coin et stockage dans le tableau
            }
        }
      
        
        Mur m0 = new Mur(0, rezdechausser.listeCoins.get(0), rezdechausser.listeCoins.get(1));
        Mur m1 = new Mur(1, rezdechausser.listeCoins.get(0), rezdechausser.listeCoins.get(3));
        Mur m2 = new Mur(2, rezdechausser.listeCoins.get(1), rezdechausser.listeCoins.get(2));
        Mur m3 = new Mur(3, rezdechausser.listeCoins.get(1), rezdechausser.listeCoins.get(4));
        Mur m4 = new Mur(4, rezdechausser.listeCoins.get(2), rezdechausser.listeCoins.get(5));
        Mur m5 = new Mur(5, rezdechausser.listeCoins.get(3), rezdechausser.listeCoins.get(4));
        Mur m6 = new Mur(6, rezdechausser.listeCoins.get(3), rezdechausser.listeCoins.get(6));
        Mur m7 = new Mur(7, rezdechausser.listeCoins.get(4), rezdechausser.listeCoins.get(5));
        Mur m8 = new Mur(8, rezdechausser.listeCoins.get(4), rezdechausser.listeCoins.get(7));
        Mur m9 = new Mur(9, rezdechausser.listeCoins.get(5), rezdechausser.listeCoins.get(8));
        Mur m10 = new Mur(10, rezdechausser.listeCoins.get(6), rezdechausser.listeCoins.get(7));
        Mur m11 = new Mur(11, rezdechausser.listeCoins.get(7), rezdechausser.listeCoins.get(8));
        rezdechausser.listeMurs.add(m0) ;
        rezdechausser.listeMurs.add(m1) ;
        rezdechausser.listeMurs.add(m2) ;
        rezdechausser.listeMurs.add(m3) ;
        rezdechausser.listeMurs.add(m4) ;
        rezdechausser.listeMurs.add(m5) ;
        rezdechausser.listeMurs.add(m6) ;
        rezdechausser.listeMurs.add(m7) ;
        rezdechausser.listeMurs.add(m8) ;
        rezdechausser.listeMurs.add(m9) ;
        rezdechausser.listeMurs.add(m10) ;
        rezdechausser.listeMurs.add(m11) ;
        ArrayList<Mur> listeMursCuisine= new ArrayList<>();
        ArrayList<Mur> listeMursSalon= new ArrayList<>();
        ArrayList<Mur> listeMursChambre= new ArrayList<>();
        ArrayList<Mur> listeMursSalleDeBain= new ArrayList<>();
        listeMursCuisine.add(rezdechausser.listeMurs.get(0));
        listeMursCuisine.add(rezdechausser.listeMurs.get(1));
        listeMursCuisine.add(rezdechausser.listeMurs.get(5));
        listeMursCuisine.add(rezdechausser.listeMurs.get(3));
        listeMursSalon.add(rezdechausser.listeMurs.get(5));
        listeMursSalon.add(rezdechausser.listeMurs.get(10));
        listeMursSalon.add(rezdechausser.listeMurs.get(8));
        listeMursChambre.add(rezdechausser.listeMurs.get(2));
        listeMursChambre.add(rezdechausser.listeMurs.get(3));
        listeMursChambre.add(rezdechausser.listeMurs.get(7));
        listeMursChambre.add(rezdechausser.listeMurs.get(4));
        listeMursSalleDeBain.add(rezdechausser.listeMurs.get(7));
        listeMursSalleDeBain.add(rezdechausser.listeMurs.get(8));
        listeMursSalleDeBain.add(rezdechausser.listeMurs.get(11));
        listeMursSalleDeBain.add(rezdechausser.listeMurs.get(9));
        Piece cuisine = new Piece(0, 1, 1, listeMursCuisine);
        Piece salon = new Piece(1, 1, 1, listeMursSalon);
        Piece  chambre = new Piece(2, 1, 1, listeMursChambre);
        Piece salleDeBain = new Piece(3, 1, 1, listeMursSalleDeBain);
        Sol solCuisine = new Sol(0, solPourPiece(cuisine));
        Sol solSalleDeBain = new Sol(1, solPourPiece(salleDeBain));
        Sol solChambre = new Sol(2, solPourPiece(chambre));
        Sol solSalon = new Sol(0, solPourPiece(salon));
        rezdechausser.listeSols.add(solChambre);
        rezdechausser.listeSols.add(solSalon);
        rezdechausser.listeSols.add(solSalleDeBain);
        rezdechausser.listeSols.add(solCuisine);
        System.out.println("llllll");
        /*solCuisine.listeRevetements.add(creerRevetement(rechercher_Revetement_Designation("Carrelage")));
        solChambre.listeRevetements.add(solCuisine.listeRevetements.get(0));
        solSalon.listeRevetements.add(solCuisine.listeRevetements.get(0));
        solSalleDeBain.listeRevetements.add(solCuisine.listeRevetements.get(0));*/
        Plafond plafondChambre = new Plafond(0,solPourPiece(chambre));
        Plafond plafondSalon = new Plafond(1,solPourPiece(salon));
        Plafond plafondSalleDeBain = new Plafond(2,solPourPiece(salleDeBain));
        Plafond plafondCuisine = new Plafond(3,solPourPiece(cuisine));
        rezdechausser.listePlafonds.add(plafondChambre);
        rezdechausser.listePlafonds.add(plafondSalon);
        rezdechausser.listePlafonds.add(plafondSalleDeBain);
        rezdechausser.listePlafonds.add(plafondCuisine);
        /*plafondChambre.listeRevetements.add(creerRevetement(rechercher_Revetement_Designation("Peinture")));
        plafondCuisine.listeRevetements.add(plafondChambre.listeRevetements.get(0));
        plafondSalon.listeRevetements.add(plafondChambre.listeRevetements.get(0));
        plafondSalleDeBain.listeRevetements.add(plafondChambre.listeRevetements.get(0));*/
        Tremie escalier = new Tremie(0, 2, 2);
        plafondSalon.listeTremies.add(escalier);
        plafondSalon.nbrTremies+=1;

        System.out.println("ggggggg");
        
        
        

        appartement.listePieces.add(cuisine);
        appartement.listePieces.add(salon);
        appartement.listePieces.add(chambre);
        appartement.listePieces.add(salleDeBain);
        rezdechausser.listeAppart.add(appartement);
        m0.nbrePortes=1;
        m4.nbrePortes=1;
        m8.nbrePortes=1;
        m11.nbrePortes=2;
        m1.nbreFenetres=1;
        m2.nbreFenetres=1;
        m3.nbreFenetres=1;
        m5.nbreFenetres=1;
        m6.nbreFenetres=1;
        m7.nbreFenetres=1;
        m9.nbreFenetres=1;
         System.out.println("ggggggg");
        /*m0.surfaceMur(3);
        m1.surfaceMur(3);
        m2.surfaceMur(3);
        m3.surfaceMur(3);
        m4.surfaceMur(3);
        m5.surfaceMur(3);
        m6.surfaceMur(3);
        m7.surfaceMur(3);
        m8.surfaceMur(3);
        m9.surfaceMur(3);
        m10.surfaceMur(3);
        m11.surfaceMur(3);
        System.out.println(m0.surface);*/
        /*m0.listeRevetements.add(creerRevetement(rechercher_Revetement_Designation("Carrelage")));
        for(int i=0;i<11;i++){
            rezdechausser.listeMurs.get(i+1).listeRevetements.add(m0.listeRevetements.get(0));

        } 
        System.out.println(creerRevetement(rechercher_Revetement_Designation("Carrelage")));*/
       /*  double devis = m0.devisMur();
        System.out.println(devis);*/
        /* 
        for (int i = 0;i<4;i++){
            appartement.listePieces.add(new Piece(i, 1, 1, listeMurs));
        }
        int compteurPiece=0;
        int e = 0;
        for (int i=0; i<2*2;i+=2){
            for (int j=0; j<2*5;j+=5){
                if (e==1){
                    e=0;
                }
                else {
                    e=0;
                }
                appartement.listePieces.get(compteurPiece).listeMurs.add(murs[i+j]);
                appartement.listePieces.get(compteurPiece).listeMurs.add(murs[i+j+1]);
                appartement.listePieces.get(compteurPiece).listeMurs.add(murs[i+j+4]);
                appartement.listePieces.get(compteurPiece).listeMurs.add(murs[i+j+3-e]);
            }
        }
        for (int i=0;i<4;i++){
            System.out.println(appartement.listePieces.get(i).listeMurs);
        }
       */
      System.out.println("ggggggg");
      System.out.println(Bat7.DevisBatiment());
      System.out.println("ggvrfveg");
      Bat7.sauvegarder();
        }
        public static Revetement creerRevetement(String ligne) {
            String[] parts = ligne.split(";");
            if (parts.length >= 6) { // Vérifier la longueur du tableau pour éviter les erreurs
                String designation = parts[1];
                int idRevetement = Integer.parseInt(parts[0]);
                boolean pourMur = parts[2].equals("1");
                boolean pourSol = parts[3].equals("1");
                boolean pourPlafond = parts[4].equals("1");
                double prixUnitaire = Double.parseDouble(parts[5]);
                return new Revetement(designation, idRevetement, pourMur, pourSol, pourPlafond, prixUnitaire);
            }
            return null; // Retourner null si la ligne n'est pas correcte
        }
        public static ArrayList<Coin> solPourPiece(Piece piece) {
        HashSet<Coin> coinSet = new HashSet<>();
        
        for (Mur mur : piece.listeMurs) {
            coinSet.add(mur.coinDebut);
            coinSet.add(mur.coinFin);
        }
        
        if (coinSet.size() != 4) {
            throw new IllegalArgumentException("La pièce ne forme pas un quadrilatère avec 4 coins uniques.");
        }
        return new ArrayList<>(coinSet);
    }

        
    public static String rechercher_Revetement_Designation(String revetementRech) {
            String rev1 = null;
            String rev2 =null;
            String rev3 =null;
            String[] tab; 
            try {
                BufferedReader revetement = new BufferedReader(new FileReader("C:\\Users\\gaspa\\OneDrive\\Documents\\NetBeansProjects\\Devis2024-A7_javafx\\Devis2024-A7_javafx\\src\\main\\java\\devis/CatalogueRevetements.txt"));
                String lignelue;// Ligne lue depula le fichier 
                while ((lignelue=revetement.readLine ())!=null){
                    tab=lignelue.split (";");
                if(tab[1].equals(revetementRech)) {
                    System.out.println(lignelue);
                    if (rev1==null){
                        rev1= lignelue ;}
                        else if (rev2==null){
                            rev2 = lignelue;
                        }
                            else if (rev3==null){
                                rev3 = lignelue;
                            }

                }
                
        }

                revetement.close ();
                System.out.print("Quel revetement voulez vous ? votre réponse devra etre rev suivi du numéro d'affichage dans la console :  ");
                String chaine = Lire.S();
                if (chaine.equals("rev1")){
                    return rev1;
                }
                
                
}
    catch (FileNotFoundException err){
        System.out.println( "Erreur le fichter n'existe pas!\n "+err) ;}
            catch (IOException err){
                System.out.println(" Erreur :\n "+err) ;
            }
            return null;
            }// Fin de la méthode "rechercher Revetement DesignatIon"
    
    
    
    
    
        
            public static String rechercher_Revetement_Designation_id(int revetementRech) {
                String[] tab; 
                try (BufferedReader Revetement = new BufferedReader(new FileReader("C:\\Users\\gaspa\\OneDrive\\Documents\\NetBeansProjects\\Devis2024-A7_javafx\\Devis2024-A7_javafx\\src\\main\\java\\devis/CatalogueRevetements.txt"))) {
                    String lignelue; // Ligne lue depuis le fichier 
                    while ((lignelue = Revetement.readLine()) != null) {
                        tab = lignelue.split(";");
                        if (tab[0].equals(String.valueOf(revetementRech))) {
                            return lignelue;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
                    e.printStackTrace();
                }
                return null;
            }
    // Fin de la méthode "rechercher Revetement DesignatIon"





}
