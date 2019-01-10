package frc.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;

public class RobotMap{

    /**
     * Access DriveTrain components such as the motor controllers and encoders.
     */
    public class Drivetrain {
        
        Spark leftDrive = new Spark(0);
        Spark rightDrive = new Spark(1);

        Encoder leftEncoder = new Encoder(0, 1);
        Encoder rightEncoder = new Encoder(2, 3);

        void DriveTrain() {
            System.out.println("Created Drivetrain.");
        }

        public void Move(double leftAmmount, double rightAmmount) {
            rightDrive.setInverted(true);
            
            leftDrive.set(leftAmmount);
            rightDrive.set(rightAmmount);

        }

        public void Stop() {
            leftDrive.stopMotor();
            rightDrive.stopMotor();
        }

        public Double getLeftEncoderAmmount() {
            throw new UnsupportedOperationException("No encoder support yet.");
        }

        public Double getRightEncoderAmmount() {
            throw new UnsupportedOperationException("No encoder support yet.");
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