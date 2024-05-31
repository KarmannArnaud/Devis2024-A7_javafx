/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devis;

public class Porte extends Ouverture {
    int idPorte;
    double dimX;
    double dimY;
    double surface;
    
    public Porte(int idPorte, double dimX, double dimY){
    this.idOuverture = idPorte;
    this.dimX = dimX;
    this.dimY = dimY;
    this.surface=0.90*2.10;
}
}