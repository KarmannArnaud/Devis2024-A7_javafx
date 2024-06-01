package com.mycompany.devis2024.a7_javafx;
import devis.Niveau;
import devis.Appartement;
import devis.Immeuble;
import devis.Batiment;
import devis.Piece;
import devis.Mur;
import devis.Coin;
import devis.Revetement;
import devis.Devis2024;
import devis.Fenetre;
import devis.Ouverture;
import devis.Porte;
import devis.Tremie;
import devis.Plafond;
import devis.Sol;
import devis.Lire;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("First Scene");

        // Créez le bouton pour la première scène
        Button btn1 = new Button();
        btn1.setText("Crée un batiment");
        btn1.setOnAction(event -> {
            start2(stage);
            });
        Button btn2 = new Button();
        btn2.setText("Prendre une sauvegarde");
        btn2.setOnAction(event -> {
            Immeuble Bat7=new Immeuble("Batiment");
            start4(stage,Bat7);
        });

        // Créez le layout pour la première scène et ajoutez le bouton
        HBox root1 = new HBox(10); // 10 est l'espacement entre les boutons
        root1.getChildren().addAll(btn1, btn2);
        Scene scene1 = new Scene(root1, 300, 250);

        stage.setScene(scene1);
        stage.show();
    }
public void start4(Stage stage4, Immeuble immeuble) {
        stage4.setTitle("First Scene");
        TextField fichier = new TextField();
        Button ouvrir = new Button("ouvrir");
        VBox Vbox1 = new VBox();
        Vbox1.getChildren().add(fichier);
        Vbox1.getChildren().add(ouvrir);
        Scene scene4 = new Scene(Vbox1, 300, 250);
        ouvrir.setOnAction(event -> {
            String nomFichier = fichier.getText();
            immeuble.ouvrir(nomFichier);
            start3(stage4,immeuble,immeuble.listeNiveau.get(0),immeuble.listeNiveau.get(0).listeAppart.get(0));
    });
        stage4.setScene(scene4);
        stage4.show();
    }
    public void start2(Stage stage2) {
        stage2.setTitle("Second Scene");

        // Créez le bouton pour la deuxième scène
        Button btn2 = new Button();
        btn2.setText("Return to First Scene");
        btn2.setOnAction(event -> start(stage2));  // Retour à la première scène

        // Créez le layout pour la deuxième scène et ajoutez le bouton
        
        TextField idA = new TextField();
        TextField idN = new TextField();
        
        Button btn3 = new Button();
        btn3.setText("Enregistrer");
        btn3.setOnAction(event -> {
            int idNiveau = Integer.parseInt(idN.getText());
            Niveau niveau = new Niveau(idNiveau,3,null);
            Immeuble Bat7 = new Immeuble("Batiment");
            Bat7.listeNiveau.add(niveau);
            int idAppart =Integer.parseInt(idA.getText());
            Appartement appart = new Appartement(idNiveau,idAppart,null);
            start3(stage2,Bat7,niveau,appart);
        });
        VBox root2 = new VBox(10);
        root2.getChildren().addAll(idN, idA, btn2,btn3);
        Scene secondScene = new Scene(root2, 400, 250);

        stage2.setScene(secondScene);
    }
    public void start3(Stage stage3, Immeuble immeuble, Niveau niveau ,Appartement appartement) {
        stage3.setTitle("HBox with 9 VBox each containing 5 TextFields and a Button");

        // Créer une HBox pour contenir les 9 VBox
        VBox grosseBoite = new VBox(50);
        HBox element = new HBox(10);
        grosseBoite.getChildren().add(element);

        VBox vBox1 = new VBox(10);
        TextField idCoin = new TextField();
        TextField cx = new TextField();
        TextField cy = new TextField();
        Button creerCoin = new Button("CreerCoin");
        vBox1.getChildren().add(idCoin);
        vBox1.getChildren().add(cx);
        vBox1.getChildren().add(cy);
        vBox1.getChildren().add(creerCoin);
        element.getChildren().add(vBox1);

        // Deuxième VBox
        VBox vBox2 = new VBox(10);
        TextField idMur = new TextField();
        TextField cd = new TextField();
        TextField cf = new TextField();
        Button creerMur = new Button("CreerMur");
        vBox2.getChildren().add(idMur);
        vBox2.getChildren().add(cd);
        vBox2.getChildren().add(cf);
        vBox2.getChildren().add(creerMur);
        element.getChildren().add(vBox2);

        // Troisième VBox
        VBox vBox3 = new VBox(10);
        TextField idSol = new TextField();
        TextField c1 = new TextField();
        TextField c2 = new TextField();
        TextField c3 = new TextField();
        TextField c4 = new TextField();
        Button creerSol = new Button("CreerSol");
        vBox3.getChildren().add(idSol);
        vBox3.getChildren().add(c1);
        vBox3.getChildren().add(c2);
        vBox3.getChildren().add(c3);
        vBox3.getChildren().add(c4);
        vBox3.getChildren().add(creerSol);
        element.getChildren().add(vBox3);

        // Quatrième VBox
        VBox vBox4 = new VBox(10);
        TextField idPlafond = new TextField();
        TextField c5 = new TextField();
        TextField c6 = new TextField();
        TextField c7 = new TextField();
        TextField c8 = new TextField();
        Button creerPlafond = new Button("CreerPlafond");
        vBox4.getChildren().add(idPlafond);
        vBox4.getChildren().add(c5);
        vBox4.getChildren().add(c6);
        vBox4.getChildren().add(c7);
        vBox4.getChildren().add(c8);
        vBox4.getChildren().add(creerPlafond);
        element.getChildren().add(vBox4);

        // Cinquième VBox
        VBox vBox5 = new VBox(10);
        TextField idPiece = new TextField();
        TextField idSolP = new TextField();
        TextField idPlafondP = new TextField();
        TextField m1 = new TextField();
        TextField m2 = new TextField();
        TextField m3 = new TextField();
        TextField m4 = new TextField();
        Button creerPiece = new Button("CreerPiece");
        vBox5.getChildren().add(idPiece);
        vBox5.getChildren().add(idSolP);
        vBox5.getChildren().add(idPlafondP);
        vBox5.getChildren().add(m1);
        vBox5.getChildren().add(m2);
        vBox5.getChildren().add(m3);
        vBox5.getChildren().add(m4);
        vBox5.getChildren().add(creerPiece);
        element.getChildren().add(vBox5);

        // Sixième VBox
        VBox vBox6 = new VBox(10);
        TextField idPorte = new TextField();
        TextField murP = new TextField();
        Button creerPorte = new Button("CreerPorte");
        vBox6.getChildren().add(idPorte);
        vBox6.getChildren().add(murP);
        vBox6.getChildren().add(creerPorte);
        element.getChildren().add(vBox6);

        // Septième VBox
        VBox vBox7 = new VBox(10);
        TextField idFenetre = new TextField();
        TextField murF = new TextField();
        Button creerFenetre = new Button("CreerFenetre");
        vBox7.getChildren().add(idFenetre);
        vBox7.getChildren().add(murF);
        vBox7.getChildren().add(creerFenetre);
        element.getChildren().add(vBox7);

        // Huitième VBox
        

        // Neuvième VBox
        VBox vBox9 = new VBox(10);
        TextField idTremie = new TextField();
        TextField SolT = new TextField();
        Button creerTremie = new Button("CreerTremie");
        vBox9.getChildren().add(idTremie);
        vBox9.getChildren().add(SolT);
        vBox9.getChildren().add(creerTremie);
        element.getChildren().add(vBox9);
        
        VBox vBox8 = new VBox(10);
        TextField idSurface = new TextField();
        TextField typeRevetement = new TextField();
        Button ajoutRevetement = new Button("ajoutRevetement");
        vBox8.getChildren().add(idSurface);
        vBox8.getChildren().add(typeRevetement);
        vBox8.getChildren().add(ajoutRevetement);
        element.getChildren().add(vBox8);
        
        VBox vBox10 = new VBox(10);
        TextField CodePromo = new TextField();
        Button devis = new Button("Devis");
        TextField enregistrer = new TextField();
        Button  sauvegarde = new Button("enregistrer");
        vBox10.getChildren().add(CodePromo);
        vBox10.getChildren().add(devis);
        vBox10.getChildren().add(enregistrer);
        vBox10.getChildren().add(sauvegarde);
        grosseBoite.getChildren().add(vBox10);
        
        devis.setOnAction(event -> {
            double prix= immeuble.DevisBatiment();
            Label afficheDevis = new Label(String.valueOf(prix));
            grosseBoite.getChildren().add(afficheDevis);
        });

        Scene scene = new Scene(grosseBoite, 1400, 1000);
        stage3.setScene(scene);
        stage3.show();
    }

    
    public static void main(String[] args) {
        launch();
    }

}