package codeinside.app.bank;

/**
 * enum = zamknięta lista możliwych wartości.
 * Tu: konto ma status i tylko te statusy są dozwolone.
 */
public enum AccountStatus {
    ACTIVE,
    BLOCKED,
    CLOSED
}
