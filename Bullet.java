import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{   
    int damage;
    
    public Bullet()
    {
        this.damage = 25;
    }
    
    public Bullet(int damage)
    {
        this.damage = damage;
    }
    
    public void act() 
    {
        World world = getWorld();
        setLocation(getX(), getY() - 10);
        
        if (isTouching(Enemy.class))
        {
            Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
            world.removeObject(this);
            enemy.health -= this.damage;
        }
        
        else if (isAtEdge())
        {
            world.removeObject(this);
        }
    }
    
    private void dealDamage(int amount)
    {
    }
}
