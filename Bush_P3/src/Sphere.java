public class Sphere extends Shape3D
{
    public Sphere(double r)
    {
        super.x = r;
        getName();
        getArea();
        getVolume();
    }

    @Override
    public String getName() {
        return "sphere";
    }

    @Override
    public double getArea() {
        return 4 * pi * (x * x);
    }

    @Override
    public double getVolume()
    {
        return (1.333333) * (pi) * (x * x * x);
    }
}
