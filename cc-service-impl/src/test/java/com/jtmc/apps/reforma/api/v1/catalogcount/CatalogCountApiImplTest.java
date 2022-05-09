package com.jtmc.apps.reforma.api.v1.catalogcount;

import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.domain.legacy.CatalogCountEnum;
import com.jtmc.apps.reforma.impl.catalogcount.CatalogCountImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;
import java.time.Instant;
import java.util.ArrayList;
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
    private Instant registrationDate = Instant.now();
    private int defaultBranchId = 1;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        catalogCountRequest = new CatalogCountRequest();
        catalogCountRequest.setAmount(expectedAmount);
        catalogCountRequest.setDetails(expectedDetails);
        catalogCountRequest.setCatalogCountEnumId(expectedCatalogCountEnumId);
        catalogCountRequest.setRegistrationDate(registrationDate);
    }

    @Test(expected = NullPointerException.class)
    public void test_insert_shouldReturnBadRequest_whenRequestObjectNull() {
        catalogCountApiImpl.insert(0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsert_shouldReturnBadRequestException_whenAmountLessThanZero() {
        catalogCountRequest.setAmount(-0.7);
        catalogCountApiImpl.insert(0, catalogCountRequest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsert_shouldReturnBadRequestException_whenAmountEqualsZero() {
        catalogCountRequest.setAmount(0.0);
        catalogCountApiImpl.insert(0, catalogCountRequest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsert_shouldReturnBadRequest_whenDetailsBlank() {
       catalogCountRequest.setDetails("   ");
       catalogCountApiImpl.insert(defaultBranchId, catalogCountRequest);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testInsert_shouldReturnBadRequest_whenCatalogCountEnumNotSet() {
        //note: for testing purposes we are setting catalogCountEnumId equals 0
        //this is to simulate no value was set in the original api call
        catalogCountRequest.setCatalogCountEnumId(0);
       catalogCountApiImpl.insert(defaultBranchId, catalogCountRequest);
    }

    @Test
    public void testInsert_shouldCall_catalogCountImpl_insertWithRegistrationDate() {
        catalogCountApiImpl.insert(defaultBranchId, catalogCountRequest);

        ArgumentCaptor<CatalogCount> captor = ArgumentCaptor.forClass(CatalogCount.class);
        verify(catalogCountImpl).insertIntoCatalogCount(captor.capture());
        CatalogCount actual = captor.getValue();

        Assert.assertTrue(actual.getRegistration() != null);
        Assert.assertEquals(registrationDate, actual.getRegistration());
    }

    @Test
    public void testInsert_happyPath() throws Exception {
        Response response = catalogCountApiImpl.insert(defaultBranchId, catalogCountRequest);

        ArgumentCaptor<CatalogCount> captor = ArgumentCaptor.forClass(CatalogCount.class);
        verify(catalogCountImpl).insertIntoCatalogCount(captor.capture());

        CatalogCount actual = captor.getValue();
        Assert.assertTrue(actual.getRegistration() != null);
        Assert.assertTrue(expectedAmount == actual.getAmount());
        Assert.assertTrue(expectedCatalogCountEnumId == actual.getCatalogcountenumid());
        Assert.assertEquals(expectedDetails, actual.getDetails());
        Assert.assertEquals(registrationDate, actual.getRegistration());

        Assertions.assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
    }

    /*
        GET LIST method
     */
    @Test
    public void testGetList_shouldCall_catalogCountImpl_selectAllMethod() throws Exception {
        catalogCountApiImpl.getList(defaultBranchId);
        verify(catalogCountImpl, times(1)).selectAllWithTotalColumn(defaultBranchId);
    }

    @Test
    public void testGetList_shouldReturn_ExpectedValues_whenSelectAllRecords(){

        Instant expectedDate = Instant.now();
        int expectedId = 3;
        String expectedCatalogCountEnumDescription = "random-value";

        CatalogCountResponse expectedCatalogCountResponse =
                new CatalogCountResponse(
                        expectedId,
                        expectedDate.toString(),
                        expectedCatalogCountEnumDescription,
                        expectedAmount,
                        expectedDetails
                );

        List<CatalogCountResponse> listOfCatalogCount = new ArrayList<>();
        listOfCatalogCount.add(expectedCatalogCountResponse);
        when(catalogCountImpl.selectAllWithTotalColumn(defaultBranchId)).thenReturn(listOfCatalogCount);

        CatalogCountResponseList actualList = catalogCountApiImpl.getList(0);

//        Assert.assertTrue(expectedSaldoAnterior == actualList.getSaldoAnterior());

        CatalogCountResponse actualCatalogCountResponse = actualList.getCatalogCountResponseCollection().get(0);
        Assert.assertEquals(expectedCatalogCountResponse.getDetails(), actualCatalogCountResponse.getDetails());
        Assert.assertEquals(expectedDate.toString(), actualCatalogCountResponse.getRegistrationDate());

        verify(catalogCountImpl).selectAllWithTotalColumn(0);
    }

    @Test
    public void testGetList_throwsException_whenNotAbleToGet_MonthlyTotal() throws Exception {
       Assertions.assertThrows(RuntimeException.class, () -> catalogCountApiImpl.getList(0));

       verify(catalogCountImpl, never()).selectAllWithTotalColumn(0);
    }

    /*
        GET ONE RECORD
     */
    @Test
    public void testGetCatalogCount_shouldCall_mapperGetOneRecordMethod() throws Exception {

        int expectedId = 1;
        CatalogCount mockCatalogCount = new CatalogCount();
        mockCatalogCount.setId(expectedId);
        mockCatalogCount.setRegistration(Instant.now());
        mockCatalogCount.setCatalogcountenumid(4);
        mockCatalogCount.setAmount(9.92);
        mockCatalogCount.setDetails("some details");

        when(catalogCountImpl.selectOneRecord(expectedId)).thenReturn(mockCatalogCount);

        catalogCountApiImpl.getCatalogCount(defaultBranchId, expectedId);
        verify(catalogCountImpl, times(1)).selectOneRecord(expectedId);
    }

    @Test
    public void testGetCatalogCount_shouldReturn_expectedRecord() throws Exception {

        int expectedId = 1;
        CatalogCount expectedCatalogCount = new CatalogCount();
        expectedCatalogCount.setDetails(expectedDetails);
        expectedCatalogCount.setRegistration(Instant.now());

        CatalogCountEnum expectedCatalogCountEnum = new CatalogCountEnum();
        expectedCatalogCountEnum.setName("random");
        expectedCatalogCountEnum.setIdentifier("identifier");
        expectedCatalogCount.setCatalogcountenumid(4);

        when(catalogCountImpl.selectOneRecord(expectedId)).thenReturn(expectedCatalogCount);

        CatalogCountResponse actualResponse = catalogCountApiImpl.getCatalogCount(defaultBranchId, expectedId);
        verify(catalogCountImpl, times(1)).selectOneRecord(expectedId);

        Assert.assertEquals(expectedDetails, actualResponse.getDetails());
        Assert.assertEquals("identifier - random", actualResponse.getCatalogCountEnum());
    }

    @Test(expected = RuntimeException.class)
    public void testGetCatalogCount_returnsNotFoundException() throws Exception {
       when(catalogCountImpl.selectOneRecord(anyInt())).thenReturn(null);

       int expectedCatalogCountId = 1;
       catalogCountApiImpl.getCatalogCount(defaultBranchId, expectedCatalogCountId);
    }

    /*
        LOGICAL DELETE RECORD
     */

    @Test
    public void testLogicalDelete_shouldCall_MapperLogicalDelete() {
        int expectedId = 1;
        catalogCountApiImpl.logicalDeleteRecord(defaultBranchId, expectedId);
        verify(catalogCountImpl, times(1)).logicalDeleteRecord(expectedId);
    }
}