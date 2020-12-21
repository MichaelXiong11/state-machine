
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{   
    public static void main(String args[])
    {   
        StateManager stateManager = StateManager.instance();
        stateManager.createStates();
        
        stateManager.runState();
    }
}
