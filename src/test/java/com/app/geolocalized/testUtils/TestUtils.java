package com.app.geolocalized.testUtils;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;

public class TestUtils {

    public static ArrayList<String> createNewNamesForBranchesToAdd(int amount) {
        ArrayList<String> branchesID = new ArrayList<>();

        int added = 0;
        while(added < amount) {
            branchesID.add("Branch " + added);
            added++;
        }
        return branchesID;
    }

    public static JsonObject createJSONBodyWithGeoLocalizationData(String deviceId, String latitude, String longitude) {
        JsonObject body = new JsonObject();
        body.addProperty("deviceId", deviceId);
        body.addProperty("latitude", latitude);
        body.addProperty("longitude", longitude);
        return body;
    }

    public static JsonObject createJsonFromStrings(HashMap<String, String> listOfStrings) {
        JsonObject json = new JsonObject();

        listOfStrings.forEach(
                json::addProperty
                );

        return json;
    }
}
