package domains.arithmetic;

import framework.problem.Mover;
import framework.problem.State;

/**
 *
 * @author Walker Voss
 */
public class ArithmeticMover extends Mover {
    
    public static final String ADD = "Add 3";
    public static final String SUB = "Subtract 5";
    public static final String MULT = "Multiply by 2";
    public static final String DIV = "Divide by 2";
    
    /**
     * this is the lambadas or whatever
     */
    public ArithmeticMover() {
        super.addMove(ADD, s ->  tryAdd((ArithmeticState) s));
        super.addMove(SUB, s -> trySub((ArithmeticState) s));
        super.addMove(MULT, s -> tryMult((ArithmeticState) s));
        super.addMove(DIV, s -> tryDiv((ArithmeticState) s));
    }
    
    /**
     * 
     * @param s which is an Arithmetic state
     * @return newArithmeticState that has 3 added to the value stored in s
     */
    private ArithmeticState tryAdd(ArithmeticState s) {
        ArithmeticState newArithmeticState = new ArithmeticState(s.getStateValue() + 3);
        return newArithmeticState;
    }
    /**
     * 
     * @param s which is an Arithmetic state
     * @return newArithmeticState that has 5 subtracted to the value stored in s
     */
    private ArithmeticState trySub(ArithmeticState s) {
        ArithmeticState newArithmeticState = new ArithmeticState(s.getStateValue() - 5);
        return newArithmeticState;
    }
    /**
     * 
     * @param s which is an Arithmetic state
     * @return newArithmeticState that has 2 multiplied by the value stored in s
     */
    private ArithmeticState tryMult(ArithmeticState s) {
        ArithmeticState newArithmeticState = new ArithmeticState(s.getStateValue() * 2);
        return newArithmeticState;
    }
    /**
     * 
     * @param s which is an Arithmetic state
     * @return newArithmeticState that has 2 divided by the value stored in s
     */
    private ArithmeticState tryDiv(ArithmeticState s) {
        ArithmeticState newArithmeticState = new ArithmeticState(s.getStateValue() / 2);
        return newArithmeticState;
    }
}
