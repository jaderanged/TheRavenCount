package com.example.javafxpractice;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;

public class HelloApplication extends Application{

    Button button = new Button("Click Here");
    private final Poem poem = new Poem();

    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Practice JavaFX");
        Text text = new Text("'The Raven' Word Counter");
        text.setFont(Font.font("Times New Roman", FontWeight.BOLD,20));
        text.setFill(Color.WHITE);
        button.setMaxSize(100,100);
        button.setStyle("-fx-background-color: #4d194d; -fx-text-fill: white");
        button.setOnAction(actionEvent -> poem.main());

        VBox layout = new VBox();
        layout.getChildren().add(text);
        layout.getChildren().add(button);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(35);
        Scene scene = new Scene(layout,400,400);
        layout.setStyle("-fx-background-color: #312244;");
        stage.setScene(scene);
        stage.show();
    }
    }
