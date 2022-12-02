package src.courseproject207.components;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ComponentView extends HBox{
    public ComponentView()
    {
        Button button = new Button();
        button.setText("tree stuff 🌲");
        this.getChildren().add(button);
    }
}
