import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jtmc.apps.reforma.domain.CatalogCountEnum;
import com.jtmc.apps.reforma.api.v1.impl.ICatalogCountEnumService;
import org.apache.commons.configuration2.resolver.CatalogResolver;

import java.util.List;

public class Launcher {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new ServerModule());
        ICatalogCountEnumService ICatalogCountEnumService = injector.getInstance(ICatalogCountEnumService.class);

        CatalogCountEnum catalogTest = new CatalogCountEnum(
                "5.3", "Comida para niños", "comida de los dias domingos", false, false
        );

        ICatalogCountEnumService.insertCatalogCountEnum(catalogTest);
//        CatalogCountEnum result = ICatalogCountEnumService.getCatalogCountEnum(3);
//        System.out.println(result.toString());
//        List<CatalogCountEnum> catalogCountEnums = ICatalogCountEnumService.selectAllCatalogCountEnum();


//        try{
//            storeJson();
//        }catch(Exception e){System.out.println(e);}
//        System.out.println("Success...");
    }

    private static void storeJson() throws Exception {
//        CatalogCountsStoreInJsonRepository storeInJsonRepository = new CatalogCountsStoreInJsonRepository();
//
//        CatalogCounts expected = new CatalogCounts();
//        expected.setDetails("some value");
//        expected.setAmount(9.3);
//        expected.setCountsEnum(CatalogCountsEnum.DIEZMO);
//        expected.setRegistrationDateTime(LocalDateTime.MAX);
//
//        storeInJsonRepository.saveCatalogCounts(expected);

    }

    private void previousTest() {

//        System.out.println("write your name dude!:");
//        Scanner scanner = new Scanner(System.in);
//        String personsName = scanner.next();
//
//        PersonaRepository personaRepository = new PersonaRepository();
//
//        Date date = new Date("Mon Dec 09 23:21:05 PST 2019");
//        personaRepository.addNewPerson(new Persona(personsName, date));
//
//
////        personaRepository.printAllList();
//        personaRepository.getMostRecentVisit();
    }
}
