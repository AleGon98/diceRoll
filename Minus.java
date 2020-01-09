import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Minus here.
 * 
 * @author Alejandro Gonzalez
 */
public class Minus extends ActionButton
{
    //declare instance variables
    private MyWorld world;
    private int sides;
    /**
     * Act - do whatever the Minus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Minus()
    {
        super("  -  ");
    }
    public void performAction() 
    {
        world = (MyWorld) getWorld();
        if (world.nSides > 2)   //checs if the dice has more than 2 sides 
        {
            sides = world.nSides--; //updates sides variable in world
            world.updateSide();     //method to update sides label
            world.updateHist();     //deletes the hist and the labels 
            world.historigram();    //creates a new historigram
        }
        
    }    
}
