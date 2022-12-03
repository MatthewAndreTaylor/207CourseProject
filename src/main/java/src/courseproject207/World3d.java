package src.courseproject207;

import javafx.geometry.Point3D;
import javafx.scene.DirectionalLight;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import src.courseproject207.tree3d.CommonTree3d;
import java.util.Objects;

public class World3d extends Group {

    private Forest forest;

    // X, Y denote the center (0,0) of the view
    public World3d(int x, int y) {

        //Setup Ground
        Box ground = new Box(1000, 1000, 1000);
        ground.translateXProperty().set(x);
        ground.translateZProperty().set(y-400);
        ground.translateYProperty().set(y+600);
        PhongMaterial grassMaterial = new PhongMaterial();

        grassMaterial.setDiffuseMap(new Image(Objects.requireNonNull(VisualizationApplication.class.getResourceAsStream("grass.png"))));
        ground.setMaterial(grassMaterial);
        this.getChildren().add(ground);

        this.forest = new Forest();

        // Draw out some trees
        this.getChildren().addAll(new CommonTree3d(x, y, 0, 60, 190, 40).getComponents());

        this.getChildren().addAll(new CommonTree3d(x + 200, y, 200, 60, 500, 40).getComponents());

        this.getChildren().addAll(new CommonTree3d(x + 200, y, -350, 40, 750, 60).getComponents());

        // Setup Lights
        this.getChildren().addAll(lights());

        // Creating a text representation of the forest for accessibility
        String forestDescription = "Forest Description:";
        forestDescription = forestDescription.concat("\nTree Families:");
        for(String family: this.forest.getTreeFamilies().keySet()) {
            forestDescription = forestDescription.concat("\n" + family + ", species: " + this.forest.getTreeFamilies().get(family));
        }
        forestDescription = forestDescription.concat("\nTree Species:");
        for(String species: this.forest.getTreeSpecies().keySet())
        {
            forestDescription = forestDescription.concat("\n" +species + ", number of Trees:" + this.forest.getTreeSpecies().get(species).size());
        }
        System.out.println(forestDescription);
        this.setAccessibleHelp("Forest containing 3d Tree Renders");
        this.setAccessibleText(forestDescription);
    }
    /**
     * @return this forest
     */
    public Forest getForest(){
        return this.forest;
    }

    /**
     * @return an Array of lights for rendering this world
     */
    private Node[] lights()
    {
        DirectionalLight right = new DirectionalLight();
        right.setDirection(new Point3D(-1, 2, -2));

        DirectionalLight left = new DirectionalLight();
        right.setDirection(new Point3D(1, 2, -1));

        return new Node[]{right, left};
    }
}