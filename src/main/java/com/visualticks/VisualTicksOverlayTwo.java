package com.visualticks;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.*;

@Slf4j
public class VisualTicksOverlayTwo extends BaseVisualTicksOverlay
{
    @Inject
    public VisualTicksOverlayTwo(VisualTicksPlugin plugin, VisualTicksConfig config, Client client)
    {
        this.plugin = plugin;
        this.config = config;
        this.client = client;
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
    }

    @Override
    protected boolean shouldShowText() {
        return config.shouldShowTextTwo();
    }

    @Override
    protected int getNumberOfTicks() {
        return config.numberOfTicksTwo();
    }

    @Override
    protected Color getTickColour() {
        return config.tickColourTwo();
    }

    @Override
    protected Color getCurrentTickColour() {
        return config.currentTickColourTwo();
    }

    @Override
    protected int getAmountPerRow() {
        return config.amountPerRowTwo();
    }

    @Override
    protected int getSizeOfTickShapes() {
        return config.sizeOfTickShapesTwo();
    }

    @Override
    protected int getTickPadding() {
        return config.tickPaddingTwo();
    }

    @Override
    protected Color getTickTextColour() {
        return config.tickTextColourTwo();
    }

    @Override
    protected Color getCurrentTickTextColour() {
        return config.currentTickTextColourTwo();
    }

    @Override
    protected int getCurrentTick() {
        return plugin.tickTwo;
    }

    @Override
    protected InterfaceTab getExclusiveTab() {
        return config.exclusiveTabTwo();
    }
}
