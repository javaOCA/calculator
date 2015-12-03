package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private double dragOffsetX;
    private double dragOffsetY;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/sample.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("view/style.css");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.setOnMousePressed((MouseEvent event) -> {
            dragOffsetX = event.getScreenX() - primaryStage.getX();
            dragOffsetY = event.getScreenY() - primaryStage.getY();
        });
        scene.setOnMouseDragged((MouseEvent event) -> {
            primaryStage.setX(event.getScreenX() - dragOffsetX);
            primaryStage.setY(event.getScreenY() - dragOffsetY);
        });
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
