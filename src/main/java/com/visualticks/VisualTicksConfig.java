package com.visualticks;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup(VisualTicksConfig.GROUP_NAME)
public interface VisualTicksConfig extends Config
{
	String GROUP_NAME = "visualticks";

	@ConfigItem(
		keyName = "maintainAspectRatio",
		name = "Maintain aspect ratio",
		description = "Ensures all circles are equal width and height"
	)
	default boolean maintainAspectRatio()
	{
		return true;
	}

	@ConfigItem(
			keyName = "numberOfTicks",
			name = "Number of ticks",
			description = "Number of tick circles to display"
	)
	default int numberOfTicks() { return 2; }

	@ConfigItem(
			keyName = "currentTickColour",
			name = "Current tick colour",
			description = "The colour of the current tick"
	)
	default Color currentTickColour() { return new Color(236, 240, 241); }

	@ConfigItem(
			keyName = "tickColour",
			name = "Tick colour",
			description = "The colour of the ticks"
	)
	default Color tickColour() { return new Color(41, 128, 185); }
}
