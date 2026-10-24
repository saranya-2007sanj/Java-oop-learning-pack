/** E08 - Composition over inheritance: Car HAS-A Engine; behaviour can be swapped at run time. */
public class E08_Composition {
    public static void main(String[] args) {
        Automobile auto = new Automobile(new PetrolEngine());
        System.out.println(auto.drive());
        check(auto.drive().equals("Petrol engine burns fuel -> moving"), "petrol");
        auto.setEngine(new ElectricEngine());                    // swap behaviour without subclassing
        System.out.println(auto.drive());
        check(auto.drive().equals("Electric motor spins -> moving"), "electric");
    }
    static void check(boolean c, String m) { if (!c) throw new AssertionError(m); }
}

interface Engine { String start(); }
class PetrolEngine implements Engine { public String start() { return "Petrol engine burns fuel"; } }
class ElectricEngine implements Engine { public String start() { return "Electric motor spins"; } }

class Automobile {
    private Engine engine;                                       // has-a
    Automobile(Engine engine) { this.engine = engine; }
    void setEngine(Engine e) { this.engine = e; }
    String drive() { return engine.start() + " -> moving"; }
}
