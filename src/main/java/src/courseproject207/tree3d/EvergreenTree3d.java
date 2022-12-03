package src.courseproject207.tree3d;

import src.courseproject207.VisualizationApplication;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

import java.io.IOException;
import java.util.Objects;

public class EvergreenTree3d extends Tree3d{

    private Box[] components;
    public EvergreenTree3d(){}

    public EvergreenTree3d(int x,int y, int z, int width,int height, int length) {
        this.components = new Box[7];
        //create trunk
        this.components[0] = new Box(width/2, height, length/2);
        PhongMaterial trunkMaterial = new PhongMaterial();
        trunkMaterial.setDiffuseColor(Color.valueOf("#725C42"));

        this.components[0].setMaterial(trunkMaterial);
        this.components[0].translateXProperty().set(x);
        this.components[0].translateYProperty().set(y);
        this.components[0].translateZProperty().set(z);

        PhongMaterial leafMaterial = new PhongMaterial();
        leafMaterial.setDiffuseMap(new Image(Objects.requireNonNull(VisualizationApplication.class.getResourceAsStream("leavesgrey.png"))));
        leafMaterial.setDiffuseColor(Color.valueOf("#145c14"));


        double leafwidth = height/6;
        double bottomoftree = y+height/2-height/6;
        double leafheight = this.components[0].getHeight()/3;//100*java.lang.Math.exp(-this.components[0].getHeight()/370);
        double leafdepth = height/2;
        //using varibales above, makes leaves
        this.components[1]=this.makebox(x,bottomoftree-height/6 ,z,leafwidth,leafheight,leafdepth, leafMaterial);
        this.components[2]=this.makebox(x+leafwidth, bottomoftree-height/6,z,leafwidth,leafheight,leafdepth, leafMaterial);
        this.components[3]=this.makebox(x-leafwidth, bottomoftree-(height*1/6),z,leafwidth,leafheight,leafdepth, leafMaterial);
        this.components[4]=this.makebox(x+(leafwidth/2), (bottomoftree-(height*1/6))-leafheight,z,leafwidth,leafheight,leafdepth*3/4, leafMaterial);
        this.components[5]=this.makebox(x-(leafwidth/2), (bottomoftree-(height*1/6))-leafheight,z,leafwidth,leafheight,leafdepth*3/4, leafMaterial);
        this.components[6]=this.makebox(x, (bottomoftree-(height*1/6))-2*leafheight,z,leafwidth,leafheight,leafdepth/3, leafMaterial);
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
    //make box object with parameters
    private Box makebox(double xpos,double ypos,double zpos, double xwidth, double yheight, double zdepth, PhongMaterial material) {
        Box B = new Box(xwidth, yheight, zdepth);
        B.setMaterial(material);
        B.translateXProperty().set(xpos);
        B.translateZProperty().set(zpos);
        B.translateYProperty().set(ypos);
        return B;
    }
}
