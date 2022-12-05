package src.courseproject207;

import javafx.geometry.Point3D;
import javafx.scene.DirectionalLight;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import src.courseproject207.tree.Tree;
import src.courseproject207.tree3d.*;

public class World3d extends Group {
    private static final PhongMaterial grassMaterial = new PhongMaterial(Color.valueOf("#9adf8f"));
    private Forest forest;

    // X, Y denote the center (0,0) of the view
    public World3d(int x, int y) {

        //Setup Ground
        Box ground = new Box(150000, 1000, 150000);
        ground.translateXProperty().set(x);
        ground.translateYProperty().set(y+800);
        ground.setMaterial(grassMaterial);
        this.getChildren().add(ground);

        this.forest = new Forest();

        for(int i = 0; i < 2000; i++)
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
        System.out.println(forestDescription);
        this.setAccessibleHelp("Forest containing 3d Tree Renders");
        this.setAccessibleText(forestDescription);
    }

    /**
     * Render in a model of each type of 3d tree, for development
     */
    public void sampleRender()
    {
        this.getChildren().remove(0, this.getChildren().size());
        Tree3d maple = tree3dRender("Maple", 0.5, 43.4396719038, 400, 15);
        this.getChildren().addAll(maple.getComponents());

        Tree3d common = tree3dRender("Common", 0.5005, 43.4396719038, 400, 10);
        this.getChildren().addAll(common.getComponents());

        Tree3d fruit = tree3dRender("Fruit", 0.501, 43.4396719038, 400, 10);
        this.getChildren().addAll(fruit.getComponents());

        Tree3d north = tree3dRender("NorthAmerican", 0.5015, 43.4396719038, 400, 12);
        this.getChildren().addAll(north.getComponents());

        Tree3d evergreen = tree3dRender("Evergreen", 0.502, 43.4396719038, 400, 12);
        this.getChildren().addAll(evergreen.getComponents());
    }

    /**
     * Render a tree 3d model given details of a tree
     * @param render the type of 3d tree
     * @param x real world longitude
     * @param z real world latitude
     * @param y scene height
     * @param height The height of the tree
     * @return a tree 3d model
     */
    public Tree3d tree3dRender(String render, double x,double z, int y,  int height)
    {
        int worldX = (int) Math.ceil((x-0.5)*600000);
        int worldZ = (int) Math.ceil((z - 43.4388419037988)*600000);

        switch (render) {
            case "Maple" -> {
                return new MapleTree3d(worldX,y,worldZ, height*50);
            }
            case "Evergreen" -> {
                return new EvergreenTree3d(worldX,y,worldZ, height*50);
            }
            case "Fruit" -> {
                return new FruitTree3d(worldX,y,worldZ, height*50);
            }
            case "NorthAmerican" -> {
                return new NorthAmericanTree3d(worldX,y,worldZ, height*50);
            }
            default -> {
                return new CommonTree3d(worldX,y,worldZ, height*50);
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