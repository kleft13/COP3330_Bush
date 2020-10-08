public class Triangle extends Shape2D {
    public Triangle(double x, double y)
    {
        super.x = x;
        super.y = y;
        getName();
        getArea();
    }

    @Override
    public String getName()
    {
        return "triangle";
    }

    public double getArea()
    {
        return (super.x * super.y)/2;
    }
}