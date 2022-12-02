package src.courseproject207.tree;

public class ConcreteTree implements Tree{

    private final double x;
    private final double y;
    private final int id;
    private int height;
    private final String speciesName;
    private final String family;

    public ConcreteTree(int id, double x, double y, int height, String speciesName, String category)
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
     * A ConcreteTree should be able to increment its height
     * @param amount
     */
    public void grow(int amount)
    {
        this.height += amount;
    }
}