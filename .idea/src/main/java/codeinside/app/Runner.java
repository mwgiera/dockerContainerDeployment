package codeinside.app;

import codeinside.app.bank.Account;
import codeinside.app.bank.InsufficientFundsException;
import codeinside.app.bank.SavingsAccount;
import codeinside.app.bank.PaymentProcessor;
import codeinside.app.bank.BankTransferProcessor;
import codeinside.app.bank.TransferService;

public class Runner {

    public static void main(String[] args) {
        System.out.println("=== Java Interview Mini Harness (bank-style) ===\n");

        demoBankBasics();        // (1)-(5)
        demoInterface();         // (6)
        demoPolymorphism();      // (7)

        System.out.println("DONE ✅");
    }

    /**
     * (1)-(5) Klasa/obiekt/metody + enum + wyjątek + static (generator numeru konta).
     */
    private static void demoBankBasics() {
        System.out.println("[Bank Basics]");

        Account a = new Account("Alice", 100);
        System.out.println("Created: " + a);

        a.deposit(50);
        System.out.println("After deposit: " + a.getBalance());

        a.withdraw(70);
        System.out.println("After withdraw: " + a.getBalance());

        try {
            a.withdraw(999);
        } catch (InsufficientFundsException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        a.block();
        try {
            a.deposit(10);
        } catch (IllegalStateException e) {
            System.out.println("Expected status error: " + e.getMessage());
        }

        System.out.println();
    }

    /**
     * (6) Interfejs = "umowa co coś potrafi".
     * Tu: TransferService nie musi wiedzieć JAK robisz przelew (API, mock, test),
     * tylko że PaymentProcessor to potrafi.
     */
    private static void demoInterface() {
        System.out.println("[Interface]");

        PaymentProcessor processor = new BankTransferProcessor(); // konkretna implementacja
        TransferService service = new TransferService(processor); // wstrzykujemy zależność

        Account from = new Account("Bob", 200);
        Account to = new Account("Charlie", 10);

        System.out.println("Before: from=" + from.getBalance() + " to=" + to.getBalance());
        service.transfer(from, to, 50);
        System.out.println("After:  from=" + from.getBalance() + " to=" + to.getBalance());

        System.out.println();
    }

    /**
     * (7) Polimorfizm = "trzymam w ręku Account, ale zachowanie zależy od konkretu".
     * SavingsAccount to Account, ale ma inne withdraw (np. opłata).
     */
    private static void demoPolymorphism() {
        System.out.println("[Inheritance + Polymorphism]");

        Account normal = new Account("Daisy", 100);
        Account savings = new SavingsAccount("Eve", 100, 2); // fee=2

        normal.withdraw(10);   // zabierze 10
        savings.withdraw(10);  // zabierze 12 (10 + fee)

        System.out.println("Normal balance:  " + normal.getBalance());
        System.out.println("Savings balance: " + savings.getBalance());

        System.out.println("Type(normal)  = " + normal.getClass().getSimpleName());
        System.out.println("Type(savings) = " + savings.getClass().getSimpleName());

        System.out.println();
    }
}
