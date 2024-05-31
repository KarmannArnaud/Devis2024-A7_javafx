/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devis;

public class Revetement {
    int idRevetement ;
    String designation ;
    Boolean pourMur;
    Boolean pourSol;
    Boolean pourPlafond;
    double prixUnitaire;
 
    public Revetement(String designation,int idRevetement,Boolean pourMur,Boolean pourSol,Boolean pourPlafond,double prixUnitaire) {
    this.designation =  designation;
    this.idRevetement = idRevetement;
    this.pourMur = pourMur;
    this.pourSol= pourSol;
    this.pourPlafond= pourPlafond;
    this.prixUnitaire = prixUnitaire;
}
    @Override
    public String toString() {
        return ("id : "+ idRevetement+" ; designation : "+ designation + " ; "+ pourMur +" ; "+ pourPlafond + " ; "+ pourSol + " ; prix unitaire : "+prixUnitaire );
}
}
