package br.com.vitormarcal.entities;

import java.util.*;

public class EntityFactory {

    private static EntityFactory entityFactory;

    private Map<Class, Entity> entitySet = new HashMap<>();

    public static EntityFactory getEntityFactory() {
        if (entityFactory == null) {
            synchronized (EntityFactory.class) {
                if (entityFactory == null) {
                    entityFactory = new EntityFactory();
                }
            }
        }
        return entityFactory;
    }


    public Player fabricatePlayer(int x, int y) {
        Player player = new Player(x, y - 10);
        entitySet.put(Player.class, player);
        return player;
    }

    public Enemy fabricateEnemy(int x, int y) {
        Enemy enemy = new Enemy(x, y);
        entitySet.put(Enemy.class, enemy);
        return enemy;
    }


    public Ball fabricateBall(int x, int y) {
        Ball ball = new Ball(x, y / 2);
        entitySet.put(Ball.class, ball);
        return ball;
    }

    public Collection<Entity> entityList() {
        return entitySet.values();
    }

    public Entity getEntitySet(Class clazz) {
        return entitySet.get(clazz);
    }
}
