package org.usfirst.frc5577.GearsBot.commands;

import org.usfirst.frc5577.GearsBot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Turn extends Command {
	
	double turnValue = 0.5;
	int degrees = 0;
	
	public Turn(double turnValue) {
  	  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
      requires(Robot.driveTrain);
      
      this.turnValue = turnValue;

  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
      setTimeout(1); //Or change back to 5 if something goes wrong 
//      Robot.gyro.startThread();
      
      }
	
	public Turn(int degrees) {
		this.degrees = degrees;
	}

	protected void execute() {
    	Robot.driveTrain.turn(turnValue);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println(Robot.imu.getAngleZ());
//    	System.out.println(Robot.gyro.deltaTime);
    	System.out.println(isTimedOut());
        return Math.abs(Robot.imu.getAngleZ()) >= Math.abs(degrees); 
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.imu.reset();
    	Robot.driveTrain.stop(); 
    }
	
}
