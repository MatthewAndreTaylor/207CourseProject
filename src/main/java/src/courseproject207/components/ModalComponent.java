package src.courseproject207.components;


import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.courseproject207.VisualizationApplication;

import java.io.IOException;

public class ModalComponent extends Stage{

    public ModalComponent() {
        Stage newStage = new Stage();
        newStage.setTitle("modal");
        this.setWidth(500);
        this.setHeight(500);
        this.setX(10.0);
        this.setY(10.0);

        Image icon = null;
        try {
            icon = new Image(VisualizationApplication.class.getResource("icon.png").openStream());
        } catch (IOException e) {
        }

        ImageView imageView = new ImageView();
        imageView.setImage(icon);
        Text paragraph = new Text();
        paragraph.setText("The group decided to do the Urban Forestry project because there was a common interest in " +
                "data science and environmental protection. The goal of this project is to display the effects of " +
                "climate change through data science and demonstrate how factors like humidity and temperature affect " +
                "local woodlands. Based on certain factors implemented in the program the characteristics of woodlands " +
                "will change. Some examples are: leaf colour, trunk colour, and more. It will also show the survival r" +
                "ate of various trees under certain environments when factors like temperature are changed.");
        paragraph.setFont(Font.font("Verdana", FontWeight.BOLD, 70));

        Text title = new Text();
        title.setText("3D Tree Visualizer");


        VBox root = new VBox(title, imageView, paragraph);
        Scene scene = new Scene(root, this.getWidth(), this.getHeight());
        this.setScene(scene);
        this.show();
    }
}
