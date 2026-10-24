/** E07 - Overloading (compile-time, by declared types) vs overriding (run-time, by actual object). */
public class E07_OverloadingOverriding {
    static String print(Object o) { return "Object"; }
    static String print(String s) { return "String"; }
    static String print(int i)    { return "int"; }

    public static void main(String[] args) {
        Object o = "hi";
        System.out.println("print(o)    -> " + print(o));      // chosen at compile time from the declared type Object
        System.out.println("print(\"hi\") -> " + print("hi"));
        System.out.println("print('c')  -> " + print('c'));     // char widens to int
        check(print(o).equals("Object"), "overload uses declared type");
        check(print("hi").equals("String"), "most specific overload");
        check(print(5).equals("int") && print('c').equals("int"), "primitive widening");

        Animal a = new Dog();                                    // declared Animal, actual Dog
        System.out.println("a.sound()   -> " + a.sound());      // chosen at run time from the actual object
        check(a.sound().equals("Woof"), "override uses actual type");
    }
    static void check(boolean c, String m) { if (!c) throw new AssertionError(m); }
}

class Animal { String sound() { return "..."; } }
class Dog extends Animal { @Override String sound() { return "Woof"; } }
