package com.javatunes.personnel;

import java.sql.Date;

class DummyEmployee extends Employee {

    public DummyEmployee() {
    }

    public DummyEmployee(String name, Date hireDate) {
        super(name, hireDate);
    }

    /**
     * All employees get paid, but they implement this differently.
     * Method in base class but NO implementation.
     */
    @Override
    public double pay() {
        return 0;
    }

    @Override
    public double payTaxes() {
        return 0;
    }
}