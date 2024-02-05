package com.visualticks;

import com.visualticks.config.TickShape;
import net.runelite.client.config.*;

import java.awt.*;

@ConfigGroup(VisualTicksConfig.GROUP_NAME)
public interface VisualTicksConfig extends Config
{
    String GROUP_NAME = "visualticks";
    String GENERAL_SETTINGS = "General-settings";
    String ALTERNATIVE_SETTINGS = "Alternative-settings";

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
}
