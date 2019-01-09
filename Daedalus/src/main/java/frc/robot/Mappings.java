package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;

public class Mappings{

    public class Drivetrain {
        
        Spark leftDrive = new Spark(0);
        Spark rightDrive = new Spark(1);

        public void Move(double leftAmmount, double rightAmmount) {
            rightDrive.setInverted(true);
            
            leftDrive.set(leftAmmount);
            rightDrive.set(rightAmmount);

        }

    }

    public class Ramp {

    }


    /**
     * The class for receiving input from the joysticks in Driver Station.
     */
    public class Input {

        Joystick leftJoy = new Joystick(0);
        Joystick rightJoy = new Joystick(1);
        
    }

}