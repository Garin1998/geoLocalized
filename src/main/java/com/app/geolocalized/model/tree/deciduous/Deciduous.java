package com.app.geolocalized.model.tree.deciduous;

import com.app.geolocalized.model.tree.Tree;

public abstract class Deciduous extends Tree {

    public Deciduous() {
        super();
    }

    @Override
    public String getTreeType() {
        return "Deciduous";
    }
}
