package src.courseproject207.components;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import src.courseproject207.World3d;

import java.util.ArrayList;

public class ComponentView extends HBox{
    public ComponentView(World3d world3d)
    {

        FilterComponent filterComponent = new FilterComponent(world3d);

        Button button = new Button();
        button.setText("Project Info 🌲");

        ArrayList<ModalComponent> modalComponents = new ArrayList<>();

        button.setOnAction(event -> {
            for(ModalComponent m: modalComponents){
                m.close();
            }
            modalComponents.clear();
            modalComponents.add(new ModalComponent());
        });

        this.getChildren().add(filterComponent);
        this.getChildren().add(button);
    }
}
