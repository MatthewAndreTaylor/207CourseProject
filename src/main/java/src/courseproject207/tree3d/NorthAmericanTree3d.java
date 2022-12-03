package src.courseproject207.tree3d;

import src.courseproject207.VisualizationApplication;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

import java.io.IOException;
import java.util.Objects;

public class NorthAmericanTree3d extends Tree3d{
    private Box[] components;
    public NorthAmericanTree3d(){}
    public NorthAmericanTree3d(int x,int y, int z, int width,int height, int length) {
        this.components = new Box[2];
        //create trunk
        this.components[0] = new Box(width, height, length);
        PhongMaterial trunkMaterial = new PhongMaterial();
        trunkMaterial.setDiffuseColor(Color.valueOf("#725C42"));

        this.components[0].setMaterial(trunkMaterial);
        this.components[0].translateXProperty().set(x);
        this.components[0].translateYProperty().set(y);
        this.components[0].translateZProperty().set(z);

        //get leaf material
        PhongMaterial leafMaterial = new PhongMaterial();
        leafMaterial.setDiffuseMap(new Image(Objects.requireNonNull(VisualizationApplication.class.getResourceAsStream("leavesgrey.png"))));
        leafMaterial.setDiffuseColor(Color.valueOf("#1d590e"));
        //make box
        this.components[1]=makebox(x,y-height/4,z,height/2,height,height/2,leafMaterial);

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

    private Box makebox(double xpos,double ypos,double zpos, double xwidth, double yheight, double zdepth, PhongMaterial material) {
        Box B = new Box(xwidth, yheight, zdepth);
        B.setMaterial(material);
        B.translateXProperty().set(xpos);
        B.translateZProperty().set(zpos);
        B.translateYProperty().set(ypos);
        return B;
    }
}
