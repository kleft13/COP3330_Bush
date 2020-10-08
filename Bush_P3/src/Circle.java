public class Circle extends Shape2D {

    public Circle(double r) {
        super.x = r;
        getName();
        getArea();
    }

    @Override
    public String getName() {
        return "circle";
    }

    @Override
    public double getArea() {
        return super.pi * (super.x) * (super.x);
    }
}
