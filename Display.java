package brendansStarfield;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Display {
    private Star[] stars;
    private Spaceship spaceshipOne;
    private Spaceship spaceshipTwo;
    private Spaceship spaceshipThree;
    private Moon moon;
    private UFO ufo;
    private UFO ufoTwo;
    private int displayWidth;
    private int displayHeight;

    public Display(int x, int y, int numOfStars) {
        displayWidth = x;
        displayHeight = y;

        stars = new Star[numOfStars];
        for (int i = 0; i < numOfStars; i++) {
            int starsX = (int)(Math.random() * displayWidth);
            int starsY = (int)(Math.random() * displayHeight);
            int cNum = (int)(Math.random() * 256);
            stars[i] = new Star(starsX, starsY, Color.rgb(cNum, cNum, cNum));
        }
        spaceshipOne = new Spaceship(450, y, Color.SILVER, 50, 100);
        spaceshipTwo = new Spaceship(650, y, Color.SILVER, 50, 100);
        spaceshipThree = new Spaceship(850, y, Color.SILVER, 50, 100);
        moon = new Moon(100, 120, Color.WHITE, 50);
        ufo = new UFO(1300, 500, 50, 50, 50);
        ufoTwo = new UFO(0, 500, 50, 50, 50);
    }

    public void scroll() {
        for (Star star : stars) {
            star.scroll(displayWidth);
        }
    }

    public void draw(GraphicsContext gc) {
        for(Star star : stars) {
            star.draw(gc);
        }
        spaceshipOne.draw(gc);
        spaceshipTwo.draw(gc);
        spaceshipThree.draw(gc);
        moon.draw(gc);
        ufo.draw(gc);
        ufoTwo.draw(gc);
    }

    public void twinkle() {
        int randNum = (int)(Math.random() * 256);
        int randomStar = (int)(Math.random() * stars.length);
        stars[randomStar].setColor(Color.rgb(randNum, randNum, randNum));
    }

    public void moveSpaceship(double x) {
        spaceshipOne.travel(x);
        spaceshipTwo.travel(x);
        spaceshipThree.travel(x);
    }

    public Spaceship getSpaceshipOne() {
        return spaceshipOne;
    }

    public Spaceship getSpaceshipTwo() {
        return spaceshipTwo;
    }

    public Spaceship getSpaceshipThree() {
        return spaceshipThree;
    }

    public UFO getUfo() {
        return ufo;
    }

    public UFO getUfoTwo() {
        return ufoTwo;
    }

}
