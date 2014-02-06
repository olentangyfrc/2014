package org.olentangyfrc.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.olentangyfrc.OI;
import org.olentangyfrc.subsystems.*;


/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    
    public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static HammerSubsystem hammerSubsystem = new HammerSubsystem();
    public static UpperRight upperRight = new UpperRight();
    public static UpperLeft upperLeft = new UpperLeft();
    public static LowerRight lowerRight = new LowerRight();
    public static LowerLeft lowerLeft = new LowerLeft();
    

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(exampleSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
