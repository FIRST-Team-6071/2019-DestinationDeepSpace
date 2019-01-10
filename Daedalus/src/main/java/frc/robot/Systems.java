package frc.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import frc.robot.RobotMap;
import frc.robot.RobotMap.Controls;
import frc.robot.RobotMap.DS_USB;
import frc.robot.RobotMap.PWM;

public class Systems{

    /**
     * Access DriveTrain components such as the motor controllers and encoders.
     */
    public class Drivetrain {
        
        Spark leftDrive = new Spark(PWM.DRIVETRAIN_LEFT);
        Spark rightDrive = new Spark(PWM.DRIVETRAIN_RIGHT);

        Encoder leftEncoder = new Encoder(0, 1);
        Encoder rightEncoder = new Encoder(2, 3);

        Drivetrain() {
            System.out.println("Created Drivetrain object.");
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
        
        Ramp() {
            throw new UnsupportedOperationException("No ramp code currently availiable.");
        }

    }

    public class HatchPanelControl {

        VictorSP motorHeight = new VictorSP(PWM.HATCH_PLATE_HEIGHT);
        VictorSP motorDepth = new VictorSP(PWM.HATCH_PLATE_DEPTH);
        HatchPanelControl() {
            throw new UnsupportedOperationException("No Hatch Panel code is currently availiable.");
        }

    }

    /**
     * The class for receiving input from the joysticks in Driver Station.
     * 
     * We use a dual Joystick configuration for more percise control of the robot. 
     */
    public class Input {
        Joystick left = new Joystick(0);
        Joystick right = new Joystick(1);

        Input() {
            System.out.println("Created Input object.");
        }
        
        public Double getLeftDrive() {
            return left.getRawAxis(Controls.DRIVE_AXIS);
        }
        public Double getRightDrive() {
            return right.getRawAxis(Controls.DRIVE_AXIS);
        }

    }

}