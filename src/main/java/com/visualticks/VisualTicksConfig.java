package com.visualticks;

import net.runelite.client.config.*;

import java.awt.*;

@ConfigGroup(VisualTicksConfig.GROUP_NAME)
public interface VisualTicksConfig extends Config {
    String GROUP_NAME = "visualticks";

    // create group for "tick settings"
    @ConfigSection(
            name = "Tick settings",
            description = "Settings for the tick circles",
            position = 0
    )
    String tickSettings = "tickSettings";

    @ConfigItem(
            keyName = "numberOfTicks",
            name = "Number of ticks",
            description = "Number of tick circles to display",
            section = tickSettings
    )
    @Range(min = 2, max = 30)
    default int numberOfTicks() {
        return 2;
    }

    @ConfigItem(
            keyName = "tickColour",
            name = "Tick colour",
            description = "The colour of the ticks",
            section = tickSettings
    )
    @Alpha
    default Color tickColour() {
        return new Color(41, 128, 185);
    }

    @ConfigItem(
            keyName = "currentTickColour",
            name = "Current tick colour",
            description = "The colour of the current tick",
            section = tickSettings
    )
    @Alpha
    default Color currentTickColour() {
        return new Color(236, 240, 241);
    }

    @ConfigItem(
            keyName = "amountPerRow",
            name = "Amount per row",
            description = "How many ticks to display per row",
            section = tickSettings
    )
    default int amountPerRow() {
        return 8;
    }

    @ConfigItem(
            keyName = "sizeOfTickShapes",
            name = "Size of ticks",
            description = "How many pixels to make the tick shapes",
            section = tickSettings
    )
    default int sizeOfTickShapes() {
        return 32;
    }

    @ConfigItem(
            keyName = "paddingBetweenTicks",
            name = "Padding between ticks",
            description = "The amount of space between ticks",
            section = tickSettings
    )
    default int tickPadding() {
        return 5;
    }

    @ConfigSection(
            name = "Text settings",
            description = "Settings for the font",
            position = 1
    )
    String fontSettings = "textSettings";

    @ConfigItem(
            keyName = "shouldShowText",
            name = "Show text",
            description = "Show the text of the current tick",
            section = fontSettings
    )
    default boolean shouldShowText() {
        return true;
    }

    @ConfigItem(
            keyName = "textColour",
            name = "Text colour",
            description = "The colour of the text",
            section = fontSettings
    )
    @Alpha
    default Color textColour() {
        return new Color(236, 240, 241);
    }
}
