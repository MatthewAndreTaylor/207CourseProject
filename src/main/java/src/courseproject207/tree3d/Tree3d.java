package src.courseproject207.tree3d;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public abstract class Tree3d {
    protected static final PhongMaterial trunkMaterial = new PhongMaterial(Color.valueOf("#725C42"));
    protected Box[] components;

    /**
     * @return an Array of 3d nodes representing a 3d Tree
     */
    public Node[] getComponents(){
        return this.components;
    }

    /**
     * @return a clone of a 3D Tree Object
     */
    public abstract Tree3d clone();
}
