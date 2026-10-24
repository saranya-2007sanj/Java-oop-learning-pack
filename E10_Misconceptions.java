/** E10 - Classic Java gotchas that AI answers and students often get wrong. Every line is verified by execution. */
public class E10_Misconceptions {
    public static void main(String[] args) {
        // 1. Fields are NOT polymorphic - only instance methods are.
        Parent p = new Child();
        System.out.println("p.name -> " + p.name + ", ((Child) p).name -> " + ((Child) p).name);
        check(p.name.equals("Parent") && ((Child) p).name.equals("Child"), "field hiding");

        // 2. static methods are hidden, not overridden: chosen by declared type.
        check(Parent.who().equals("Parent") && Child.who().equals("Child"), "static hiding");

        // 3. == compares references; equals compares content.
        String a = new String("java"), b = new String("java");
        System.out.println("a == b -> " + (a == b) + ", a.equals(b) -> " + a.equals(b));
        check(a != b && a.equals(b), "string identity vs equality");

        // 4. Java is always pass-by-value (the value of a reference is copied).
        StringBuilder sb = new StringBuilder("hi");
        change(sb);
        System.out.println("after change(): " + sb);
        check(sb.toString().equals("hi!"), "reassigning the parameter does not affect caller");

        // 5. Private members are not inherited as accessible members, but a subclass object still contains them.
        Child c = new Child();
        check(c.reveal().equals("secret"), "parent's private state still exists in the child object");
    }
    static void change(StringBuilder s) { s.append("!"); s = new StringBuilder("new"); }
    static void check(boolean c, String m) { if (!c) throw new AssertionError(m); }
}

class Parent {
    String name = "Parent";
    private String secret = "secret";
    static String who() { return "Parent"; }
    String reveal() { return secret; }
}
class Child extends Parent {
    String name = "Child";                 // hides, does not override
    static String who() { return "Child"; }
}
