package EventDrivenExamples;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Observable;
import java.util.Observer;

class BallPane extends Pane {

    private final double radius = 20;
    private double x = 4*radius, y = 4*radius;
    private double dx = 1, dy = 2;
    private Circle circle = new Circle(x, y, radius);
    private Timeline animation;

    private double xRect, yRect=0;
    private Rectangle rectangle = new Rectangle(xRect,yRect,4*radius,radius);

    BallPane() {
        circle.setFill(Color.GREEN); // Set ball color
        rectangle.setFill(Color.BLUE);
        getChildren().add(circle); // Place a ball into this pane
        getChildren().add(rectangle);//Place rectangle on pane
        // Create an animation for moving the ball
        animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
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

    private void moveBall() {
        double x1=xRect,x2=xRect+rectangle.getWidth();
        double y1=yRect,y2=yRect+rectangle.getHeight();
        // Check boundaries
        if ((x < radius) || (x > getWidth() - radius)) {dx *=-1;/* Change ball move direction  */   }else
        if ((y < radius) || (y > getHeight() - radius)) {dy *= -1; /* Change ball move direction */    }else
        // Adjust ball position
            if ((x1<x && x<x2) && (y1<y && y<y2));
        else{
        if ((x1<x && x<x2) && ((y2<y && y<y2+radius)||(y<y1 && y>y1-radius))) dy*=-1;else
        if (((x1-radius<x && x<x1)||(x2<x && x<x2+radius)) && (y1<y && y<y2)) dx*=-1;else
        if (distancePoints(x1,y1,x,y)< radius ||distancePoints(x2,y2,x,y)< radius
                ||distancePoints(x1,y2,x,y)< radius ||distancePoints(x2,y1,x,y)< radius){dx*=-1;dy*=-1;}}
        x += dx;
        y += dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
    }

    void moveRectangleBy(int dx) {
        if (dx == 0) return;

        final double cx = rectangle.getWidth()  / 2;
        final double cy = rectangle.getHeight() / 2;

        xRect = cx + rectangle.getLayoutX() + dx;
        yRect = cy + rectangle.getLayoutY() + 0;

        moveRectangleTo(xRect, yRect);
    }
    void moveRectangleTo(double xloc, double yloc) {
        final double cx = rectangle.getWidth()  / 2;
        final double cy = rectangle.getHeight() / 2;

        if (xloc - cx >= 0 &&
                xloc + cx <= getWidth() &&
                yloc - cy >= 0 &&
                yloc + cy <= getHeight()) {
            xRect=xRect - cx;  yRect=yRect - cy;
            rectangle.relocate(xRect, yRect);
        }
    }
    private static double distancePoints(double x1, double y1, double x2, double y2){
        return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }
}


