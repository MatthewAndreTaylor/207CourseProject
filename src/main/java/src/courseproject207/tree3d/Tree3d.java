package src.courseproject207.tree3d;

import javafx.scene.Node;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public abstract class Tree3d {

    /**
     * @return an Array of 3d nodes representing a 3d Tree
     */
    public abstract Node[] getComponents();

    /**
     * @return a clone of a 3D Tree Object
     */
    public abstract Tree3d clone();

    /**
     * Generate a box with given dimensions and material
     * @param x position
     * @param y position
     * @param z position
     * @param width size
     * @param height size
     * @param length size
     * @param material texture
     * @return Box with the given features
     */
    Box makeBox(double x, double y, double z, double width, double height, double length, PhongMaterial material){
        Box B = new Box(width, height, length);
        B.setMaterial(material);
        B.translateXProperty().set(x);
        B.translateZProperty().set(z);
        B.translateYProperty().set(y);
        return B;
    }
}
