package src.courseproject207.tree3d;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;

public abstract class Tree3d {

    public static final PhongMaterial trunkMaterial = new PhongMaterial(Color.valueOf("#725C42"));

    /**
     * @return an Array of 3d nodes representing a 3d Tree
     */
    public abstract Node[] getComponents();

    /**
     * @return a clone of a 3D Tree Object
     */
    public abstract Tree3d clone();
}
