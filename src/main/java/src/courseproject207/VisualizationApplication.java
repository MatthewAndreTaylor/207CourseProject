package src.courseproject207;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

import java.io.IOException;

public class VisualizationApplication extends Application {

    protected static final int WIDTH = 1000;
    protected static final int HEIGHT = 800;

    @Override
    public void start(Stage stage) throws IOException {

        MovableCamera camera = new MovableCamera();

        View view = new View(WIDTH/2, HEIGHT/2);
        Scene scene = new Scene(view, WIDTH, HEIGHT);
        scene.setCamera(camera);
        scene.setFill(Color.SKYBLUE);
        stage.setTitle("Forest Visualization");
        stage.setScene(scene);

        // Basic key input camera movement
        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case A -> camera.rotate(5, Rotate.Y_AXIS);
                case D -> camera.rotate(-5, Rotate.Y_AXIS);
                case S -> camera.rotate(-5, Rotate.X_AXIS);
                case W -> camera.rotate(5, Rotate.X_AXIS);
                case UP -> camera.translateZProperty().set(camera.getTranslateZ() + 100);
                case DOWN -> camera.translateZProperty().set(camera.getTranslateZ() - 100);
                case RIGHT -> camera.translateXProperty().set(camera.getTranslateX() + 100);
                case LEFT -> camera.translateXProperty().set(camera.getTranslateX() - 100);
            }
        });
        stage.show();

        Forest f= new Forest();
    }

    class MovableCamera extends PerspectiveCamera {
        private Rotate rotation;
        private Transform transform;

        public MovableCamera()
        {
            this.transform = new Rotate();
        }
        public void rotate(int ang, Point3D axis) {
            this.rotation = new Rotate(ang, axis);
            this.transform = this.transform.createConcatenation(this.rotation);
            this.getTransforms().clear();
            this.getTransforms().addAll(this.transform);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
