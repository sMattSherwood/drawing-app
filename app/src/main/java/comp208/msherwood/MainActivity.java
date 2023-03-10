package comp208.msherwood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Drawer lines;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lines = findViewById(R.id.drawer);

        // these buttons will change the colour of the lines
        ImageButton redButton = (ImageButton) findViewById(R.id.Red);
        ImageButton yellowButton = (ImageButton) findViewById(R.id.Yellow);
        ImageButton greenButton = (ImageButton) findViewById(R.id.Green);
        ImageButton lightBlueButton = (ImageButton) findViewById(R.id.LightBlue);
        ImageButton blueButton = (ImageButton) findViewById(R.id.Blue);
        ImageButton blackButton = (ImageButton) findViewById(R.id.Black);
        ImageButton whiteButton = (ImageButton) findViewById(R.id.White);
        // on click of button uses the set Drawing color to change the color of the line
            View.OnClickListener red = (view)-> {
                lines.setDrawingColor(1);
            };

            View.OnClickListener yellow = (view)-> {
                lines.setDrawingColor(2);
            };

            View.OnClickListener green = (view)-> {
                lines.setDrawingColor(3);
            };

            View.OnClickListener lightBlue = (view)-> {
                lines.setDrawingColor(4);
            };

            View.OnClickListener blue = (view)-> {
                lines.setDrawingColor(5);
            };

            View.OnClickListener black = (view)-> {
                lines.setDrawingColor(6);
            };

            View.OnClickListener white = (view)-> {
                lines.setDrawingColor(7);
            };

        // these buttons will change the width of the brushes based off the button
        ImageButton pencilButton = (ImageButton) findViewById(R.id.Pencil);
        ImageButton markerButton = (ImageButton) findViewById(R.id.Marker);
        ImageButton paintButton = (ImageButton) findViewById(R.id.PaintBrush);
        // on click of button will change the width of lines
            View.OnClickListener pencil = (view)-> {
                lines.setDrawingStyle(1);
            };

            View.OnClickListener marker = (view)-> {
                lines.setDrawingStyle(2);
            };

            View.OnClickListener paint = (view)-> {
                lines.setDrawingStyle(3);
            };

        // this button will clear the screen of all lines
        Button clearButton = (Button) findViewById(R.id.Clear);
        // when user clicks button it will remove all lines
            View.OnClickListener clear = (view)-> {
                lines.empty();
            };

        View.OnTouchListener listener = (view, event) ->{
            int action = event.getActionMasked();

            switch (action) {
                // action down stores the inital x an y values when user put's finger on screen
                case (MotionEvent.ACTION_DOWN):
                    lines.begin(event.getX(), event.getY());
                    break;
                // ACTION UP is when user takes their finger off of the screen
                case (MotionEvent.ACTION_UP):
                    view.performClick();
                    break;
                case (MotionEvent.ACTION_MOVE):
                    lines.addPoint(event.getX(), event.getY());
                    break;

            }
            return true; // function needs return this true does nothing
        };
    // these are the colour onclick listeners
        redButton.setOnClickListener(red);
        yellowButton.setOnClickListener(yellow);
        greenButton.setOnClickListener(green);
        lightBlueButton.setOnClickListener(lightBlue);
        blueButton.setOnClickListener(blue);
        blackButton.setOnClickListener(black);
        whiteButton.setOnClickListener(white);

    // these are the widths of the lines onclick listeners
        pencilButton.setOnClickListener(pencil);
        markerButton.setOnClickListener(marker);
        paintButton.setOnClickListener(paint);

    // clear button onclick listeners
        clearButton.setOnClickListener(clear);

    // arraylist lines onclick listener
        lines.setOnTouchListener(listener);

    }
}