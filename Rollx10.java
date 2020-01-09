import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rollx10 here.
 * 
 * @author Alejandro Gonzalez
 */
public class Rollx10 extends ActionButton
{
    //declare instance variables
    private MyWorld world;
    private int sides;
    private int sum2;
    /**
     * Act - do whatever the Rollx10 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Rollx10()
    {
        super(" Rollx10 ");
    }
    public void performAction() 
    {
        world = (MyWorld) getWorld(); //gets world in order to call methods
        sides = world.nSides;         //get sides variable from world
        for (int j=0; j<10; j++)      //for loop to iterate 10 times
        {
            world.draw(sides);        //method to draw dice
            sum2 = world.totalRoll(); //gets the sum of the rolls in order to pass it to the historigram method
            world.growHist(sum2);
        }
    }    
}
