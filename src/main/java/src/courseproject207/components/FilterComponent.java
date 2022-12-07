package src.courseproject207.components;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import src.courseproject207.World3d;
import src.courseproject207.tree.Tree;
import src.courseproject207.tree3d.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FilterComponent extends ComboBox{

    private World3d world3d;

    private Random random = new Random();

    private List<List<String>> filters = new ArrayList<>();

    public FilterComponent(World3d world3d){
        this.world3d = world3d;

        this.filters.add(new ArrayList<>(this.world3d.getForest().getTreeFamilies().keySet()));
        this.filters.add(new ArrayList<>(this.world3d.getForest().getTreeSpecies().keySet()));

        this.setOnAction(event -> choice());
        this.setItems(FXCollections.observableArrayList(
                "All Trees",
                "Random trees",
                "Fruit Tree Renders 🍎",
                "Maple Tree Renders 🍁",
                "North American Tree Renders 🌳",
                "Evergreen Tree Renders 🎄",
                "Common Tree Renders 🌲"
        ));
        for(List list: this.filters)
        {
            for(Object s: list)
            {
                this.getItems().add(s);
            }
        }
        this.setAccessibleHelp("Options for filtering trees in the forest");
    }

    /**
     * Filters the trees based on the user choice box input
     */
    public void choice(){
        System.out.println(this.getValue());
        this.world3d.getChildren().removeAll(this.world3d.getChildren());
        this.world3d.setupWorld(this.world3d.grassMaterial);
        switch(String.valueOf(this.getValue()))
        {
            case "All Trees" -> {
                for(Tree t: this.world3d.getForest().getTrees()) {
                    Tree3d tree3D = this.world3d.tree3dRender(t);
                    this.world3d.getChildren().addAll(tree3D.getComponents());
                }
            }
            case "Random trees" -> {
                int start = random.nextInt(this.world3d.getForest().getTrees().size());
                int end = random.nextInt(this.world3d.getForest().getTrees().size());
                for(Tree t: this.world3d.getForest().getTrees().subList(Math.min(start,end), Math.max(start,end))) {
                    Tree3d tree3D = this.world3d.tree3dRender(t);
                    this.world3d.getChildren().addAll(tree3D.getComponents());
                }
            }
            case "Fruit Tree Renders 🍎"->{
                for(Tree t: this.world3d.getForest().getTrees()) {
                    Tree3d tree3D = this.world3d.tree3dRender(t);
                    if(tree3D instanceof FruitTree3d) this.world3d.getChildren().addAll(tree3D.getComponents());
            }}
            case "North American Tree Renders 🌳"->{
                for(Tree t: this.world3d.getForest().getTrees()) {
                    Tree3d tree3D = this.world3d.tree3dRender(t);
                    if(tree3D instanceof NorthAmericanTree3d) this.world3d.getChildren().addAll(tree3D.getComponents());
            }}
            case "Maple Tree Renders 🍁"->{
                for(Tree t: this.world3d.getForest().getTrees()) {
                    Tree3d tree3D = this.world3d.tree3dRender(t);
                    if(tree3D instanceof MapleTree3d) this.world3d.getChildren().addAll(tree3D.getComponents());
            }}
            case "Evergreen Tree Renders 🎄"->{
                for(Tree t: this.world3d.getForest().getTrees()) {
                    Tree3d tree3D = this.world3d.tree3dRender(t);
                    if(tree3D instanceof EvergreenTree3d) this.world3d.getChildren().addAll(tree3D.getComponents());
            }}
            case "Common Tree Renders 🌲"->{
                for(Tree t: this.world3d.getForest().getTrees()) {
                    Tree3d tree3D = this.world3d.tree3dRender(t);
                    if(tree3D instanceof CommonTree3d) this.world3d.getChildren().addAll(tree3D.getComponents());
            }}
            default -> {
                if(this.filters.get(0).contains(this.getValue()))
                {
                    for(Tree t: this.world3d.getForest().getTrees()) {
                        Tree3d tree3D = this.world3d.tree3dRender(t);
                        if (t.getFamily().equals(this.getValue()))
                            this.world3d.getChildren().addAll(tree3D.getComponents());
                    }
                }
                if(this.filters.get(1).contains(this.getValue()))
                {
                    for(Tree t: this.world3d.getForest().getTrees()) {
                        Tree3d tree3D = this.world3d.tree3dRender(t);
                        if(t.getSpeciesName().equals(this.getValue())) this.world3d.getChildren().addAll(tree3D.getComponents());
                    }
                }
            }
        }
    }
}

