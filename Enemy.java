import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Enemy extends Actor
{
    int health;
    int speed;
    int timer = 0;
    
    public Enemy(int health, int speed)
    {
        this.health = health;
        this.speed = speed;
    }
    
    public void act() 
    {
        Space world = (Space) getWorld();
        
        fly();
        // Enemy dies when health is 0 or less
        if (this.health <= 0)
        {
            // increment the score of player
            world.getObjects(Player.class).get(0).score += 75;
            world.removeObject(this);
        }
    }
    
    private void fly()
    {
        setLocation(getX() + this.speed, getY());
        
        if (getX() > 768 || getX() < 32)
        {
            this.speed *= -1;
            setLocation(getX(), getY() + 32);
        }
        
        if (getY() > 568)
        {
            setLocation(32, 32);
        }
        
        // Soft borders in if statements above
    }
}
