package src.courseproject207;

import src.courseproject207.tree.*;

import java.util.ArrayList;

public class Forest {
    private ArrayList<Tree> trees;
    private TreeFactory treeFactory;

    public Forest()
    {
        this.treeFactory =new TreeFactory();
        this.generateTrees();
    }

    private void generateTrees()
    {

    }

    public void addTree(Tree t)
    {
        this.trees.add(t);
    }

    public void removeTree(Tree t)
    {
        this.trees.remove(t);
    }
}
