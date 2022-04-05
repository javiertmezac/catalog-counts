package com.jtmc.apps.reforma.api.v1.catalogcount;

import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.domain.CatalogCountEnum;
import com.jtmc.apps.reforma.impl.catalogcount.CatalogCountImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.*;

import javax.ws.rs.core.Response;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

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

        Assert.assertTrue(actual.getRegistration() != null);
        Assert.assertEquals(registrationDate, actual.getRegistration());
    }

    @Test
    public void testInsert_happyPath() throws Exception {
        Response response = catalogCountApiImpl.insert(catalogCountRequest);

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
        catalogCountApiImpl.getList();
        verify(catalogCountImpl, times(1)).selectAllWithTotalColumn();
    }

    @Test
    public void testGetList_shouldReturn_ExpectedValues_whenSelectAllRecords(){

        double expectedSaldoAnterior = 0.0;
        when(catalogCountImpl.getCorrespondingTotal()).thenReturn(expectedSaldoAnterior);

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
        when(catalogCountImpl.selectAllWithTotalColumn()).thenReturn(listOfCatalogCount);

        CatalogCountResponseList actualList = catalogCountApiImpl.getList();

//        Assert.assertTrue(expectedSaldoAnterior == actualList.getSaldoAnterior());

        CatalogCountResponse actualCatalogCountResponse = actualList.getCatalogCountResponseCollection().get(0);
        Assert.assertEquals(expectedCatalogCountResponse.getDetails(), actualCatalogCountResponse.getDetails());
        Assert.assertEquals(expectedDate.toString(), actualCatalogCountResponse.getRegistrationDate());

        verify(catalogCountImpl).getCorrespondingTotal();
        verify(catalogCountImpl).selectAllWithTotalColumn();
    }

    @Test
    public void testGetList_throwsException_whenNotAbleToGet_MonthlyTotal() throws Exception {
       doThrow(RuntimeException.class).when(catalogCountImpl).getCorrespondingTotal();
       Assertions.assertThrows(RuntimeException.class, () -> catalogCountApiImpl.getList());

       verify(catalogCountImpl, never()).selectAllWithTotalColumn();
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

        catalogCountApiImpl.getCatalogCount(expectedId);
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

        CatalogCountResponse actualResponse = catalogCountApiImpl.getCatalogCount(expectedId);
        verify(catalogCountImpl, times(1)).selectOneRecord(expectedId);

        Assert.assertEquals(expectedDetails, actualResponse.getDetails());
        Assert.assertEquals("identifier - random", actualResponse.getCatalogCountEnum());
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