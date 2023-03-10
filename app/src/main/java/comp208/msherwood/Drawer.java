package comp208.msherwood;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Drawer extends View {

    // this arrayList is where all the lines will be stored
    private ArrayList<ColouredPath> lines = new ArrayList<>();

    int currentColor = Color.BLACK; // default colour

    int brushWidth = 8; // default width

    Paint paint = new Paint(); // stores the colour value, thickness of stroke
    // Path myPath = new Path();
    public Drawer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    // this method will allow drawable instances onto the canvas

    // this on draw method will set the values of what colour, width of brush to send to the canvas
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas); // this will allow us to call methods from canvas
        // this for each loop will look to see
        for(ColouredPath lp: lines) {
            paint.setStrokeWidth(lp.strokeWidth); // width of brush stroke
            paint.setColor(lp.color); // sets colour to black
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(lp.linePath, paint);
        }
    }


    Path myPath = null;
    public void begin(float x, float y) {
        myPath = new Path(); // this will reset and start a new path
        ColouredPath lp = new ColouredPath(currentColor, brushWidth, myPath);
        lines.add(lp); // this is storing the the line path into the arraylist
        myPath.moveTo(x,y);
        // invalidate(); //  calls the onDraw method again and redraws it
    }

    // this addPint method will draw the lines based off of the x and y coordinates
    public void addPoint(float x, float y) {
        if(myPath != null) { // if my path has data
            myPath.lineTo(x, y); // using the x and y coordinates it will draw a line
            invalidate(); // calls the onDraw method to re draw the line
        }

    }

    // this method will clear the screen by removing all elements out of the list
    public void empty() {
        lines.clear(); // this will clear the array list
        invalidate(); // will
    }

    /* the set Drawing Color method will determine the value of the colour based off of the
    * value that is passed through the parameter for the colored image buttons */
    public void setDrawingColor(int value){
        switch(value) {
            case 1:
                currentColor = Color.RED;
                break;
            case 2:
                currentColor = Color.YELLOW;
                break;
            case 3:
                currentColor = Color.GREEN;
                break;
            case 4:
                currentColor = Color.rgb(173,216,230); // rgb code for lightBlue
                break;
            case 5:
                currentColor = Color.BLUE;
                break;
            case 6:
                currentColor = Color.BLACK;
                break;
            case 7:
                currentColor= Color.WHITE;
                break;
        }
    }


    /* this setDrawingStyle will determine the width of the brushes from the value they pass
    * in the parameters  */
    public void setDrawingStyle(int value) {
        switch(value) {
            case 1: // for the pencil
                brushWidth = 8;
                break;
            case 2: // for the marker
                brushWidth = 15;
                break;
            case 3: // for the paint brush
                brushWidth = 30;
                break;
        }
    }

}
