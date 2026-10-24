import java.util.List;

/** E04 - Runtime polymorphism: one call site, many behaviours (dynamic dispatch). */
public class E04_Polymorphism {
    public static void main(String[] args) {
        List<Shape> shapes = List.of(new Circle(1), new Rectangle(2, 3), new Square(4));
        double total = 0;
        for (Shape s : shapes) {                       // the loop never changes when new shapes are added
            System.out.printf("%-9s area = %.2f%n", s.name(), s.area());
            total += s.area();
        }
        System.out.printf("Total area = %.2f%n", total);
        check(Math.abs(total - (Math.PI + 6 + 16)) < 1e-9, "sum of areas");
    }
    static void check(boolean c, String m) { if (!c) throw new AssertionError(m); }
}

class Shape {
    double area() { return 0; }
    String name() { return "Shape"; }
}
class Circle extends Shape {
    private final double r;
    Circle(double r) { this.r = r; }
    @Override double area() { return Math.PI * r * r; }
    @Override String name() { return "Circle"; }
}
class Rectangle extends Shape {
    protected final double w, h;
    Rectangle(double w, double h) { this.w = w; this.h = h; }
    @Override double area() { return w * h; }
    @Override String name() { return "Rectangle"; }
}
class Square extends Rectangle {
    Square(double side) { super(side, side); }
    @Override String name() { return "Square"; }
}
