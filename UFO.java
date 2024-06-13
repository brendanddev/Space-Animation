package brendansStarfield;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class UFO extends NightObject {

    private double height;
    private double width;
    private double radius;

    public UFO(double x, double y, double height, double width, double radius) {
        super(x, y);
        this.height = height;
        this.width = width;
        this.radius = radius;
    }

    public void draw(GraphicsContext gc) {
        // Dome of the UFO
        gc.setFill(Color.SILVER);
        gc.fillOval(getX() - radius, getY() + height / 2 - radius / 2, radius * 2, radius);
        gc.setStroke(Color.WHITE);
        gc.setLineWidth(2);
        gc.strokeOval(getX() - radius, getY() + height / 2 - radius / 2, radius * 2, radius);
        gc.setStroke(Color.BLACK);
        gc.strokeLine(getX() - radius, getY() + 25, getX() + radius, getY() + 25);

        // UFO Body
        gc.setFill(Color.GREEN);
        gc.fillOval(getX() - width * 1.2 / 2, getY() - height * 1.2 / 4, width * 1.2, height * 1.2 / 2);

        // UFO Lights
        gc.setFill(Color.YELLOW);
        double ufoLightRadius = height / 8;
        for (int i = 0; i < 8; i++) {
            double lightAngle = 2 * Math.PI * i / 8;
            double lightPosX = getX() + (width / 2 - ufoLightRadius) * Math.cos(lightAngle);
            double lightPosY = getY() - (height / 4) * Math.sin(lightAngle);
            gc.fillOval(lightPosX - ufoLightRadius / 2, lightPosY - ufoLightRadius / 2, ufoLightRadius, ufoLightRadius);
        }
    }

    public void fly(double amount) {
        double xPos = getX();
        double yPos = getY();
        xPos = xPos - amount;
        yPos = yPos - amount / 2;
        setX(xPos);
        setY(yPos);
    }

    public void flyLeft(double amount) {
        double xPos = getX();
        double yPos = getY();
        double displayHeight = 1000;

        xPos = xPos + amount;

        if (yPos < displayHeight - height) {
            yPos = yPos + amount / 2;
        } else {
            yPos = yPos - amount / 2;
        }
        setX(xPos);
        setY(yPos);
    }
}
