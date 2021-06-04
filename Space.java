import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Space extends World {
    int enemyCount = 0;
    
    public Space()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        spawnPlayer();
        // Seven enemies fit in a row
        spawnEnemies(5);
    }
    
    private void spawnPlayer()
    {
        // Spawn in lower middle
        addObject(new Player(), 400, 550);
    }
    
    private void spawnEnemies(int enemyAmount)
    {
        int offsetX = 100;
        int offsetY = 35;
        
        while (enemyCount != enemyAmount)
        {
            if (offsetX <= 700)
            addObject(new Enemy(), offsetX, offsetY);
            enemyCount++;
            offsetX += 100;
        }
    }
    
    public void spawnBullet(int posX, int posY)
    {
        // Spawn at location of actor
        addObject(new Bullet(), posX, posY);
    }
}
