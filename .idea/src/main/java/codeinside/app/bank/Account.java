package codeinside.app.bank;

/**
 * Klasa = przepis (template).
 * Obiekt = konkretna instancja z pamięci: "to konto Ani z saldem 100".
 */
public class Account {

    // private = nikt z zewnątrz nie może tego zmienić bez kontroli (to jest ENKAPSULACJA)
    private final String accountNumber;
    private String ownerName;
    private int balance; // dla juniora int wystarczy (w realu pieniądze -> BigDecimal)
    private AccountStatus status;

    // static = należy do KLASY, nie do obiektu.
    // Użyjemy do prostego generatora numerów kont.
    private static int nextId = 1;

    /**
     * Konstruktor = sposób tworzenia obiektu.
     * Ustalamy startowy stan konta.
     */
    public Account(String ownerName, int initialBalance) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner name cannot be empty");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }

        this.accountNumber = generateAccountNumber();
        this.ownerName = ownerName;
        this.balance = initialBalance;
        this.status = AccountStatus.ACTIVE;
    }

    // public = API klasy (to co inni mogą wołać)
    public void deposit(int amount) {
        ensureActive();
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be > 0");
        }
        balance += amount;
    }

    public void withdraw(int amount) {
        ensureActive();
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be > 0");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Not enough funds. balance=" + balance + ", requested=" + amount);
        }
        balance -= amount;
    }

    public void block() {
        status = AccountStatus.BLOCKED;
    }

    public void close() {
        status = AccountStatus.CLOSED;
    }

    // Gettery = kontrolowany dostęp do danych (zamiast grzebania w polach)
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getBalance() {
        return balance;
    }

    public AccountStatus getStatus() {
        return status;
    }

    // prywatne metody = logika pomocnicza (ukryta)
    private void ensureActive() {
        if (status != AccountStatus.ACTIVE) {
            throw new IllegalStateException("Account is not ACTIVE. status=" + status);
        }
    }

    private static String generateAccountNumber() {
        // Prosty generator dla demo: ACC-0001, ACC-0002...
        int id = nextId++;
        return String.format("ACC-%04d", id);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                ", status=" + status +
                '}';
    }
}
