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

public class Appartement {
   int idNiveauAppartement;
   int idAppartement;
   ArrayList<Piece> listePieces;
   
   public Appartement(int idNiveauAppartement,int idAppartement,ArrayList<Piece> listePieces){
     this.idNiveauAppartement=idNiveauAppartement; 
     this.idAppartement=idAppartement;
     if (listePieces == null) {
      this.listePieces = new ArrayList<Piece>();
    } 
    else {
   this.listePieces = listePieces;
  }
     
   }
   @Override
    public String toString() {
    return ("Appartement;"+idAppartement+";"+idNiveauAppartement);
    }
}