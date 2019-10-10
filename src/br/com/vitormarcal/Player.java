package br.com.vitormarcal;

import java.awt.*;

public class Player {

    public void tick() {

    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(100, 120-10, 40,10);
    }

}
