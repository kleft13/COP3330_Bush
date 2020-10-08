public abstract class Shape {
    protected double x;
    protected double y;
    protected double z;
    protected double pi = 3.14159;

    public void shape()
    {
        Square square = new Square(x);
        Triangle triangle = new Triangle(x,y);
        Circle circle = new Circle(x);
        Cube cube = new Cube(x);
        Pyramid pyramid = new Pyramid(x,y,z);
        Sphere sphere = new Sphere(x);
    }

    //Measurements
    public abstract String getName();

    public abstract double getArea();
}
