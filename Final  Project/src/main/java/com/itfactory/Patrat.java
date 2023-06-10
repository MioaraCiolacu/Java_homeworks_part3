package com.itfactory;

public class Patrat implements FiguriGeometrice {
    private int lungime;

    public Patrat(int lungime) {
        this.lungime = lungime;
    }

    @Override
    public int calculeazaPerimetru() {
        return 4 * lungime;
    }
}
