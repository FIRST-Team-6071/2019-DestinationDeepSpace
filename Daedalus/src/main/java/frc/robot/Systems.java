package frc.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import frc.robot.RobotMap.Controls;
import frc.robot.RobotMap.PWM;

public class Systems{

    /**
     * Access DriveTrain components such as the motor controllers and encoders.
     */
    public class Drivetrain {
        
        Spark leftDrive = new Spark(PWM.DRIVETRAIN_LEFT);
        Spark rightDrive = new Spark(PWM.DRIVETRAIN_RIGHT);

        Encoder leftEncoder = new Encoder(2, 3);
        Encoder rightEncoder = new Encoder(0, 1);

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
            leftDrive.setInverted(true);

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

        public int getLeftEncoderAmmount() {
            return leftEncoder.getRaw();
        }
        public int getRightEncoderAmmount() {
            return rightEncoder.getRaw();
        }

        public void ResetEncoders() {
            rightEncoder.reset();
            leftEncoder.reset();
        }

    }


    /**
     * Currently, this does nothing. It's just a place holder for when we get around to putting together the ramp.
     * 
     */
    public class Ramp {
        
        // Waiting to do this until we have the ramp mostly completed. Mainly because that way I don't have to go back and change a bunch of stuff over and over again when Josh ineviteably changes somthing.
        Ramp() {
            throw new UnsupportedOperationException("No ramp code currently availiable.");
        }

    }

    public class Conveyer {
        
        VictorSP mtrDepth = new VictorSP(RobotMap.PWM.CONVEYER_DEPTH);

        public void forward() {
            mtrDepth.set(0.4);
        }

        public void backward() {
            mtrDepth.set(-0.4);
        }
        
        public void stop() {
            mtrDepth.set(0);
        }

        Conveyer() {
            System.out.println("Conveyer Initalised");
        }
    }

    public class HatchPanel {

        // VictorSP motorHeight = new VictorSP(PWM.HATCH_PLATE_HEIGHT);
        // VictorSP motorDepth = new VictorSP(PWM.HATCH_PLATE_DEPTH);

        VictorSP mtrDepth = new VictorSP(RobotMap.PWM.PLATE_HIGHT);

        // TODO: Make limit swiches. I beleive that there will be 4 in total. But,I'm waiting for Josh to get that all figured out.

        HatchPanel() {
            System.out.println("Hatch Panel initalised");
        }

        public void raise(){
            // TODO: Check if any of the limit switches are pressed.
            // They have yet to be put on, so that's why I'm not doing anything with them just yet.

            mtrDepth.set(0.7);
        }

        public void lower(){
            // TODO: Check if any of the limit switches are pressed.
            // They have yet to be put on, so that's why I'm not doing anything with them just yet.

            mtrDepth.set(-0.7);
        }

        public void stop() {
            mtrDepth.set(0);
        }




    }

    public class BallShooter {

        BallShooter() {
            System.out.println("Ball Shooter Initalised");
        }

        VictorSP ballDrive = new VictorSP(RobotMap.PWM.BALL_DRIVE);
        VictorSP ballTilt = new VictorSP(RobotMap.PWM.BALL_TILT);
        public void tiltUp() {
            System.out.println("Tilting");
            ballTilt.set(0.4);
        }

        public void tiltDown() {
            ballTilt.set(-0.4);
        }

        public void tiltStop() {
            ballTilt.set(0);
        }

        public void pullIn() {
            ballDrive.set(1);
        }

        public void pushOut() {
            ballDrive.set(-1);
        }

        public void driveStop() {
            ballDrive.set(0);
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

        public int BallTilt() {
            if (left.getRawButton(RobotMap.Controls.LEFT_BALL_TILT_UP)) return 1;
            else if (left.getRawButton(RobotMap.Controls.LEFT_BALL_TILT_DOWN)) return -1;
            else return 0;
        }

        public int BallShoot() {
            if (left.getRawButton(RobotMap.Controls.LEFT_BALL_IN)) return 1;
            else if (right.getRawButton(RobotMap.Controls.RIGHT_BALL_OUT)) return -1;
            else return 0;
        }

        public int Hatch() {
            if (right.getRawButton(RobotMap.Controls.RIGHT_PLATE_HIGHT_UP)) return 1;
            else if (right.getRawButton(RobotMap.Controls.RIGHT_PLATE_HIGHT_DOWN)) return -1;
            else return 0;
        }

        public int DepthConveyer() {
            if (left.getRawButton(RobotMap.Controls.LEFT_DEPTH_FORWARD)) return 1;
            else if (left.getRawButton(RobotMap.Controls.LEFT_DEPTH_BACKWARD)) return -1;
            else return 0;
        }

    }

}