package EventDrivenExamples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class BounceBallControl extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        BallPane ballPane = new BallPane(); // Create a ball pane
        ballPane.moveRectangleTo(ballPane.getWidth(),ballPane.getHeight());
        // Pause and resume animation
        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());

        ballPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {ballPane.increaseSpeed();}
            else if (e.getCode() == KeyCode.DOWN) {ballPane.decreaseSpeed();}
            else if (e.getCode() == KeyCode.RIGHT) {ballPane.moveRectangleBy(10);}   //shifting rectangular
            else if (e.getCode() == KeyCode.LEFT) {ballPane.moveRectangleBy(-10);}
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(ballPane,400,200);
        primaryStage.setTitle("BounceBallControl"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        // Must request focus after the primary stage is displayed
        ballPane.requestFocus();
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}