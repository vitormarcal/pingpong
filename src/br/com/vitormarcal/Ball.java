package br.com.vitormarcal;

import java.awt.*;
import java.util.Random;

public class Ball implements Entity {

    private final CustomDimension dimension;
    private double x;
    private double y;
    private double dx;
    private double dy;

    public double speed = 1.7;

    public Ball(double x, double y) {
        this.x = x;
        this.y = y;

        dimension = CustomDimension.of(4, 4);

        int angle = new Random().nextInt(75) + 46;
        dx = Math.cos(Math.toRadians(angle));
        dy = Math.sin(Math.toRadians(angle));
    }

    @Override
    public void tick() {

        if (x + (dx * speed) + dimension.getWidth() >= Game.dimension.getWidth()) {
            dx *= -1;
        } else if (x + (dx * speed) < 0) {
            dx *= -1;
        }

        x += dx * speed;
        y += dy * speed;

        if (y >= Game.dimension.getHeight()) {
            System.out.println("Ponto do inimigo!");
            new Game();
            return;
        } else if (y < 0) {
            System.out.println("Ponto do jogador!");
            new Game();
            return;
        }

        Rectangle bounds = new Rectangle((int) (x + (dx * speed)), (int) (y + (dx * speed)), dimension.getWidth(), dimension.getHeight());
        Rectangle boundsPlayer = new Rectangle((int) Game.player.getX(), (int) Game.player.getY(), Game.player.getDimension().getWidth(), Game.player.getDimension().getHeight());
        Rectangle boundsEnemy = new Rectangle((int) Game.enemy.getX(), (int) Game.enemy.getY(), Game.enemy.getDimension().getWidth(), Game.player.getDimension().getHeight());

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

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillRect((int) getX(), (int) getY(), dimension.getWidth(), dimension.getHeight());
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
