package com.mycompany.devis2024.a7_javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var label = new Label("Voulez vous crée un immeuble ou un batiment.");
        label.setFont(new Font(20));
        
       
        Button Bim = new Button("Immeuble");
     
        Button Bbat = new Button("Batiment");
        HBox Buttonbar = new HBox (40, Bim, Bbat);
         Buttonbar.setAlignment(Pos.CENTER);
         Buttonbar.setTranslateY(-100);   
        
        BorderPane Base = new BorderPane();
        Base.setCenter(label);
        Base.setBottom(Buttonbar);
        
        Scene scene = new Scene(Base, 600, 500);
        stage.setScene(scene);
        stage.setTitle("Devis2024-A7");
       
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }

}