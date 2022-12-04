package com.app.geolocalized.model.tree.deciduous;

import com.app.geolocalized.model.tree.Tree;

/**
 * Abstract subclass of {@link Tree Class} provided basic template for deciduous trees.
 *
 * @author Krzysztof Kubiś
 * @version 1.0
 * @since JDK 17
 */
public abstract class Deciduous extends Tree {

    public Deciduous() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTreeType() {
        return "Deciduous";
    }
}
