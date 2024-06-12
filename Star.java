package brendansStarfield;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Star extends NightObject {

    private Color color;

    public Star(double x, double y, Color color) {
        super(x, y);
        this.color = color;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(getX(), getY(), 3, 3);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void scroll(int max) {
        double xPos = getX();
        xPos++;
        if (xPos > max) {
            xPos = 0;
        }
        setX(xPos);
    }
}
