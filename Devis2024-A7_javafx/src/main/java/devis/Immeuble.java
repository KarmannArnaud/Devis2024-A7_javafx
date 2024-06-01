/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devis;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Immeuble extends Batiment {
    String idImmeuble;
    
    public Immeuble(String id){
        this.listeNiveau=new ArrayList<Niveau>();
        this.idImmeuble=id;
        this.idBatiment=id;
    }
    public double DevisBatiment(){
        double prixDevis=0;
        for (Niveau niveau : listeNiveau) {
            for (Mur mur : niveau.listeMurs){
                mur.surfaceMur(niveau.hauteurSousPlafond);
                if (mur.listeRevetements!=null && !mur.listeRevetements.isEmpty()){
                prixDevis+=mur.devisMur();
                }
            }
            for (Sol sol : niveau.listeSols){
                sol.surfaceSol();
                if (sol.listeRevetements!=null && !sol.listeRevetements.isEmpty()){
                prixDevis+=sol.devisSol();}
            }
            for (Plafond plafond : niveau.listePlafonds){
                plafond.surfacePlafond();
                if (plafond.listeRevetements!=null && !plafond.listeRevetements.isEmpty()){
                prixDevis+=plafond.devisPlafond();}
            }

        }
        return prixDevis;
    }
    public void sauvegarder() {
        System.out.println("Dans quel fichier voulez-vous sauvegarder le batiment ?");
        String nom_fichier_sortie = Lire.S();
        File fichier = new File("C:\\Users\\gaspa\\OneDrive\\Documents\\NetBeansProjects\\Devis2024-A7_javafx\\Devis2024-A7_javafx\\src\\main\\java\\devis/" + nom_fichier_sortie);

        if (!fichier.exists()) {
            System.out.println("Ce fichier n'existe pas.");
        } else {
            try (PrintWriter writer = new PrintWriter(fichier)) {
                // Ajoutez ici le code que vous souhaitez écrire dans le fichier
                
                for (Niveau niveau : listeNiveau){
                    writer.println(niveau.toString());
                    for (Appartement appart : niveau.listeAppart){
                            writer.println(appart.toString());
                    
                        for (Coin coin : niveau.listeCoins){
                            writer.println(coin.toString());
                        }
                        for (Mur mur : niveau.listeMurs){
                            writer.println(mur.toString());
                        }
                        for (Sol sol : niveau.listeSols){
                            writer.println(sol.toString());
                        }
                        for (Plafond plafond : niveau.listePlafonds){
                            writer.println(plafond.toString());
                        }
                    }
                }
                System.out.println("Le batiment a été sauvegardé dans " + nom_fichier_sortie);
            } catch (FileNotFoundException e) {
                System.out.println("Erreur: Le fichier n'a pas été trouvé.");
                e.printStackTrace();
            }
        }

        // Fermez le scanner si vous n'en avez plus besoin
    }
    public void ouvrir(String nomDuFichier){
        String nomFichier;
        if (nomDuFichier.equals(null)){
            System.out.println("Veuillez entrer le fichier que vous voulez ouvrir :");
            nomFichier = Lire.S();
        }
        else {
            nomFichier = nomDuFichier;
        }
        /*ArrayList<Appartement> listeAppart = new ArrayList<Appartement>();
        ArrayList<Coin> listeCoins = new ArrayList<Coin>();
        ArrayList<Mur> listeMurs = new ArrayList<Mur>();
        ArrayList<Plafond> listePlafonds = new ArrayList<Plafond>();
        ArrayList<Sol> listeSols= new ArrayList<Sol>();*/
        int n=-1;
        int compteurTremie=-1;
        int compteurPorte=-1;
        int compteurFenetre=-1;
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\gaspa\\OneDrive\\Documents\\NetBeansProjects\\Devis2024-A7_javafx\\Devis2024-A7_javafx\\src\\main\\java\\devis/" +nomFichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] elements = ligne.split(";");
                String type = elements[0];
                switch (type) {
                    case "Coin":
                        int idCoin = Integer.parseInt(elements[1]);
                        double PositionX = Double.parseDouble(elements[2]);
                        double PositionY = Double.parseDouble(elements[3]);
                        Coin coin = new Coin(idCoin, PositionX, PositionY);
                        listeNiveau.get(n).listeCoins.add(coin);
                        break;
                    // Cas pour les autres types d'éléments
                    case "Mur":
                        int idMur = Integer.parseInt(elements[1]);
                        int idCoinDebut = Integer.parseInt(elements[2]);
                        int idCoinFin = Integer.parseInt(elements[3]);
                        int nbrePortes = Integer.parseInt(elements[4]);
                        int nbreFenetres= Integer.parseInt(elements[5]);
                        int idRevetementMur;
                        if(!elements[6].isEmpty()){
                            idRevetementMur = Integer.parseInt(elements[6]);
                        }
                        else{
                            idRevetementMur = 0;
                        }
                        for (Coin a : listeNiveau.get(n).listeCoins){
                            for (Coin b : listeNiveau.get(n).listeCoins){
                                if (idCoinDebut== a.idCoin && idCoinFin==b.idCoin){
                                    Mur mur = new Mur(idMur, a, b);
                                    listeNiveau.get(n).listeMurs.add(mur);
                                    if (idRevetementMur != 0){
                                        String designation = Devis2024.rechercher_Revetement_Designation_id(idRevetementMur);
                                        Revetement revetement = Devis2024.creerRevetement(designation);
                                        mur.listeRevetements.add(revetement);
                                    }
                                    
                                    for (int i=0;i<nbrePortes+1;i++){
                                        compteurPorte+=1;
                                        Porte porte = new Porte(compteurPorte, 0.90, 2.10);
                                        mur.listePortes.add(porte);
                                        mur.nbrePortes +=1;
                                        
                                    }
                                    for (int i=0;i<nbreFenetres+1;i++){
                                        compteurFenetre+=1;
                                        Fenetre fenetre = new Fenetre(compteurFenetre, 1.2, 1.2);
                                        mur.listeFenetres.add(fenetre);
                                        mur.nbreFenetres +=1;
                                        
                                    }
                                    
                                }
                            }
                        }

                        break;
                    case "Sol":
                        int idSol = Integer.parseInt(elements[1]);
                        int idCoin1 = Integer.parseInt(elements[2]);
                        int idCoin2= Integer.parseInt(elements[3]);
                        int idCoin3= Integer.parseInt(elements[4]);
                        int idCoin4 = Integer.parseInt(elements[5]);
                        int nbrTremies = Integer.parseInt(elements[6]);
                        int idRevetementSol;
                        
                        if(!elements[7].isEmpty()){
                            idRevetementSol = Integer.parseInt(elements[7]);
                        }
                        else{
                            idRevetementSol = 0;
                        }
                        for (Coin a : listeNiveau.get(n).listeCoins){
                            for (Coin b : listeNiveau.get(n).listeCoins){
                                for (Coin c : listeNiveau.get(n).listeCoins){
                                    for (Coin d : listeNiveau.get(n).listeCoins){
                                if (idCoin1== a.idCoin && idCoin2==b.idCoin && idCoin3==c.idCoin && idCoin4==d.idCoin){
                                    ArrayList<Coin> listeCoin =new ArrayList<>();
                                    listeCoin.add(a);
                                    listeCoin.add(b);
                                    listeCoin.add(c);
                                    listeCoin.add(d);
                                    Sol sol =new Sol(idSol,listeCoin);
                                    listeNiveau.get(n).listeSols.add(sol);
                                    if (idRevetementSol != 0){
                                        String designation = Devis2024.rechercher_Revetement_Designation_id(idRevetementSol);
                                        Revetement revetement = Devis2024.creerRevetement(designation);
                                        sol.listeRevetements.add(revetement);
                                    }
                                    for (int i=0;i<nbrTremies+1;i++){
                                        compteurTremie+=1;
                                        Tremie tremie = new Tremie(compteurTremie, 2, 2);
                                        sol.listeTremies.add(tremie);
                                        sol.nbrTremies +=1;
                                        
                                    }
                                    
                                }
                            }
                        }
                    }
                }

                        break;
                    case "Plafond":
                    int idPlafond = Integer.parseInt(elements[1]);
                    int idCoin11 = Integer.parseInt(elements[2]);
                    int idCoin22= Integer.parseInt(elements[3]);
                    int idCoin33= Integer.parseInt(elements[4]);
                    int idCoin44 = Integer.parseInt(elements[5]);
                    int nbrTremies2 = Integer.parseInt(elements[6]);
                    int idRevetementPlafond;
                    if(!elements[7].isEmpty()){
                        idRevetementPlafond = Integer.parseInt(elements[7]);
                    }
                    else{
                        idRevetementPlafond = 0;
                    }
                    for (Coin a : listeNiveau.get(n).listeCoins){
                        for (Coin b : listeNiveau.get(n).listeCoins){
                            for (Coin c : listeNiveau.get(n).listeCoins){
                                for (Coin d : listeNiveau.get(n).listeCoins){
                            if (idCoin11== a.idCoin && idCoin22==b.idCoin && idCoin33==c.idCoin && idCoin44==d.idCoin){
                                ArrayList<Coin> listeCoin =new ArrayList<>();
                                listeCoin.add(a);
                                listeCoin.add(b);
                                listeCoin.add(c);
                                listeCoin.add(d);
                                Plafond plafond =new Plafond(idPlafond,listeCoin);
                                listeNiveau.get(n).listePlafonds.add(plafond);
                                if (idRevetementPlafond != 0){
                                    String designation = Devis2024.rechercher_Revetement_Designation_id(idRevetementPlafond);
                                    Revetement revetement = Devis2024.creerRevetement(designation);
                                    plafond.listeRevetements.add(revetement);
                                }
                                
                                for (int i=0;i<nbrTremies2+1;i++){
                                    compteurTremie+=1;
                                    Tremie tremie = new Tremie(compteurTremie, 2, 2);
                                    plafond.listeTremies.add(tremie);
                                    plafond.nbrTremies +=1;
                                    
                                }
                            }
                        }
                    }
                }
            }
                        break;
                    case "Piece":
                        // Parse and create Piece object
                        break;
                    case "Niveau":
                        int idNiveau = Integer.parseInt(elements[1]);
                        int hauteurSousPlafond = Integer.parseInt(elements[2]);
                        Niveau niveau = new Niveau(idNiveau, hauteurSousPlafond, null);
                        listeNiveau.add(niveau);
                        n+=1;
                        break;
                    case "Appartement":
                        int idAppartement = Integer.parseInt(elements[1]);
                        int idNiveauAppartement = Integer.parseInt(elements[2]);
                        Appartement appart = new Appartement(idAppartement, idNiveauAppartement, null);
                        int positionDansLaListe = 0;
                        for (Niveau c : listeNiveau){
                            if (c.idniveau==idNiveauAppartement){
                                listeNiveau.get(positionDansLaListe).listeAppart.add(appart);
                                positionDansLaListe+=1;
                            }
                        }
                        break;
                    default:
                        System.out.println("Type inconnu: " + type);
                        break;
                }
            }
            
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            e.printStackTrace();
        }
        
    }
    @Override
    public String toString() {
    return ("Immeuble;"+idImmeuble+";"+listeNiveau.get(0).idniveau);
    }
}

    

