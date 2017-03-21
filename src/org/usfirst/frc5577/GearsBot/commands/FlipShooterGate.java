package org.usfirst.frc5577.GearsBot.commands;

import org.usfirst.frc5577.GearsBot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class FlipShooterGate extends Command {
	
	private double position = 0.0;
	
	public FlipShooterGate(double position) {
		requires(Robot.shooterGate);
		this.position = position;
		
		setTimeout(1);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Robot.shooterGate.setPosition(position);
		System.out.println(Robot.shooterGate.getPosition());
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		Robot.shooterGate.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
