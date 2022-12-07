package src.courseproject207.components;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorInput;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import src.courseproject207.World3d;

import java.io.IOException;
import java.util.ArrayList;

public class ComponentView extends HBox{
    public ComponentView(World3d world3d)
    {
        this.setSpacing(10);

        // This button shows a modal displaying project info
        Button projectInfoButton = new Button();
        projectInfoButton.setText("Project Info 🌲");

        ArrayList<ModalComponent> modalComponents = new ArrayList<>();

        projectInfoButton.setOnAction(event -> {
            for(ModalComponent m: modalComponents){
                m.close();
            }
            modalComponents.clear();
            try {
                modalComponents.add(new ModalComponent());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // This component allows the user to filter Trees
        FilterComponent filterComponent = new FilterComponent(world3d);

        Button b = new Button();
        b.setText("Color Overlay 🎨");
        b.setAccessibleHelp("Color Overlay Yellow");
        b.setOnAction(event -> {
            //ObservableList<Node> array = FXCollections.observableArrayList();
            world3d.getChildren().remove(0);
            world3d.setupWorld(new PhongMaterial(Color.YELLOW));
            //world3d.getChildren().addAll(array);

        });

        this.getChildren().add(projectInfoButton);
        this.getChildren().add(filterComponent);
        this.getChildren().add(b);
        this.setAccessibleHelp("2D components for interacting with the application");
    }
}
