/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domains.farmer;

import framework.problem.Problem;

/**
 *
 * @author walker
 */
public class FarmerProblem extends Problem{
    public FarmerProblem() {
        super();
        super.setName("Farmer Problem");
        super.setIntroduction("Get across the river");
        super.setMover(new FarmerMover());
        super.setInitialState(new FarmerState("West", "West", "West", "West"));
        super.setCurrentState(super.getInitialState());
        super.setFinalState(new FarmerState("East", "East", "East", "East"));
    }
}
