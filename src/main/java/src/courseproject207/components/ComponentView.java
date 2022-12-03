package src.courseproject207.components;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
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

        this.getChildren().add(projectInfoButton);
        this.getChildren().add(filterComponent);
        this.setAccessibleHelp("2D components for interacting with the application");
    }
}
