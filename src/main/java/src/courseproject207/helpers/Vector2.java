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

    public Vector2 copy()
    {
        return new Vector2(this.x, this.y);
    }

    public Vector2 difference(Vector2 other)
    {
        return new Vector2(this.x - other.x, this.y - other.y);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
