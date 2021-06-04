import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Space extends World {
    int enemyCount = 0;

    public Space()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        spawnPlayer();
        // Six enemies fit in a row nicely
        spawnEnemies(4);
    }

    private void spawnPlayer()
    {
        // Spawn in lower middle
        addObject(new Player(), 400, 550);
    }

    private void spawnEnemies(int enemyAmount)
    {
        // (Res - ScreenSize * enemies) / 2 + halfOfSize
        int offsetX = (800 - 128 * enemyAmount) / 2 + 64; // padding
        int offsetY = 35;
        
        while (enemyCount != enemyAmount)
        {
            addObject(new Enemy(), offsetX + enemyCount * 128, offsetY);
            enemyCount++;
        }
    }

    public void spawnBullet(int posX, int posY)
    {
        // Spawn at location of actor
        addObject(new Bullet(), posX, posY);
    }
}
