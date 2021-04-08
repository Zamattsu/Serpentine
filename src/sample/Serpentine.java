package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;


public class Serpentine extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane rootPane = new StackPane();
        GridPane grid = new GridPane();
        grid.setVgap(1);
        grid.setHgap(1);
        for(int row = 0; row < 7;row++){
            for(int col = 0; col < 7; col++){
                grid.add(new Rectangle(20,20, Color.rgb(149, 144, 217)), col, row, 1, 1);
            }
        }



        grid.setAlignment(Pos.CENTER);
        grid.setGridLinesVisible(false);
        grid.setPrefHeight(400);
        grid.setPrefWidth(400);
        Button button = new Button("Randomize");
        StackPane ui = new StackPane(button);
        ui.setPadding(new Insets(0, 0, 20, 0));
        ui.setAlignment(Pos.BOTTOM_CENTER);
        rootPane.getChildren().addAll(grid, ui);
        Food food = new Food(20, 20,null);
        EventHandler<MouseEvent> eventHandler = new EventHandler<>(){
            @Override
            public void handle(MouseEvent e){
                food.randomize(grid);
                System.out.println();
            }
        };
        button.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);



        Scene scene = new Scene(rootPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
