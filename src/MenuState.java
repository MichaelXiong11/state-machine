
/**
 * Write a description of class MenuState here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MenuState extends State
{   
    private static StateManager stateManager;
    
    private static final int SPRING = 1;
    private static final int SUMMER = 2;
    private static final int FALL = 3;
    private static final int WINTER = 4;
    private static final int QUIT = 5;
    
    public MenuState()
    {
        stateManager = StateManager.instance();
    }
    
    public void process()
    {
        StdOut.println("SEASONS SIMULATOR (MENU)");
        StdOut.println("==========================");
        
        int choice;
        
        choice = menu();
        
        if(choice >= SPRING && choice <= WINTER)
        {
            changeState(choice);
        }
        else if(choice == QUIT)
        {
            System.exit(0);
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
            StdOut.println(SPRING +": SPRING | " + 
                           SUMMER + ": SUMMER | " +
                           FALL + ": FALL | " +
                           WINTER + ": WINTER | " +
                           QUIT + ": QUIT" + "\n");
                           
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
}
