import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plus here.
 * 
 * @author Alejandro Gonzalez
 */
public class Plus extends ActionButton
{
    //declare instance variables
    private MyWorld world;
    private int sides;
    /**
     * Act - do whatever the Plus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Plus()
    {
        super("  +  ");
    }
    public void performAction() 
    {
        world = (MyWorld) getWorld();
        if (world.nSides < 12)      //checks if sides is smaller than 12
        {
            sides = world.nSides++; //updates variable in world class
            world.updateSide();     //update labels 
            world.updateHist();     //delete the bars
            world.historigram();    //creates a new historigram
        }
    }    
}
