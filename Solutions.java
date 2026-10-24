import java.util.*;

/**
 * 20 OOP exercises with reference solutions. Each block between "// @EX" and "// @END"
 * is turned into docs/exercises.md by tools/generate.py. Run: java exercises/Solutions.java
 */
public class Solutions {
    public static void main(String[] args) {
        Runnable[] all = {
            Solutions::ex01, Solutions::ex02, Solutions::ex03, Solutions::ex04, Solutions::ex05,
            Solutions::ex06, Solutions::ex07, Solutions::ex08, Solutions::ex09, Solutions::ex10,
            Solutions::ex11, Solutions::ex12, Solutions::ex13, Solutions::ex14, Solutions::ex15,
            Solutions::ex16, Solutions::ex17, Solutions::ex18, Solutions::ex19, Solutions::ex20
        };
        int i = 1;
        for (Runnable r : all) { r.run(); System.out.printf("Exercise %02d PASS%n", i++); }
        System.out.println("ALL 20 EXERCISES PASSED");
    }

    static void check(boolean c, String m) { if (!c) throw new AssertionError(m); }
    static void checkThrows(Class<? extends Throwable> t, Runnable r) {
        try { r.run(); } catch (Throwable e) { if (t.isInstance(e)) return; throw new AssertionError("wrong exception " + e); }
        throw new AssertionError("expected " + t.getSimpleName());
    }

    // @EX 01 | Classes & objects | Create a class Student(name, rollNo, marks) with a constructor, getters and toString() that prints "1:Asha (88.5)".
    static class Student {
        private final String name; private final int rollNo; private double marks;
        Student(String name, int rollNo, double marks) { this.name = name; this.rollNo = rollNo; this.marks = marks; }
        String getName() { return name; }
        int getRollNo() { return rollNo; }
        double getMarks() { return marks; }
        @Override public String toString() { return rollNo + ":" + name + " (" + marks + ")"; }
    }
    static void ex01() {
        Student s = new Student("Asha", 1, 88.5);
        check(s.toString().equals("1:Asha (88.5)"), "toString");
        check(s.getName().equals("Asha") && s.getRollNo() == 1, "getters");
    }
    // @END

    // @EX 02 | Encapsulation | Write an Account class with a private balance. deposit() and withdraw() must reject non-positive amounts (IllegalArgumentException) and overdrafts (IllegalStateException).
    static class Account {
        private double balance;
        void deposit(double amt) { if (amt <= 0) throw new IllegalArgumentException("amount must be positive"); balance += amt; }
        void withdraw(double amt) {
            if (amt <= 0) throw new IllegalArgumentException("amount must be positive");
            if (amt > balance) throw new IllegalStateException("insufficient funds");
            balance -= amt;
        }
        double getBalance() { return balance; }
    }
    static void ex02() {
        Account a = new Account();
        a.deposit(100); a.withdraw(30);
        check(a.getBalance() == 70.0, "balance");
        checkThrows(IllegalArgumentException.class, () -> a.deposit(-5));
        checkThrows(IllegalStateException.class, () -> a.withdraw(1000));
        check(a.getBalance() == 70.0, "state unchanged after failures");
    }
    // @END

    // @EX 03 | Constructors | Create Rect with constructors Rect(w, h), Rect(side) and Rect() (unit square). Use this(...) to avoid duplicate code.
    static class Rect {
        final double w, h;
        Rect(double w, double h) { this.w = w; this.h = h; }
        Rect(double side) { this(side, side); }
        Rect() { this(1); }
        double area() { return w * h; }
    }
    static void ex03() {
        check(new Rect(2, 3).area() == 6.0, "w*h");
        check(new Rect(4).area() == 16.0, "square");
        check(new Rect().area() == 1.0, "unit");
    }
    // @END

    // @EX 04 | static members | Create a Ticket class that gives each new object a unique, increasing id using a static counter, and a static method issued() returning how many were created.
    static class Ticket {
        private static int next = 1;
        final int id;
        Ticket() { id = next++; }
        static int issued() { return next - 1; }
    }
    static void ex04() {
        int before = Ticket.issued();
        Ticket a = new Ticket(), b = new Ticket(), c = new Ticket();
        check(Ticket.issued() == before + 3, "count");
        check(b.id == a.id + 1 && c.id == b.id + 1, "ids increase");
    }
    // @END

    // @EX 05 | Inheritance | Create Animal(name) with speak(). Create Dog extends Animal whose speak() reuses the parent's text via super and appends ": Woof".
    static class Animal5 {
        protected final String name;
        Animal5(String name) { this.name = name; }
        String speak() { return name + " makes a sound"; }
    }
    static class Dog5 extends Animal5 {
        Dog5(String name) { super(name); }
        @Override String speak() { return super.speak() + ": Woof"; }
    }
    static void ex05() {
        check(new Dog5("Rex").speak().equals("Rex makes a sound: Woof"), "super call");
        check(new Animal5("Cat").speak().equals("Cat makes a sound"), "parent unchanged");
    }
    // @END

