package com.itfactory;

public class Triunghi implements FiguriGeometrice {
    private int cateta1;
    private int cateta2;
    private int ipotenuza;

    public Triunghi(int cateta1, int cateta2, int ipotenuza) {
        this.cateta1 = cateta1;
        this.cateta2 = cateta2;
        this.ipotenuza = ipotenuza;
    }
    @Override
    public int calculeazaPerimetru() {
        return cateta1 + cateta2 + ipotenuza;
    }
}
