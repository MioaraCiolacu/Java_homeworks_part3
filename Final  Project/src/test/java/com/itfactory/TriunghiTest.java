package com.itfactory;

import org.testng.annotations.Test;
import static junit.framework.Assert.assertFalse;

public class TriunghiTest {
    private Triunghi triunghi;

    @Test
    public void testCalculeazaPerimetru(){
        triunghi=new Triunghi(3,4,5);
        int perimetru= triunghi.calculeazaPerimetru();
        assertFalse(perimetru!=12);
    }

}
