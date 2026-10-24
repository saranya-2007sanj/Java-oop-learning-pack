/** E02 - Encapsulation: private state, validated access through methods. */
public class E02_Encapsulation {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-1", 1000);
        acc.deposit(500);
        acc.withdraw(200);
        System.out.println(acc);
        check(acc.getBalance() == 1300.0, "balance");

        try { acc.deposit(-10); check(false, "negative deposit must fail"); }
        catch (IllegalArgumentException e) { System.out.println("Rejected: " + e.getMessage()); }
        try { acc.withdraw(99999); check(false, "overdraft must fail"); }
        catch (IllegalStateException e) { System.out.println("Rejected: " + e.getMessage()); }
        check(acc.getBalance() == 1300.0, "invalid operations leave state unchanged");
    }
    static void check(boolean c, String m) { if (!c) throw new AssertionError(m); }
}

class BankAccount {
    private final String id;
    private double balance;                       // cannot be touched from outside
    BankAccount(String id, double opening) {
        if (opening < 0) throw new IllegalArgumentException("opening balance < 0");
        this.id = id; this.balance = opening;
    }
    void deposit(double amt) {
        if (amt <= 0) throw new IllegalArgumentException("deposit must be positive");
        balance += amt;
    }
    void withdraw(double amt) {
        if (amt <= 0) throw new IllegalArgumentException("withdrawal must be positive");
        if (amt > balance) throw new IllegalStateException("insufficient funds");
        balance -= amt;
    }
    double getBalance() { return balance; }
    @Override public String toString() { return id + " balance=" + balance; }
}
