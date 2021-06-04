import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    int health = 100;
    int speed = 8;
    
    public Player()
    {
    }
    
    public Player(int health)
    {
        this.health = health;
    }
    
    public void act() 
    {
        steer();
    }
    
    /*
     * Check for key presses and initate movement based on them.
     */
    private void steer()
    {
        // Steer left
        if (Greenfoot.isKeyDown("A"))
        {
            move(-speed); // negative direction
        }
        
        if (Greenfoot.isKeyDown("D"))
        {
            move(speed);
        }
        
        if (Greenfoot.isKeyDown("space"))
        {
            shootBullet();
        }
    }

    private void shootBullet()
    {
        
    }
}
