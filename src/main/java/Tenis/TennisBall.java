package Tenis;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import java.util.ArrayList;

class TennisBall {
    private Circle thisBall;
    private double velocityX=0;
    private double velocityY=0;
    private Pane myPane;
    private ArrayList<TennisBat> players=new ArrayList<>();


    TennisBall(Circle thisBall, double velocityX, double velocityY, Pane thisPane){
        this.thisBall=thisBall;
        this.velocityX=velocityX;
        this.velocityY=velocityY;
        this.myPane=thisPane;
    }

    void addPlayer (TennisBat player){
        this.players.add(player);
    }
    void removePlayer(TennisBat player){
        this.players.remove(player);
    }

    void moveBall() {
        double x=thisBall.getCenterX(),y=thisBall.getCenterY();
        double radius=thisBall.getRadius();
        if ((x < radius) || (x > this.myPane.getWidth() - radius)) {velocityX *=-1;/* Change ball move direction  */   }else
        if ((y < radius) || (y > this.myPane.getHeight() - radius)) {velocityY *=-1; /* Change ball move direction */  }

            for (TennisBat player:players ) {
                double xR=player.myShape.getX();
                double w=player.myShape.getWidth();
                double yR=player.myShape.getY();
                double h=player.myShape.getHeight();
                if ((x>=xR && x<= xR+w)&&((y>=yR-radius && y<=yR) ||((y>=yR+h)&&(y<=yR+h+radius))))velocityY*=-1;
                if ((y>=yR && y<= yR+h)&&((x>=xR-radius && x<=xR)||(x<=xR+w+radius && x>=xR+w )))velocityX*=-1;
                if (((x<xR&&x>xR-radius)&&(y<yR&&y>yR-radius))||((x<xR&&x>xR-radius)&&(y>yR+h&&y<yR+h+radius))
                        ||((x>xR+w&&x<xR+w+radius)&&(y<yR&&y>yR-radius))||((x>xR+w&&x<xR+w+radius)&&(y>yR+h&&y<yR+h+radius)))
                {velocityY*=-1;velocityX*=-1;}
            }
        x += velocityX;
        y += velocityY;
        thisBall.setCenterX(x);
        thisBall.setCenterY(y);
    }
    private static double distancePoints(double x1, double y1, double x2, double y2){
        return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }
}