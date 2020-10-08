public class Square extends Shape2D
{
    public Square(double x)
    {
        super.x = x;
        getName();
        getArea();
    }

    @Override
    public String getName()
    {
        return "square";
    }

    @Override
    public double getArea()
    {
        return super.x * super.x;
    }
}
