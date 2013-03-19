/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.templates.*;


/**
 *
 * @author Chris
 */
public class Chassis extends Subsystem {
 
    RobotDrive drive;
    static Chassis instance;
 
 public void initDefaultCommand() {
 setDefaultCommand(new DriveWithJoystick()); // set default command
 }
 public Chassis() {
 drive = new RobotDrive(2, 1);
 drive.setSafetyEnabled(false);
 }
 public void straight() { // sets the motor speeds to drive straight (no turn)
 drive.tankDrive(1.0, 1.0);
 }
 public void turnLeft() { // sets the motor speeds to start a left turn
 drive.tankDrive(0.0, 1.0);
 }
 public void turnRight() { // sets the motor speeds to start a left turn
 drive.tankDrive(1.0, 0.0);
 }
 public void driveWithJoystick(OI oi) {
 drive.tankDrive(oi.stick.getRawAxis(2),oi.stick.getRawAxis(5));
 }
 public static Chassis getInstance() {
 if (instance==null)
     instance = new Chassis();
 return instance;
 }
 public void stop()  {
     drive.tankDrive(0.0,0.0);
 }
}