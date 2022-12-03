package com.app.geolocalized.model.tree.deciduous.species;

import com.app.geolocalized.model.tree.elements.Branch;
import com.app.geolocalized.model.tree.deciduous.Deciduous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringJoiner;

public class Birch extends Deciduous {

    public Birch() {
        super();
    }

    @Override
    public String grow() {
        return "Birch had grown";
    }

    @Override
    public String growBranches(ArrayList<String> branchID, int amount) {
        this.getTrunk().addBranches(branchID, amount);

        StringJoiner stringJoiner = new StringJoiner(" ");
        return stringJoiner
                .add("Birch had grown")
                .add(Integer.toString(amount))
                .add("new branches")
                .toString();
    }

    @Override
    public String growLeavesOnBranch(String branchID, int amount) {
        Branch selectedBranch = this.getTrunk().getBranches().get(branchID);

        if(selectedBranch == null) {
            throw new NullPointerException("Selected branch doesn't exist");
        }

        selectedBranch.addLeaves(amount);

        StringJoiner stringJoiner = new StringJoiner(" ");
        return stringJoiner
                .add("Birch had grown")
                .add(Integer.toString(amount))
                .add("new leaves on branch")
                .add(branchID)
                .toString();
    }

    @Override
    public String shedAllLeavesFromBranch(String branchID) {
        this.getTrunk().getBranches().get(branchID).removeAllLeaves();

        StringJoiner stringJoiner = new StringJoiner(" ");
        return stringJoiner
                .add("Birch had shed all leaves from branch")
                .add(branchID)
                .toString();
    }

    @Override
    public String shedAllLeavesFromAllBranches() {
        HashMap<String, Branch> branches = this.getTrunk().getBranches();

        branches.forEach((branchID,branch) -> branch.getLeaves().clear());

        return "Birch had shed all leaves from all branches";
    }
}
