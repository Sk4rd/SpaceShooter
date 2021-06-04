import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    int health;
    
    public Enemy()
    {
        this.health = 100;
    }
    
    public void act() 
    {
        World world = getWorld();
        // Enemy dies when health is 0 or less
        if (this.health <= 0)
        {
            world.removeObject(this);
        }
    }    
}
