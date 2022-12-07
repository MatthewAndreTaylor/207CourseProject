package src.courseproject207.tree3d;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import src.courseproject207.VisualizationApplication;
import java.util.Objects;

public class CommonTree3d extends Tree3d {
    private static final PhongMaterial commonLeafMaterial = new PhongMaterial(Color.valueOf("#228B22")
            , new Image(Objects.requireNonNull(VisualizationApplication.class.getResourceAsStream("leaves.png"))),null,null,null);
    public CommonTree3d(){}
    public CommonTree3d(int x,int y, int z, int height){
        this.components = new Box[2];
        // Create trunk
        this.components[0] = new Box(40, height, 40);
        this.components[0].setMaterial(trunkMaterial);
        this.components[0].translateXProperty().set(x);
        this.components[0].translateYProperty().set(y);
        this.components[0].translateZProperty().set(z);

        // Leaves
        this.components[1] = new Box(120, 120, 120);
        this.components[1].setMaterial(commonLeafMaterial);
        this.components[1].translateXProperty().set(x);
        this.components[1].translateZProperty().set(z);
        this.components[1].translateYProperty().set(this.components[0].getTranslateY()-this.components[0].getHeight()/2);
    }

    @Override
    public Tree3d clone() {
        CommonTree3d clone = new CommonTree3d();
        clone.components = this.components.clone();
        return clone;
    }
}
