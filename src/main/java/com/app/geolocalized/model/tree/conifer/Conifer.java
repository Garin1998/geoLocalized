package com.app.geolocalized.model.tree.conifer;

import com.app.geolocalized.model.tree.Tree;

/**
 * Abstract subclass of {@link Tree Class} provided basic template for conifer trees.
 *
 * @author Krzysztof Kubiś
 * @version 1.0
 * @since JDK 17
 */
public abstract class Conifer extends Tree {

    public Conifer() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTreeType() {
        return "Conifer";
    }
}
