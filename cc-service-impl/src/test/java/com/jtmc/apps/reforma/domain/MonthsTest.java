package com.jtmc.apps.reforma.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MonthsTest {

    @Test
    void valueOfNumber() {
        String expectedLabel = "JUNE";
        Months month = Months.valueOfNumber(6);
        Assertions.assertEquals(expectedLabel, month.name());
    }

}