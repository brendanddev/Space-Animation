package brendansStarfield;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Sun extends DayObject {

    private Color color;
    private double radius;

    public Sun(double x, double y, Color color, double radius) {
        super(x, y);
        this.color = color;
        this.radius = radius;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(getX(), getY(), radius, radius);
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
