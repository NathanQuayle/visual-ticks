package com.visualticks;

import com.visualticks.config.InterfaceTab;
import com.visualticks.config.TickShape;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import javax.inject.Inject;
import java.awt.*;

@Slf4j
public class VisualTicksOverlayTwo extends BaseVisualTicksOverlay
{
    @Inject
    public VisualTicksOverlayTwo(VisualTicksPlugin plugin, VisualTicksConfig config, Client client)
    {
        super(plugin, config, client);
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

    @Override
    protected TickShape getTickShape() {
        return config.tickShapeTwo();
    }

    @Override
    protected int getTickArc() {
        return config.tickArcTwo();
    }
}
