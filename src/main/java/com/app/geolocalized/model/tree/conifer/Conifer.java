package com.app.geolocalized.model.tree.conifer;

import com.app.geolocalized.model.tree.Tree;

public abstract class Conifer extends Tree {

    public Conifer() {
        super();
    }

    @Override
    public String getTreeType() {
        return "Conifer";
    }
}
