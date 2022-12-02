package src.courseproject207.tree3d;

import javafx.scene.Node;

public abstract class Tree3d {

    /**
     * @return an Array of 3d nodes representing a 3d Tree
     */
    public abstract Node[] getComponents();

    /**
     * @return a clone of a 3D Tree Object
     */
    public abstract Tree3d clone();
}
