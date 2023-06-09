package com.visualticks;

import net.runelite.client.config.*;

import java.awt.*;

@ConfigGroup(VisualTicksConfig.GROUP_NAME)
public interface VisualTicksConfig extends Config
{
    String GROUP_NAME = "visualticks";

    @ConfigItem(
            position = 0,
            keyName = "numberOfTicks",
            name = "Number of ticks",
            description = "Number of tick circles to display"
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
            description = "The colour of the ticks"
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
            description = "The colour of the current tick"
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
			description = "How many ticks to display per row"
	)
	default int amountPerRow()
	{
		return 8;
	}

    @ConfigItem(
            position = 3,
            keyName = "sizeOfTickShapes",
            name = "Size of ticks",
            description = "How many pixels to make the tick shapes"
    )
    default int sizeOfTickShapes()
    {
        return 32;
    }

    @ConfigItem(
            position = 5,
            keyName = "paddingBetweenTicks",
            name = "Padding between ticks",
            description = "The amount of space between ticks"
    )
    default int tickPadding()
    {
        return 5;
    }
}
