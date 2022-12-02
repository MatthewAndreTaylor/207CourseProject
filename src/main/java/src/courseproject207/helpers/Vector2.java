package src.courseproject207.helpers;

public class Vector2 {
    private double x;
    private double y;

    public Vector2(){
        this.x = 0;
        this.y = 0;
    }

    Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return Copy of a given Vector
     */
    public Vector2 copy()
    {
        return new Vector2(this.x, this.y);
    }

    /**
     * @return Difference between this vector and another
     */
    public Vector2 difference(Vector2 other)
    {
        return new Vector2(this.x - other.x, this.y - other.y);
    }

    /**
     * @return x
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return y
     */
    public double getY() {
        return this.y;
    }

    /**
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }
}
