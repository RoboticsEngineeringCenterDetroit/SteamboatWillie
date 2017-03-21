package org.usfirst.frc5577.GearsBot;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterGate extends Subsystem {
	Servo shooterGateServo = RobotMap.servo;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
//		setDefaultCommand(new FirePinballFlipper(false));
	}
	
	public void setPosition(double position) {
		shooterGateServo.set(position);
	}
	
	public double getPosition() {
		return shooterGateServo.get();
	}
	
//	public void spin(double speed) {
//		pinballMotor.set(speed);
//	}
//	
	public void stop() {
		shooterGateServo.set(0);
	}
	
}