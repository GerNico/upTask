package Tenis;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class TennisTable extends Pane {

    private final double radius = 20;
    private double x = 8*radius, y = 8*radius;
    private Circle circle = new Circle(x, y, radius);
    private Timeline animation;

    private TennisBall myBall=new TennisBall(circle,1,1,this);
    TennisBat playerOne=new TennisBat(new Rectangle(4*radius,radius,Color.BLACK),this);
    TennisBat playerTwo=new TennisBat(new Rectangle(4*radius,radius,Color.BLUE),this);

    TennisTable() {
        this.heightProperty().addListener((observableValue, oldSceneHeight, newSceneHeight) -> {
            double newH= (double) newSceneHeight;
            playerTwo.myShape.setY(newH-radius); //down
            playerOne.myShape.setY(0);             //up
            myBall.addPlayer(playerOne);
            myBall.addPlayer(playerTwo);
        });//Shift first players bat after resizing

        circle.setFill(Color.GREEN); // Set ball color
        getChildren().add(circle); // Place a ball into this pane
        getChildren().add(playerOne.myShape);
        getChildren().add(playerTwo.myShape);
        animation = new Timeline(new KeyFrame(Duration.millis(50), e ->myBall.moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    void play() {
        animation.play();
    }

    void pause() {
        animation.pause();
    }

    void increaseSpeed() {
        animation.setRate(animation.getRate() + 0.1);
    }

    void decreaseSpeed() {
        animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }

    public DoubleProperty rateProperty() {
        return animation.rateProperty();
    }
}