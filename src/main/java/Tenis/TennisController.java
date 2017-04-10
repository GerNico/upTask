package Tenis;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class TennisController extends Application {
    @Override
    public void start(Stage primaryStage) {
        TennisTable ballPane = new TennisTable();

        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());

        int batSpeed=8;

        ballPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {ballPane.increaseSpeed();}
            else if (e.getCode() == KeyCode.DOWN) {ballPane.decreaseSpeed();}
            else if (e.getCode() == KeyCode.RIGHT){ballPane.playerOne.moveBatBy(batSpeed);}
            else if (e.getCode() == KeyCode.LEFT){ballPane.playerOne.moveBatBy(-batSpeed);}
            else if (e.getCode() == KeyCode.D){ballPane.playerTwo.moveBatBy(batSpeed);}
            else if (e.getCode() == KeyCode.A){ballPane.playerTwo.moveBatBy(-batSpeed);}
        });

        Scene scene = new Scene(ballPane,400,200);
        primaryStage.setTitle("BounceBallControl");
        primaryStage.setScene(scene);
        primaryStage.show();

        ballPane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}