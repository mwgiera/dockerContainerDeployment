package codeinside.app.bank;

/**
 * Interfejs = umowa.
 * Mówi: "jeśli coś jest PaymentProcessor, to POTRAFI wykonać przelew".
 * Nie mówi JAK. To robią klasy implementujące.
 */
public interface PaymentProcessor {
    void process(Account from, Account to, int amount);
}
