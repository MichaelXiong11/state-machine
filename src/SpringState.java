
/**
 * Write a description of class SpringState here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SpringState extends State
{
    private static StateManager stateManager;
    
    private static final int RAIN = 1;
    private static final int SUNNY = 2;
    private static final int CLOUDY = 3;
    private static final int NEXT = 4;
    private static final int MENU = 5;
    private static final int QUIT = 6; 
    
    private int day;
    public SpringState()
    {
       stateManager = stateManager.instance();
       day = 1;
    }
    
    public void process()
    {
        StdOut.println("SPRING");
        StdOut.println("==========================");
        
        int choice;
        boolean done = false;
        while(true)
        {
            choice = menu();
            done = evaluateChoice(choice);
            
            if(done == true)
            {
                break;
            }
        }
    }
    
    protected void changeState(int state)
    {
        stateManager.changeState(state);
    }
    
    private int menu()
    {
        String input;
        
        while(true)
        {
            StdOut.println(RAIN + ": Heavy Rain | " + 
                           SUNNY + ": Sunny | " + 
                           CLOUDY + ": Cloudy | " + 
                           NEXT + ": Next Season | " + 
                           MENU + ": Menu | " + 
                           QUIT + ": Quit \n");
                           
            //Read user input
            input = StdIn.readLine();
            
            //Check if input was valid
            if(isValid(input) == true)
            {
                return (Integer.parseInt(input));
            }
        }
    }
    
    private boolean isValid(String input)
    {
        int choice = 0;
        
        //Check for invalid inputs
        try{
            choice = Integer.parseInt(input);
                
            //Out of range check
            if(choice <= 0 ||  choice > QUIT)
            {
                StdOut.println("INVALID INPUT");
                return false;
            }
            else
            {
                return true;
            }
        }catch(NumberFormatException e){
            StdOut.println("INVALID INPUT");
            
            return false;
        }
    }
    
    private boolean evaluateChoice(int choice)
    {
        switch(choice)
        {
            case RAIN:
                StdOut.println("Day " + day + ": Raining Heavy \n");
                break;
            case SUNNY:
                StdOut.println("Day " + day + ": Sunny \n");
                break;
            case CLOUDY:
                StdOut.println("Day " + day + ": Cloudy \n");
                break;
            case NEXT:
                changeState(2);
                return true;
            case MENU:
                changeState(0);
                return true;
            case QUIT:
                System.exit(0);
                break;
        }
        ++day;
        return false;
    }
}
