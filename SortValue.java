import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SortValue here.
 * 
 * @author Alejandro Gonzalez
 */
public class SortValue extends ActionButton
{
    //declare instance variable
    private MyWorld world;
    /**
     * Act - do whatever the SortValue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SortValue()
    {
        super(" Sort by Value ");
    }
    public void performAction() 
    {
        world = (MyWorld) getWorld(); 
        int c = world.sum;
        world.sortValue(c);              //calls method to sort the bars by value
        
    }    
}

