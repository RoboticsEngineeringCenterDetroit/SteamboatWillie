package org.usfirst.frc5577.GearsBot.subsystems;

import org.usfirst.frc5577.GearsBot.Robot;
import org.usfirst.frc5577.GearsBot.RobotMap;
import org.usfirst.frc5577.GearsBot.commands.Blend;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
	private final double scaleFactor = 0.85;
	
	public void intakeBall(double speed) {
		Joystick controller = Robot.oi.getJoystick();
		
//		double leftTrigger = controller.getRawAxis(Robot.oi.LEFT_TRIGGER_AXIS);
//		double leftAxisX = controller.getRawAxis(Robot.oi.LEFT_AXIS_X);
//		controller.getButton()

		RobotMap.intakeMotor.set(speed);
//    	Timer.delay(0.005);
	}
	
	public void stop() {
		RobotMap.intakeMotor.set(0);
//		RobotMap.blenderMotor.set(0);
//    	Timer.delay(0.005);
	}

	@Override
	protected void initDefaultCommand() {
//		setDefaultCommand(new ShooterArmIntake(0));
	}

}
