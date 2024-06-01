/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devis;

/**
 *
 * @author gaspa
 */
import java.util.ArrayList;

public class Sol {
    int idSol;
    int nbrTremies;
    ArrayList<Coin>listeCoins;
    ArrayList<Revetement>listeRevetements;
    ArrayList<Tremie>listeTremies;
    double surface;
    public Sol(int idSol, ArrayList<Coin> listeCoins) {
        this.listeCoins = listeCoins;
        this.listeTremies = new ArrayList<Tremie>();
        this.listeRevetements=new ArrayList<Revetement>();
}
    public void surfaceSol (){
        double surface = Math.sqrt(Math.pow((listeCoins.get(0).cx-listeCoins.get(2).cx)*(listeCoins.get(1).cy-listeCoins.get(3).cy),2))-2*2*nbrTremies;
        this.surface = surface;
    }
    public double devisSol(){
        double prix= this.surface*listeRevetements.get(0).prixUnitaire;
        return prix;
    }
    void afficher(){
        System.out.println("Sol : id="+this.idSol + "Revetement : id"+this.listeRevetements);

    }
    @Override
    public String toString() {
        if(!listeRevetements.isEmpty()){
    return ("Sol;"+idSol+";"+listeCoins.get(0).idCoin+";"+listeCoins.get(1).idCoin+";"+listeCoins.get(2).idCoin+";"+listeCoins.get(3).idCoin+";"+nbrTremies+";"+listeRevetements.get(0));
    }
        else{
            return ("Sol;"+idSol+";"+listeCoins.get(0).idCoin+";"+listeCoins.get(1).idCoin+";"+listeCoins.get(2).idCoin+";"+listeCoins.get(3).idCoin+";"+nbrTremies);
        }
    }
}
