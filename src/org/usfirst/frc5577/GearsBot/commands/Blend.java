package org.usfirst.frc5577.GearsBot.commands;

import org.usfirst.frc5577.GearsBot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Blend extends Command {
	
	private double speed = 0.0;
	
	public Blend(double speed) {
		requires(Robot.blender);
		this.speed = speed;
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.blender.blend(speed);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
//		Robot.intake.stop();
	}

	@Override
	protected void interrupted() {
    	end();
	}

}
