package com.visualticks;

import com.visualticks.config.InterfaceTab;
import com.visualticks.config.TickShape;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.*;

@Slf4j
public class VisualTicksOverlayOne extends BaseVisualTicksOverlay
{
    @Inject
    public VisualTicksOverlayOne(VisualTicksPlugin plugin, VisualTicksConfig config, Client client)
    {
        this.plugin = plugin;
        this.config = config;
        this.client = client;
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
        return config.tickColourOne();
    }

    @Override
    protected Color getCurrentTickColour() {
        return config.currentTickColourOne();
    }

    @Override
    protected int getAmountPerRow() {
        return config.amountPerRowOne();
    }

    @Override
    protected int getSizeOfTickShapes() {
        return config.sizeOfTickShapesOne();
    }

    @Override
    protected int getTickPadding() {
        return config.tickPaddingOne();
    }

    @Override
    protected int getCurrentTick() {
        return plugin.tickOne;
    }

    @Override
    protected InterfaceTab getExclusiveTab() {
        return config.exclusiveTabOne();
    }

    @Override
    protected Color getTickTextColour() {
        return config.tickTextColourOne();
    }

    @Override
    protected Color getCurrentTickTextColour() {
        return config.currentTickTextColourOne();
    }

    @Override
    protected TickShape getTickShape() {
        return config.tickShapeOne();
    }

    @Override
    protected int getTickArc() {
        return config.tickArcOne();
    }
}
