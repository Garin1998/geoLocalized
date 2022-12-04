package com.app.geolocalized.model.tree;

import com.app.geolocalized.model.tree.elements.Trunk;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * Abstract class provided basic template for different types of trees.
 *
 * @author Krzysztof Kubiś
 * @version 1.0
 * @since JDK 17
 */
@Getter
@Setter
public abstract class Tree {

    private Trunk trunk;

    public Tree() {
        this.trunk = new Trunk();
    }

    /**
     * Provide name of tree type.
     *
     * @return Name of tree type.
     */
    public abstract String getTreeType();

    /**
     * Makes tree's trunk to grow.
     *
     * @return Message with information about growing status.
     */
    public abstract String grow();

    /**
     * Makes tree to grow specific amount of branches with specific ID each.
     *
     * @param branchID Collection of names for each branch.
     * @param amount How many branches is expected to grow on trunk.
     * @return Message with information about growing status.
     */
    public abstract String growBranches(ArrayList<String> branchID, int amount);

    /**
     * Makes specific amount of leaves to grow on selected branch.
     *
     * @param branchID ID of selected branch.
     * @param amount how many leaves is expected to grow on selected branch.
     * @return Message with information about growing status.
     */
    public abstract String growLeavesOnBranch(String branchID, int amount);

    /**
     * Makes selected branch to shed all existing leaves on it.
     * @param branchID ID of selected branch.
     * @return Message with information about shedding status.
     */
    public abstract String shedAllLeavesFromBranch(String branchID);

    /**
     * Makes shed leaves on all existing branches on tree's trunk.
     * @return Message with information about shedding status.
     */
    public abstract String shedAllLeavesFromAllBranches();

}
