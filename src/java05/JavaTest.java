package java05;

public class JavaTest {

    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0] = new Square(4);
        shape[1] = new Circle(2);
        shape[2] = new Square(5);

        for (Shape s : shape) {
            printShape(s);
        }
    }

    public static void printShape(Shape shape) {
        System.out.print("Area : " + shape.getArea());
        System.out.println(", Perimeter : " + shape.getPerimeter());
    }
}

abstract class Shape {

    protected int length;

    public Shape(int length) {
        this.length = length;
    }

    protected abstract double getArea();

    protected abstract double getPerimeter();
}

class Square extends Shape {

    public Square(int length) {
        super(length);
    }

    @Override
    protected double getArea() {
        return length * length;
    }

    @Override
    protected double getPerimeter() {
        return length * 4;
    }
}

class Circle extends Shape {

    private static final double PI = 3.14;

    public Circle(int length) {
        super(length);
    }

    @Override
    protected double getArea() {
        return PI * length * length;
    }

    @Override
    protected double getPerimeter() {
        return PI * 2 * length;
    }
}

