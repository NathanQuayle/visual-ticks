package com.visualticks;
import net.runelite.client.config.*;
import java.awt.*;
import java.awt.event.KeyEvent;

@ConfigGroup(VisualTicksConfig.GROUP_NAME)
public interface VisualTicksConfig extends Config {
    String GROUP_NAME = "visualticks";

    //region Tick settings - One
    @ConfigSection(
            name = "Tick settings - One",
            description = "Settings for the first set of ticks",
            position = 0
    )
    String tickSettings = "tickSettings";

    @ConfigItem(
            keyName = "isEnabledOne",
            name = "Enabled",
            description = "Enable the first set of ticks",
            section = tickSettings,
            position = 0
    )
    default boolean isEnabledOne() {
        return true;
    }

    @ConfigItem(
            keyName = "exclusiveTabOne",
            name = "Only show if on tab",
            description = "Show the ticks only when the selected tab is active",
            section = tickSettings,
            position = 1
    )
    default InterfaceTab exclusiveTabOne() {
        return InterfaceTab.ALL;
    }

    @ConfigItem(
            keyName = "numberOfTicksOne",
            name = "Number of ticks",
            description = "Number of tick circles to display",
            section = tickSettings,
            position = 2
    )
    @Range(min = 2, max = 30)
    default int numberOfTicksOne() {
        return 2;
    }

    @ConfigItem(
            keyName = "tickColourOne",
            name = "Tick colour",
            description = "The colour of the ticks",
            section = tickSettings,
            position = 3
    )
    @Alpha
    default Color tickColourOne() {
        return new Color(41, 128, 185);
    }

    @ConfigItem(
            keyName = "currentTickColourOne",
            name = "Current tick colour",
            description = "The colour of the current tick",
            section = tickSettings,
            position = 4
    )
    @Alpha
    default Color currentTickColourOne() {
        return new Color(236, 240, 241);
    }

    @ConfigItem(
            keyName = "shouldShowTextOne",
            name = "Show text",
            description = "Show the text of the current tick",
            section = tickSettings,
            position = 5
    )
    default boolean shouldShowTextOne() {
        return true;
    }

    @ConfigItem(
            keyName = "tickTextColourOne",
            name = "Tick text colour",
            description = "The colour of the text non-current ticks",
            section = tickSettings,
            position = 6
    )
    @Alpha
    default Color tickTextColourOne() {
        return new Color(236, 240, 241);
    }

    @ConfigItem(
            keyName = "currentTickTextColourOne",
            name = "Current tick text colour",
            description = "The colour of the text on the current tick",
            section = tickSettings,
            position = 7
    )
    @Alpha
    default Color currentTickTextColourOne() {
        return new Color(41, 128, 185);
    }

    @ConfigItem(
            keyName = "amountPerRowOne",
            name = "Amount per row",
            description = "How many ticks to display per row",
            section = tickSettings,
            position = 8
    )
    @Range(min = 1)
    default int amountPerRowOne() {
        return 8;
    }

    @ConfigItem(
            keyName = "sizeOfTickShapesOne",
            name = "Size of ticks",
            description = "How many pixels to make the tick shapes",
            section = tickSettings,
            position = 9
    )
    default int sizeOfTickShapesOne() {
        return 32;
    }

    @ConfigItem(
            keyName = "paddingBetweenTicksOne",
            name = "Padding between ticks",
            description = "The amount of space between ticks",
            section = tickSettings,
            position = 10
    )
    default int tickPaddingOne() {
        return 5;
    }
    //endregion

    //region Tick settings - Two
    @ConfigSection(
            name = "Tick settings - Two",
            description = "Settings for the second set of ticks",
            position = 1
    )
    String tickSettingsTwo = "tickSettingsTwo";

    @ConfigItem(
            keyName = "isEnabledTwo",
            name = "Enabled",
            description = "Enable the second set of ticks",
            section = tickSettingsTwo,
            position = 0
    )
    default boolean isEnabledTwo() {
        return false;
    }

    @ConfigItem(
            keyName = "exclusiveTabTwo",
            name = "Only show if on tab",
            description = "Show the ticks only when the selected tab is active",
            section = tickSettingsTwo,
            position = 1
    )
    default InterfaceTab exclusiveTabTwo() {
        return InterfaceTab.ALL;
    }

    @ConfigItem(
            keyName = "numberOfTicksTwo",
            name = "Number of ticks",
            description = "Number of tick circles to display",
            section = tickSettingsTwo,
            position = 2
    )
    @Range(min = 2, max = 30)
    default int numberOfTicksTwo() {
        return 2;
    }

    @ConfigItem(
            keyName = "tickColourTwo",
            name = "Tick colour",
            description = "The colour of the ticks",
            section = tickSettingsTwo,
            position = 3
    )
    @Alpha
    default Color tickColourTwo() {
        return new Color(41, 128, 185);
    }

    @ConfigItem(
            keyName = "currentTickColourTwo",
            name = "Current tick colour",
            description = "The colour of the current tick",
            section = tickSettingsTwo,
            position = 4
    )
    @Alpha
    default Color currentTickColourTwo() {
        return new Color(236, 240, 241);
    }

    @ConfigItem(
            keyName = "shouldShowTextTwo",
            name = "Show text",
            description = "Show the text of the current tick",
            section = tickSettingsTwo,
            position = 5
    )
    default boolean shouldShowTextTwo() {
        return true;
    }

