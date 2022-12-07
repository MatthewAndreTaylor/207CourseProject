package src.courseproject207.tree3d;

import src.courseproject207.VisualizationApplication;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

import java.util.Objects;

public class EvergreenTree3d extends Tree3d{
    private static final PhongMaterial evergreenLeafMaterial = new PhongMaterial(Color.valueOf("#0f2e07")
            , new Image(Objects.requireNonNull(VisualizationApplication.class.getResourceAsStream("leavesgrey.png"))),null,null,null);
    public EvergreenTree3d(){}
    public EvergreenTree3d(int x,int y, int z, int height) {
        this.components = new Box[4];
        // Create trunk
        this.components[0] = new Box(30, height, 30);
        this.components[0].setMaterial(trunkMaterial);
        this.components[0].translateXProperty().set(x);
        this.components[0].translateYProperty().set(y);
        this.components[0].translateZProperty().set(z);

        this.components[1] = new Box(150, 150, 150);
        this.components[1].setMaterial(evergreenLeafMaterial);
        this.components[1].translateXProperty().set(x);
        this.components[1].translateZProperty().set(z);
        this.components[1].translateYProperty().set(this.components[0].getTranslateY()-this.components[0].getHeight()/2);
        this.components[2] = new Box(100, 100, 100);
        this.components[2].setMaterial(evergreenLeafMaterial);
        this.components[2].translateXProperty().set(x);
        this.components[2].translateZProperty().set(z);
        this.components[2].translateYProperty().set(this.components[0].getTranslateY()-this.components[0].getHeight()/2-50);
        this.components[3] = new Box(50, 50, 50);
        this.components[3].setMaterial(evergreenLeafMaterial);
        this.components[3].translateXProperty().set(x);
        this.components[3].translateZProperty().set(z);
        this.components[3].translateYProperty().set(this.components[0].getTranslateY()-this.components[0].getHeight()/2-120);
    }

    @Override
    public Tree3d clone() {
        EvergreenTree3d clone = new EvergreenTree3d();
        clone.components = this.components.clone();
        return clone;
    }
}
