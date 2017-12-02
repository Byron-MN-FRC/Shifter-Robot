package org.usfirst.frc.team4859.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shifter extends Subsystem {
	
	DoubleSolenoid shifterLeft = new DoubleSolenoid(2, 3);
	DoubleSolenoid shifterRight = new DoubleSolenoid(1, 0);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void shiftUp() {
		shifterLeft.set(Value.kForward);
		shifterRight.set(Value.kForward);
	}
	
	public void shiftDown() {
		shifterLeft.set(Value.kReverse);
		shifterRight.set(Value.kReverse);
	}
	
	public void shiftStop() {
		shifterLeft.set(Value.kOff);
		shifterRight.set(Value.kOff);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

