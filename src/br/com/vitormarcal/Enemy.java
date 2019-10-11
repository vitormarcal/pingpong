package br.com.vitormarcal;

import java.awt.*;

public class Enemy implements Entity {

    public final int width;
    public final int height;
    private double x;
    private double y;

    public Enemy(double x, double y) {
        this.x = x;
        this.y = y;
        width = 40;
        height = 5;
    }

    @Override
    public void tick() {
        x += (Game.ball.getX() - x - 6) * 0.085;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect((int) x, (int) y, width, height);
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
