package Tenis;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

class TennisBat {
    Rectangle  myShape;
    Pane myPane;

    TennisBat(Rectangle myShape,Pane myPane){
        this.myShape=myShape;
        this.myPane=myPane;
    }

    void moveBatBy(int dx) {
        if (dx == 0) return;
        if ((0<this.myShape.getX()&&dx<0) || (dx>0 && this.myShape.getX()<this.myPane.getWidth()-this.myShape.getWidth()))
        moveBatTo(myShape.getX()+dx, myShape.getY());
    }
    void moveBatTo(double xloc, double yloc) {
        myShape.setX(xloc);
        myShape.setY(yloc);
    }
}