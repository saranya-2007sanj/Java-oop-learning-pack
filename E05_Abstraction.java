import java.util.List;

/** E05 - Abstraction: abstract class + template method; callers depend on the idea, not the details. */
public class E05_Abstraction {
    public static void main(String[] args) {
        List<Employee> staff = List.of(new FullTime("Asha", 60000), new PartTime("Ravi", 80, 250), new Intern("Meena"));
        double total = 0;
        for (Employee e : staff) { System.out.println(e.payslip()); total += e.monthlyPay(); }
        check(total == 60000 + 20000 + 8000, "payroll total");
        check(staff.get(1).payslip().equals("Ravi: 20000.00"), "payslip format comes from the base class");
        // new Employee("x");  // would not compile: Employee is abstract
    }
    static void check(boolean c, String m) { if (!c) throw new AssertionError(m); }
}

abstract class Employee {
    protected final String name;
    Employee(String name) { this.name = name; }
    abstract double monthlyPay();                                   // the "what"
    final String payslip() { return name + ": " + String.format("%.2f", monthlyPay()); } // template method
}
class FullTime extends Employee {
    private final double salary;
    FullTime(String n, double salary) { super(n); this.salary = salary; }
    double monthlyPay() { return salary; }
}
class PartTime extends Employee {
    private final int hours; private final double rate;
    PartTime(String n, int hours, double rate) { super(n); this.hours = hours; this.rate = rate; }
    double monthlyPay() { return hours * rate; }
}
class Intern extends Employee {
    Intern(String n) { super(n); }
    double monthlyPay() { return 8000; }
}
