import processing.core.*;

public class Main_graphical extends PApplet {
    private final int RAD = 250;

    public void settings() {
        size(500, 500);
    }

    private void shape (int n, float x, float y, float rad){
        if (n == 0) { return; }

        ellipse(x, y, rad, rad);
        shape(n - 1, x - rad / 2, y, rad / 2);
        shape(n - 1, x + rad / 2, y, rad / 2);
    }

    @Override
    public void setup() {
        background(64);
        fill(64,0);
        stroke(255);
        shape(10, 250, 250, RAD);
    }

    public static void main(String[] args) {
        PApplet.main(new String[] { "Main_graphical" });
    }
}