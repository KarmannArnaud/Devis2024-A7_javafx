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
        Label message = new Label("Bonjour que voulez-vous faire ?");
        message.setFont(new Font(40));
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
        HBox root1 = new HBox(20); // 10 est l'espacement entre les boutons
        root1.getChildren().addAll(btn1, btn2);
        root1.setAlignment(Pos.CENTER);
        BorderPane PPrinc = new BorderPane();
        PPrinc.setCenter(message);
        PPrinc.setBottom(root1);
        root1.setTranslateY(-100);
        Scene scene1 = new Scene(PPrinc, 600, 400);

        stage.setScene(scene1);
        stage.show();
    }
public void start4(Stage stage4, Immeuble immeuble) {
        stage4.setTitle("First Scene");
        Label message1 = new Label("Entrer le nom de votre ficher (il faut mettre .txt à la fin):");
        message1.setFont(new Font(20));
        TextField fichier = new TextField();
        Button ouvrir = new Button("Ouvrir le fichier");
        VBox Vbox1 = new VBox(20);
        Vbox1.getChildren().add(fichier);
        Vbox1.getChildren().add(ouvrir);
        
        Vbox1.setAlignment(Pos.CENTER);
        Vbox1.setTranslateY(-100);
        BorderPane root = new BorderPane();
        root.setCenter(message1);
        root.setBottom(Vbox1);
        Scene scene4 = new Scene(root, 600, 400);
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
        btn2.setText("Retour en arrière");
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
        Scene secondScene = new Scene(root2, 600, 450);

        stage2.setScene(secondScene);
    }
    public void start3(Stage stage3, Immeuble immeuble, Niveau niveau ,Appartement appartement) {
        stage3.setTitle("HBox with 9 VBox each containing 5 TextFields and a Button");

        // Créer une HBox pour contenir les 9 VBox
        VBox grosseBoite = new VBox(20);
        HBox element = new HBox(10);
        grosseBoite.getChildren().add(element);

        VBox vBox1 = new VBox(10);
        TextField idCoin = new TextField();
        TextField cx = new TextField();
        TextField cy = new TextField();
        Label TidCoin = new Label("Id Coin :");
        Label Tcx = new Label("Cx :");
        Label Tcy = new Label("Cy :");
        Button creerCoin = new Button("Creer un Coin");
        vBox1.getChildren().add(TidCoin);
        vBox1.getChildren().add(idCoin);
        vBox1.getChildren().add(Tcx);
        vBox1.getChildren().add(cx);
        vBox1.getChildren().add(Tcy);
        vBox1.getChildren().add(cy);
        vBox1.getChildren().add(creerCoin);
        element.getChildren().add(vBox1);

        // Deuxième VBox
        VBox vBox2 = new VBox(10);
        TextField idMur = new TextField();
        TextField cd = new TextField();
        TextField cf = new TextField();
        Label TidMur = new Label("Mur :");
        Label Tcd = new Label("Coin debut :");
        Label Tcf = new Label("Coin fin: ");
        Button creerMur = new Button("Creer un Mur");
        vBox2.getChildren().add(TidMur);
        vBox2.getChildren().add(idMur);
        vBox2.getChildren().add(Tcd);
        vBox2.getChildren().add(cd);
        vBox2.getChildren().add(Tcf);
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
        Label TidSol = new Label("Id :");
        Label Tc1 = new Label("Coin 1 :");
        Label Tc2 = new Label("Coin 2 :");
        Label Tc3 = new Label("Coin 3 :");
        Label Tc4 = new Label("Coin 4 :");
        Button creerSol = new Button("Creer un Sol");
        vBox3.getChildren().add(TidSol);
        vBox3.getChildren().add(idSol);
        vBox3.getChildren().add(Tc1);
        vBox3.getChildren().add(c1);
        vBox3.getChildren().add(Tc2);
        vBox3.getChildren().add(c2);
        vBox3.getChildren().add(Tc3);
        vBox3.getChildren().add(c3);
        vBox3.getChildren().add(Tc4);
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
        Label TidPlafond = new Label("Id:");
        Label Tc5 = new Label("Coin 1 :");
        Label Tc6 = new Label("Coin 2 :");
        Label Tc7 = new Label("Coin 3 :");
        Label Tc8 = new Label("Coin 4 :");
        Button creerPlafond = new Button("Creer un Plafond");
        vBox4.getChildren().add(TidPlafond);
        vBox4.getChildren().add(idPlafond);
        vBox4.getChildren().add(Tc5);
        vBox4.getChildren().add(c5);
        vBox4.getChildren().add(Tc6);
        vBox4.getChildren().add(c6);
        vBox4.getChildren().add(Tc7);
        vBox4.getChildren().add(c7);
        vBox4.getChildren().add(Tc8);
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
        Label tidPiece = new Label("Id Pieice :");
        Label tidSolP = new Label("Id Sol :");
        Label tidPlafondP = new Label("");
        Label tm1 = new Label("Mur 1:");
        Label tm2 = new Label("Mur 2:");
        Label tm3 = new Label("Mur 3:");
        Label tm4 = new Label("Mur 4:");
        Button creerPiece = new Button("Creer une Piece");
        vBox5.getChildren().add(tidPiece);
        vBox5.getChildren().add(idPiece);
        vBox5.getChildren().add(tidSolP);
        vBox5.getChildren().add(idSolP);
        vBox5.getChildren().add(tidPlafondP);
        vBox5.getChildren().add(idPlafondP);
        vBox5.getChildren().add(tm1);
        vBox5.getChildren().add(m1);
        vBox5.getChildren().add(tm2);
        vBox5.getChildren().add(m2);
        vBox5.getChildren().add(tm3);
        vBox5.getChildren().add(m3);
        vBox5.getChildren().add(tm4);
        vBox5.getChildren().add(m4);
        vBox5.getChildren().add(creerPiece);
        element.getChildren().add(vBox5);

        // Sixième VBox
        VBox vBox6 = new VBox(10);
        TextField idPorte = new TextField();
        TextField murP = new TextField();
        Label tidPorte = new Label("Id Porte :");
        Label tmurP = new Label("Mur :");
        Button creerPorte = new Button("Creer une Porte");
        vBox6.getChildren().add(tidPorte);
         vBox6.getChildren().add(idPorte);
         vBox6.getChildren().add(tmurP);
        vBox6.getChildren().add(murP);
        vBox6.getChildren().add(creerPorte);
        element.getChildren().add(vBox6);

        // Septième VBox
        VBox vBox7 = new VBox(10);
        TextField idFenetre = new TextField();
        TextField murF = new TextField();
        Label tidFenetre = new Label("Id :");
        Label tmurF = new Label("Mur :");
        Button creerFenetre = new Button("Creer une Fenetre");
        vBox7.getChildren().add(tidFenetre);
        vBox7.getChildren().add(idFenetre);
        vBox7.getChildren().add(tmurF);
        vBox7.getChildren().add(murF);
        vBox7.getChildren().add(creerFenetre);
        element.getChildren().add(vBox7);

        // Huitième VBox
        

        // Neuvième VBox
        VBox vBox9 = new VBox(10);
        TextField idTremie = new TextField();
        TextField SolT = new TextField();
        Label tidTremie = new Label(" Id :");
        Label tSolT = new Label("Sol :");
        Button creerTremie = new Button("Creer un Tremie");
        vBox9.getChildren().add(tidTremie);
        vBox9.getChildren().add(idTremie);
        vBox9.getChildren().add(tSolT);
        vBox9.getChildren().add(SolT);
        vBox9.getChildren().add(creerTremie);
        element.getChildren().add(vBox9);
        
        VBox vBox8 = new VBox(10);
        TextField idSurface = new TextField();
        TextField typeRevetement = new TextField();
        Label tidSurface = new Label("Id :");
        Label ttypeRevetement = new Label("Type de revetement :");
        Button ajoutRevetement = new Button("Ajout de Revetement");
        vBox8.getChildren().add(tidSurface);
        vBox8.getChildren().add(idSurface);
        vBox8.getChildren().add(ttypeRevetement);
        vBox8.getChildren().add(typeRevetement);
        vBox8.getChildren().add(ajoutRevetement);
        element.getChildren().add(vBox8);
        
        VBox vBox10 = new VBox(10);
        TextField CodePromo = new TextField();
        HBox devisBox = new HBox(10);
        Button devis = new Button("Devis");
        TextField enregistrer = new TextField();
        Label Save = new Label("Enregistrer le Devis :");
        Button  sauvegarde = new Button("Enregistrer");
        vBox10.getChildren().add(CodePromo);
        devisBox.getChildren().add(devis);
        vBox10.getChildren().add(devisBox);
        vBox10.getChildren().add(Save);
        vBox10.getChildren().add(enregistrer);
        vBox10.getChildren().add(sauvegarde);
        grosseBoite.getChildren().add(vBox10);
        
        devis.setOnAction(event -> {
            double prix= immeuble.DevisBatiment();
            Label afficheDevis = new Label(String.valueOf(prix));
            devisBox.getChildren().add(afficheDevis);
        });

        Scene scene = new Scene(grosseBoite, 1400, 1000);
        stage3.setScene(scene);
        stage3.show();
    }

    
    public static void main(String[] args) {
        launch();
    }

}

