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

public class Piece {
    int idPiece;
    int sol;
    int plafond;
    ArrayList<Mur>listeMurs;
    public Piece (int idPiece, int sol, int plafond, ArrayList<Mur> listeMurs){
        this.idPiece = idPiece;
        this.listeMurs = listeMurs;
        this.sol = sol;
        this.plafond= plafond;
    }
    }