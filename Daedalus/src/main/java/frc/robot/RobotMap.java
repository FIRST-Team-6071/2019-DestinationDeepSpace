package frc.robot;

public class RobotMap {

    public class PWM {

        public static final int 
            DRIVETRAIN_LEFT = 0,
            DRIVETRAIN_RIGHT = 1,
            HATCH_PLATE_DEPTH = 2,
            HATCH_PLATE_HEIGHT = 3;
            ;

        private PWM() {} // Should never be constructed.

    }

    public class DIO {
        
        public static final int
            ENCODER_LEFT_A = 0,
            ENCODER_LEFT_B = 0,
            ENCODER_RIGHT_A = 0,
            ENCODER_RIGHT_B = 0;

        private DIO() {} // Should never be constructed.
     }

     public class DS_USB {

        public static final int 
            LEFT_STICK = 0,
            RIGHT_STICK = 1;
        
        private DS_USB() {} // Should never be constructed.
     }

     public class Controls {

        public static final int 
            DRIVE_AXIS = 1;

        private Controls() {} // Should never be constructed.
     }

}