package br.com.vitormarcal.entities;

import br.com.vitormarcal.CustomDimension;
import br.com.vitormarcal.Game;

import java.awt.*;

public class Player implements Entity {

    private final CustomDimension dimension;

    private boolean right;
    private boolean left;
    private int x;
    private int y;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;

        dimension = CustomDimension.of(40, 5);
    }

    @Override
    public void tick() {

        if (right) {
            x++;
        } else if (left) {
            x--;
        }


        if (x + dimension.getWidth() > Game.dimension.getWidth()) {
            x = Game.dimension.getWidth() - dimension.getWidth();
        } else if (x < 0) {
            x = 0;
        }

    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(x, y, dimension.getWidth(), dimension.getHeight());
    }

    @Override
    public CustomDimension getDimension() {
        return dimension;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}
