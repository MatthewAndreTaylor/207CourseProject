package src.courseproject207;

import javafx.geometry.Point3D;
import javafx.scene.DirectionalLight;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import src.courseproject207.tree.Tree;
import src.courseproject207.tree3d.CommonTree3d;
import src.courseproject207.tree3d.EvergreenTree3d;
import src.courseproject207.tree3d.MapleTree3d;
import src.courseproject207.tree3d.Tree3d;

public class World3d extends Group {

    private Forest forest;

    // X, Y denote the center (0,0) of the view
    public World3d(int x, int y) {

        //Setup Ground
        Box ground = new Box(100000, 1000, 100000);
        ground.translateXProperty().set(x);
        ground.translateYProperty().set(y+800);
        PhongMaterial groundMaterial = new PhongMaterial();
        groundMaterial.setDiffuseColor(Color.valueOf("#9adf8f"));
        ground.setMaterial(groundMaterial);
        this.getChildren().add(ground);

        this.forest = new Forest();

        for(int i = 0; i < 100; i++)
        {
            Tree t = this.forest.getTrees().get(i);
            Tree3d tree3D = tree3dRender(forest.getRenderMapping().get(t.getFamily()), t.getX(), t.getY(), y, t.getHeight());
            this.getChildren().addAll(tree3D.getComponents());
        }

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
        //System.out.println(forestDescription);
        this.setAccessibleHelp("Forest containing 3d Tree Renders");
        this.setAccessibleText(forestDescription);
    }

    public Tree3d tree3dRender(String render, double x,double z, int y,  int height)
    {
        int worldX = (int) Math.ceil((x-0.5)*600000);
        int worldZ = (int) Math.ceil((z - 43.4388419037988)*600000);

        switch (render) {
            case "Maple" -> {
                return new MapleTree3d(worldX,y,worldZ, 50, height*100, 50);
            }
            case "Evergreen" -> {
                return new EvergreenTree3d(worldX,y,worldZ, 50, height*100, 50);
            }
            default -> {
                return new CommonTree3d(worldX,y,worldZ, 50, height*100, 50);
            }
        }
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