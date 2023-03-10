package comp208.msherwood;

import android.graphics.Path;

public class ColouredPath extends android.graphics.Path {

    public int color;

    public int strokeWidth;

    public Path linePath;

    public ColouredPath(int color, int strokeWidth, Path linePath) {
        this.color = color;
        this.strokeWidth = strokeWidth;
        this.linePath = linePath;
    }
}
