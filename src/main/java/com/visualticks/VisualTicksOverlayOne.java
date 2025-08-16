package com.visualticks;

import com.visualticks.config.InterfaceTab;
import com.visualticks.config.TickShape;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import javax.inject.Inject;
import java.awt.*;

@Slf4j
public class VisualTicksOverlayOne extends BaseVisualTicksOverlay
{
    @Inject
    public VisualTicksOverlayOne(VisualTicksPlugin plugin, VisualTicksConfig config, Client client)
    {
        super(plugin, config, client);
    }

    @Override
    protected boolean shouldShowText() {
        return config.shouldShowTextOne();
    }

    @Override
    protected boolean shouldShowTickShape() {
        return config.shouldShowTickShapeOne();
    }

    @Override
    protected int getTickTextSize() {
        return config.tickTextSizeOne();
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
    protected int getHorizontalSpacing() {
        return config.horizontalSpacingOne();
    }

    @Override
    protected int getVerticalSpacing() {
        return config.verticalSpacingOne();
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

    @Override
    protected boolean shouldShowCustomText() { return config.shouldShowCustomTextOne(); }

    @Override
    protected String getCustomTickText() { return config.customTextOne(); }
}
