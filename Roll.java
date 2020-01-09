import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Roll here.
 * 
 * @author Alejandro Gonzalez
 */
public class Roll extends ActionButton
{
    // declares instance variables
    private MyWorld world;
    private int sides;
    private int sum2;
    /**
     * Act - do whatever the Roll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Roll()
    {
        super(" Roll ");
    }
    public void performAction() 
    {
        
        world = (MyWorld) getWorld(); //gets world in order to call methods
        sides = world.nSides;         //get sides variable from world
        world.draw(sides);            //method to draw dice
        sum2 = world.totalRoll();     //gets the sum of the rolls in order to pass it to the historigram method
        world.growHist(sum2);
        
        
    }    
}
