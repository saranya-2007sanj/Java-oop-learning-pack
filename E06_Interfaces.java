import java.util.List;

/** E06 - Interfaces: a contract that unrelated classes can fulfil; default methods; multiple interfaces. */
public class E06_Interfaces {
    public static void main(String[] args) {
        Duck duck = new Duck();
        Drone drone = new Drone();
        List<Flyable> flyers = List.of(duck, drone);          // unrelated classes, one type
        for (Flyable f : flyers) System.out.println(f.getClass().getSimpleName() + " -> " + f.fly() + " [" + f.mode() + "]");
        check(duck.fly().equals("flaps wings"), "duck fly");
        check(drone.fly().equals("spins rotors"), "drone fly");
        check(duck.mode().equals("flying"), "default method inherited");
        check(drone.mode().equals("hovering"), "default method overridden");
        check(duck.swim().equals("paddles"), "implements two interfaces");
    }
    static void check(boolean c, String m) { if (!c) throw new AssertionError(m); }
}

interface Flyable {
    String fly();
    default String mode() { return "flying"; }
}
interface Swimmable { String swim(); }
class Duck implements Flyable, Swimmable {
    public String fly() { return "flaps wings"; }
    public String swim() { return "paddles"; }
}
class Drone implements Flyable {
    public String fly() { return "spins rotors"; }
    @Override public String mode() { return "hovering"; }
}
