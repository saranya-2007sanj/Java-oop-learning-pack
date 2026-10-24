/** E09 - static vs instance state, initialisation order, constructor chaining with this(...). */
public class E09_StaticAndConstructors {
    public static void main(String[] args) {
        new Counter();
        new Counter("x");
        System.out.println(Counter.LOG);
        check(Counter.LOG.toString().equals("static-init;instance-init;ctor(auto);instance-init;ctor(x);"), "init order");
        check(Counter.count == 2, "static field shared by all objects");
    }
    static void check(boolean c, String m) { if (!c) throw new AssertionError(m); }
}

class Counter {
    static final StringBuilder LOG = new StringBuilder();
    static int count;                                  // one copy for the whole class
    static { LOG.append("static-init;"); }             // runs once, when the class is first used
    { LOG.append("instance-init;"); }                  // runs for every object, before the constructor body
    Counter() { this("auto"); }                        // constructor chaining
    Counter(String label) { count++; LOG.append("ctor(" + label + ");"); }
}
