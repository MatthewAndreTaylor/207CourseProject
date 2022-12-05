package src.courseproject207.tree3d;

import src.courseproject207.VisualizationApplication;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

import java.util.Objects;

public class FruitTree3d extends Tree3d{
    private static final PhongMaterial fruitLeafMaterial = new PhongMaterial(Color.valueOf("#145c14")
            , new Image(Objects.requireNonNull(VisualizationApplication.class.getResourceAsStream("leavesgrey.png"))),null,null,null);
    private static final PhongMaterial fruitMaterial = new PhongMaterial(Color.valueOf("#ffe135"));
    private Box[] components;
    public FruitTree3d(){}
    public FruitTree3d(int x,int y, int z,int height) {
        this.components = new Box[4];
        // Create trunk
        this.components[0] = new Box(25, height, 25);
        this.components[0].setMaterial(trunkMaterial);
        this.components[0].translateXProperty().set(x);
        this.components[0].translateYProperty().set(y);
        this.components[0].translateZProperty().set(z);

        // Leaves
        this.components[1] = new Box(120, 120, 120);
        this.components[1].setMaterial(fruitLeafMaterial);
        this.components[1].translateXProperty().set(x);
        this.components[1].translateZProperty().set(z);
        this.components[1].translateYProperty().set(this.components[0].getTranslateY()-this.components[0].getHeight()/2);
        this.components[2] = new Box(20,20,20);
        this.components[2].setMaterial(fruitMaterial);
        this.components[2].translateXProperty().set(x-60);
        this.components[2].translateZProperty().set(z-60);
        this.components[2].translateYProperty().set(this.components[0].getTranslateY()-this.components[0].getHeight()/2-20);
        this.components[3] = new Box(20,20,20);
        this.components[3].setMaterial(fruitMaterial);
        this.components[3].translateXProperty().set(x+60);
        this.components[3].translateZProperty().set(z+60);
        this.components[3].translateYProperty().set(this.components[0].getTranslateY()-this.components[0].getHeight()/2);
    }
    @Override
    public Node[] getComponents() {
        return this.components;
    }

    @Override
    public Tree3d clone() {
        FruitTree3d clone = new FruitTree3d();
        clone.components = this.components.clone();
        return clone;
    }
}
