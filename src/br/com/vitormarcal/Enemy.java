package br.com.vitormarcal;

import java.awt.*;

public class Enemy {

    public final int width;
    public final int height;
    public double x;
    public double y;

    public Enemy(double x, double y) {
        this.x = x;
        this.y = y;
        width = 40;
        height = 5;
    }

    public void tick() {
        x += (Game.ball.x - x - 6) * 0.085;
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect((int) x, (int) y, width, height);
    }

}
