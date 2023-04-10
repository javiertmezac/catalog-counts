package com.jtmc.apps.reforma.api.v1.catalogcountenum;

import com.jtmc.apps.reforma.domain.CatalogCountEnum;
import com.jtmc.apps.reforma.repository.CatalogCountEnumRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CatalogCountEnumApiImplTest {
    @InjectMocks
    private CatalogCountEnumApiImpl catalogCountEnumApiImpl;

    @Mock
    private CatalogCountEnumRepository catalogCountEnumRepository;

    private EasyRandom easyRandom;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        easyRandom = new EasyRandom();
    }

    @Test
    void testGetCatalogCountEnums_callsCatalogCountEnumRepo() {
        catalogCountEnumApiImpl.getCatalogCountEnums();
        verify(catalogCountEnumRepository).selectAllCatalogCountEnum();
    }

    @Test
    void testGetCatalogCountEnums_returnsExpectedValue() {
        Stream<CatalogCountEnum> easyRandomCatalogCountEnumStream =
                easyRandom.objects(CatalogCountEnum.class, 4);
        CatalogCountEnum randomInitialAmount = easyRandom.nextObject(CatalogCountEnum.class);
        List<CatalogCountEnum> expectedCatalogCountEnum = easyRandomCatalogCountEnumStream
                .filter(x -> !x.getIdentifier().equals(randomInitialAmount.getIdentifier()))
                .collect(Collectors.toList());
        when(catalogCountEnumRepository.selectAllCatalogCountEnum()).thenReturn(expectedCatalogCountEnum);
        when(catalogCountEnumRepository.getInitialAmountEnum())
                .thenReturn(randomInitialAmount);

        CatalogCountEnumResponseList actualResponse = catalogCountEnumApiImpl.getCatalogCountEnums();

        Assertions.assertNotNull(actualResponse);
        Assertions.assertTrue(expectedCatalogCountEnum.size() == actualResponse.getCatalogCountEnumList().size());

        String label = String.format("%s - %s", expectedCatalogCountEnum.get(0).getIdentifier(), expectedCatalogCountEnum.get(0).getName());
        Assertions.assertEquals(label, actualResponse.getCatalogCountEnumList().get(0).getLabel());
    }
}