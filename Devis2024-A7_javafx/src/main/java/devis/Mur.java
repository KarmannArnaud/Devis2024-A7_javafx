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
public class Mur {
int idMur;
Coin coinDebut;
Coin coinFin;
int nbrePortes;
int nbreFenetres;
double hauteurSousPlafond;
ArrayList<Revetement> listeRevetements;
ArrayList<Fenetre> listeFenetres ;
ArrayList<Porte> listePortes ;
double surface ;
public Mur (int id, Coin Debut,Coin Fin){
    this.idMur = id;
    this.coinDebut = Debut;
    this.coinFin = Fin;
    this.listeFenetres = new ArrayList<Fenetre>();
    this.listePortes = new ArrayList<Porte>();
    this.listeRevetements = new ArrayList<Revetement>();
    this.nbreFenetres=0;
    this.nbrePortes=0;
    
}
public void surfaceMur (double hauteur){
double surface = Math.sqrt(Math.pow(coinDebut.cx - coinFin.cx,2)+ Math.pow(coinDebut.cy - coinFin.cy,2))*hauteur-nbrePortes*0.90*2.10-nbreFenetres*1.2*1.2;
this.surface = surface;
}
public double devisMur(){
    double prix= this.surface*listeRevetements.get(0).prixUnitaire;
    return prix;
}
@Override
public String toString() {
    return ("Mur;"+idMur+";"+coinDebut.idCoin+";"+coinFin.idCoin+";"+nbrePortes+";"+nbreFenetres+";"+listeRevetements.get(0));
}
}
