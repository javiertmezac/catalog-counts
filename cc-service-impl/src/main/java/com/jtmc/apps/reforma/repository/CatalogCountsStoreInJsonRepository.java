package com.jtmc.apps.reforma.repository;

import com.google.gson.Gson;
import com.jtmc.apps.reforma.domain.CatalogCounts;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class CatalogCountsStoreInJsonRepository implements ICrudActionsRepository {

    @Override
    public void saveCatalogCounts(CatalogCounts catalogCounts) throws Exception {
        if (catalogCounts == null) {
            throw new Exception("saveCatalogCounts object is null");
        }

        Gson catalogCountsJson = new Gson();
        String jsonValue = catalogCountsJson.toJson(catalogCounts);
        System.out.println(jsonValue);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("one_value", jsonValue);

        //Write JSON file
        try (FileWriter file = new FileWriter("catalog_counts.json", true)) {

            file.write(jsonObject.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
            //what ever
        }
    }

    @Override
    public CatalogCounts getCatalogCount(CatalogCounts catalogCounts) {
        return null;
    }

    @Override
    public List<CatalogCounts> getAllCatalogCounts() {
        return null;
    }

    @Override
    public List<CatalogCounts> getRangeDateRegisteredCatalogCounts(Date from, Date to) {
        return null;
    }

}
