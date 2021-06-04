import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    int health;
    int speed = 5;
    int timer = 0;
    
    public Player()
    {
        this.health = 100;
    }
    
    public Player(int health)
    {
        this.health = health;
    }
    
    public void act() 
    {
        steer();
        // increment timer to function as a delay
        timer++;
    }
    
    /*
     * Check for key presses and initate movement based on them.
     */
    private void steer()
    {
        // Steer left
        if (Greenfoot.isKeyDown("A") && getX() > 64)
        {
            move(-speed);
        }
        
        // Steer right
        if (Greenfoot.isKeyDown("D") && getX() < 736)
        {
            move(speed);
        }
        
        // Steer up
        if (Greenfoot.isKeyDown("W") && getY() > 64)
        {
            setLocation(getX(), getY() - speed);
        }
        
        // Steer down
        if (Greenfoot.isKeyDown("S") && getY() < 536)
        {
            setLocation(getX(), getY() + speed);
        }
        
        // Shoot
        if (Greenfoot.isKeyDown("space") && timer > 30)
        {
            shootBullet();
            timer = 0;
        }
    }

    private void shootBullet()
    {
        Space world = (Space) getWorld();
        world.spawnBullet(getX(), getY() - 35);
    }
}
