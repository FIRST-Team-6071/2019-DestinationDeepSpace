package frc.robot;

public class RobotMap {

    public class PWM {

        public static final int 
            DRIVETRAIN_RIGHT = 0,
            DRIVETRAIN_LEFT = 1,
            CONVEYER_DEPTH = 2, // Temporary. Still need to wait for final wiring.
            BALL_TILT = 3, // Temporary. Still need to wait for final wiring.
            RAMP_CONTROL = 4,
            BALL_DRIVE = 5,
            PLATE_HIGHT = 6;

        private PWM() {} // Should never be constructed.

    }

    public class DIO {
        
        public static final int
            ENCODER_LEFT_A = 0,
            ENCODER_LEFT_B = 1,
            ENCODER_RIGHT_A = 2,
            ENCODER_RIGHT_B = 3;

        private DIO() {} // Should never be constructed.
    }

    public class CAN {

        private CAN() {} // SHould never be constructed.
    }

     public class DS_USB {

        public static final int 
            LEFT_STICK = 0,
            RIGHT_STICK = 1;
        
        private DS_USB() {} // Should never be constructed.
     }

     public class Controls {

        public static final int 
            DRIVE_AXIS = 1,
            RIGHT_PLATE_HIGHT_UP = 5,
            RIGHT_PLATE_HIGHT_DOWN = 3,
            LEFT_BALL_IN = 1,
            RIGHT_BALL_OUT = 1,
            LEFT_DEPTH_FORWARD = 5,
            LEFT_DEPTH_BACKWARD = 3,
            LEFT_BALL_TILT_UP = 6,
            LEFT_BALL_TILT_DOWN = 4;

        private Controls() {} // Should never be constructed.
     }

}