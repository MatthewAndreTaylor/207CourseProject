package src.courseproject207.tree3d;

import src.courseproject207.VisualizationApplication;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

import java.io.IOException;
import java.util.Objects;

public class FruitTree3d extends Tree3d{
    private Box[] components;
    public FruitTree3d(){}
    public FruitTree3d(int x,int y, int z, int width,int height, int length) {
        this.components = new Box[6];
        //create trunk
        this.components[0] = new Box(width/2, height, length/2);
        PhongMaterial trunkMaterial = new PhongMaterial();
        trunkMaterial.setDiffuseColor(Color.valueOf("#725C42"));

        this.components[0].setMaterial(trunkMaterial);
        this.components[0].translateXProperty().set(x);
        this.components[0].translateYProperty().set(y);
        this.components[0].translateZProperty().set(z);

        //get leaf material
        PhongMaterial leafMaterial = new PhongMaterial();
        leafMaterial.setDiffuseMap(new Image(Objects.requireNonNull(VisualizationApplication.class.getResourceAsStream("leavesgrey.png"))));
        leafMaterial.setDiffuseColor(Color.valueOf("#145c14"));


        double leafwidth = height/4;
        double leafheight = this.components[0].getHeight()/3;
        double leafdepth = this.components[0].getHeight()/2;
        //using variables above make boxes
        this.components[1]=this.makebox(x, (this.components[0].getTranslateY()-(this.components[0].getHeight()*1/5)),z,leafwidth,leafheight,leafdepth, leafMaterial);
        this.components[2]=this.makebox(x+leafwidth, (this.components[0].getTranslateY()-(this.components[0].getHeight()*1/5)),z,leafwidth,leafheight,leafdepth, leafMaterial);
        this.components[3]=this.makebox(x-leafwidth, (this.components[0].getTranslateY()-(this.components[0].getHeight()*1/5)),z,leafwidth,leafheight,leafdepth, leafMaterial);
        this.components[4]=this.makebox(x+(leafwidth/2), (this.components[0].getTranslateY()-(this.components[0].getHeight()*1/5))-leafheight,z,leafwidth,leafheight,leafdepth/2, leafMaterial);
        this.components[5]=this.makebox(x-(leafwidth/2), (this.components[0].getTranslateY()-(this.components[0].getHeight()*1/5))-leafheight,z,leafwidth,leafheight,leafdepth/2, leafMaterial);
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
    private Box makebox(double xpos,double ypos,double zpos, double xwidth, double yheight, double zdepth, PhongMaterial material) {
        Box B = new Box(xwidth, yheight, zdepth);
        B.setMaterial(material);
        B.translateXProperty().set(xpos);
        B.translateZProperty().set(zpos);
        B.translateYProperty().set(ypos);
        return B;
    }
}
