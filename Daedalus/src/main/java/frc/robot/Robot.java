package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.cameraserver.*;
import edu.wpi.first.wpilibj.Timer;

import frc.robot.Systems.*;


public class Robot extends TimedRobot{

    // Create a new RobotMap to have access to the different parts of the robot.
    Systems system = new Systems();
    Drivetrain drivetrain = system.new Drivetrain();
    Input input = system.new Input();

    BallShooter ballShooter = system.new BallShooter();
    HatchPanel hatchPanel = system.new HatchPanel();
    Conveyer conveyer = system.new Conveyer();
    // Ramp ramp = system.new Ramp();
    
    public boolean left = false;
    public boolean right = false;

    public boolean stepOne = true;
    public boolean stepTwo = false;
    public boolean stepThree = false;

    @Override
    public void robotInit() {
      CameraServer.getInstance().startAutomaticCapture("hatchCam", 0);
       CameraServer.getInstance().startAutomaticCapture("ballCam", 1);

      System.out.println("Daedalus is online. Insert some snarky line to chuckle at whenever we turn on the robot at a competition.");
      // CameraServer.getInstance().startAutomaticCapture();
    }

    @Override
    public void robotPeriodic() {
      System.out.println("Right:" + drivetrain.getRightEncoderAmmount());
      System.out.println("Left: " + drivetrain.getLeftEncoderAmmount());
    }


    /**
     * NGL... I'm not looking forward to this....
     */
    @Override
    public void autonomousInit() {

    }

    @Override
    public void autonomousPeriodic() {

      while (stepOne) {

        System.out.println("Right:" + drivetrain.getRightEncoderAmmount());
        System.out.println("Left: " + drivetrain.getLeftEncoderAmmount());
        
        System.out.println("Step One");
        if (drivetrain.getLeftEncoderAmmount() >= -12599) {
          drivetrain.leftDrive.set(-0.6);
        }
        else {drivetrain.leftDrive.set(0); left = true;}

        if (drivetrain.getRightEncoderAmmount() <= 12863) {
          drivetrain.rightDrive.set(-0.6);
        }
        else {drivetrain.rightDrive.set(0); right = true;}

        if(left == true && right == true){
          stepOne = false;
          left = false;
          right = false;
          drivetrain.ResetEncoders();
          stepTwo = true;
        }
      }

      while (stepTwo) {
        
        System.out.println("Right:" + drivetrain.getRightEncoderAmmount());
        System.out.println("Left: " + drivetrain.getLeftEncoderAmmount());
        
        System.out.println("Step Two");
        if (drivetrain.getLeftEncoderAmmount() >= -1649) {
          drivetrain.leftDrive.set(-0.7);
        }
        else {drivetrain.leftDrive.set(0); left = true;}

        if (drivetrain.getRightEncoderAmmount() >= -1555) {
          drivetrain.rightDrive.set(0.7);
        }
        else {drivetrain.rightDrive.set(0); right = true;}

        if(left == true && right == true){
          stepTwo = false;
          left = false;
          right = false;
          // stepThree = true;
        }
      }


    }

    
    @Override
    public void teleopInit() {
      // Ok, so this isn't used really until we get into encoders. Which won't be for a while.  
    }

    @Override
    public void teleopPeriodic() {    

      drivetrain.Move(input.getLeftDrive(), input.getRightDrive());

      if (input.BallTilt() == 1) {  ballShooter.tiltUp(); }
      else if (input.BallTilt() == -1) {  ballShooter.tiltDown(); }
      else {  ballShooter.tiltStop(); }
  
      if (input.BallShoot() == 1) {  ballShooter.pullIn(); }
      else if (input.BallShoot() == -1) {  ballShooter.pushOut(); }
      else {  ballShooter.driveStop(); }

      if(input.left.getRawButton(5)) {
        drivetrain.ResetEncoders();

      }

      
      if (input.Hatch() == 1) {  hatchPanel.raise(); }
      else if (input.Hatch() == -1) {  hatchPanel.lower(); }
      else {  hatchPanel.stop(); }
      
      
      if (input.DepthConveyer() == 1) {  conveyer.forward(); }
      else if (input.DepthConveyer() == -1) {  conveyer.backward(); }
      else {  conveyer.stop(); }
    }
}
