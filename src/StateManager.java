
/**
 * Write a description of class StateManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StateManager
{
    private static StateManager stateManager;
    
    private int currentState;
    private int previousState;
    private static final int NUM_STATES = 5;
    private static State[] states;
    private int [][] nextState;
    
    /**
     * Constructor for objects of class StateManager
     */
    private StateManager()
    {
        states = new State[NUM_STATES];
        
        //State Transition Table
        nextState = new int [NUM_STATES][NUM_STATES];
        nextState[0][0] = 0; nextState[0][1] = 1; nextState[0][2] = 2; nextState[0][3] = 3; nextState[0][4] = 4;
        nextState[1][0] = 0; nextState[1][1] = 1; nextState[1][2] = 2; nextState[1][3] = -1; nextState[1][4] = -1;
        nextState[2][0] = 0; nextState[2][1] = -1; nextState[2][2] = 2; nextState[2][3] = 3; nextState[2][4] = -1;
        nextState[3][0] = 0; nextState[3][1] = -1; nextState[3][2] = -1; nextState[3][3] = 3; nextState[3][4] = 4;
        nextState[4][0] = 0; nextState[4][1] = 1; nextState[4][2] = -1; nextState[4][3] = -1; nextState[4][4] = 4;
        
        currentState = 0;
        previousState = -1;
    }
    
    public static StateManager instance()
    {
        if(stateManager == null)
        {
            stateManager = new StateManager();
        }
        
        return stateManager;
    }
    
    public int getCurrentState(){return currentState;}
    public int getPreviousState(){return previousState;}
    
    public void createStates()
    {
        states[0] = new MenuState();
        states[1] = new SpringState();
        states[2] = new SummerState();
        states[3] = new FallState();
        states[4] = new WinterState();
    }
    
    public void changeState(int transition)
    {
        if(nextState[currentState][transition] == -1)
        {
            return;
        }
        else
        {
            previousState = currentState;
            currentState = nextState[currentState][transition];
            createStates();
        }
        
        states[currentState].process();
    }
    
    public void runState()
    {
        states[currentState].process();
    }
}
