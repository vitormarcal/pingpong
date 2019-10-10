package br.com.vitormarcal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable, KeyListener {

    public static int WIDTH = 240;
    public static int HEIGHT = 120;
    public static int SCALE = 3;

    public Player player;
    public BufferedImage layer;

    public Game() {
        this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        this.addKeyListener(this);
        player = new Player(100, HEIGHT -10);
        layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
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

    public void tick() {
        player.tick();
    }

    public void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if(bufferStrategy == null) {
            this.createBufferStrategy(3);
            bufferStrategy = this.getBufferStrategy();
        }
        Graphics graphics = layer.getGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0, WIDTH, HEIGHT);
        player.render(graphics);


        graphics = bufferStrategy.getDrawGraphics();
        graphics.drawImage(layer, 0,0,WIDTH*SCALE, HEIGHT*SCALE, null);
        bufferStrategy.show();
    }

    @Override
    public void run() {
        while(true) {
            tick();
            render();
            try {
                Thread.sleep(1_000/60);
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
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right = true;
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right = false;
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left = false;
        }
    }
}
