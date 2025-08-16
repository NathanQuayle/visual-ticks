package com.visualticks;
import com.visualticks.config.InterfaceTab;
import com.visualticks.config.TickShape;
import net.runelite.client.config.*;
import java.awt.*;
import java.awt.event.KeyEvent;

@ConfigGroup(VisualTicksConfig.GROUP_NAME)
public interface VisualTicksConfig extends Config {
    String GROUP_NAME = "visualticks";

    //region Hotkey Settings
    @ConfigSection(
            name = "Hotkey settings",
            description = "Settings for hotkeys",
            position = 0
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

    //region Tick settings - One
    @ConfigSection(
            name = "Tick settings - One",
            description = "Settings for the first set of ticks",
            position = 1
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
            keyName = "shouldShowTickShapeOne",
            name = "Show Tick Shape",
            description = "Show the shape of the first set of ticks",
            section = tickSettings,
            position = 1
    )
    default boolean shouldShowTickShapeOne() {
        return true;
    }

    @ConfigItem(
            keyName = "tickShapeOne",
            name = "Tick shape",
            description = "The shape of the ticks",
            section = tickSettings,
            position = 2
    )
    default TickShape tickShapeOne() {
        return TickShape.CIRCLE;
    }

    @ConfigItem(
            keyName = "exclusiveTabOne",
            name = "Only show if on tab",
            description = "Show the ticks only when the selected tab is active",
            section = tickSettings,
            position = 3
    )
    default InterfaceTab exclusiveTabOne() {
        return InterfaceTab.ALL;
    }

    @ConfigItem(
            keyName = "numberOfTicksOne",
            name = "Number of ticks",
            description = "Number of tick circles to display",
            section = tickSettings,
            position = 4
    )
    @Range(min = 2, max = 30)
    default int numberOfTicksOne() {
        return 2;
    }

    @ConfigItem(
            keyName = "amountPerRowOne",
            name = "Amount per row",
            description = "How many ticks to display per row",
            section = tickSettings,
            position = 5
    )
    @Range(min = 1)
    default int amountPerRowOne() {
        return 8;
    }

    @ConfigItem(
            keyName = "tickColourOne",
            name = "Tick colour",
            description = "The colour of the ticks",
            section = tickSettings,
            position = 6
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
            position = 7
    )
    @Alpha
    default Color currentTickColourOne() {
        return new Color(236, 240, 241);
    }

    @ConfigItem(
            keyName = "sizeOfTickShapesOne",
            name = "Size of ticks",
            description = "How many pixels to make the tick shapes",
            section = tickSettings,
            position = 8
    )
    default int sizeOfTickShapesOne() {
        return 32;
    }

    @ConfigItem(
            keyName = "tickArcOne",
            name = "Tick arc(rounded square)",
            description = "The arc of the corners of the rounded square tick shape",
            section = tickSettings,
            position = 9
    )
    @Range(max = 100)
    default int tickArcOne() {
        return 10;
    }

    @ConfigItem(
            keyName = "shouldShowTextOne",
            name = "Show text",
            description = "Show the text of the current tick",
            section = tickSettings,
            position = 10
    )
    default boolean shouldShowTextOne() {
        return true;
    }

    @ConfigItem(
            keyName = "tickTextSizeOne",
            name = "Tick text size",
            description = "The size of the text on the ticks",
            section = tickSettings,
            position = 11
    )
    @Range(min = 1, max = 100)
    default int tickTextSizeOne() {
        return 15;
    }

    @ConfigItem(
            keyName = "tickTextColourOne",
            name = "Tick text colour",
            description = "The colour of the text non-current ticks",
            section = tickSettings,
            position = 12
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
            position = 13
    )
    @Alpha
    default Color currentTickTextColourOne() {
        return new Color(41, 128, 185);
    }

    @ConfigItem(
            keyName = "shouldShowCustomTextOne",
            name = "Show custom text",
            description = "Show custom text of the current tick",
            section = tickSettings,
            position = 14
    )
    default boolean shouldShowCustomTextOne() { return false; }

    @ConfigItem(
            keyName = "customTextOne",
            name = "Custom text",
            description = "Custom text to show on each tick, separated by commas",
            section = tickSettings,
            position = 15
    )
    default String customTextOne() { return "1,2,3"; }

    @ConfigItem(
            keyName = "horizontalSpacingOne",
            name = "Horizontal spacing",
            description = "The amount of space between ticks on the x-axis",
            section = tickSettings,
            position = 16
    )
    @Range(min = -50)
    default int horizontalSpacingOne() {
        return 5;
    }

    @ConfigItem(
            keyName = "verticalSpacingOne",
            name = "Vertical spacing",
            description = "The amount of space between ticks on the y-axis",
            section = tickSettings,
            position = 17
    )
    @Range(min = -50)
    default int verticalSpacingOne() {
        return 5;
    }
    //endregion

    //region Tick settings - Two
    @ConfigSection(
            name = "Tick settings - Two",
            description = "Settings for the second set of ticks",
            position = 2
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
            keyName = "shouldShowTickShapeTwo",
            name = "Show Tick Shape",
            description = "Show the shape of the second set of ticks",
            section = tickSettingsTwo,
            position = 1
    )
    default boolean shouldShowTickShapeTwo() {
        return true;
    }

    @ConfigItem(
            keyName = "tickShapeTwo",
            name = "Tick shape",
            description = "The shape of the ticks",
            section = tickSettingsTwo,
            position = 2
    )
    default TickShape tickShapeTwo() {
        return TickShape.CIRCLE;
    }

    @ConfigItem(
            keyName = "exclusiveTabTwo",
            name = "Only show if on tab",
            description = "Show the ticks only when the selected tab is active",
            section = tickSettingsTwo,
            position = 3
    )
    default InterfaceTab exclusiveTabTwo() {
        return InterfaceTab.ALL;
    }

    @ConfigItem(
            keyName = "numberOfTicksTwo",
            name = "Number of ticks",
            description = "Number of tick circles to display",
            section = tickSettingsTwo,
            position = 4
    )
    @Range(min = 2, max = 30)
    default int numberOfTicksTwo() {
        return 2;
    }

    @ConfigItem(
            keyName = "amountPerRowTwo",
            name = "Amount per row",
            description = "How many ticks to display per row",
            section = tickSettingsTwo,
            position = 5
    )
    @Range(min = 1)
    default int amountPerRowTwo() {
        return 8;
    }

    @ConfigItem(
            keyName = "tickColourTwo",
            name = "Tick colour",
            description = "The colour of the ticks",
            section = tickSettingsTwo,
            position = 6
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
            position = 7
    )
    @Alpha
    default Color currentTickColourTwo() {
        return new Color(236, 240, 241);
    }

    @ConfigItem(
            keyName = "sizeOfTickShapesTwo",
            name = "Size of ticks",
            description = "How many pixels to make the tick shapes",
            section = tickSettingsTwo,
            position = 8
    )
    default int sizeOfTickShapesTwo() {
        return 32;
    }

    @ConfigItem(
            keyName = "tickArcTwo",
            name = "Tick arc(rounded square)",
            description = "The arc of the corners of the rounded square tick shape",
            section = tickSettingsTwo,
            position = 9
    )
    @Range(max = 100)
    default int tickArcTwo() {
        return 10;
    }

    @ConfigItem(
            keyName = "shouldShowTextTwo",
            name = "Show text",
            description = "Show the text of the current tick",
            section = tickSettingsTwo,
            position = 10
    )
    default boolean shouldShowTextTwo() {
        return true;
    }

    @ConfigItem(
            keyName = "tickTextSizeTwo",
            name = "Tick text size",
            description = "The size of the text on the ticks",
            section = tickSettingsTwo,
            position = 11
    )
    @Range(min = 1, max = 100)
    default int tickTextSizeTwo() {
        return 15;
    }

    @ConfigItem(
            keyName = "tickTextColourTwo",
            name = "Tick text colour",
            description = "The colour of the text non-current ticks",
            section = tickSettingsTwo,
            position = 12
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
            position = 13
    )
    @Alpha
    default Color currentTickTextColourTwo() {
        return new Color(41, 128, 185);
    }

    @ConfigItem(
            keyName = "shouldShowCustomTextTwo",
            name = "Show custom text",
            description = "Show custom text of the current tick",
            section = tickSettingsTwo,
            position = 14
    )
    default boolean shouldShowCustomTextTwo() { return false; }

    @ConfigItem(
            keyName = "customTextTwo",
            name = "Custom text",
            description = "Custom text to show on each tick, separated by commas",
            section = tickSettingsTwo,
            position = 15
    )
    default String customTextTwo() { return "1,2,3"; }

    @ConfigItem(
            keyName = "horizontalSpacingTwo",
            name = "Horizontal spacing",
            description = "The amount of space between ticks on the x-axis",
            section = tickSettingsTwo,
            position = 16
    )
    @Range(min = -50)
    default int horizontalSpacingTwo() {
        return 5;
    }

    @ConfigItem(
            keyName = "verticalSpacingTwo",
            name = "Vertical spacing",
            description = "The amount of space between ticks on the y-axis",
            section = tickSettingsTwo,
            position = 17
    )
    @Range(min = -50)
    default int verticalSpacingTwo() {
        return 5;
    }
    //endregion

    //region Tick settings - Three
    @ConfigSection(
            name = "Tick settings - Three",
            description = "Settings for the third set of ticks",
            position = 3
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
            keyName = "shouldShowTickShapeThree",
            name = "Show Tick Shape",
            description = "Show the shape of the third set of ticks",
            section = tickSettingsThree,
            position = 1
    )
    default boolean shouldShowTickShapeThree() {
        return true;
    }

    @ConfigItem(
            keyName = "tickShapeThree",
            name = "Tick shape",
            description = "The shape of the ticks",
            section = tickSettingsThree,
            position = 2
    )
    default TickShape tickShapeThree() {
        return TickShape.CIRCLE;
    }

    @ConfigItem(
            keyName = "exclusiveTabThree",
            name = "Only show if on tab",
            description = "Show the ticks only when the selected tab is active",
            section = tickSettingsThree,
            position = 3
    )
    default InterfaceTab exclusiveTabThree() {
        return InterfaceTab.ALL;
    }

    @ConfigItem(
            keyName = "numberOfTicksThree",
            name = "Number of ticks",
            description = "Number of tick circles to display",
            section = tickSettingsThree,
            position = 4
    )
    @Range(min = 2, max = 30)
    default int numberOfTicksThree() {
        return 2;
    }

    @ConfigItem(
            keyName = "amountPerRowThree",
            name = "Amount per row",
            description = "How many ticks to display per row",
            section = tickSettingsThree,
            position = 5
    )
    @Range(min = 1)
    default int amountPerRowThree() {
        return 8;
    }

    @ConfigItem(
            keyName = "tickColourThree",
            name = "Tick colour",
            description = "The colour of the ticks",
            section = tickSettingsThree,
            position = 6
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
            position = 7
    )
    @Alpha
    default Color currentTickColourThree() {
        return new Color(236, 240, 241);
    }

    @ConfigItem(
            keyName = "sizeOfTickShapesThree",
            name = "Size of ticks",
            description = "How many pixels to make the tick shapes",
            section = tickSettingsThree,
            position = 8
    )
    default int sizeOfTickShapesThree() {
        return 32;
    }

    @ConfigItem(
            keyName = "tickArcThree",
            name = "Tick arc(rounded square)",
            description = "The arc of the corners of the rounded square tick shape",
            section = tickSettingsThree,
            position = 9
    )
    @Range(max = 100)
    default int tickArcThree() {
        return 10;
    }

    @ConfigItem(
            keyName = "shouldShowTextThree",
            name = "Show text",
            description = "Show the text of the current tick",
            section = tickSettingsThree,
            position = 10
    )
    default boolean shouldShowTextThree() {
        return true;
    }

    @ConfigItem(
            keyName = "tickTextSizeThree",
            name = "Tick text size",
            description = "The size of the text on the ticks",
            section = tickSettingsThree,
            position = 11
    )
    @Range(min = 1, max = 100)
    default int tickTextSizeThree() {
        return 15;
    }

    @ConfigItem(
            keyName = "tickTextColourThree",
            name = "Tick text colour",
            description = "The colour of the text non-current ticks",
            section = tickSettingsThree,
            position = 12
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
            position = 13
    )
    @Alpha
    default Color currentTickTextColourThree() {
        return new Color(41, 128, 185);
    }

    @ConfigItem(
            keyName = "shouldShowCustomTextThree",
            name = "Show custom text",
            description = "Show custom text of the current tick",
            section = tickSettingsThree,
            position = 14
    )
    default boolean shouldShowCustomTextThree() { return false; }

    @ConfigItem(
            keyName = "customTextThree",
            name = "Custom text",
            description = "Custom text to show on each tick, separated by commas",
            section = tickSettingsThree,
            position = 15
    )
    default String customTextThree() { return "1,2,3"; }

    @ConfigItem(
            keyName = "horizontalSpacingThree",
            name = "Horizontal spacing",
            description = "The amount of space between ticks on the x-axis",
            section = tickSettingsThree,
            position = 16
    )
    @Range(min = -50)
    default int horizontalSpacingThree() {
        return 5;
    }

    @ConfigItem(
            keyName = "verticalSpacingThree",
            name = "Vertical spacing",
            description = "The amount of space between ticks on the y-axis",
            section = tickSettingsThree,
            position = 17
    )
    @Range(min = -50)
    default int verticalSpacingThree() {
        return 5;
    }
    //endregion
}
