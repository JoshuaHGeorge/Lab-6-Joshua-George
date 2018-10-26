/*\
|*|       \\  Joshua George  //
|*|        ))===============((
|*|       //    200416927    \\
\*/

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DrawLinesViewController implements Initializable {

    @FXML
    private Canvas canvas;

    @FXML
    private ImageView lPatternImageView;

    @FXML
    private ImageView footballPatternImageView;

    @FXML
    private ImageView threeQuartersImageView;

    @FXML
    private ImageView fullImageView;

    // set a variable for the number of lines you want to draw
    private static int lines = 40;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lPatternImageView.setImage(new Image("L-pattern.png"));
        footballPatternImageView.setImage(new Image("footballPattern.png"));
        threeQuartersImageView.setImage(new Image("3Quarters.png"));
        fullImageView.setImage(new Image("full.png"));
    }

    // reference maths for coordinates

    // code to move down on y axis
    // (canvas.getHeight()/lines)*i

    // code to move up along y axis
    // (canvas.getHeight() - (canvas.getHeight()/lines)*i

    // code to move right on x axis
    // (canvas.getWidth()/lines)*i

    // code to move left along x axis
    // (canvas.getWidth() - (canvas.getWidth()/lines)*i


    @FXML
    public void drawXButtonPressed()
    {
        //get the GraphicsContent, which is used to draw on the canvas
        GraphicsContext gc = clearCanvasAndGetGraphicsContext();

        //draw line from top corner to bottom corner
        gc.strokeLine(
                0,
                0,
                canvas.getWidth(),
                canvas.getHeight()
        );

        //draw line from bottom left corner to upper right corner
        gc.strokeLine(
                0,
                canvas.getHeight(),
                canvas.getWidth(),
                0
        );
    }

    @FXML
    public void drawLPatternButtonPressed()
    {
        //get the GraphicsContent, which is used to draw on the canvas
        GraphicsContext gc = clearCanvasAndGetGraphicsContext();

        // loop to draw lines for each number of lines
        for(int i = 0; i <= lines; i++) {

            // draw L shape in bottom left
            gc.strokeLine(
                    0,
                    (canvas.getHeight()/lines)*i,
                    (canvas.getWidth()/lines)*i,
                    canvas.getHeight()
            );

        }
    }

    @FXML
    public void footballPatternButtonPressed()
    {
        //get the GraphicsContent, which is used to draw on the canvas
        GraphicsContext gc = clearCanvasAndGetGraphicsContext();

        // loop to draw lines for each number of lines
        for(int i = 0; i <= lines; i++) {

            // draw L shape in bottom left
            gc.strokeLine(
                    0,
                    (canvas.getHeight()/lines)*i,
                    (canvas.getWidth()/lines)*i,
                    canvas.getHeight()
            );

            // draw L shape in top right
            gc.strokeLine(
                    (canvas.getWidth()/lines)*i,
                    0,
                    canvas.getWidth(),
                    (canvas.getHeight()/lines)*i
            );
        }
    }

    @FXML
    public void threeQuartersPatternButtonPressed()
    {
        //get the GraphicsContent, which is used to draw on the canvas
        GraphicsContext gc = clearCanvasAndGetGraphicsContext();

        // loop to draw lines for each number of lines
        for(int i = 0; i <= lines; i++) {

            // draw L shape in bottom left
            gc.strokeLine(
                    0,
                    (canvas.getHeight()/lines)*i,
                    (canvas.getWidth()/lines)*i,
                    canvas.getHeight()
            );

            // draw L shape in top right
            gc.strokeLine(
                    (canvas.getWidth()/lines)*i,
                    0,
                    canvas.getWidth(),
                    (canvas.getHeight()/lines)*i
            );

            // draw L shape in bottom right
            gc.strokeLine(
                    (canvas.getWidth()/lines)*i,
                    canvas.getHeight(),
                    canvas.getWidth(),
                    canvas.getHeight() - (canvas.getHeight()/lines)*i
            );
        }
    }

    @FXML
    public void fullPatternButtonPressed()
    {
        //get the GraphicsContent, which is used to draw on the canvas
        GraphicsContext gc = clearCanvasAndGetGraphicsContext();


        // loop to draw lines for each number of lines
        for(int i = 0; i <= lines; i++) {

            // draw L shape in bottom left
            gc.strokeLine(
                    0,
                    (canvas.getHeight()/lines)*i,
                    (canvas.getWidth()/lines)*i,
                    canvas.getHeight()
            );

            // draw L shape in top right
            gc.strokeLine(
                    (canvas.getWidth()/lines)*i,
                    0,
                    canvas.getWidth(),
                    (canvas.getHeight()/lines)*i
            );

            // draw L shape in bottom right
            gc.strokeLine(
                    (canvas.getWidth()/lines)*i,
                    canvas.getHeight(),
                    canvas.getWidth(),
                    canvas.getHeight() - (canvas.getHeight()/lines)*i
            );

            // draw L shape in top left
            gc.strokeLine(
                    (canvas.getWidth()/lines)*i,
                    0,
                    0,
                    canvas.getHeight() - (canvas.getHeight()/lines)*i
            );
        }
    }

    public GraphicsContext clearCanvasAndGetGraphicsContext()
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //clear the canvas
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        return gc;
    }
}
