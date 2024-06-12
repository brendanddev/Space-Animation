package brendansStarfield;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Moon extends NightObject {

    private Color color;
    private double radius;

    public Moon(double x, double y, Color color, double radius) {
        super(x, y);
        this.color = color;
        this.radius = radius;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(getX() - radius, getY() - radius, radius * 2, radius * 2);
        gc.setFill(Color.BLACK);
        gc.fillOval(getX() - radius * 0.6, getY() - radius, radius * 2, radius * 2);
        // gc.fillArc(getX(), getY(), 150, 150, 90, 180, ArcType.ROUND); // Initial attempt at Moon

    }

    public void setColor(Color color) {
        this.color = color;
    }
}
