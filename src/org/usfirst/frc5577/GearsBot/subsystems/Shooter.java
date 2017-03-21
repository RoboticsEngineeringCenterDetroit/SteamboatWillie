package org.usfirst.frc5577.GearsBot.subsystems;

import org.usfirst.frc5577.GearsBot.Robot;
import org.usfirst.frc5577.GearsBot.RobotMap;
import org.usfirst.frc5577.GearsBot.commands.Shoot;

import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
	
	private final double scaleFactor = 0.8;
	private StringBuilder sb = new StringBuilder();
	int loops = 0;
	
	public Shooter() {
		RobotMap.shooterMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		RobotMap.shooterMotor.reverseSensor(false);
		RobotMap.shooterMotor.configNominalOutputVoltage(+0.0f, -0.0f);
		RobotMap.shooterMotor.configPeakOutputVoltage(+12.0f, -12.0f);
		RobotMap.shooterMotor.setProfile(0);
		RobotMap.shooterMotor.setF(0.01);
		RobotMap.shooterMotor.setP(0.0);
		RobotMap.shooterMotor.setI(0.0);
		RobotMap.shooterMotor.setD(0.0);
		RobotMap.shooterMotor.changeControlMode(TalonControlMode.PercentVbus);
	}
	
	public void shootOutBall(double speed) {
		Joystick controller = Robot.oi.getJoystick();
		
		double motorOutput = RobotMap.shooterMotor.getOutputVoltage() / RobotMap.shooterMotor.getBusVoltage();
		sb.append("\tout:");
		sb.append(motorOutput);
		sb.append("\tspeed");
		sb.append(RobotMap.shooterMotor.getSpeed());
		
//		double rightTrigger = controller.getRawAxis(Robot.oi.RIGHT_TRIGGER_AXIS);
//		RobotMap.shooterLeftMotor.setInverted(false);
//		RobotMap.shooterRightMotor.setInverted(false);
		
		double targetSpeed = speed; // 6000 RPM target
		RobotMap.shooterMotor.set(targetSpeed);
		
		sb.append("/terr"); 
		sb.append(RobotMap.shooterMotor.getClosedLoopError()); 
		sb.append("/ttrg:"); 
		sb.append(targetSpeed); 
	
		
		if(++loops >= 10) { 
			loops = 0; 
			System.out.println(sb.toString()); 
		} 
		
		sb.setLength(0);
		
		
	}
	
	public void stop() {
		RobotMap.shooterMotor.set(0);
//		RobotMap.blenderMotor.set(0);
//    	Timer.delay(0.005);
	}

	@Override
	protected void initDefaultCommand() {
//		setDefaultCommand(new ShooterArmShootOut(0));
	}

}
