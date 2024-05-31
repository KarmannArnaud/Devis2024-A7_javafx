/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devis;
public class Fenetre extends Ouverture {
    int idFenetre;
    double dimX;
    double dimY;
    Mur mur;
    
   
    public Fenetre(int idFenetre, double dimX, double dimY){
    this.idFenetre = idFenetre;
    this.dimX = dimX;
    this.dimY = dimY;
}
    
}
