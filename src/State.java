
/**
 * Abstract class State - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class State
{    
    protected State()
    {
        
    }
    
    protected abstract void changeState(int state);
    protected abstract void process();
}
