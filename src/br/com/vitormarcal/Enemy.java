package br.com.vitormarcal;

import java.awt.*;

public class Enemy implements Entity {

    private final CustomDimension dimension;
    private double x;
    private double y;

    Enemy(double x, double y) {
        this.x = x;
        this.y = y;

        dimension = CustomDimension.of(40, 5);
    }

    @Override
    public void tick() {
        x += (Game.ball.getX() - x - 6) * 0.085;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect((int) x, (int) y, dimension.getWidth(), dimension.getHeight());
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
}
