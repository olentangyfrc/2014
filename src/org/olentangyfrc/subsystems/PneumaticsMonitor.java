
package org.olentangyfrc.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalOutput;
import org.olentangyfrc.RobotMap

/**
 *
 */
public class PneumaticsMonitor extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    AnalogChannel pressureInput;
    DigitalOutput compressorOutput;
    
    public PneumaticsMonitor() {
        super("PneumaticsMonitor");
        pressureInput = new AnalogChannel(RobotMap.PRESSURE_INPUT);
        compressorOutput = new DigitalOutput(RobotMap.COMPRESSOR_OUTPUT);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void getPressureVoltage() {
        pressureInput.getVoltage();
    }
    public void startCompresssor() {
        compressorOutput.set(true);
    }
    public void stopCompressor() {
        compressorOutput.set(false);
    }
}

