package com.app.geolocalized.model.tree.elements;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * Store information about branch which is a part of tree's trunk.
 *
 * @author Krzysztof Kubiś
 * @version 1.0
 * @since JDK 17
 */
@Getter
@Setter
public class Branch {
    private ArrayList<Leaf> leaves;

    public Branch() {
        this.leaves = new ArrayList<>();
    }

    public void addLeaves(int amount) {
        int added = 0;
        while(added < amount) {
            this.leaves.add(new Leaf());
            added++;
        }

    }

    public void removeAllLeaves() {
        leaves.clear();
    }
}
