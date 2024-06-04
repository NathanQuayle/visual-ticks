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
            section = tickSettings,
            position = 0
    )
    @Range(min = 2, max = 30)
    default int numberOfTicks() {
        return 2;
    }

    @ConfigItem(
            keyName = "tickColour",
            name = "Tick colour",
            description = "The colour of the ticks",
            section = tickSettings,
            position = 1
    )
    @Alpha
    default Color tickColour() {
        return new Color(41, 128, 185);
    }

    @ConfigItem(
            keyName = "currentTickColour",
            name = "Current tick colour",
            description = "The colour of the current tick",
            section = tickSettings,
            position = 2
    )
    @Alpha
    default Color currentTickColour() {
        return new Color(236, 240, 241);
    }

    @ConfigItem(
            keyName = "amountPerRow",
            name = "Amount per row",
            description = "How many ticks to display per row",
            section = tickSettings,
            position = 3
    )
    @Range(min = 1)
    default int amountPerRow() {
        return 8;
    }

    @ConfigItem(
            keyName = "sizeOfTickShapes",
            name = "Size of ticks",
            description = "How many pixels to make the tick shapes",
            section = tickSettings,
            position = 4
    )
    default int sizeOfTickShapes() {
        return 32;
    }

    @ConfigItem(
            keyName = "paddingBetweenTicks",
            name = "Padding between ticks",
            description = "The amount of space between ticks",
            section = tickSettings,
            position = 5
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
            section = fontSettings,
            position = 0
    )
    default boolean shouldShowText() {
        return true;
    }

    @ConfigItem(
            keyName = "tickTextColour",
            name = "Tick text colour",
            description = "The colour of the text non-current ticks",
            section = fontSettings,
            position = 1
    )
    @Alpha
    default Color tickTextColour() {
        return new Color(236, 240, 241);
    }

    @ConfigItem(
            keyName = "currentTickTextColour",
            name = "Current tick text colour",
            description = "The colour of the text on the current tick",
            section = fontSettings,
            position = 2
    )
    @Alpha
    default Color currentTickTextColour() {
        return new Color(41, 128, 185);
    }
}
