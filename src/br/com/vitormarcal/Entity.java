package br.com.vitormarcal;

public interface Entity extends Tickable, Renderable {
    
    double getX();

    double getY();

    default void render() {
        throw new UnsupportedOperationException("Not implemented");
    }

}