    // @EX 06 | Overriding | Vehicle.wheels() returns 4. Override it in Bike (2) and Trike (3). Show that a Vehicle reference calls the subclass version.
    static class Vehicle { int wheels() { return 4; } }
    static class Bike extends Vehicle { @Override int wheels() { return 2; } }
    static class Trike extends Vehicle { @Override int wheels() { return 3; } }
    static void ex06() {
        Vehicle v1 = new Vehicle(), v2 = new Bike(), v3 = new Trike();
        check(v1.wheels() == 4 && v2.wheels() == 2 && v3.wheels() == 3, "dynamic dispatch");
    }
    // @END

    // @EX 07 | Polymorphism | Build Figure[] containing a Circle(r=2) and a Rect(3x4). Write one loop that sums all areas without any instanceof checks.
    static abstract class Figure { abstract double area(); }
    static class Circle7 extends Figure { final double r; Circle7(double r) { this.r = r; } double area() { return Math.PI * r * r; } }
    static class Rect7 extends Figure { final double w, h; Rect7(double w, double h) { this.w = w; this.h = h; } double area() { return w * h; } }
    static void ex07() {
        Figure[] fs = { new Circle7(2), new Rect7(3, 4) };
        double total = 0;
        for (Figure f : fs) total += f.area();
        check(Math.abs(total - (4 * Math.PI + 12)) < 1e-9, "total area");
    }
    // @END

    // @EX 08 | Abstract classes | Create abstract class Staff with abstract pay(). Implement Salaried(monthly) and Hourly(hours, rate). Compute the payroll total for a List<Staff>.
    static abstract class Staff { abstract double pay(); }
    static class Salaried extends Staff { final double m; Salaried(double m) { this.m = m; } double pay() { return m; } }
    static class Hourly extends Staff { final int h; final double r; Hourly(int h, double r) { this.h = h; this.r = r; } double pay() { return h * r; } }
    static void ex08() {
        List<Staff> list = List.of(new Salaried(5000), new Hourly(10, 200), new Hourly(20, 100));
        double total = 0;
        for (Staff s : list) total += s.pay();
        check(total == 9000.0, "payroll");
    }
    // @END

    // @EX 09 | Interfaces (Comparable) | Make Player implement Comparable<Player> so that Collections.sort orders players by score, highest first.
    static class Player implements Comparable<Player> {
        final String name; final int score;
        Player(String name, int score) { this.name = name; this.score = score; }
        @Override public int compareTo(Player o) { return Integer.compare(o.score, this.score); }
    }
    static void ex09() {
        List<Player> ps = new ArrayList<>(List.of(new Player("A", 40), new Player("B", 90), new Player("C", 65)));
        Collections.sort(ps);
        check(ps.get(0).name.equals("B") && ps.get(1).name.equals("C") && ps.get(2).name.equals("A"), "descending order");
    }
    // @END

    // @EX 10 | Default methods | Define interface Greeter with abstract name() and a default greet() returning "Hello, <name>". Implement it with a lambda.
    interface Greeter {
        String name();
        default String greet() { return "Hello, " + name(); }
    }
    static void ex10() {
        Greeter g = () -> "Ravi";
        check(g.greet().equals("Hello, Ravi"), "default method uses abstract one");
    }
    // @END

    // @EX 11 | Overloading | Create Calc with add(int,int), add(double,double) and add(int...). Predict which one add(1,2), add(1.5,2.5), add(1,2,3) and add(1,2.5) call, then verify.
    static class Calc {
        String last;
        int add(int a, int b) { last = "int,int"; return a + b; }
        double add(double a, double b) { last = "double,double"; return a + b; }
        int add(int... xs) { last = "varargs"; int s = 0; for (int x : xs) s += x; return s; }
    }
    static void ex11() {
        Calc c = new Calc();
        c.add(1, 2);       check(c.last.equals("int,int"), "exact match wins over varargs");
        c.add(1.5, 2.5);   check(c.last.equals("double,double"), "doubles");
        c.add(1, 2, 3);    check(c.last.equals("varargs"), "three args");
        check(c.add(1, 2.5) == 3.5 && c.last.equals("double,double"), "int widens to double");
    }
    // @END

    // @EX 12 | Composition | Model a Car that HAS-A Engine. Car.start() must report the engine's start message plus "Car moving".
    static class Engine { String start() { return "Engine running"; } }
    static class Car12 {
        private final Engine engine = new Engine();
        String start() { return engine.start() + "; Car moving"; }
    }
    static void ex12() { check(new Car12().start().equals("Engine running; Car moving"), "delegation"); }
    // @END

    // @EX 13 | equals & hashCode | Implement equals and hashCode for Point(x, y) so that two equal points collapse to one entry in a HashSet.
    static class Point {
        final int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
        @Override public boolean equals(Object o) { return o instanceof Point p && p.x == x && p.y == y; }
        @Override public int hashCode() { return Objects.hash(x, y); }
    }
    static void ex13() {
        Set<Point> set = new HashSet<>();
        set.add(new Point(1, 2)); set.add(new Point(1, 2)); set.add(new Point(2, 1));
        check(set.size() == 2, "equal points collapse");
        check(set.contains(new Point(2, 1)), "lookup by value");
    }
    // @END