    @ConfigItem(
            keyName = "tickTextColourTwo",
            name = "Tick text colour",
            description = "The colour of the text non-current ticks",
            section = tickSettingsTwo,
            position = 6
    )
    @Alpha
    default Color tickTextColourTwo() {
        return new Color(236, 240, 241);
    }

    @ConfigItem(
            keyName = "currentTickTextColourTwo",
            name = "Current tick text colour",
            description = "The colour of the text on the current tick",
            section = tickSettingsTwo,
            position = 7
    )
    @Alpha
    default Color currentTickTextColourTwo() {
        return new Color(41, 128, 185);
    }

    @ConfigItem(
            keyName = "amountPerRowTwo",
            name = "Amount per row",
            description = "How many ticks to display per row",
            section = tickSettingsTwo,
            position = 8
    )
    @Range(min = 1)
    default int amountPerRowTwo() {
        return 8;
    }

    @ConfigItem(
            keyName = "sizeOfTickShapesTwo",
            name = "Size of ticks",
            description = "How many pixels to make the tick shapes",
            section = tickSettingsTwo,
            position = 9
    )
    default int sizeOfTickShapesTwo() {
        return 32;
    }

    @ConfigItem(
            keyName = "tickPaddingTwo",
            name = "Padding between ticks",
            description = "The amount of space between ticks",
            section = tickSettingsTwo,
            position = 10
    )
    default int tickPaddingTwo() {
        return 5;
    }
    //endregion

    //region Tick settings - Three
    @ConfigSection(
            name = "Tick settings - Three",
            description = "Settings for the third set of ticks",
            position = 2
    )
    String tickSettingsThree = "tickSettingsThree";

    @ConfigItem(
            keyName = "isEnabledThree",
            name = "Enabled",
            description = "Enable the third set of ticks",
            section = tickSettingsThree,
            position = 0
    )
    default boolean isEnabledThree() {
        return false;
    }

    @ConfigItem(
            keyName = "exclusiveTabThree",
            name = "Only show if on tab",
            description = "Show the ticks only when the selected tab is active",
            section = tickSettingsThree,
            position = 1
    )
    default InterfaceTab exclusiveTabThree() {
        return InterfaceTab.ALL;
    }

    @ConfigItem(
            keyName = "numberOfTicksThree",
            name = "Number of ticks",
            description = "Number of tick circles to display",
            section = tickSettingsThree,
            position = 2
    )
    @Range(min = 2, max = 30)
    default int numberOfTicksThree() {
        return 2;
    }

    @ConfigItem(
            keyName = "tickColourThree",
            name = "Tick colour",
            description = "The colour of the ticks",
            section = tickSettingsThree,
            position = 3
    )
    @Alpha
    default Color tickColourThree() {
        return new Color(41, 128, 185);
    }

    @ConfigItem(
            keyName = "currentTickColourThree",
            name = "Current tick colour",
            description = "The colour of the current tick",
            section = tickSettingsThree,
            position = 4
    )
    @Alpha
    default Color currentTickColourThree() {
        return new Color(236, 240, 241);
    }

    @ConfigItem(
            keyName = "shouldShowTextThree",
            name = "Show text",
            description = "Show the text of the current tick",
            section = tickSettingsThree,
            position = 5
    )
    default boolean shouldShowTextThree() {
        return true;
    }

    @ConfigItem(
            keyName = "tickTextColourThree",
            name = "Tick text colour",
            description = "The colour of the text non-current ticks",
            section = tickSettingsThree,
            position = 6
    )
    @Alpha
    default Color tickTextColourThree() {
        return new Color(236, 240, 241);
    }

    @ConfigItem(
            keyName = "currentTickTextColourThree",
            name = "Current tick text colour",
            description = "The colour of the text on the current tick",
            section = tickSettingsThree,
            position = 7
    )
    @Alpha
    default Color currentTickTextColourThree() {
        return new Color(41, 128, 185);
    }

    @ConfigItem(
            keyName = "amountPerRowThree",
            name = "Amount per row",
            description = "How many ticks to display per row",
            section = tickSettingsThree,
            position = 8
    )
    @Range(min = 1)
    default int amountPerRowThree() {
        return 8;
    }

    @ConfigItem(
            keyName = "sizeOfTickShapesThree",
            name = "Size of ticks",
            description = "How many pixels to make the tick shapes",
            section = tickSettingsThree,
            position = 9
    )
    default int sizeOfTickShapesThree() {
        return 32;
    }

    @ConfigItem(
            keyName = "tickPaddingThree",
            name = "Padding between ticks",
            description = "The amount of space between ticks",
            section = tickSettingsThree,
            position = 10
    )
    default int tickPaddingThree() {
        return 5;
    }
    //endregion

    //region Hotkey Settings
    @ConfigSection(
            name = "Hotkey settings",
            description = "Settings for hotkeys",
            position = 3
    )
    String hotkeySettings = "hotkeySettings";

    @ConfigItem(
            position = 0,
            keyName = "tickResetHotkey",
            name = "Tick Reset Hotkey",
            description = "Hotkey to reset tick counter",
            section = hotkeySettings
    )
    default Keybind tickResetHotkey() {
        return new Keybind(KeyEvent.VK_BACK_QUOTE, KeyEvent.VK_UNDEFINED);
    }
    //endregion
}
