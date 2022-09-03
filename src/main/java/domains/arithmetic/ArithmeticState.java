package domains.arithmetic;

import framework.problem.State;

/**
 *
 * @author Walker Voss
 * This constructor takes the state and stores it in an instance field
 */
public class ArithmeticState extends State {
    
    public ArithmeticState(int value) {
        StateValue = value;
    }
    /**
     * 
     * @param other which is the state you are comparing to
     * @return true if the state is the same, false if not
     */
    @Override
    public boolean equals(Object other) {
        ArithmeticState thisState = (ArithmeticState) other;
        if (this.StateValue == thisState.StateValue) {return true;}
        else {return false;}
    }
    
    /**
     * 
     * @return a sting that says "the value is: "answer"
     */
    @Override
    public String toString() {
        return "The value is: " + StateValue;
    }
    
    /**
     * 
     * @return StateValue
     */
    public int getStateValue() {
        return StateValue;
    }
    
    
    private final int StateValue;
}
