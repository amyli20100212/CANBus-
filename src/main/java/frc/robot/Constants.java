package frc.robot;

import com.ctre.phoenix6.CANBus;

public final class Constants {
    public static final class GeneralConstants {
        public static final CANBus CAN_BUS = new CANBus("11256");
        public static final int MOTOR_ID = 1;
        
    }

    public static final class ShootConstants {
        public static final double RUN_VOLTAGE = 4.0;
    }
}