    // @EX 14 | Immutability | Create an immutable Money class (cents, currency). plus() must return a NEW object and reject different currencies.
    static final class Money {
        private final long cents; private final String currency;
        Money(long cents, String currency) { this.cents = cents; this.currency = currency; }
        Money plus(Money o) {
            if (!currency.equals(o.currency)) throw new IllegalArgumentException("currency mismatch");
            return new Money(cents + o.cents, currency);
        }
        long cents() { return cents; }
    }
    static void ex14() {
        Money a = new Money(500, "INR"), b = new Money(250, "INR");
        Money c = a.plus(b);
        check(c.cents() == 750 && a.cents() == 500, "original unchanged");
        checkThrows(IllegalArgumentException.class, () -> a.plus(new Money(1, "USD")));
    }
    // @END

    // @EX 15 | Singleton | Implement Config as a singleton: private constructor and getInstance() always returning the same object.
    static class Config {
        private static final Config INSTANCE = new Config();
        private Config() { }
        static Config getInstance() { return INSTANCE; }
    }
    static void ex15() { check(Config.getInstance() == Config.getInstance(), "same instance"); }
    // @END

    // @EX 16 | Enums | Create enum Level with weights LOW=1, MEDIUM=5, HIGH=10 and a static method fromWeight(int) returning the highest level whose weight is <= the input.
    enum Level {
        LOW(1), MEDIUM(5), HIGH(10);
        final int weight;
        Level(int weight) { this.weight = weight; }
        static Level fromWeight(int w) {
            Level best = LOW;
            for (Level l : values()) if (l.weight <= w) best = l;
            return best;
        }
    }
    static void ex16() {
        check(Level.fromWeight(0) == Level.LOW && Level.fromWeight(7) == Level.MEDIUM && Level.fromWeight(99) == Level.HIGH, "mapping");
    }
    // @END

    // @EX 17 | Custom exceptions | Create a checked InsufficientFundsException and a method withdraw(balance, amt) that throws it. Catch it and read the shortfall.
    static class InsufficientFundsException extends Exception {
        final double shortfall;
        InsufficientFundsException(double shortfall) { super("short by " + shortfall); this.shortfall = shortfall; }
    }
    static double withdraw(double balance, double amt) throws InsufficientFundsException {
        if (amt > balance) throw new InsufficientFundsException(amt - balance);
        return balance - amt;
    }
    static void ex17() {
        try { withdraw(100, 150); throw new AssertionError("should have thrown"); }
        catch (InsufficientFundsException e) { check(e.shortfall == 50.0, "shortfall"); }
        try { check(withdraw(100, 40) == 60.0, "ok path"); } catch (InsufficientFundsException e) { throw new AssertionError(e); }
    }
    // @END

    // @EX 18 | Casting & instanceof | Write describe(Object) using pattern matching: Integer -> "int <n+1>", String -> "str <length>", anything else -> "other". Show a bad downcast throws ClassCastException.
    static String describe(Object o) {
        if (o instanceof Integer i) return "int " + (i + 1);
        if (o instanceof String s) return "str " + s.length();
        return "other";
    }
    static void ex18() {
        check(describe(41).equals("int 42") && describe("hello").equals("str 5") && describe(2.5).equals("other"), "describe");
        Object o = "text";
        checkThrows(ClassCastException.class, () -> { Integer bad = (Integer) o; });
    }
    // @END

    // @EX 19 | Strategy pattern | Define interface Discount { double apply(double price); }. Use lambdas for 10% off, flat 50 off (never below 0) and no discount, then apply them in a checkout method.
    interface Discount { double apply(double price); }
    static double checkout(double price, Discount d) { return d.apply(price); }
    static void ex19() {
        Discount tenOff = p -> p * 0.9, flat = p -> Math.max(0, p - 50), none = p -> p;
        check(Math.abs(checkout(200, tenOff) - 180) < 1e-9, "10%");
        check(checkout(200, flat) == 150.0 && checkout(30, flat) == 0.0, "flat");
        check(checkout(200, none) == 200.0, "none");
    }
    // @END

    // @EX 20 | Generics | Write Box<T extends Comparable<T>> with isBigger(Box<T>) and a generic static max(List<T>) that works for Integer and String.
    static class Box<T extends Comparable<T>> {
        final T value;
        Box(T value) { this.value = value; }
        boolean isBigger(Box<T> o) { return value.compareTo(o.value) > 0; }
    }
    static <T extends Comparable<T>> T max(List<T> xs) {
        T best = xs.get(0);
        for (T x : xs) if (x.compareTo(best) > 0) best = x;
        return best;
    }
    static void ex20() {
        check(new Box<>(5).isBigger(new Box<>(3)) && !new Box<>("a").isBigger(new Box<>("b")), "Box");
        check(max(List.of(3, 9, 4)) == 9 && max(List.of("pear", "apple", "zebra")).equals("zebra"), "max");
    }
    // @END
}
