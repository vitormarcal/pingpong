package br.com.vitormarcal;

import java.awt.*;
import java.util.Random;

public class Ball {

    private final int width;
    private final int height;
    public double x;
    public double y;
    public double dx;
    public double dy;

    public double speed = 1.6;

    public Ball(double x, double y) {
        this.x = x;
        this.y = y;
        width = 4;
        height = 4;

        dx = new Random().nextGaussian();
        dy = new Random().nextGaussian();
    }

    public void tick() {
        x += dx * speed;
        y += dy * speed;
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillRect((int)x, (int)y, width, height);
    }
}
