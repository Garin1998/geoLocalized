package com.app.geolocalized.testUtils;

import java.util.ArrayList;

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
}
