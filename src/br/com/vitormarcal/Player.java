package br.com.vitormarcal;

import java.awt.*;

public class Player implements Entity {


    public final int height;
    public final int width;
    public boolean right;
    public boolean left;
    private int x;
    private int y;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        width = 40;
        height = 5;
    }

    @Override
    public void tick() {

        if (right) {
            x++;
        } else if (left) {
            x--;
        }


        if (x + width > Game.WIDTH) {
            x = Game.WIDTH - width;
        } else if (x < 0) {
            x = 0;
        }

    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(x, y, width, height);
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
