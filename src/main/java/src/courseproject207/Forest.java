package src.courseproject207;

import src.courseproject207.tree.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.*;

public class Forest {
    private ArrayList<Tree> trees;
    private HashMap<String, ArrayList<Tree>> treeSpecies;

    private HashMap<String, HashSet<String>> treeFamilies;
    private TreeFactory treeFactory;

    public Forest()
    {
        this.treeFactory =new TreeFactory();
        this.trees = new ArrayList<>();
        this.treeSpecies = new HashMap<>();
        this.treeFamilies = new HashMap<>();
        this.generateTrees();
    }

    private void generateTrees()
    {
        try
        {
            this.treeFactory.readFiles(VisualizationApplication.class.getResource("Tree_Inventory.csv").getFile(), this);
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    public void addTree(Tree t)
    {
        String type = t.getSpeciesName();
        String family = t.getFamily();

        // Add the tree to the list of trees for this species
        if(!this.treeSpecies.containsKey(type)) {
            this.treeSpecies.put(type, new ArrayList<>(List.of(t)));
        }
        else {
            this.treeSpecies.get(type).add(t);
        }

        // Add the species to the list of species for this family of trees
        if(!this.treeFamilies.containsKey(family)) {
            this.treeFamilies.put(family, new HashSet<>(Set.of(type)));
        }
        else {
            this.treeFamilies.get(family).add(type);
        }

        this.trees.add(t);
    }

    public void removeTree(Tree t)
    {
        this.treeSpecies.get(t.getSpeciesName()).remove(t);

        this.trees.remove(t);
    }

    public ArrayList<Tree> getTrees()
    {
        return this.trees;
    }

    public HashMap<String, ArrayList<Tree>> getTreeSpecies() {
        return this.treeSpecies;
    }
    public HashMap<String, HashSet<String>> getTreeFamilies() {
        return treeFamilies;
    }
}
