public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        double area = Math.PI * Math.pow(radius, 2);
        return area;
    }

    @Override
    public double perimeter() {
        double perimeter = 2 * Math.PI * radius;
        return perimeter;
    }
    
}
