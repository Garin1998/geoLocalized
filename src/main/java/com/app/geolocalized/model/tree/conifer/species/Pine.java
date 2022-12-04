package com.app.geolocalized.model.tree.conifer.species;

import com.app.geolocalized.model.tree.elements.Branch;
import com.app.geolocalized.model.tree.conifer.Conifer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringJoiner;

/**
 * Subclass of {@link Conifer Class} provided methods for Pine tree.
 *
 * @author Krzysztof Kubiś
 * @version 1.0
 * @since JDK 17
 */
public class Pine extends Conifer {

    public Pine() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String grow() {
        return "Pine had grown";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String growBranches(ArrayList<String> branchID, int amount) {
        this.getTrunk().addBranches(branchID, amount);

        StringJoiner stringJoiner = new StringJoiner(" ");
        return stringJoiner
                .add("Pine had grown")
                .add(Integer.toString(amount))
                .add("new branches")
                .toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String growLeavesOnBranch(String branchID, int amount) {
        Branch selectedBranch = this.getTrunk().getBranches().get(branchID);

        if(selectedBranch == null) {
            throw new NullPointerException("Selected branch doesn't exist");
        }

        selectedBranch.addLeaves(amount);

        StringJoiner stringJoiner = new StringJoiner(" ");
        return stringJoiner
                .add("Pine had grown")
                .add(Integer.toString(amount))
                .add("new leaves on branch")
                .add(branchID)
                .toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String shedAllLeavesFromBranch(String branchID) {
        this.getTrunk().getBranches().get(branchID).removeAllLeaves();

        StringJoiner stringJoiner = new StringJoiner(" ");
        return stringJoiner
                .add("Pine had shed all leaves from branch")
                .add(branchID)
                .toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String shedAllLeavesFromAllBranches() {
        HashMap<String, Branch> branches = this.getTrunk().getBranches();

        branches.forEach((branchID,branch) -> branch.getLeaves().clear());

        return "Pine had shed all leaves from all branches";
    }
}
