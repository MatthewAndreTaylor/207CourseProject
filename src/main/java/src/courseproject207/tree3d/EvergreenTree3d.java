package src.courseproject207.tree3d;

import src.courseproject207.VisualizationApplication;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

import java.util.Objects;

public class EvergreenTree3d extends Tree3d{

    private Box[] components;
    public EvergreenTree3d(){}

    public EvergreenTree3d(int x,int y, int z, int width,int height, int length) {
        this.components = new Box[7];
        // Create trunk
        this.components[0] = new Box(width/2, height, length/2);
        PhongMaterial trunkMaterial = new PhongMaterial();
        trunkMaterial.setDiffuseColor(Color.valueOf("#725C42"));

        this.components[0].setMaterial(trunkMaterial);
        this.components[0].translateXProperty().set(x);
        this.components[0].translateYProperty().set(y);
        this.components[0].translateZProperty().set(z);

        // Leaf Material
        PhongMaterial leafMaterial = new PhongMaterial();
        leafMaterial.setDiffuseMap(new Image(Objects.requireNonNull(VisualizationApplication.class.getResourceAsStream("leavesgrey.png"))));
        leafMaterial.setDiffuseColor(Color.valueOf("#145c14"));

        double leafWidth = height/6;
        double bottomTree = y+height/2-height/6;
        double leafHeight = this.components[0].getHeight()/3;
        double leafDepth = height/2;
        //need ratio to determine if leaf clips into trunk
        double ratio = java.lang.Math.max(width,length);
        if (height/ratio>0.1) {
            leafWidth = height/3;
            leafDepth = height;
        }
        // Create leaves

        this.components[1]=this.makeBox(x,bottomTree-leafWidth ,z,leafWidth,leafHeight,leafDepth, leafMaterial);
        this.components[2]=this.makeBox(x+leafWidth, bottomTree-leafWidth,z,leafWidth,leafHeight,leafDepth, leafMaterial);
        this.components[3]=this.makeBox(x-leafWidth, bottomTree-leafWidth,z,leafWidth,leafHeight,leafDepth, leafMaterial);
        this.components[4]=this.makeBox(x+(leafWidth/2), (bottomTree-leafWidth)-leafHeight,z,leafWidth,leafHeight,leafDepth*3/4, leafMaterial);
        this.components[5]=this.makeBox(x-(leafWidth/2), (bottomTree-leafWidth)-leafHeight,z,leafWidth,leafHeight,leafDepth*3/4, leafMaterial);
        this.components[6]=this.makeBox(x, (bottomTree-(leafWidth))-2*leafHeight,z,leafWidth,leafHeight,leafDepth/3, leafMaterial);
    }
    @Override
    public Node[] getComponents() {
        return this.components;
    }

    @Override
    public Tree3d clone() {
        EvergreenTree3d clone = new EvergreenTree3d();
        clone.components = this.components.clone();
        return clone;
    }
}
