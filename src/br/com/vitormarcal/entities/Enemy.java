package br.com.vitormarcal.entities;

import br.com.vitormarcal.CustomDimension;
import br.com.vitormarcal.Game;

import java.awt.*;

public class Enemy implements Entity {

    private final CustomDimension dimension;
    private final EntityFactory entityFactory;
    private double x;
    private double y;

    Enemy(double x, double y) {
        this.x = x;
        this.y = y;

        dimension = CustomDimension.of(40, 5);
        entityFactory = EntityFactory.getEntityFactory();
    }

    @Override
    public void tick() {
        Ball ball = (Ball) entityFactory.getEntitySet(Ball.class);
        x += (ball.getX() - x - 6) * 0.085;

        if (x + dimension.getWidth() > Game.dimension.getWidth()) {
            x = Game.dimension.getWidth() - dimension.getWidth();
        } else if (x < 0) {
            x = 0;
        }
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
