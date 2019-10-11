package br.com.vitormarcal.entities;

import br.com.vitormarcal.Renderable;
import br.com.vitormarcal.Tickable;

public interface Entity extends Tickable, Renderable {

    double getX();

    double getY();

    default void render() {
        throw new UnsupportedOperationException("Not implemented");
    }

}
