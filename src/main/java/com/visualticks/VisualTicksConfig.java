package com.visualticks;

import com.visualticks.config.TickShape;
import net.runelite.api.Skill;
import net.runelite.client.config.*;

import java.awt.*;

@ConfigGroup(VisualTicksConfig.GROUP_NAME)
public interface VisualTicksConfig extends Config
{
    String GROUP_NAME = "visualticks";
    String GENERAL_SETTINGS = "General-settings";
    String RESET_SETTINGS = "Reset-settings";

    // General settings
    @ConfigSection(
            position = 0,
            name = "General",
            description = "General settings"

    )
    String generalSettings = GENERAL_SETTINGS;

    @ConfigItem(
            position = 0,
            keyName = "numberOfTicks",
            name = "Number of ticks",
            description = "Number of tick circles to display",
            section = generalSettings
    )
    @Range(min = 2, max = 30)
    default int numberOfTicks()
    {
        return 2;
    }

    @ConfigItem(
            position = 1,
            keyName = "tickColour",
            name = "Tick colour",
            description = "The colour of the ticks",
            section = generalSettings
    )
    @Alpha
    default Color tickColour()
    {
        return new Color(41, 128, 185);
    }

    @ConfigItem(
            position = 2,
            keyName = "currentTickColour",
            name = "Current tick colour",
            description = "The colour of the current tick",
            section = generalSettings
    )
    @Alpha
    default Color currentTickColour()
    {
        return new Color(236, 240, 241);
    }

	@ConfigItem(
			position = 3,
			keyName = "amountPerRow",
			name = "Amount per row",
			description = "How many ticks to display per row",
            section = generalSettings
	)
	default int amountPerRow()
	{
		return 8;
	}

    @ConfigItem(
            position = 4,
            keyName = "sizeOfTickShapes",
            name = "Size of ticks",
            description = "How many pixels to make the tick shapes",
            section = generalSettings
    )
    default int sizeOfTickShapes()
    {
        return 32;
    }

    @ConfigItem(
            position = 5,
            keyName = "paddingBetweenTicks",
            name = "Padding between ticks",
            description = "The amount of space between ticks",
            section = generalSettings
    )
    default int tickPadding()
    {
        return 5;
    }


    @ConfigItem(
            position = 6,
            keyName = "arcOnTicks",
            name = "Arc",
            description = "Arc (if using Rounded Square)",
            section = generalSettings
    )
    default int getTickArc() {
        return 5;
    }

    @ConfigItem(
            position =7,
            keyName = "tickShape",
            name = "Shape of the tick",
            description = "The shape of the visual ticks",
            section = generalSettings
    )
    default TickShape getTickShape()
    {
        return TickShape.CIRCLE;
    }

    @ConfigSection(
            position = 1,
            name = "Reset counter",
            description = "Reset counter"

    )
    String resetSettings = RESET_SETTINGS;


    @ConfigItem(
            position = 0,
            keyName = "reset-conter",
            name = "Reset counter on xp drop",
            description = "Reset the tick-counter after xp-drop.",
            section = resetSettings
    )
    default boolean isResetCounter() {
        return false;
    }

    @ConfigItem(
            position = 1,
            keyName = "startTick",
            name = "Start on tick",
            description = "Which tick to start on after the reset.",
            section = resetSettings
    )
    @Range(max = 30)
    default int getOffset() {
        return 0;
    }


    @ConfigItem(
            position = 2,
            keyName = "skill",
            name = "Skill",
            description = "Which skill you want to trigger the reset",
            section = resetSettings
    )
    default Skill getResetSkill() {
        return Skill.HITPOINTS;
    }

    @ConfigItem(
            position = 3,
            keyName = "currentResetTickColour",
            name = "Current reset tick colour",
            description = "The colour of the reset tick when active",
            section = resetSettings
    )
    @Alpha
    default Color getCurrentResetTickColour()
    {
        return Color.GREEN;
    }

    @ConfigItem(
            position = 4,
            keyName = "resetTickColour",
            name = "Reset tick colour",
            description = "The colour of the reset tick when not active",
            section = resetSettings
    )
    @Alpha
    default Color getResetTickColour()
    {
        return Color.decode("#0D430D");
    }
}
