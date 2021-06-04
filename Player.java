import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Player extends Actor
{
    int speed;
    int timer = 0;
    int score;
    
    public Player()
    {
        this.score = 0;
        this.speed = 5;
    }
   
    public void act() 
    {
        steer();
        displayInfo();        
        // increment timer to function as a delay
        this.timer++;
        
        if (isTouching(Enemy.class))
        {
            getWorld().removeObject(this);
        }
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
            this.timer = 0;
        }
    }

    private void shootBullet()
    {
        getWorld().addObject(new Bullet(), getX(), getY() - 35);
    }
    
    private void displayInfo()
    {
        World world = getWorld();
        world.showText("Score: " + this.score, 100, 550);
    }
}
