package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.Systems.*;


public class Robot extends TimedRobot{

    // Create a new RobotMap to have access to the different parts of the robot.
    Systems system = new Systems();
    Drivetrain drivetrain = system.new Drivetrain();
    Input input = system.new Input();
    Ramp ramp = system.new Ramp();
    

    @Override
    public void robotInit() {
      System.out.println("Daedalus is online. Insert some snarky line to chuckle at whenever we turn on the robot at a competition.");
    }


    @Override
    public void robotPeriodic() {

    }


    /**
     * NGL... I'm not looking forward to this....
     */
    @Override
    public void autonomousInit() {

    }

    @Override
    public void autonomousPeriodic() {

    }

    
    @Override
    public void teleopInit() {
      // Ok, so this isn't used really until we get into encoders. Which won't be for a while.  
    }

    @Override
    public void teleopPeriodic() {    
      // This is where all of our code goes to control the input from the user.
      /*
        Looking in RobotMap.java you'll see a lot of the setup code has been taken care of. I mainly just did this so I could have a stable base when we get to working on auton.

        For right now, all we need to do is setup controling the Drivetrain with the Input.
        I've already constructed the correct classes to do this, so, it should be pretty much plug and play.
      */

      // Put code here...
     drivetrain.Move(input.getLeftDrive(), input.getRightDrive());
    }
}
