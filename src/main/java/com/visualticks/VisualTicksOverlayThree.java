package com.visualticks;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.*;

@Slf4j
public class VisualTicksOverlayThree extends BaseVisualTicksOverlay
{
    @Inject
    public VisualTicksOverlayThree(VisualTicksPlugin plugin, VisualTicksConfig config)
    {
        this.plugin = plugin;
        this.config = config;
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
    }

    @Override
    protected boolean shouldShowText() {
        return config.shouldShowTextThree();
    }

    @Override
    protected int getNumberOfTicks() {
        return config.numberOfTicksThree();
    }

    @Override
    protected Color getTickColour() {
        return config.tickColourThree();
    }

    @Override
    protected Color getCurrentTickColour() {
        return config.currentTickColourThree();
    }

    @Override
    protected int getAmountPerRow() {
        return config.amountPerRowThree();
    }

    @Override
    protected int getSizeOfTickShapes() {
        return config.sizeOfTickShapesThree();
    }

    @Override
    protected int getTickPadding() {
        return config.tickPaddingThree();
    }

    @Override
    protected int getCurrentTick() {
        return plugin.tickThree;
    }
}
