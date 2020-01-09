import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ResetCounts here.
 * 
 * @author Alejandro Gonzalez
 */
public class ResetCounts extends ActionButton
{
    //declares instance variable
    private MyWorld world;
    /**
     * Act - do whatever the ResetCounts wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ResetCounts()
    {
        super("Reset Counts");
    }
    public void performAction()
    {
        world = (MyWorld) getWorld();   //gets world
        world.updateHist();             //delete the hist
        world.historigram();            //creates a new hist
    }    
}
