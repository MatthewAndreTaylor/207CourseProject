package src.courseproject207.tree3d;

import src.courseproject207.VisualizationApplication;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

import java.io.IOException;

public class FruitTree3d extends Tree3d{
    private Box[] components;
    public FruitTree3d(){}
    public FruitTree3d(int x,int y, int z, int width,int height, int length) {
        this.components = new Box[6];

        this.components[0] = new Box(width/2, height, length/2);
        PhongMaterial trunkMaterial = new PhongMaterial();
        trunkMaterial.setDiffuseColor(Color.valueOf("#725C42"));

        this.components[0].setMaterial(trunkMaterial);
        this.components[0].translateXProperty().set(x);
        this.components[0].translateYProperty().set(y);
        this.components[0].translateZProperty().set(z);

        PhongMaterial leafMaterial = new PhongMaterial();
        Image leafImage=null;
        try{
            leafImage = new Image(VisualizationApplication.class.getResource("leaves.png").openStream());
        }catch (IOException e){}

        leafMaterial.setDiffuseColor(Color.valueOf("#145c14"));
        leafMaterial.setDiffuseMap(leafImage);

        //for (int i = 1; i < 2; i++)
        //{
        //this.components[i] = new Box(120, 120, 120);
        //this.components[i].setMaterial(leafMaterial);
        //this.components[i].translateXProperty().set(x);
        //this.components[i].translateZProperty().set(z);
        //this.components[i].translateYProperty().set(this.components[0].getTranslateY()-this.components[0].getHeight()/2);
        //}
        double leafwidth = height/4;
        double leafheight = this.components[0].getHeight()/3;
        double leafdepth = this.components[0].getHeight()/2;
        double newz= z;
        this.components[1]=this.makebox(x, (this.components[0].getTranslateY()-(this.components[0].getHeight()*1/5)),newz,leafwidth,leafheight,leafdepth, leafMaterial);
        this.components[2]=this.makebox(x+leafwidth, (this.components[0].getTranslateY()-(this.components[0].getHeight()*1/5)),newz,leafwidth,leafheight,leafdepth, leafMaterial);
        this.components[3]=this.makebox(x-leafwidth, (this.components[0].getTranslateY()-(this.components[0].getHeight()*1/5)),newz,leafwidth,leafheight,leafdepth, leafMaterial);
        this.components[4]=this.makebox(x+(leafwidth/2), (this.components[0].getTranslateY()-(this.components[0].getHeight()*1/5))-leafheight,newz,leafwidth,leafheight,leafdepth/2, leafMaterial);
        this.components[5]=this.makebox(x-(leafwidth/2), (this.components[0].getTranslateY()-(this.components[0].getHeight()*1/5))-leafheight,newz,leafwidth,leafheight,leafdepth/2, leafMaterial);
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
