/** E03 - Inheritance: is-a, super(...), constructor chaining order, extending behaviour. */
public class E03_Inheritance {
    static final StringBuilder LOG = new StringBuilder();

    public static void main(String[] args) {
        ElectricCar tesla = new ElectricCar("Tesla", 4, 75);
        System.out.println(LOG);
        check(LOG.toString().equals("Vehicle>Car>ElectricCar"), "parent constructors run first");
        System.out.println(tesla.describe());
        check(tesla.describe().equals("Tesla with 4 wheels, battery 75 kWh"), "describe");
        check(tesla instanceof Car && tesla instanceof Vehicle, "is-a chain");
    }
    static void check(boolean c, String m) { if (!c) throw new AssertionError(m); }
}

class Vehicle {
    protected final String brand;
    Vehicle(String brand) { this.brand = brand; E03_Inheritance.LOG.append("Vehicle"); }
    String describe() { return brand; }
}
class Car extends Vehicle {
    protected final int wheels;
    Car(String brand, int wheels) { super(brand); this.wheels = wheels; E03_Inheritance.LOG.append(">Car"); }
    @Override String describe() { return super.describe() + " with " + wheels + " wheels"; }
}
class ElectricCar extends Car {
    private final int kwh;
    ElectricCar(String brand, int wheels, int kwh) { super(brand, wheels); this.kwh = kwh; E03_Inheritance.LOG.append(">ElectricCar"); }
    @Override String describe() { return super.describe() + ", battery " + kwh + " kWh"; }
}
