package com.visualticks;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.*;

@Slf4j
public class VisualTicksOverlayOne extends BaseVisualTicksOverlay
{
    @Inject
    public VisualTicksOverlayOne(VisualTicksPlugin plugin, VisualTicksConfig config)
    {
        this.plugin = plugin;
        this.config = config;
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
    }

    @Override
    protected boolean shouldShowText() {
        return config.shouldShowTextOne();
    }

    @Override
    protected int getNumberOfTicks() {
        return config.numberOfTicksOne();
    }

    @Override
    protected Color getTickColour() {
        return config.tickColour();
    }

    @Override
    protected Color getCurrentTickColour() {
        return config.currentTickColour();
    }

    @Override
    protected int getAmountPerRow() {
        return config.amountPerRow();
    }

    @Override
    protected int getSizeOfTickShapes() {
        return config.sizeOfTickShapes();
    }

    @Override
    protected int getTickPadding() {
        return config.tickPadding();
    }

    @Override
    protected int getCurrentTick() {
        return plugin.tickOne;
    }
}
