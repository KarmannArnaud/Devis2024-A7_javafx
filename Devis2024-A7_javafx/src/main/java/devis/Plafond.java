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

public class Plafond {
    int idPlafond;
    ArrayList<Coin>listeCoins ;
    ArrayList<Revetement>listeRevetements; 
    ArrayList<Tremie>listeTremies;
    double surface;
    int nbrTremies;
    
    public Plafond(int idPlafond,ArrayList<Coin>listeCoins){
        this.idPlafond=idPlafond;
        this.listeCoins=listeCoins;
        this.listeRevetements=new ArrayList<Revetement>();
        this.listeTremies = new ArrayList<Tremie>();
        this.nbrTremies=0;
    
    }
    public void surfacePlafond(){
        double surface = Math.sqrt(Math.pow((listeCoins.get(0).cx-listeCoins.get(2).cx)*(listeCoins.get(1).cy-listeCoins.get(3).cy),2))-2*2*nbrTremies;
        this.surface = surface;
    }
    public double devisPlafond(){
        double prix= this.surface*listeRevetements.get(0).prixUnitaire;
        return prix;
    }
    @Override
    public String toString() {
        if(!listeRevetements.isEmpty()){
    return ("Plafond;"+idPlafond+";"+listeCoins.get(0).idCoin+";"+listeCoins.get(1).idCoin+";"+listeCoins.get(2).idCoin+";"+listeCoins.get(3).idCoin+";"+listeRevetements.get(0));
    }
        else{
            return ("Plafond;"+idPlafond+";"+listeCoins.get(0).idCoin+";"+listeCoins.get(1).idCoin+";"+listeCoins.get(2).idCoin+";"+listeCoins.get(3).idCoin);
        }
    }
}
