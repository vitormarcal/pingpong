package br.com.vitormarcal;

import java.awt.*;

public class Ball {

    private final int width;
    private final int height;
    public double x;
    public double y;

    public Ball(double x, double y) {
        this.x = x;
        this.y = y;
        width = 3;
        height = 3;
    }

    public void tick() {

    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillRect((int)x, (int)y, width, height);
    }
}
