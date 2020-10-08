public class Pyramid extends Shape3D
{
    public Pyramid(double x, double z, double y)
    {
        super.x = x;
        super.y = y;
        super.z = z;
        getName();
        getArea();
        getVolume();
    }

    @Override
    public String getName() {
        return "pyramid";
    }

    @Override
    public double getArea() {
        double part1 = x * z;
        double help = (z/2) * (z/2);
        double help2 = (x/2) * (x/2);
        double part2 = x * Math.sqrt(help + y * y);
        double part3 = z * Math.sqrt(help2 + y * y);
        return part1 + part2 + part3;
    }

    @Override
    public double getVolume() {
        return (super.x * super.y * super.z) / 3;
    }
}
