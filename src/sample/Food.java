package sample;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Food extends Rectangle {
    private double v1;
    private double v2;
    private javafx.scene.paint.Paint paint;
    private Rectangle currentFood = null;

    public Food(double v1, double v2, Paint paint){
        super(v1, v2, paint);
    }
    public void randomize(GridPane grid){
        Random rand = new Random();
        Rectangle nextFood = null;
        int randRow = rand.nextInt(grid.getRowCount());
        int randCol = rand.nextInt(grid.getColumnCount());
        for(Node i : grid.getChildren()){
            if(i instanceof Rectangle){
                if(grid.getRowIndex(i) == randRow){
                    if(grid.getColumnIndex(i) == randCol){
                        nextFood = (Rectangle)i;
                    }
                }
            }
        }
        nextFood.setFill(Color.rgb(227,227,17));
        if(this.currentFood != null && this.currentFood != nextFood){
            this.currentFood.setFill(Color.rgb(149, 144, 217));
        }
        this.currentFood = nextFood;
        System.out.println("Row = " + randRow + " Col = " + randCol);
    }
}
