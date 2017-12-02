package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import org.usfirst.frc.team4859.robot.ThrottleLookup.ThrottleLookup;
import org.usfirst.frc.team4859.robot.commands.DriveWithJoystick;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	public static CANTalon driveLeft = new CANTalon(RobotMap.talonIDDrivetrainLeft);
	public static CANTalon driveLeft2 = new CANTalon(RobotMap.talonIDDrivetrainLeft2);
	public static CANTalon driveRight = new CANTalon(RobotMap.talonIDDrivetrainRight);
	public static CANTalon driveRight2 = new CANTalon(RobotMap.talonIDDrivetrainRight2);
	
	public static RobotDrive drivetrain = new RobotDrive(driveLeft, driveLeft2, driveRight, driveRight2);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new DriveWithJoystick());
    }
    
    public void driveWithJoystick(Joystick joystick) {
    	double y = joystick.getY();
    	double twist = joystick.getTwist();
    	
    	y = ThrottleLookup.calcJoystickCorrection("NormY", y);
    	twist = ThrottleLookup.calcJoystickCorrection("NormT", twist);
    	
    	drivetrain.arcadeDrive(y, twist);
    }
}

