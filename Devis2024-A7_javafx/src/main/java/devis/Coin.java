/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devis;

/**
 *
 * @author gaspa
 */
public class Coin {
    int idCoin;
    double cx;
    double cy;
    
Coin(int idCoin, double cx, double cy){
        this.idCoin = idCoin;
        this.cx = cx;
        this.cy = cy;
}
public void afficher(){
    System.out.println("Coin: id= "+this.idCoin+" abscisse = "+this.cx+" Ordonnee = "+this.cy);
}
@Override       
public String toString() {
    return ("Coin;"+idCoin+";"+cx+";"+cy);
}
}
