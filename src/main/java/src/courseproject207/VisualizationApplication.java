package src.courseproject207;

import javafx.application.Application;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import src.courseproject207.components.*;
import src.courseproject207.helpers.Vector2;

import java.util.Objects;

public class VisualizationApplication extends Application {

    protected static final int WIDTH = 1000;
    protected static final int HEIGHT = 800;
    protected Vector2 scenePos = new Vector2();
    protected Vector2 backupPos;
    protected Vector2 dragAmount;

    @Override
    public void start(Stage stage) {
        MovableCamera camera = new MovableCamera();
        World3d world3D = new World3d(WIDTH/2, HEIGHT/2);
        SubScene subScene = new SubScene(world3D, WIDTH, HEIGHT, true, SceneAntialiasing.BALANCED);
        subScene.setFill(Color.SKYBLUE);
        subScene.setCamera(camera);

        ComponentView componentView = new ComponentView(world3D);
        VBox vbox = new VBox(componentView, subScene);
        Scene scene = new Scene(vbox, WIDTH, HEIGHT);
        stage.setTitle("Forest Visualization");
        stage.setScene(scene);

        scene.setOnMousePressed( mouseEvent -> {
            scenePos.setX(mouseEvent.getSceneX());
            scenePos.setY(mouseEvent.getSceneY());
        });

        scene.setOnMouseDragged( mouseEvent -> {
            // Backup the originals
            backupPos = scenePos.copy();

            // Find the end of the drag
            scenePos.setX(mouseEvent.getSceneX());
            scenePos.setY(mouseEvent.getSceneY());

            // Take the difference of the two vectors
            dragAmount = scenePos.difference(backupPos);
            if (mouseEvent.isPrimaryButtonDown()) {
                camera.planeXY();
            }
            else if (mouseEvent.isSecondaryButtonDown() ) {
                camera.orbit();
            }
        });

        scene.setOnScroll( scrollEvent -> camera.setTranslateZ(scrollEvent.getDeltaY() + camera.getTranslateZ()));
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case SHIFT -> camera.setOrientation(0,0,0,0,0);
                case ALT -> System.out.println(camera.printOrientation());
            }
        });

        stage.getIcons().add(new Image(Objects.requireNonNull(VisualizationApplication.class.getResourceAsStream("icon.png"))));
        stage.show();
    }

    class MovableCamera extends PerspectiveCamera {
        private final Translate plane = new Translate(0, 0, 0);
        private final Rotate xRotation = new Rotate(0, Rotate.X_AXIS);
        private final Rotate yRotation = new Rotate(0, Rotate.Y_AXIS);

        private final double dampening = 0.25;

        public MovableCamera()
        {
            this.getTransforms().addAll(plane, yRotation, xRotation);
        }

        /**
         * Orbit the camera given the last rotations and new drag
         */
        public void orbit()
        {
            this.xRotation.setAngle((xRotation.getAngle() - dragAmount.getY()*dampening % 360));
            this.yRotation.setAngle((yRotation.getAngle() + dragAmount.getX()*dampening % 360));
        }

        /**
         * Move the camera in the XY plane
         */
        public void planeXY()
        {
            this.plane.setX(this.plane.getX() - dragAmount.getX() * 10 * dampening);
            this.plane.setY(this.plane.getY() - dragAmount.getY() * 10 * dampening);
        }

        /**
         * Given a position and rotation move and adjust the camera
         * @param x location
         * @param y location
         * @param z location
         * @param xAngle rotation
         * @param yAngle rotation
         */
        public void setOrientation(double x, double y, double z, double xAngle, double yAngle){
            this.plane.setX(x);
            this.plane.setY(y);
            this.plane.setY(z);
            this.xRotation.setAngle(xAngle);
            this.xRotation.setAngle(yAngle);
        }

        /**
         * @return String representation of the camera's location and rotation
         */
        public String printOrientation()
        {
            return plane.getX() + ", " + plane.getY() + ", " + plane.getZ() + ", "
                    + xRotation.getAngle() + ", " + yRotation.getAngle();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
