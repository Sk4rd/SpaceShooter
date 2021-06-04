import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Space extends World 
{  
    public Space()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels
        super(800, 600, 1);
        spawnPlayer(400, 520);
    }
        
    public void act()
    {
        if (getObjects(Enemy.class).isEmpty())
        {           
            spawnEnemies(getRandomNum(1, 8),
                         getRandomNum(1, 6),
                         getRandomNum(25, 75),
                         getRandomNum(1, 4));
        }
        
        if (getObjects(Player.class).isEmpty())
        {
            Greenfoot.stop();
        }
    }   

    private void spawnPlayer(int x, int y)
    {
        addObject(new Player(), x, y);
    }

    /*
     * Spawn a given matrix of enemies and give them an amount of HP and speed.
     */
    private void spawnEnemies(int numToSpawn, int numRows, int healthPoints, int speed)
    {
        int posY = 32;
        for (int row = 0; row < numRows; row++)
        {
            // create row of enemies
            List<Enemy> enemies = new ArrayList<Enemy>();
            for (int enemyCount = 0; enemyCount < numToSpawn; enemyCount++)
            {
                enemies.add(new Enemy(healthPoints, speed));
            }
        
            // divide the screen in segments of the count of enemies
            int intervalX = 800 / enemies.size();
            int step = intervalX / 2;
            for (Enemy enemy : enemies)
            {
                addObject(enemy, step, posY);
                step += intervalX;
            }
            
            posY += 64;
        }
        
    }
        
    private void cleanWorld()
    {
        removeObjects(getObjects(null));
    }
    
    public int getRandomNum(int start, int end)
    {
        int normal = Greenfoot.getRandomNumber(end - start + 1);
        return normal + start;
    }
}
