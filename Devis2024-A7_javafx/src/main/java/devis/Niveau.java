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
public class Niveau {

    int idniveau;
    double hauteurSousPlafond;
    ArrayList<Appartement> listeAppart;
    ArrayList<Coin> listeCoins;
    ArrayList<Mur> listeMurs;
    ArrayList<Plafond> listePlafonds;
    ArrayList<Sol> listeSols;
    
    public Niveau(int idniveau,double hauteurSousPlafond,  ArrayList<Appartement> listeAppart){
        this.idniveau = idniveau;
        this.hauteurSousPlafond = hauteurSousPlafond;
        if (listeAppart == null) {
            this.listeAppart = new ArrayList<Appartement>();
        } else {
            this.listeAppart = listeAppart;
        }
        this.listeCoins= new ArrayList<Coin>();
        this.listeMurs= new ArrayList<Mur>();
        this.listePlafonds= new ArrayList<Plafond>();
        this.listeSols= new ArrayList<Sol>();
}
    void afficher(){
        System.out.println("Niveau : id="+this.idniveau+"Hauteur : h="+this.hauteurSousPlafond+"");

    }
    @Override
    public String toString() {
    return ("Niveau;"+idniveau+";"+hauteurSousPlafond+";"+listeAppart.get(0).idAppartement);
    }
}