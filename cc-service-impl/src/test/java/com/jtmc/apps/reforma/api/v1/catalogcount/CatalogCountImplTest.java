package com.jtmc.apps.reforma.api.v1.catalogcount;

import com.jtmc.apps.reforma.api.v1.BadRequestException;
import com.jtmc.apps.reforma.dbmapper.catalogcount.CatalogCountMapper;
import com.jtmc.apps.reforma.domain.CatalogCount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.*;

import java.util.Date;

import static org.mockito.Mockito.verify;


@RunWith(BlockJUnit4ClassRunner.class)
public class CatalogCountImplTest {

    @InjectMocks
    private CatalogCountImpl catalogCountImpl;

    @Mock
    private CatalogCountMapper catalogCountMapper;

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
        catalogCountRequest.setCatalogCountEnumId(expectedCatalogCountEnumId);
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
        //note: for testing purposes we are setting catalogCountEnumId equals 0
        //this is to simulate no value was set in the original api call
        catalogCountRequest.setCatalogCountEnumId(0);
       catalogCountImpl.insert(catalogCountRequest);
    }

    @Test
    public void testInsert_shouldCall_catalogMapper_insertWithRegistrationDate() {
        catalogCountImpl.insert(catalogCountRequest);

        ArgumentCaptor<CatalogCount> captor = ArgumentCaptor.forClass(CatalogCount.class);
        verify(catalogCountMapper).insertIntoCatalogCount(captor.capture());
        CatalogCount actual = captor.getValue();
        Assert.assertTrue(actual.getRegistrationDate() != null);
    }

    @Test
    public void testInsert_happyPath() throws Exception {
        catalogCountImpl.insert(catalogCountRequest);

        ArgumentCaptor<CatalogCount> captor = ArgumentCaptor.forClass(CatalogCount.class);
        verify(catalogCountMapper).insertIntoCatalogCount(captor.capture());
        CatalogCount actual = captor.getValue();
        Assert.assertTrue(actual.getRegistrationDate() != null);
        Assert.assertTrue(expectedAmount == actual.getAmount());
        Assert.assertTrue(expectedCatalogCountEnumId == actual.getCatalogCountEnumId());
        Assert.assertEquals(expectedDetails, actual.getDetails());

    }
}