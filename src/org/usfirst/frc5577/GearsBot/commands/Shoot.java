package org.usfirst.frc5577.GearsBot.commands;

import org.usfirst.frc5577.GearsBot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {
	
	private double speed = 0;
	
	public Shoot(double speed) {
		requires(Robot.shooter);
		this.speed = speed;
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.shooter.shootOutBall(speed);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
//		Robot.shootOut.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
