package brendansStarfield;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Spaceship extends NightObject {

    private Color color;
    private double height;
    private double width;

    public Spaceship(double x, double y, Color color, double width, double height) {
        super(x, y);
        this.color = color;
        this.height = height;
        this.width = width;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        // Spaceship body
        gc.fillRect(getX() - width / 4, getY() - height / 2, width / 2, height / 2);

        // Spaceship first wing
        gc.fillPolygon(
                new double[]{getX() - width / 4, getX() - width / 2, getX() - width / 4},
                new double[]{getY() - height / 2, getY(), getY() + height / 2}, 3
        );

        // Spaceship second wing
        gc.fillPolygon(
                new double[]{getX() + width / 4, getX() + width / 2, getX() + width / 4},
                new double[]{getY() - height / 2, getY(), getY() + height / 2}, 3
        );

        // Top of spaceship
        gc.fillPolygon(
                new double[]{getX() - width / 4, getX(), getX() + width / 4},
                new double[]{getY() - height / 2, getY() - height, getY() - height / 2},
                3
        );
        // Spaceship window
        gc.setFill(Color.WHITE);
        double window = width / 6;
        gc.fillOval(getX() - window, getY() - height / 4 - window, window * 2, window * 2);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void travel(double amount) {
        double yPos = getY();
        yPos = yPos - amount;
        setY(yPos);
    }
}

