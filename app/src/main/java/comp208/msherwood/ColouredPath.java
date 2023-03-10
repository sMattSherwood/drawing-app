package comp208.msherwood;

import android.graphics.Path;

public class ColouredPath extends android.graphics.Path {

    public int color; // color that will be associated with the line

    public int strokeWidth; // width that will be associated with the line

    public Path linePath; // the line that will be drawn

    // default constructor that will be used in the Drawer class to assocate values to the lines
    public ColouredPath(int color, int strokeWidth, Path linePath) {
        this.color = color;
        this.strokeWidth = strokeWidth;
        this.linePath = linePath;
    }
}
