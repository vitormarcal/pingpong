package br.com.vitormarcal;

import java.awt.*;
import java.util.Random;

public class Ball {

    public final int width;
    public final int height;
    public double x;
    public double y;
    public double dx;
    public double dy;

    public double speed = 1.7;

    public Ball(double x, double y) {
        this.x = x;
        this.y = y;
        width = 4;
        height = 4;

        int angle = new Random().nextInt(75) + 46;
        dx = Math.cos(Math.toRadians(angle));
        dy = Math.sin(Math.toRadians(angle));
    }

    public void tick() {

        if (x + (dx * speed) + width >= Game.WIDTH) {
            dx *= -1;
        } else if (x + (dx * speed) < 0) {
            dx *= -1;
        }

        x += dx * speed;
        y += dy * speed;

        if (y >= Game.HEIGHT) {
            System.out.println("Ponto do inimigo!");
            new Game();
            return;
        } else if (y < 0) {
            System.out.println("Ponto do jogador!");
            new Game();
            return;
        }

        Rectangle bounds = new Rectangle((int) (x + (dx * speed)), (int) (y + (dx * speed)), width, height);
        Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
        Rectangle boundsEnemy = new Rectangle((int) Game.enemy.x, (int) Game.enemy.y, Game.enemy.width, Game.enemy.height);

        if (bounds.intersects(boundsPlayer)) {
            int angle = new Random().nextInt(75) + 46;
            dx = Math.cos(Math.toRadians(angle));
            dy = Math.sin(Math.toRadians(angle));
            if (dy > 0) {
                dy *= -1;
            }
        } else if (bounds.intersects(boundsEnemy)) {
            int angle = new Random().nextInt(75) + 46;
            dx = Math.cos(Math.toRadians(angle));
            dy = Math.sin(Math.toRadians(angle));
            if (dy < 0) {
                dy *= -1;
            }
        }
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillRect((int) x, (int) y, width, height);
    }
}
