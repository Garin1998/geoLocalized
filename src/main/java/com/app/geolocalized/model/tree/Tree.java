package com.app.geolocalized.model.tree;

import com.app.geolocalized.model.tree.elements.Trunk;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public abstract class Tree {

    private Trunk trunk;

    public Tree() {
        this.trunk = new Trunk();
    }

    public abstract String getTreeType();
    public abstract String grow();
    public abstract String growBranches(ArrayList<String> branchID, int amount);
    public abstract String growLeavesOnBranch(String branchID, int amount);
    public abstract String shedAllLeavesFromBranch(String branchID);
    public abstract String shedAllLeavesFromAllBranches();

}
