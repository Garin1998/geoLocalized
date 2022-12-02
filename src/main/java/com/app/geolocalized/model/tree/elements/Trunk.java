package com.app.geolocalized.model.tree.elements;

import com.app.geolocalized.model.tree.elements.Branch;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
public class Trunk {
    private HashMap<String, Branch> branches;

    public Trunk() {
        this.branches = new HashMap<>();
    }

    public void addBranches(ArrayList<String> branchID, int amount) {
        int added = 0;
        while(added < amount) {
            this.branches.put(branchID.get(added), new Branch());
            added++;
        }

    }
}
