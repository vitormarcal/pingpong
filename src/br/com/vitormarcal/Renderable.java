package br.com.vitormarcal;

import java.awt.*;

public interface Renderable {

    void render(Graphics graphics);

    void render();

    CustomDimension getDimension();

}
