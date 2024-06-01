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
public abstract class Batiment {
    String idBatiment;
    public ArrayList<Niveau> listeNiveau;
    
    @Override
    public String toString() {
    return ("Batiment;"+idBatiment+";"+listeNiveau.get(0).idniveau);
    }
}