package br.com.vitormarcal;

import java.awt.*;

public class Enemy {

    private final int width;
    private final int height;
    public double x;
    public double y;

    public Enemy(double x, double y) {
        this.x = x;
        this.y = y;
        width = 40;
        height = 10;
    }

    public void tick() {
        x += (Game.ball.x - x - 6);
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect((int) x, (int) y, width, height);
    }

}
