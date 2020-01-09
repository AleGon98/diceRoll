import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Historigram here.
 * 
 * @author Alejandro Gonzalez
 */
public class Historigram extends Actor
{
    //instance variables
    private MyWorld world;
    private int sides;
    private int numberBar;
    private GreenfootImage bar;
    private GreenfootImage grow;
    private int position;
    private int center;
    private int counter;
    private int suma;
    private int yc;

    /**
     * Act - do whatever the Historigram wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Historigram(int sides, int value, int sumaa)
    {
        world = (MyWorld) getWorld();
        draw(sides);  //draw the historigram
        counter = 1;  //set counter to 1  
        
        
        
        
    }
    public void draw(int sides) //method that draw the bar image
    {
        numberBar = sides*2;
        yc = 1;
        center = 600/numberBar; //centers the bars 
        bar = new GreenfootImage(center - 10, yc);
        bar.setColor(Color.RED);
        bar.drawRect(0, 0, center - 10, 1);
        setImage(bar);
    }
    public void erase()
    {
        getWorld().removeObject(this);  //removes the bar
    }
    public void grow()      //method that adds a another image in order to grow the historigram
    {
       bar = new GreenfootImage(center - 10, counter + 1);
       bar.setColor(Color.RED);
       bar.drawRect(0, 0, center - 11, counter + 1 - 1);
       setImage(bar);
       setLoc();        //calls method to make bar grow upwards
    }
    public void setLoc()    //method to make the bar grow up
    {
        if (counter % 2 == 0)setLocation(this.getX(), 500-counter/2);
        else setLocation(this.getX(), 500-(counter+1)/2);
    }
    public void increase()  //method to increase the counter
    {
        counter++;
        
    }
    public int sum()        //method to return sum
    {
        
        return suma;
    }
    public int counter(){return counter;}   //method to return the counter
}
