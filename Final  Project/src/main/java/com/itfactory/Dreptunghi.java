package com.itfactory;

public class Dreptunghi implements FiguriGeometrice {
    private int latura;
    private int latime;

    public Dreptunghi(int latura, int latime) {
        this.latura = latura;
        this.latime = latime;
    }

    @Override
    public int calculeazaPerimetru() {
        return 2 * latura + 2 * latime;
    }
}
