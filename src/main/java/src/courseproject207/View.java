package src.courseproject207;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PointLight;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import src.courseproject207.tree3d.CommonTree3d;

import java.io.IOException;

public class View extends Group {

    private Forest forest;

    // X, Y denote the center (0,0) of the view
    public View(int x, int y) {

        //Setup Ground
        Box ground = new Box(1000, 1000, 1000);
        ground.translateXProperty().set(x);
        ground.translateZProperty().set(y-400);
        ground.translateYProperty().set(y+600);
        PhongMaterial grassMaterial = new PhongMaterial();
        Image grassImage=null;
        try{
            grassImage = new Image(VisualizationApplication.class.getResource("grass.png").openStream());
        }catch (IOException e){}

        grassMaterial.setDiffuseMap(grassImage);
        ground.setMaterial(grassMaterial);
        this.getChildren().add(ground);

        this.forest = new Forest();

        System.out.println("Tree Species:");
        for(String species: this.forest.getTreeSpecies().keySet())
        {
            System.out.println(species + ", number of Trees:" + this.forest.getTreeSpecies().get(species).size());
        }

        System.out.println("\nTree Families:");
        for(String family: this.forest.getTreeFamilies().keySet())
        {
            System.out.println(family + ", species: " + this.forest.getTreeFamilies().get(family));
        }

        // Draw out some trees
        this.getChildren().addAll(new CommonTree3d(x, y, 0, 60, 190, 40).getComponents());

        this.getChildren().addAll(new CommonTree3d(x + 200, y, 200, 60, 500, 40).getComponents());

        this.getChildren().addAll(new CommonTree3d(x + 200, y, -350, 40, 750, 60).getComponents());

        // Setup Lights
        this.getChildren().addAll(lights());
    }

    private Node[] lights()
    {
        PointLight right = new PointLight();
        Transform base = new Rotate(0, Rotate.Y_AXIS);
        right.getTransforms().add(new Translate(0,50,-1000));
        right.getTransforms().add(base);

        PointLight left = new PointLight();

        return new Node[]{right, left};
    }
}