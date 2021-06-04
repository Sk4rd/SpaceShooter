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
    int speed;
    
    public Enemy(int health, int speed)
    {
        this.health = 75;
        this.speed = 2;
    }
    
    public void act() 
    {
        Space world = (Space) getWorld();
        
        fly();
        // Enemy dies when health is 0 or less
        if (this.health <= 0)
        {
            world.removeObject(this);
        }
    }
    
    private void fly()
    {
        setLocation(getX() + this.speed, getY());
        
        if (getX() > 768 || getX() < 32)
        {
            this.speed *= -1;
            setLocation(getX(), getY() + 64);
        }
        
        if (getY() > 568)
        {
            setLocation(32, 32);
        }
    }
}
