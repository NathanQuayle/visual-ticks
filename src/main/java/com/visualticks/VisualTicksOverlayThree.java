package com.visualticks;

import com.visualticks.config.InterfaceTab;
import com.visualticks.config.TickShape;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import javax.inject.Inject;
import java.awt.*;

@Slf4j
public class VisualTicksOverlayThree extends BaseVisualTicksOverlay
{
    @Inject
    public VisualTicksOverlayThree(VisualTicksPlugin plugin, VisualTicksConfig config, Client client)
    {
        super(plugin, config, client);
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
    protected Color getTickTextColour() {
        return config.tickTextColourThree();
    }

    @Override
    protected Color getCurrentTickTextColour() {
        return config.currentTickTextColourThree();
    }

    @Override
    protected int getCurrentTick() {
        return plugin.tickThree;
    }

    @Override
    protected InterfaceTab getExclusiveTab() {
        return config.exclusiveTabThree();
    }

    @Override
    protected TickShape getTickShape() {
        return config.tickShapeThree();
    }

    @Override
    protected int getTickArc() {
        return config.tickArcThree();
    }
}
