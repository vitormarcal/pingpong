package br.com.vitormarcal.entities;

import br.com.vitormarcal.CustomDimension;
import br.com.vitormarcal.Game;

import java.awt.*;
import java.util.Random;

public class Ball implements Entity {

    private final CustomDimension dimension;
    private final EntityFactory entityFactory;
    private double x;
    private double y;
    private double dx;
    private double dy;

    private double speed = 1.0;

    Ball(double x, double y) {
        this.x = x;
        this.y = y;

        dimension = CustomDimension.of(4, 4);

        int angle = new Random().nextInt(75) + 46;
        dx = Math.cos(Math.toRadians(angle));
        dy = Math.sin(Math.toRadians(angle));

        entityFactory = EntityFactory.getEntityFactory();


    }

    @Override
    public void tick() {

        Enemy enemy = (Enemy) entityFactory.getEntitySet(Enemy.class);
        Player player = (Player) entityFactory.getEntitySet(Player.class);

        if (x + (dx * speed) + dimension.getWidth() >= Game.dimension.getWidth()) {
            dx *= -1;
        } else if (x + (dx * speed) < 0) {
            dx *= -1;
        }

        x += dx * speed;
        y += dy * speed;

        if (y >= Game.dimension.getHeight()) {
            System.out.println("Ponto do inimigo!");
            Game.RESTART = true;
            return;
        } else if (y < 0) {
            System.out.println("Ponto do jogador!");
            Game.RESTART = true;
            return;
        }

        Rectangle bounds = new Rectangle((int) (x + (dx * speed)), (int) (y + (dx * speed)), dimension.getWidth(), dimension.getHeight());
        Rectangle boundsPlayer = new Rectangle((int) player.getX(), (int) player.getY(), player.getDimension().getWidth(), player.getDimension().getHeight());
        Rectangle boundsEnemy = new Rectangle((int) enemy.getX(), (int) enemy.getY(), enemy.getDimension().getWidth(), enemy.getDimension().getHeight());

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

        speed += ((speed * 0.1) / 100);
        if (speed > 2.5)
            speed = 2.5;
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
