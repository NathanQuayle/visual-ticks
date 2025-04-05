package com.visualticks;

import com.visualticks.config.InterfaceTab;
import com.visualticks.config.Tick;
import com.visualticks.config.TickShape;
import net.runelite.api.Client;
import net.runelite.api.VarClientInt;
import net.runelite.client.ui.overlay.Overlay;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseVisualTicksOverlay extends Overlay
{
    protected VisualTicksPlugin plugin;
    protected VisualTicksConfig config;
    protected Client client;

    protected boolean configChanged = true;

    // arraylist of x and y values for each tick
    protected final List<Tick> ticks = new ArrayList<>();

    // track dimension values
    protected final Dimension dimension = new Dimension();

    public void onConfigChanged() {
        configChanged = true;
    }

    protected abstract boolean shouldShowText();
    protected abstract int getNumberOfTicks();
    protected abstract Color getTickColour();
    protected abstract Color getCurrentTickColour();
    protected abstract int getAmountPerRow();
    protected abstract int getSizeOfTickShapes();
    protected abstract int getTickPadding();
    protected abstract int getCurrentTick();
    protected abstract InterfaceTab getExclusiveTab();
    protected abstract Color getTickTextColour();
    protected abstract Color getCurrentTickTextColour();
    protected abstract TickShape getTickShape();
    protected abstract int getTickArc();

    protected void calculateSizes(Graphics2D g) {
        configChanged = false;
        ticks.clear();

        for (int tick = 0, position = 0, row = 0; tick < getNumberOfTicks(); tick++)
        {
            int x = position * (getSizeOfTickShapes() + getTickPadding());
            int y = row * (getSizeOfTickShapes() + getTickPadding());

            position++;
            if(shouldShowText()) {
                FontMetrics fm = g.getFontMetrics();

                int textWidth = fm.stringWidth(String.valueOf(tick + 1));
                int textHeight = fm.getHeight();

                int fontX = x + (getSizeOfTickShapes() / 2) - (textWidth / 2);
                int fontY = y + (getSizeOfTickShapes() / 2) + (textHeight / 2);

                ticks.add(new Tick(x, y, fontX, fontY));
            } else {
                ticks.add(new Tick(x, y, 0, 0));
            }
            if(position > getAmountPerRow() - 1) {
                position = 0;
                row++;
            }
        }

        int rowsRendered = (int) Math.ceil((double) getNumberOfTicks() / (double) getAmountPerRow());
        dimension.height = (rowsRendered - 1) * getTickPadding() + rowsRendered * getSizeOfTickShapes();

        int ticksRenderedPerRow = Math.min(getAmountPerRow(), getNumberOfTicks());
        dimension.width = (ticksRenderedPerRow - 1) * getTickPadding() + ticksRenderedPerRow * getSizeOfTickShapes();
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if(configChanged) {
            calculateSizes(graphics);
        }

        if(getExclusiveTab().getIndex() != -1 && client.getVarcIntValue(VarClientInt.INVENTORY_TAB) != getExclusiveTab().getIndex()) return null;
        if(ticks.size() < getNumberOfTicks() - 1) return null;

        for (int i = 0; i < getNumberOfTicks(); i++)
        {
            Tick tick = ticks.get(i);
            graphics.setColor(i == getCurrentTick() ? getCurrentTickColour() : getTickColour());
            switch(getTickShape()) {
                case SQUARE:
                    graphics.fillRect(tick.getShapeX(), tick.getShapeY(), getSizeOfTickShapes(), getSizeOfTickShapes());
                    break;
                case CIRCLE:
                    graphics.fillOval(tick.getShapeX(), tick.getShapeY(), getSizeOfTickShapes(), getSizeOfTickShapes());
                    break;
                case ROUNDED_SQUARE:
                    graphics.fillRoundRect(tick.getShapeX(), tick.getShapeY(), getSizeOfTickShapes(), getSizeOfTickShapes(), getTickArc(), getTickArc());
                    break;
            }
            graphics.fillOval(tick.getShapeX(), tick.getShapeY(), getSizeOfTickShapes(), getSizeOfTickShapes());

            if (shouldShowText()) {
                graphics.setColor(i == getCurrentTick() ? getCurrentTickTextColour() : getTickTextColour());
                graphics.drawString(String.valueOf(i + 1), tick.getFontX(), tick.getFontY());
            }
        }

        return new Dimension(dimension.width, dimension.height + 5);
    }
}

