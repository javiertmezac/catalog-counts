package com.jtmc.apps.reforma.api.v1.catalogcount;

import com.jtmc.apps.reforma.dbmapper.catalogcount.CatalogCountMapper;
import com.jtmc.apps.reforma.domain.CatalogCount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.*;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;


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

    @Test(expected = NullPointerException.class)
    public void test_insert_shouldReturnBadRequest_whenRequestObjectNull() {
        catalogCountImpl.insert(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsert_shouldReturnBadRequestException_whenAmountLessThanZero() {
        catalogCountRequest.setAmount(-0.7);
        catalogCountImpl.insert(catalogCountRequest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsert_shouldReturnBadRequestException_whenAmountEqualsZero() {
        catalogCountRequest.setAmount(0.0);
        catalogCountImpl.insert(catalogCountRequest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsert_shouldReturnBadRequest_whenDetailsBlank() {
       catalogCountRequest.setDetails("   ");
       catalogCountImpl.insert(catalogCountRequest);
    }

    @Test(expected = IllegalArgumentException.class)
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

    /*
        GET LIST method
     */
    @Test
    public void testGetList_shouldCall_catalogCountMapper_selectAllMethod() throws Exception {
        catalogCountImpl.getList();
        verify(catalogCountMapper, times(1)).selectAllRecords();
    }

    @Test
    public void testGetList_shouldReturn_ExpectedValues_whenSelectAllMethod(){
        Date expectedDate = new Date();
        System.out.println(expectedDate.toString());
        CatalogCount expectedCatalogCount = new CatalogCount();
        expectedCatalogCount.setDetails(expectedDetails);
        expectedCatalogCount.setRegistrationDate(expectedDate);

        List<CatalogCount> listOfCatalogCount = new ArrayList<>();
        listOfCatalogCount.add(expectedCatalogCount);
        when(catalogCountMapper.selectAllRecords()).thenReturn(listOfCatalogCount);

        CatalogCountResponseList actualList = catalogCountImpl.getList();

        CatalogCountResponse actualCatalogCountResponse = actualList.catalogCountResponseCollection.get(0);
        Assert.assertEquals(expectedCatalogCount.getDetails(), actualCatalogCountResponse.getDetails());
        Assert.assertEquals(expectedDate, actualCatalogCountResponse.getRegistrationDate());

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
        when(catalogCountMapper.selectOneRecord(expectedId)).thenReturn(mockCatalogCount);

        catalogCountImpl.getCatalogCount(expectedId);
        verify(catalogCountMapper, times(1)).selectOneRecord(expectedId);
    }

    @Test
    public void testGetCatalogCount_shouldReturn_expectedRecord() throws Exception {

        int expectedId = 1;
        CatalogCount expectedCatalogCount = new CatalogCount();
        expectedCatalogCount.setDetails(expectedDetails);
        when(catalogCountMapper.selectOneRecord(expectedId)).thenReturn(expectedCatalogCount);

        CatalogCountResponse actualResponse = catalogCountImpl.getCatalogCount(expectedId);
        verify(catalogCountMapper, times(1)).selectOneRecord(expectedId);

        Assert.assertEquals(expectedDetails, actualResponse.getDetails());
    }

    @Test(expected = NotFoundException.class)
    public void testGetCatalogCount_returnsNotFoundException() throws Exception {
       when(catalogCountMapper.selectOneRecord(anyInt())).thenReturn(null);

       int expectedCatalogCountId = 1;
       catalogCountImpl.getCatalogCount(expectedCatalogCountId);
    }

    /*
        LOGICAL DELETE RECORD
     */

    @Test
    public void testLogicalDelete_shouldCall_MapperLogicalDelete() {
        int expectedId = 1;
        catalogCountImpl.logicalDeleteRecord(expectedId);
        verify(catalogCountMapper, times(1)).logicalDeleteRecord(expectedId);
    }
}