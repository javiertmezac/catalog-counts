package com.jtmc.apps.reforma.domain;

import com.google.inject.Inject;
import org.junit.Test;

import static org.junit.Assert.*;

public class CatalogCountsEnumTest {
    @Inject
    private CatalogCountsEnum countsEnum;

    @Test
    public void getOfrenda_ValueAndType_AreCorrect() throws Exception {
        double ofrendaValue = 1.1;
        String typeOfrenda = "CARGO";
        String ofrendaName = "OFRENDA";

        countsEnum = CatalogCountsEnum.OFRENDA;

        assertEquals(typeOfrenda, countsEnum.getType());
        assertEquals(ofrendaName, countsEnum.toString());
        assertTrue(ofrendaValue == countsEnum.getValue());
    }

}