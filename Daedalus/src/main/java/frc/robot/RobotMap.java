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

        /**
         * Set the speeds of the left and right sides of the robot.
         * 
         * We use 2 motors on each side, but we use a PWM splitter going from one port on the RoboRIO to 2 seperate Rev Robotics Spark motor controllers. Hence why we are able to have just the 2 controllers.
         * 
         * @param leftAmmount
         * @param rightAmmount
         */
        public void Move(double leftAmmount, double rightAmmount) {
            rightDrive.setInverted(true);

            // TODO: Implement Exponential Drive.
            leftDrive.set(leftAmmount);
            rightDrive.set(rightAmmount);

        }

        /**
         * Stop all motors on the robot.
         */
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


    /**
     * Currently, this does nothing. It's just a place holder for when we get around to putting together the ramp.
     * 
     */
    public class Ramp {
        
        void Ramp() {
            throw new UnsupportedOperationException("No ramp code currently availiable.");
        }

    }


    /**
     * The class for receiving input from the joysticks in Driver Station.
     * 
     * We use a dual Joystick configuration for more percise control of the robot. 
     */
    public class Input {
        Joystick leftJoy = new Joystick(0);
        Joystick rightJoy = new Joystick(1);
        

        
    }

}