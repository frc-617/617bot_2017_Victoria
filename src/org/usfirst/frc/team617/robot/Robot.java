
package org.usfirst.frc.team617.robot;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Spark;
import com.ctre.CANTalon;

public class Robot extends SampleRobot {
	CANTalon right;
	CANTalon left;
	Joystick stick1;
	Joystick stick2;
    Spark    gears;
    Talon    rightWinch;
    Talon    leftWinch;
    
    /* double Comstock = 1; {
    if (stick1.getRawButton(1)) {
    	Comstock++;
    };
    if (stick2.getRawButton(1)) {
    	Comstock--;
    };
    } */
    public Robot() {
        stick1     = new Joystick(0);   //joysticks
    	stick2     = new Joystick(1);
        right      = new CANTalon(0);   //Driving Motors
        left       = new CANTalon(1);
        gears      = new Spark(2);      //Winch mechanism for gear collector
        leftWinch  = new Talon(0);      //Climbing Mechanism
        rightWinch = new Talon(1);
    }
    
    public void robotInit() {
        CameraServer.getInstance().startAutomaticCapture();  //Starts Camera
        CameraServer.getInstance().startAutomaticCapture();
    }
    
    public void autonomous() {
    	
    }

    public void operatorControl() {
        
        
        while (isOperatorControl() && isEnabled()) {
           double Elizabeth = stick1.getY(); //Value left stick gets on the Y axis
           double Booker    = stick2.getY(); //Value right stick gets on Y axis
      
  
           left.set(-Elizabeth);
           right.set(-Booker);
           
         if (stick1.getRawButton(1)) {
        	 gears.set(1);
         }
         
         else if (stick2.getRawButton(1)) {
        	 gears.set(-1); //BOOMWINCH
         }
         
         else {
        	 gears.set(0);
         }
         
         if (stick1.getRawButton(3)) {
        	 leftWinch.set(.33);
        	 rightWinch.set(.33);
         }
         else if (stick1.getRawButton(2)) {
        	 leftWinch.set(-.33);
        	 rightWinch.set(-.33);
         }
         else {
        	 leftWinch.set(0);
        	 rightWinch.set(0);
         }
         /* if (Comstock != 0) {
        	   left.set(-Elizabeth/Comstock);   //Driving system
               right.set(Booker/Comstock);
           }
           
         */
           Timer.delay(.005);		// wait for a motor update time
           
        }
        
    }

    /**
     * Runs during test mode
     */
    public void test() {
    }
}
