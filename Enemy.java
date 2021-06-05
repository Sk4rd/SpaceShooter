import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Enemy extends Actor
{
    int health;
    int speed;
    int timer = 0;
    boolean randomMotion;
    int direction;

    public Enemy(int health, int speed, boolean randomMotion)
    {
        this.health = health;
        this.speed = speed;
        this.randomMotion = randomMotion;
        this.direction = getRandomNum(0, 360);
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
            Greenfoot.playSound("dying_enemy.wav");
            world.removeObject(this);
        }
    }
    
    private void fly()
    {
        if (randomMotion)
        {
            // get x y based of an angle and a distance (speed)
            double x = getX() + this.speed * Math.cos(direction);
            double y = getY() + this.speed * Math.sin(direction);

            setLocation((int)x, (int)y);

            // set random directon when enemy hits border
            if (getX() > 768)
            {
                this.direction = getRandomNum(90, 270);

                // add padding left
                setLocation(getX() - 16, getY());
            }
            if (getX() < 32)
            {
                this.direction = getRandomNum(270, 450);

                // add padding right
                setLocation(getX() + 16, getY());
            }
            
            if (getY() > 568)
            {
                this.direction = getRandomNum(180, 360);

                // add padding bottom
                setLocation(getX(), getY() - 16);
            }
            if (getY() < 32)
            {
                this.direction = getRandomNum(180, 360);

                // add padding top
                setLocation(getX(), getY() + 16);
            }
        }
        else
        {
            // Soft borders
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
        }

    }

    public int getRandomNum(int start, int end)
    {
        int normal = Greenfoot.getRandomNumber(end - start + 1);
        return normal + start;
    }
}
