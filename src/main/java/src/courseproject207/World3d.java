package src.courseproject207;

import javafx.geometry.Point3D;
import javafx.scene.DirectionalLight;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import src.courseproject207.tree.Tree;
import src.courseproject207.tree3d.*;

public class World3d extends Group {
    private static final PhongMaterial grassMaterial = new PhongMaterial(Color.valueOf("#9adf8f"));
    private Forest forest;
    private int x;
    private int y;

    // X, Y denote the center (0,0) of the view
    public World3d(int x, int y) {
        this.x=x;
        this.y=y;
        this.setupWorld();

        this.forest = new Forest();

        for(Tree t: this.forest.getTrees())
        {
            Tree3d tree3D = tree3dRender(t);
            this.getChildren().addAll(tree3D.getComponents());
        }

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
        this.getChildren().removeAll(this.getChildren());
        this.setupWorld();
        Tree t = new Tree(40000,0.5, 43.4396719038, 15, "", "Maple");
        Tree3d maple = tree3dRender(t);
        this.getChildren().addAll(maple.getComponents());

        t = new Tree(40001,0.5005, 43.4396719038, 10, "", "MediumTree");
        Tree3d common = tree3dRender(t);
        this.getChildren().addAll(common.getComponents());

        t = new Tree(40002,0.501, 43.4396719038, 10, "", "Pear");
        Tree3d fruit = tree3dRender(t);
        this.getChildren().addAll(fruit.getComponents());

        t = new Tree(40003,0.5015, 43.4396719038, 10, "", "Birch");
        Tree3d north = tree3dRender(t);
        this.getChildren().addAll(north.getComponents());

        t = new Tree(40004,0.502, 43.4396719038, 12, "", "Pine");
        Tree3d evergreen = tree3dRender(t);
        this.getChildren().addAll(evergreen.getComponents());
    }

    /**
     * Render a tree 3d model given details of a tree
     * @param t a Tree
     * @return a tree 3d model
     */
    public Tree3d tree3dRender(Tree t)
    {

        int worldX = (int) Math.ceil((t.getX()-0.5)*600000);
        int worldZ = (int) Math.ceil((t.getY() - 43.4388419037988)*600000);

        switch (getForest().getRenderMapping().get(t.getFamily())) {
            case "Maple" -> {
                return new MapleTree3d(worldX,this.y,worldZ, t.getHeight()*50);
            }
            case "Evergreen" -> {
                return new EvergreenTree3d(worldX,this.y,worldZ, t.getHeight()*50);
            }
            case "Fruit" -> {
                return new FruitTree3d(worldX,this.y,worldZ, t.getHeight()*50);
            }
            case "NorthAmerican" -> {
                return new NorthAmericanTree3d(worldX,this.y,worldZ, t.getHeight()*50);
            }
            default -> {
                return new CommonTree3d(worldX,this.y,worldZ, t.getHeight()*50);
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
     * Setup this world with ground and directional lights
     */
    public void setupWorld()
    {
        //Setup Ground
        Box ground = new Box(150000, 1000, 150000);
        ground.translateXProperty().set(this.x);
        ground.translateYProperty().set(this.y+800);
        ground.setMaterial(grassMaterial);
        this.getChildren().add(ground);

        // Setup lights
        DirectionalLight right = new DirectionalLight();
        right.setDirection(new Point3D(-1, 2, -2));
        this.getChildren().add(right);
        DirectionalLight left = new DirectionalLight();
        right.setDirection(new Point3D(1, 2, -1));
        this.getChildren().add(left);
    }


}