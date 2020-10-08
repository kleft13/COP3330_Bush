public class Cube extends Shape3D
{
    public Cube(double x)
    {
        super.x = x;
        getName();
        getArea();
        getVolume();
    }

    @Override
    public String getName() {
        return "cube";
    }

    @Override
    public double getArea() {
        return 6 * super.x * super.x;
    }

    @Override
    public double getVolume() {
        return super.x * super.x * super.x;
    }
}
