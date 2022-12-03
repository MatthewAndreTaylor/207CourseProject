package src.courseproject207.tree3d;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import src.courseproject207.VisualizationApplication;

import java.io.IOException;
import java.util.Objects;

public class CommonTree3d extends Tree3d {

    private Box[] components;

    public CommonTree3d(){}

    public CommonTree3d(int x,int y, int z, int width,int height, int length){
        this.components = new Box[7];

        this.components[0] = new Box(width, height, length);
        PhongMaterial trunkMaterial = new PhongMaterial();
        trunkMaterial.setDiffuseColor(Color.valueOf("#725C42"));

        this.components[0].setMaterial(trunkMaterial);
        this.components[0].translateXProperty().set(x);
        this.components[0].translateYProperty().set(y);
        this.components[0].translateZProperty().set(z);

        PhongMaterial leafMaterial = new PhongMaterial();

        leafMaterial.setDiffuseColor(Color.valueOf("#228B22"));

        // Set the Image of the leaves
        leafMaterial.setDiffuseMap(new Image(Objects.requireNonNull(VisualizationApplication.class.getResourceAsStream("leaves.png"))));

        for (int i = 1; i < 7; i++)
        {
            this.components[i] = new Box(120, 120, 120);
            this.components[i].setMaterial(leafMaterial);
            this.components[i].translateXProperty().set(x);
            this.components[i].translateZProperty().set(z);
            this.components[i].translateYProperty().set(this.components[0].getTranslateY()-this.components[0].getHeight()/2);
        }
    }

    @Override
    public Node[] getComponents() {
        return this.components;
    }

    @Override
    public Tree3d clone() {
        CommonTree3d clone = new CommonTree3d();
        clone.components = this.components.clone();
        return clone;
    }
}
