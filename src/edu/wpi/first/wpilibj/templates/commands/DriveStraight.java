/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Chassis;

/**
 *
 * @author Chris
 */
public class DriveStraight extends CommandBase {
    private double m_timeout;
    
    public DriveStraight(double timeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    m_timeout = timeout;
    requires(Chassis.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(m_timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    Chassis.getInstance().straight();    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        Chassis.getInstance().stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        
    }
    
}