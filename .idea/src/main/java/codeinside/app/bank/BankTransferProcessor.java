package codeinside.app.bank;

/**
 * Implementacja interfejsu = konkret.
 */
public class BankTransferProcessor implements PaymentProcessor {

    @Override
    public void process(Account from, Account to, int amount) {
        // Najprostszy model: zabierz z jednego, dodaj do drugiego
        from.withdraw(amount);
        to.deposit(amount);
    }
}
