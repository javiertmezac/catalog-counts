package com.jtmc.apps.reforma.domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.WeakHashMap;

import static org.junit.Assert.*;

public class CatalogCountsTest {

    @InjectMocks
    private CatalogCounts catalogCounts;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = Exception.class)
    public void setAmount_ThrowsException_whenEqualsZero() throws Exception {
        catalogCounts.setAmount(0.0);
    }

    @Test(expected = Exception.class)
    public void setAmount_ThrowsException_whenLessThanZero() throws Exception {
        catalogCounts.setAmount(-0.1);
    }

    @Test
    public void setAmount_SetsValue_whenGreaterThanZero() throws Exception {
        double expectedValue = 0.1;
        catalogCounts.setAmount(expectedValue);
        assertTrue(expectedValue == catalogCounts.getAmount());
    }

    @Test(expected = Exception.class)
    public void setDetails_ThrowsException_WhenWhiteSpaces() throws Exception {
       catalogCounts.setDetails("   ");
    }

    @Test (expected = Exception.class)
    public void setDetails_ThrowsException_WhenEmpty() throws Exception {
        catalogCounts.setDetails("");
    }

    @Test(expected = Exception.class)
    public void setDetails_ThrowsException_WhenNull() throws Exception {
        catalogCounts.setDetails(null);
    }

    @Test
    public void setDetails_SetsCorrectValue() throws Exception {
        String expectedValue = "random_value";
        catalogCounts.setDetails(expectedValue);
        assertEquals(expectedValue, catalogCounts.getDetails());
    }

    @Test (expected = Exception.class)
    public void setLocalDate_ThrowsException_WhenNull() throws Exception {
        catalogCounts.setRegistrationDateTime(null);
    }

    @Test
    public void setLocalDate_SetsCorrectValue() throws Exception {
        LocalDateTime localDateTime = LocalDateTime.MAX;
        catalogCounts.setRegistrationDateTime(localDateTime);
        assertEquals(localDateTime, catalogCounts.getRegistrationDateTime());
    }

    @Test (expected = Exception.class)
    public void setCountsEnum_ThrowsException_WhenNull() throws Exception {
        catalogCounts.setCountsEnum(null);
    }

    @Test
    public void setCountsEnum_SetsCorrectValue() throws Exception {
        CatalogCountsEnum countsEnum = CatalogCountsEnum.OFRENDA;
        catalogCounts.setCountsEnum(countsEnum);
        assertEquals(countsEnum, catalogCounts.getCountsEnum());
    }
}