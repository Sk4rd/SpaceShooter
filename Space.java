import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Space extends World {
    int points = 0;
    
    public Space()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        startLevel(0);
    }

    private void spawnPlayer()
    {
        // Spawn in lower middle
        addObject(new Player(), 400, 550);
    }

    /*
     * Spawn a given matrix of enemies and give them an amount of HP and speed.
     */
    private void spawnEnemies(int numToSpawn, int numRows, int healthPoints, int speed)
    {
        
        
        // create matrix of enemies
        List<Enemy> enemies = new ArrayList<Enemy>();
        for (int enemyCount = 0; enemyCount < numToSpawn; enemyCount++)
        {
            enemies.add(new Enemy(healthPoints, speed));
        }
        
        int intervalX = 800 / enemies.size();
        int step = intervalX / 2;
        
        for (Enemy enemy : enemies)
        {
            addObject(enemy, step, 32);
            step += intervalX;
        }
        
        //addObject(new Enemy(healthPoints, speed), offsetX + enemyCount * 128, offsetY);
    }

    public void spawnBullet(int posX, int posY)
    {
        // Spawn at location of actor
        addObject(new Bullet(), posX, posY);
    }
    
    private void startLevel(int level)
    {
        this.points = 0;
        
        if (level == 0)
        {
            spawnPlayer();
            spawnEnemies(4, 1, 25, 1);
        }
    }
}
