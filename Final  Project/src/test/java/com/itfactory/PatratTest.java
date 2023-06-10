package com.itfactory;

import org.testng.annotations.Test;
import static junit.framework.Assert.assertEquals;

public class PatratTest {
    private Patrat patrat;

    @Test
    public void testCalculeazaPerimetru(){
        patrat=new Patrat(6);
        int perimetru= patrat.calculeazaPerimetru();
        assertEquals(24,24);
    }
}
