package src.courseproject207.tree3d;

import src.courseproject207.VisualizationApplication;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import java.util.Objects;

public class MapleTree3d extends Tree3d {
    private static final PhongMaterial mapleLeafMaterial = new PhongMaterial(Color.valueOf("#bf0505")
            , new Image(Objects.requireNonNull(VisualizationApplication.class.getResourceAsStream("leavesgrey.png"))),null,null,null);
    public MapleTree3d() {}
    public MapleTree3d(int x, int y, int z, int height) {
        this.components = new Box[2];
        // Create trunk
        this.components[0] = new Box(30, height, 30);
        PhongMaterial trunkMaterial = new PhongMaterial();
        trunkMaterial.setDiffuseColor(Color.valueOf("#725C42"));
        this.components[0].setMaterial(trunkMaterial);
        this.components[0].translateXProperty().set(x);
        this.components[0].translateYProperty().set(y);
        this.components[0].translateZProperty().set(z);

        // Leaves
        this.components[1] = new Box(160, 160, 160);
        this.components[1].setMaterial(mapleLeafMaterial);
        this.components[1].translateXProperty().set(x);
        this.components[1].translateZProperty().set(z);
        this.components[1].translateYProperty().set(this.components[0].getTranslateY() - this.components[0].getHeight() / 2);

    }

    @Override
    public Tree3d clone() {
        MapleTree3d clone = new MapleTree3d();
        clone.components = this.components.clone();
        return clone;
    }
}