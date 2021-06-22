package com.jtmc.apps.reforma.api.v1.catalogcount;

import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.impl.catalogcount.CatalogCountImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;


@Ignore
@RunWith(BlockJUnit4ClassRunner.class)
public class CatalogCountApiImplTest {

    @InjectMocks
    private CatalogCountApiImpl catalogCountApiImpl;

    @Mock
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
        catalogCountRequest.setCatalogCountEnumId(expectedCatalogCountEnumId);
    }

    @Test(expected = NullPointerException.class)
    public void test_insert_shouldReturnBadRequest_whenRequestObjectNull() {
        catalogCountApiImpl.insert(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsert_shouldReturnBadRequestException_whenAmountLessThanZero() {
        catalogCountRequest.setAmount(-0.7);
        catalogCountApiImpl.insert(catalogCountRequest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsert_shouldReturnBadRequestException_whenAmountEqualsZero() {
        catalogCountRequest.setAmount(0.0);
        catalogCountApiImpl.insert(catalogCountRequest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsert_shouldReturnBadRequest_whenDetailsBlank() {
       catalogCountRequest.setDetails("   ");
       catalogCountApiImpl.insert(catalogCountRequest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsert_shouldReturnBadRequest_whenCatalogCountEnumNotSet() {
        //note: for testing purposes we are setting catalogCountEnumId equals 0
        //this is to simulate no value was set in the original api call
        catalogCountRequest.setCatalogCountEnumId(0);
       catalogCountApiImpl.insert(catalogCountRequest);
    }

    @Test
    public void testInsert_shouldCall_catalogCountImpl_insertWithRegistrationDate() {
        catalogCountApiImpl.insert(catalogCountRequest);

        ArgumentCaptor<CatalogCount> captor = ArgumentCaptor.forClass(CatalogCount.class);
        verify(catalogCountImpl).insertIntoCatalogCount(captor.capture());
        CatalogCount actual = captor.getValue();
        Assert.assertTrue(actual.getRegistrationDate() != null);
    }

    @Test
    public void testInsert_happyPath() throws Exception {
        catalogCountApiImpl.insert(catalogCountRequest);

        ArgumentCaptor<CatalogCount> captor = ArgumentCaptor.forClass(CatalogCount.class);
        verify(catalogCountImpl).insertIntoCatalogCount(captor.capture());
        CatalogCount actual = captor.getValue();
        Assert.assertTrue(actual.getRegistrationDate() != null);
        Assert.assertTrue(expectedAmount == actual.getAmount());
        Assert.assertTrue(expectedCatalogCountEnumId == actual.getCatalogCountEnumId());
        Assert.assertEquals(expectedDetails, actual.getDetails());

    }

    /*
        GET LIST method
     */
    @Test
    public void testGetList_shouldCall_catalogCountImpl_selectAllMethod() throws Exception {
        catalogCountApiImpl.getList();
        verify(catalogCountImpl, times(1)).selectAllRecordsWithTotalColumn(anyDouble());
    }

    @Test
    public void testGetList_shouldReturn_ExpectedValues_whenSelectAllRecords(){
        Date expectedDate = new Date();
        int expectedId = 3;
        CatalogCountResponse expectedCatalogCountResponse =
                new CatalogCountResponse(
                        expectedId,
                        expectedDate,
//                        expectedCatalogCountEnumId,
                        expectedAmount,
                        expectedDetails
                );

        List<CatalogCountResponse> listOfCatalogCount = new ArrayList<>();
        listOfCatalogCount.add(expectedCatalogCountResponse);
        when(catalogCountImpl.selectAllRecordsWithTotalColumn(anyDouble())).thenReturn(listOfCatalogCount);

        CatalogCountResponseList actualList = catalogCountApiImpl.getList();

        CatalogCountResponse actualCatalogCountResponse = actualList.getCatalogCountResponseCollection().get(0);
        Assert.assertEquals(expectedCatalogCountResponse.getDetails(), actualCatalogCountResponse.getDetails());
        Assert.assertEquals(expectedDate, actualCatalogCountResponse.getRegistrationDate());

    }

    @Test(expected = RuntimeException.class)
    @Ignore
    public void testGetList_throwsException_whenNotAbleToGet_MonthlyTotal() throws Exception {
       when(catalogCountImpl.getCorrespondingMonthlyTotal()).thenThrow(RuntimeException.class);
       catalogCountApiImpl.getList();
    }

    /*
        GET ONE RECORD
     */


    //note we can try implementing everything as a mock
    //like this example
    @Test
    public void testGetCatalogCount_shouldCall_mapperGetOneRecordMethod() throws Exception {

        int expectedId = 1;
        CatalogCount mockCatalogCount = Mockito.mock(CatalogCount.class);
        when(catalogCountImpl.selectOneRecord(expectedId)).thenReturn(mockCatalogCount);

        catalogCountApiImpl.getCatalogCount(expectedId);
        verify(catalogCountImpl, times(1)).selectOneRecord(expectedId);
    }

    @Test
    public void testGetCatalogCount_shouldReturn_expectedRecord() throws Exception {

        int expectedId = 1;
        CatalogCount expectedCatalogCount = new CatalogCount();
        expectedCatalogCount.setDetails(expectedDetails);
        when(catalogCountImpl.selectOneRecord(expectedId)).thenReturn(expectedCatalogCount);

        CatalogCountResponse actualResponse = catalogCountApiImpl.getCatalogCount(expectedId);
        verify(catalogCountImpl, times(1)).selectOneRecord(expectedId);

        Assert.assertEquals(expectedDetails, actualResponse.getDetails());
    }

    @Test(expected = RuntimeException.class)
    public void testGetCatalogCount_returnsNotFoundException() throws Exception {
       when(catalogCountImpl.selectOneRecord(anyInt())).thenReturn(null);

       int expectedCatalogCountId = 1;
       catalogCountApiImpl.getCatalogCount(expectedCatalogCountId);
    }

    /*
        LOGICAL DELETE RECORD
     */

    @Test
    public void testLogicalDelete_shouldCall_MapperLogicalDelete() {
        int expectedId = 1;
        catalogCountApiImpl.logicalDeleteRecord(expectedId);
        verify(catalogCountImpl, times(1)).logicalDeleteRecord(expectedId);
    }
}