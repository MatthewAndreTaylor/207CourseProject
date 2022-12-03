package src.courseproject207.components;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import src.courseproject207.Forest;
import src.courseproject207.World3d;


public class FilterComponent extends ComboBox{

    private Forest forest;
    public FilterComponent(World3d world3d){
        this.forest = world3d.getForest();
        this.setOnAction(event -> mouseClick());
        this.setItems(FXCollections.observableArrayList(
                "Fruit Trees 🍎",
                "Maple Trees 🍁",
                "North American Trees 🌳",
                "Evergreen Trees 🎄",
                "Common Trees 🌲"
        ));
    }

    /**
     * Filters the trees based on the user choice box input
     */
    public void mouseClick(){
        System.out.println(this.getValue());
    }
}

