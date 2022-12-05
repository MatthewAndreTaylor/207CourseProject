package src.courseproject207.tree3d;

import src.courseproject207.VisualizationApplication;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

import java.util.Objects;

public class NorthAmericanTree3d extends Tree3d{
    private static final PhongMaterial northLeafMaterial = new PhongMaterial(Color.valueOf("#235416")
            , new Image(Objects.requireNonNull(VisualizationApplication.class.getResourceAsStream("leavesgrey.png"))),null,null,null);
    private Box[] components;
    public NorthAmericanTree3d(){}
    public NorthAmericanTree3d(int x,int y, int z, int height) {
        this.components = new Box[3];
        // Create trunk
        this.components[0] = new Box(30, height, 30);

        this.components[0].setMaterial(trunkMaterial);
        this.components[0].translateXProperty().set(x);
        this.components[0].translateYProperty().set(y);
        this.components[0].translateZProperty().set(z);

        // Leaves
        this.components[1] = new Box(120, 120, 120);
        this.components[1].setMaterial(northLeafMaterial);
        this.components[1].translateXProperty().set(x);
        this.components[1].translateZProperty().set(z);
        this.components[1].translateYProperty().set(this.components[0].getTranslateY()-this.components[0].getHeight()/2);
        this.components[2] = new Box(120, 120, 120);
        this.components[2].setMaterial(northLeafMaterial);
        this.components[2].translateXProperty().set(x);
        this.components[2].translateZProperty().set(z);
        this.components[2].translateYProperty().set(this.components[0].getTranslateY()-this.components[0].getHeight()/2-100);
    }
    @Override
    public Node[] getComponents() {
        return this.components;
    }

    @Override
    public Tree3d clone() {
        NorthAmericanTree3d clone = new NorthAmericanTree3d();
        clone.components = this.components.clone();
        return clone;
    }
}
