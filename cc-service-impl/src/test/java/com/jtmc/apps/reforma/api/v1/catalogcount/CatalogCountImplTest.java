package com.jtmc.apps.reforma.api.v1.catalogcount;

import com.jtmc.apps.reforma.api.v1.BadRequestException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;


@RunWith(BlockJUnit4ClassRunner.class)
public class CatalogCountImplTest {

    @InjectMocks
    private CatalogCountImpl catalogCountImpl;

    private CatalogCountRequest catalogCountRequest;
    private double expectedAmount = 0.1;
    private String expectedDetails = "some random value";
    private int expectedCatalogCountEnumId = 1;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        catalogCountRequest = new CatalogCountRequest();
        catalogCountRequest.setAmount(expectedAmount);
        catalogCountRequest.setDetails(expectedDetails);
    }

    @Test(expected = BadRequestException.class)
    public void test_insert_shouldReturnBadRequest_whenRequestObjectNull() {
        catalogCountImpl.insert(null);
    }

    @Test(expected = BadRequestException.class)
    public void testInsert_shouldReturnBadRequestException_whenAmountLessThanZero() {
        catalogCountRequest.setAmount(-0.7);
        catalogCountImpl.insert(catalogCountRequest);
    }

    @Test(expected = BadRequestException.class)
    public void testInsert_shouldReturnBadRequestException_whenAmountEqualsZero() {
        catalogCountRequest.setAmount(0.0);
        catalogCountImpl.insert(catalogCountRequest);
    }

    @Test(expected = BadRequestException.class)
    public void testInsert_shouldReturnBadRequest_whenDetailsBlank() {
       catalogCountRequest.setDetails("   ");
       catalogCountImpl.insert(catalogCountRequest);
    }

    @Test(expected = BadRequestException.class)
    public void testInsert_shouldReturnBadRequest_whenCatalogCountEnumNotSet() {
       catalogCountImpl.insert(catalogCountRequest);
    }
}