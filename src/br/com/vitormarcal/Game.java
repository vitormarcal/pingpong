package br.com.vitormarcal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable, KeyListener, Tickable, Renderable {

    static final CustomDimension dimension = CustomDimension.of(160, 120, 3);

    static Player player;
    static Enemy enemy;
    static Ball ball;
    private BufferedImage layer;

    Game() {
        this.setPreferredSize(new Dimension(dimension.getScaleWidth(), dimension.getScaleHeight()));
        this.addKeyListener(this);
        player = new Player(60, dimension.getHeight() - 10);
        enemy = new Enemy(60, 5);
        ball = new Ball(60, dimension.getHeight() / 2);
        layer = new BufferedImage(dimension.getWidth(), dimension.getHeight(), BufferedImage.TYPE_INT_RGB);
    }

    public static void main(String[] args) {

        Game game = new Game();

        JFrame frame = new JFrame("PingPong!");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        new Thread(game).start();
    }

    @Override
    public void tick() {
        player.tick();
        enemy.tick();
        ball.tick();
    }

    @Override
    public void render() {
        BufferStrategy bufferStrategy = initBufferedStrategy();

        Graphics graphics = layer.getGraphics();
        graphics.setColor(Color.BLACK);

        graphics.fillRect(0, 0, dimension.getWidth(), dimension.getHeight());

        player.render(graphics);
        enemy.render(graphics);
        ball.render(graphics);
        render(bufferStrategy.getDrawGraphics());
    }

    @Override
    public CustomDimension getDimension() {
        return dimension;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(layer, 0, 0, dimension.getScaleWidth(), dimension.getScaleHeight(), null);
        showBuffer();
    }

    private void showBuffer() {
        BufferStrategy bufferStrategy = initBufferedStrategy();
        bufferStrategy.show();
    }

    private BufferStrategy initBufferedStrategy() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            this.createBufferStrategy(3);
            bufferStrategy = this.getBufferStrategy();
        }
        return bufferStrategy;
    }

    @Override
    public void run() {
        requestFocus();
        while (true) {
            tick();
            render();
            try {
                Thread.sleep(1_000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.setRight(true);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.setLeft(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.setRight(false);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.setLeft(false);
        }
    }
}
