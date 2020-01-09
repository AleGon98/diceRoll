    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    import java.util.Random.*;   
    /**
     * Write a description of class MyWorld here.
     * 
     * @author Alejandro Gonzalez
     */
    public class MyWorld extends World
    {
        //Define all the instance variables used in the code
        private DiceImageGenerator dado;
        private DiceImageGenerator dado2;
        public int nSides = 6;
        private String sides;
        private String txt;
        private GreenfootImage img1;
        private Color color;
        public static int random;
        public static int random1;
        private Minus minus;
        private Plus plus;
        private Roll roll;
        private Rollx10 rollx10;
        private ResetCounts reset;
        private int historigram;
        private Historigram[] hist;
        public static int sum;
        private SortValue sortValue;
        private Historigram t;
        private Historigram t1;
        private SortCount sortCount;
        
        /**
         * Constructor for objects of class MyWorld.
         * 
         */
    public MyWorld()
    {    
            // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        ShowSides();    // calls a method to draw the labels for the dice count
        draw(nSides);   // calls a method to draw both dices
        addObjects();   //Calls a method that adds all the objects to the world
        historigram(); // Calls a method that creates the empty historigram
        sum = 1;
    } 
    public void addObjects()            //This method creates each object and adds it to the world
    {
        minus = new Minus();
        addObject(minus, 65, 65);
        plus = new Plus();
        addObject(plus, 130, 65);
        roll = new Roll();
        addObject(roll, 95, 440);
        rollx10 = new Rollx10();
        addObject(rollx10,95,465);
        reset = new ResetCounts();
        addObject(reset, 95, 490);
        sortValue = new SortValue();
        addObject(sortValue, 95, 515);
        sortCount = new SortCount();
        addObject(sortCount, 95, 540);
    }
    public void ShowSides()         //this method creates the labels for the dice number and actions
    {
        sides =Integer.toString(nSides);    //transform the number of sides to an int
        color = new Color(0,0,0);           //creates a new color black
        getBackground().drawImage(new GreenfootImage("Sides on Dice", 28, color, null, null), 40, 27); // draw the different labels
        getBackground().drawImage(new GreenfootImage(sides, 28, color, null, null), 90, 50); 
        getBackground().drawImage(new GreenfootImage("Dice Values", 28, color, null, null), 50, 100); 
        getBackground().drawImage(new GreenfootImage("Actions", 28, color, null, null), 60, 400);
    }
    public int getRandom(int sides)     // This method creates a random number betwen the number of sides the dice has
    {
        int random = (int)(Math.random() * sides + 1);  //math operation that uses the package math.random to generate a random number 
        return random;
    }
   
    public void draw(int sides)         //This method draw the two dices with the respective random number
    {
        dado = new DiceImageGenerator();    //creates the dice
        dado2 = new DiceImageGenerator();
        random = getRandom(nSides);         //creates the random number using the method above
        random1 = getRandom(nSides);
        sum = random + random1;             //store the sum of the rolls in a variable that will be used for the historigram
        getBackground().drawImage(dado.generateImage(random), 50, 140);     //draw the dices
        getBackground().drawImage(dado2.generateImage(random1), 50, 250);
        
    }
    public void updateSide()        //This method erases the previous number of sides and draws a new image above a white image
    {
        String update;
        GreenfootImage white = new  GreenfootImage(28, 28);//creates a white image
        white.setColor(Color.WHITE);
        white.fill();           //fills the image with white
        getBackground().drawImage(white, 90, 50);  //draws the white image to hide the previous number of sides
        update =Integer.toString(nSides);       //transfor the int to a string in order to draw it
        getBackground().drawImage(new GreenfootImage(update, 28, color, null, null), 90, 50); //draw the new number of sides 
    }
    public void historigram()       //this method creates the historigram depending on the sides of the dice
    {  
        historigram = nSides * 2;   // number of bars is double the number of sides  
        int x = 188 +(600/historigram); // the position in the x coordinate in a math operation in order that it will be updated when a new bar is added
        int y = 500;  
        hist = new Historigram[historigram]; // creates the array containing the bars
        for (int i = 0; i< hist.length; i++) //for loop that goes as many times as bars 
        {
            hist[i] = new Historigram(nSides, 1, sum); //creates a new bar and stores it in the array
            
        }
        
        histLabels();   //method that places the labels under each bar
        
    }
    public void histLabels() //method that places the labels under each bar and adds them
    {
        int x = 188 +(600/historigram); // the position in the x coordinate in a math operation in order that it will be updated when a new bar is added
        int y = 500;                    //y coordinate
        for (int j = 0; j < historigram-1; j++)//for loop that goes as many times as bars are in the world
        {
            addObject(hist[j], x,y);        //adds each bar
            String label = Integer.toString(j + 2);
            getBackground().drawImage(new GreenfootImage(label, 15, Color.BLACK, null, null), x - 5, y + 5); //adds the label
            x += 600/historigram; //updates the c coordinate
        }
    }
    public void updateHist()        //method to erase the bars and labels
    {
        for (int i = 0; i < historigram; i++) {
            removeObject(hist[i]);  //remove all the bars
            
        }
        GreenfootImage eraseLabels = new  GreenfootImage(790, 50);  //adds white image to cover the labels
        eraseLabels.setColor(Color.WHITE);
        eraseLabels.fill();
        getBackground().drawImage(eraseLabels, 0, 500);
    }
    public static int totalRoll() 
    {
        return sum;     //returns the sum of the rolls 
    }
    public void growHist(int sum3)  //methos to change hist size
    {
        hist[sum3 - 2].grow();     //calls a methon to grow the hist
        hist[sum3-2].increase();    //calls a method to increase the counter
    }
    public void sortValue(int sum)
    {
       for (int i = 0; i < hist.length - 1; i++) 
       {
            for (int j = 0; j < hist.length - 1; j++) 
            {
                if (hist[j].sum() > hist[j+1].sum()) 
                {
                    
                    
                    //This part did not work because i could not get the sum() methis in the historigram class to work, it does not return the apropiate value therefore this method does not execute correctly
                    hist[j] = hist[j+1];
                    
                }
            }
        }
        updateHist();
        
        int histn = nSides*2;
        int xCord = 180 + (600 / histn);
        int yCord = 500;
        
        
        for (int i = 0; i < histn-1; i++) {
            if (hist[i].counter() % 2 ==0) 
                addObject(hist[i], xCord, yCord - hist[i].counter()/2);
            else 
                addObject(hist[i], xCord, yCord - (hist[i].counter()+1)/2);
                
            // Adds a label indicating each bar's value.
            String label = Integer.toString(hist[i].sum());
            getBackground().drawImage(new GreenfootImage(label, 15, Color.BLACK, null, null), xCord - 5, yCord + 5);
            
            // Updates the x-coordinate for the next bar.
            xCord += 600/histn;
        }
    }
    public void sortCount()     //method to sort by count
    {
        
        for (int i = 0; i < hist.length - 1; i++)   //nested for loop to iterate each bar and compare each bar to each other   
        {
            for (int j = 0; j < hist.length - 1; j++) 
            {
                if (hist[j].counter() < hist[j+1].counter()) //if the cointer of the bar is < to the next one rotate it
                {
                    t1 = hist[j];   //temporatl variable to store the larger 
                    hist[j] = hist[j+1];    
                    hist[j+1] = t1;
                }
            }
        }
        updateHist();//removes the labels and the bars
        
        int histnumber = nSides * 2;            //the number of bars
        int x = 180 + (600 / histnumber);       //x coodinate 
        int y = 500;                            //y coordinate
        
        // Moves each bar depending on the counter value.
        for (int i = 0; i < histnumber-1; i++) 
        {
            int sumaa5 = random + random1;
            if (hist[i].counter() % 2 ==0) 
                addObject(hist[i], x, y - hist[i].counter()/2);     
            else 
                addObject(hist[i], x , y - (hist[i].counter()+1)/2);
                
            // Adds a label indicating each bar's count.
            String label = Integer.toString(hist[i].counter());
            getBackground().drawImage(new GreenfootImage(label, 15, Color.BLACK, null, null), x - 5, y + 5);
            
            // Updates the x-coordirdinate.
            x += 600/histnumber;
        }
    }
}
