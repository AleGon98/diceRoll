import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SortCount here.
 * 
 * @author Alejandro Gonzalez
 */
public class SortCount extends ActionButton
{
    //declare instance variable
    private MyWorld world;
    /**
     * Act - do whatever the SortCount wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SortCount()
    {
        super(" Sort by Count ");
    }
    public void performAction() 
    {
        world = (MyWorld) getWorld(); //gets world
        world.sortCount();            //calls method that sorts the bars  
    }    
}
