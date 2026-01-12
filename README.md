mwgiera@icloud.com

                      JAVA OOP MINDMAP
                                   |
        ----------------------------------------------------------------
        |                 |                 |               |          |
     OOP Core        Encapsulation      Inheritance     Interfaces   Collections
        |                 |                 |               |          |
   Class (blueprint)   private fields     "is-a"         Contract     List (order)
   Object (instance)   methods enforce    vs             "can do"     Set (unique)
   Field (data)        rules              Composition    Swap impls   Map (key→value)
   Method (action)     valid ctor         "has-a"
   Polymorphism
   (one type, many behaviors)

        ----------------------------------------------------------------
        |                 |                 |               |
     Equality         Exceptions          State         Senior Habits
        |                 |                 |               |
   == same object     IllegalArg → bad   ACTIVE         Small methods
   equals() value     IllegalState →     BLOCKED        Clear names
   hashCode() rule    wrong mode         CLOSED         Keep invariants
                                         Check first    Interfaces = what/how

        ----------------------------------------------------------------
        |
     Override vs Overload
        |
   Override → same signature, new behavior (child)
   Overload → same name, different params (same class)

        ----------------------------------------------------------------
       |
   Clean, readable Java
   Correctness → simplicity
   Ask when unsure, iterate fast




                         ┌─────────────────────────────┐
                         │          UI / APP            │
                         │  (klik: przelew / wypłata)   │
                         └──────────────┬──────────────┘
                                        │
                                        v
                         ┌─────────────────────────────┐
                         │        TransferService       │
                         │  (logika biznesowa: transfer)│
                         └──────────────┬──────────────┘
        Kompozycja (HAS-A)              │
   ┌─────────────────────────┐         │         ┌─────────────────────────┐
   │ PaymentProcessor (iface)│<────────┘         │ FraudChecker (opcjonalnie)│
   │ "UMOWA: process(...)"   │                   │ "czy podejrzane?"         │
   └──────────────┬──────────┘                   └─────────────────────────┘
     Polimorfizm  │
  (podmienność)   │
      ┌───────────┴───────────┐
      v                       v
┌───────────────────┐   ┌────────────────────┐
│ BankTransferProc  │   │ MockProcessor       │
│ (prawdziwa logika)│   │ (do testów)         │
└──────────┬────────┘   └────────────────────┘
           │
           v
 ┌─────────────────────────────┐
 │  AccountRepository (Map)     │
 │  Map<accountNo, Account>     │
 └──────────────┬──────────────┘
                │  Map = szybkie znalezienie po kluczu
                v
      ┌────────────────────┐
      │ Account (base)      │  <--- enkapsulacja: private balance
      │  - accountNo (final)│  <--- final = tożsamość
      │  - balance (private)│
      │  - withdraw()       │
      └─────────┬──────────┘
     Dziedziczenie (IS-A)   │
                            │ Polimorfizm: jedna metoda, różne zachowanie
        ┌───────────────────┴───────────────────┐
        v                                       v
┌──────────────────────┐                ┌──────────────────────┐
│ SavingsAccount        │                │ BusinessAccount       │
│ override withdraw()   │                │ override withdraw()   │
│ (fee / rules)         │                │ (overdraft rules)     │
└──────────────────────┘                └──────────────────────┘

   List<Transaction> = historia (kolejność, duplikaty)
   Set<CustomerId>   = unikalność (np. zbiory)
   TreeMap           = raport posortowany (audyt)
   Exceptions         = kontrolowane "STOP": InsufficientFunds, IllegalArgument

   
