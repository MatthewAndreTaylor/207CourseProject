package src.courseproject207.tree;

public class Tree {

    private final double x;
    private final double y;
    private final int id;
    private int height;
    private final String speciesName;
    private final String family;

    public Tree(int id, double x, double y, int height, String speciesName, String category)
    {
        this.x = x;
        this.y = y;
        this.id = id;
        this.height = height;
        this.speciesName = speciesName;
        this.family = category;
    }

    @Override
    public String toString() {
        return "I am a " + this.speciesName + "located at (" + this.x + "," +  this.y + "). I am "
                + this.height + "m tall. My id:" + this.id;
    }

    /**
     * @return this Trees species
     */
    public String getSpeciesName() {
        return this.speciesName;
    }

    /**
     * @return this Trees family name
     */
    public String getFamily() {
        return this.family;
    }

    /**
     * A Tree should be able to increment its height
     * @param amount How much the tree should grow by
     */
    public void grow(int amount)
    {
        this.height += amount;
    }

    /**
     * A tree should be able to access its id
     * @return this Trees integer id
     */
    public int getId() {
        return this.id;
    }

    /**
     * A tree should be able to access its x
     * @return this Trees x position
     */
    public double getX() {
        return this.x;
    }

    /**
     * A tree should be able to access its y
     * @return this Trees y position
     */
    public double getY() {
        return this.y;
    }

    /**
     * A tree should be able to access its height
     * @return this Trees height
     */
    public int getHeight() {
        return this.height;
    }
}