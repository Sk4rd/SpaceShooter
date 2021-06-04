import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Space()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        spawnPlayer();
    }
    
    private void spawnPlayer()
    {
        // Spawn in lower middle
        addObject(new Player(), 400, 550);
    }
    
    public void spawnBullet(int posX, int posY)
    {
        // Spawn at location of actor
        addObject(new Bullet(), posX, posY);
    }
}
