package codeinside.app.bank;

/**
 * Wyjątek = sygnał, że nie da się wykonać operacji.
 * RuntimeException = nie musisz go deklarować w każdym miejscu (prościej na junior poziomie).
 */
public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
