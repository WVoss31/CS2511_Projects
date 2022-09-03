/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domains.farmer;

import framework.problem.Mover;
import framework.problem.State;

/**
 *
 * @author walker
 */
public class FarmerMover extends Mover{
    private final String FARM = "Farmer Goes Alone";
    private final String WOLF = "Farmer Takes Wolf";
    private final String GOAT = "Farmer Takes Goat";
    private final String CABBAGE = "Farmer Takes Cabbage";
    
    public FarmerMover() {
        super.addMove(FARM, s -> goesAlone(s));
        super.addMove(WOLF, s -> takesWolf(s));
        super.addMove(GOAT, s -> takesGoat(s));
        super.addMove(CABBAGE, s -> takesCabbage(s));
    }
    
    private FarmerState goesAlone(State s) {
      FarmerState thisFarmerState = (FarmerState) s;
      if (thisFarmerState.getGoat().equals(thisFarmerState.getWolf())) {
                    return null;
                }
      else if (thisFarmerState.getGoat().equals(thisFarmerState.getCabbage())) {
                    return null;
                }
      if ("West".equals(thisFarmerState.getFarmer())) {
        return new FarmerState("East",
                               thisFarmerState.getWolf(),
                               thisFarmerState.getGoat(),
                               thisFarmerState.getCabbage());
      }
      else if (thisFarmerState.getFarmer().equals("East")) {
            return new FarmerState("West",
                               thisFarmerState.getWolf(),
                               thisFarmerState.getGoat(),
                               thisFarmerState.getCabbage());
      }
      
      return thisFarmerState;
    }
    
    private FarmerState takesWolf(State s) {
      FarmerState thisFarmerState = (FarmerState) s;
      if (thisFarmerState.getGoat().equals(thisFarmerState.getCabbage())) {
                return null;
            }
      else if ((thisFarmerState.getFarmer().equals("West") && thisFarmerState.getWolf().equals("East"))) {
          return null;
            }
      else if (thisFarmerState.getFarmer().equals("East") && thisFarmerState.getWolf().equals("West")) {
                return null;
            }
      if (thisFarmerState.getFarmer().equals("West") && thisFarmerState.getWolf().equals("West")) {
        return new FarmerState("East",
                               "East",
                               thisFarmerState.getGoat(),
                               thisFarmerState.getCabbage());
      }
      else if (thisFarmerState.getFarmer().equals("East") && thisFarmerState.getWolf().equals("East")) {
            return new FarmerState("West",
                                    "West",
                                    thisFarmerState.getGoat(),
                                    thisFarmerState.getCabbage());
      }
      
      return thisFarmerState;
    }
    
    
    private FarmerState takesGoat(State s) {
      FarmerState thisFarmerState = (FarmerState) s;
      if ((thisFarmerState.getFarmer().equals("West") && thisFarmerState.getGoat().equals("East"))) {
          return null;
            }
      else if (thisFarmerState.getFarmer().equals("East") && thisFarmerState.getGoat().equals("West")) {
                return null;
            }
      if (thisFarmerState.getFarmer().equals("West") && thisFarmerState.getGoat().equals("West")) {
        return new FarmerState("East",
                               thisFarmerState.getWolf(),
                               "East",
                               thisFarmerState.getCabbage());
      }
      else if (thisFarmerState.getFarmer().equals("East") && thisFarmerState.getGoat().equals("East")) {
            return new FarmerState("West",
                                    thisFarmerState.getWolf(),
                                    "West",
                                    thisFarmerState.getCabbage());
      }
      
      return thisFarmerState;
    }
    
    
    
    
    private FarmerState takesCabbage(State s) {
      FarmerState thisFarmerState = (FarmerState) s;
      if (thisFarmerState.getGoat().equals(thisFarmerState.getCabbage()) && thisFarmerState.getFarmer().equals(thisFarmerState.getWolf())) {
            return null;
            }
      else if ((thisFarmerState.getFarmer().equals("West") && thisFarmerState.getCabbage().equals("East"))) {
          return null;
            }
      else if (thisFarmerState.getFarmer().equals("East") && thisFarmerState.getCabbage().equals("West")) {
                return null;
            }
      if (thisFarmerState.getFarmer().equals("West") && thisFarmerState.getCabbage().equals("West")) {
        return new FarmerState("East",
                               thisFarmerState.getWolf(),
                               thisFarmerState.getGoat(),
                               "East");
      }
      else if (thisFarmerState.getFarmer().equals("East") && thisFarmerState.getCabbage().equals("East")) {
            return new FarmerState("West",
                                    thisFarmerState.getWolf(),
                                    thisFarmerState.getGoat(),
                                    "West");
      }
      
      return thisFarmerState;
    }
}
