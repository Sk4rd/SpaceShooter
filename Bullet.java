import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


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
        
        // Check for enemy and deal damage
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
}
