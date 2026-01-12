package codeinside.app.oop;

interface Payable {
    int pay(); // contract
}

abstract class Employee implements Payable {
    protected final String name;      // state
    protected Employee(String name) { this.name = name; }

    public String getName() { return name; } // shared implementation
}

class Contractor extends Employee {
    private final int hourlyRate;
    private final int hours;

    Contractor(String name, int hourlyRate, int hours) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }

    @Override public int pay() {
        return hourlyRate * hours;
    }
}
