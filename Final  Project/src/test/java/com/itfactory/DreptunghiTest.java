package com.itfactory;

import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;


public class DreptunghiTest {
    private Dreptunghi dreptunghi;

    @Test
    public void testCalculeazaPerimetru() {
        dreptunghi = new Dreptunghi(5, 6);
        int perimetru = dreptunghi.calculeazaPerimetru();
        assertEquals(22, perimetru);
    }

}
