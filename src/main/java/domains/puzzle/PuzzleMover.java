/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domains.puzzle;

import framework.problem.Mover;
import framework.problem.State;
import domains.puzzle.PuzzleState.Location;

/**
 *
 * @author walker
 */
public class PuzzleMover extends Mover {
    public static final String slideTile1 = "Slide Tile 1";
    public static final String slideTile2 = "Slide Tile 2";
    public static final String slideTile3 = "Slide Tile 3";
    public static final String slideTile4 = "Slide Tile 4";
    public static final String slideTile5 = "Slide Tile 5";
    public static final String slideTile6 = "Slide Tile 6";
    public static final String slideTile7 = "Slide Tile 7";
    public static final String slideTile8 = "Slide Tile 8";
    
    public PuzzleMover() {
        super.addMove(slideTile1, s -> Slide1(s));
        super.addMove(slideTile2, s -> Slide2(s));
        super.addMove(slideTile3, s -> Slide3(s));
        super.addMove(slideTile4, s -> Slide4(s));
        super.addMove(slideTile5, s -> Slide5(s));
        super.addMove(slideTile6, s -> Slide6(s));
        super.addMove(slideTile7, s -> Slide7(s));
        super.addMove(slideTile8, s -> Slide8(s));
        
    }
    
    private PuzzleState Slide1(State s) {
        PuzzleState state = (PuzzleState) s;
        Location l1 = state.getLocation(1);
        Location l2 = state.getLocation(0);
        
        if(valid_move(l1, l2)) {
            return new PuzzleState(state, l1, l2);
        }
        return null;
    }
    
    private PuzzleState Slide2(State s) {
        PuzzleState state = (PuzzleState) s;
        Location l1 = state.getLocation(2);
        Location l2 = state.getLocation(0);
        
        if(valid_move(l1, l2)) {
            return new PuzzleState(state, l1, l2);
        }
        return null;
    }
    
    private PuzzleState Slide3(State s) {
        PuzzleState state = (PuzzleState) s;
        Location l1 = state.getLocation(3);
        Location l2 = state.getLocation(0);
        
        if(valid_move(l1, l2)) {
            return new PuzzleState(state, l1, l2);
        }
        return null;
    }
    
    private PuzzleState Slide4(State s) {
        PuzzleState state = (PuzzleState) s;
        Location l1 = state.getLocation(4);
        Location l2 = state.getLocation(0);
        
        if(valid_move(l1, l2)) {
            return new PuzzleState(state, l1, l2);
        }
        return null;
    }
    
    private PuzzleState Slide5(State s) {
        PuzzleState state = (PuzzleState) s;
        Location l1 = state.getLocation(5);
        Location l2 = state.getLocation(0);
        
        if(valid_move(l1, l2)) {
            return new PuzzleState(state, l1, l2);
        }
        return null;
    }
    
    private PuzzleState Slide6(State s) {
        PuzzleState state = (PuzzleState) s;
        Location l1 = state.getLocation(6);
        Location l2 = state.getLocation(0);
        
        if(valid_move(l1, l2)) {
            return new PuzzleState(state, l1, l2);
        }
        return null;
    }
    
    private PuzzleState Slide7(State s) {
        PuzzleState state = (PuzzleState) s;
        Location l1 = state.getLocation(7);
        Location l2 = state.getLocation(0);
        
        if(valid_move(l1, l2)) {
            return new PuzzleState(state, l1, l2);
        }
        return null;
    }
    
    private PuzzleState Slide8(State s) {
        PuzzleState state = (PuzzleState) s;
        Location l1 = state.getLocation(8);
        Location l2 = state.getLocation(0);
        
        if(valid_move(l1, l2)) {
            return new PuzzleState(state, l1, l2);
        }
        return null;
    }
    
    private boolean valid_move(Location tileL, Location blankL) {
        return ((tileL.getColumn() - 1 == blankL.getColumn() || tileL.getColumn() + 1 == blankL.getColumn())
                && (tileL.getRow() == blankL.getRow()))
                || ((tileL.getRow() - 1 == blankL.getRow()
                || tileL.getRow() + 1 == blankL.getRow())
                && tileL.getColumn() == blankL.getColumn());
    }
}
    

