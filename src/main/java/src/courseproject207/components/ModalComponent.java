package src.courseproject207.components;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import src.courseproject207.VisualizationApplication;

import java.io.IOException;
import java.util.Objects;

public class ModalComponent extends Stage{

    public ModalComponent() throws IOException {
        FXMLLoader modalLoader = new FXMLLoader(VisualizationApplication.class.getResource("modal-component.fxml"));
        // Loads the modal scene from the fxml with accessible text
        Scene scene = new Scene(modalLoader.load(), this.getWidth(), this.getHeight());
        this.getIcons().add(new Image(Objects.requireNonNull(VisualizationApplication.class.getResourceAsStream("icon.png"))));
        this.setScene(scene);
        this.show();
    }
}
