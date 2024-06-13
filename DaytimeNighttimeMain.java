package brendansStarfield;

/**
 * @author BRENDAN DILEO, @drendos
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DaytimeNighttimeMain extends Application {

    // Display screen sizes
    static final int DISPLAY_WIDTH = 1200; // Width of display
    static final int DISPLAY_HEIGHT = 1000; // Height of display

    /**
     * Stage setup and main thread
     *
     * @param stage The primary stage
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Space!"); // Title of the window
        Canvas canvas = new Canvas(DISPLAY_WIDTH, DISPLAY_HEIGHT); // Size of canvas based on display sizes
        Group root = new Group();
        Scene scene = new Scene(root);
        root.getChildren().add(canvas);
        stage.setScene(scene);
        stage.show();
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Starts thread responsible for executing animation
        Thread t = new Thread(() -> animate(gc));
        t.start();
    }

    /**
     * Animation thread.
     * All of my code responsible for executing the animations are here.
     *
     * @param gc The surface drawn on.
     */
    public void animate(GraphicsContext gc) {

        // New instance of the Display
        Display display = new Display(DISPLAY_WIDTH, DISPLAY_HEIGHT, 2000);

        long startTime = System.currentTimeMillis();


        while (true) {
            display.scroll(); // Scroll method
            display.twinkle(); // Twinkle method
            display.getUfo().fly(1); // Method for the UFO flying
            display.getUfoTwo().flyLeft(1);

            Platform.runLater(() -> {
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, DISPLAY_WIDTH, DISPLAY_HEIGHT);
                display.draw(gc);
            });
            pause(10);

            long timeElapsed = System.currentTimeMillis() - startTime;

            if (timeElapsed > 0) {
                display.getSpaceshipOne().travel(1);
            }
            if (timeElapsed > 2500) {
                display.getSpaceshipTwo().travel(1);
            }
            if (timeElapsed > 5500) {
                display.getSpaceshipThree().travel(1);
            }
        }
    }

    /**
     *
     * @param duration Pause time in milliseconds.
     */
    public static void pause(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
        }
    }

    /**
     *
     */
    @Override
    public void stop() {
        System.exit(0);
    }

    /**
     * Launches the app
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}


