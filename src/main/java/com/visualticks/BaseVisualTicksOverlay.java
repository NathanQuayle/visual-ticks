package com.visualticks;

import com.google.inject.Inject;
import com.visualticks.config.InterfaceTab;
import com.visualticks.config.Tick;
import com.visualticks.config.TickShape;
import net.runelite.api.Client;
import net.runelite.api.VarClientInt;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseVisualTicksOverlay extends Overlay
{
    protected VisualTicksPlugin plugin;
    protected VisualTicksConfig config;
    protected Client client;
    protected boolean configChanged = true;
    protected final List<Tick> ticks = new ArrayList<>();
    protected final Dimension dimension = new Dimension();

    @Inject
    public BaseVisualTicksOverlay(VisualTicksPlugin plugin, VisualTicksConfig config, Client client)
    {
        this.plugin = plugin;
        this.config = config;
        this.client = client;
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
    }

    public void onConfigChanged() {
        configChanged = true;
    }

    protected abstract boolean shouldShowText();
    protected abstract boolean shouldShowTickShape();
    protected abstract int getTickTextSize();
    protected abstract int getNumberOfTicks();
    protected abstract Color getTickColour();
    protected abstract Color getCurrentTickColour();
    protected abstract int getAmountPerRow();
    protected abstract int getSizeOfTickShapes();
    protected abstract int getHorizontalSpacing();
    protected abstract int getVerticalSpacing();
    protected abstract int getCurrentTick();
    protected abstract InterfaceTab getExclusiveTab();
    protected abstract Color getTickTextColour();
    protected abstract Color getCurrentTickTextColour();
    protected abstract TickShape getTickShape();
    protected abstract int getTickArc();
    protected abstract boolean shouldShowCustomText();
    protected abstract String getCustomTickText();

    protected String[] customTickText;

    protected String getTickText(int tickIndex){
        String tickText = String.valueOf(tickIndex + 1);
        if (shouldShowCustomText()){
            if (customTickText.length > tickIndex){
                tickText = customTickText[tickIndex];
            }
        }
        return tickText;
    }

    protected void calculateCustomTickText() {
        configChanged = false;
        customTickText = Arrays.stream(getCustomTickText().split(",")).map(String::trim).toArray(String[]::new);
    }

    protected void calculateSizes(Graphics2D g) {
        configChanged = false;
        ticks.clear();

        int totalTicks = getNumberOfTicks();
        int perRow = getAmountPerRow();
        int shapeSize = getSizeOfTickShapes();
        Font originalFont = g.getFont();
        g.setFont(g.getFont().deriveFont((float) getTickTextSize()));
        FontMetrics fm = g.getFontMetrics();

        int maxBoundingSize = 0;
        int maxCol = 0;
        int maxRow = 0;

        for (int i = 0; i < totalTicks; i++)
        {
            int boundingSize = shouldShowTickShape() ? shapeSize : 0;

            String text = getTickText(i);
            int textWidth = fm.stringWidth(text);
            int textHeight = fm.getAscent();

            if (shouldShowText()) {
                boundingSize = Math.max(boundingSize, textWidth);
                boundingSize = Math.max(boundingSize, textHeight);
            }

            int row = i / perRow;
            int col = i % perRow;
            int x = col * (boundingSize + getHorizontalSpacing());
            int y = row * (boundingSize + getVerticalSpacing());

            Tick tick = new Tick(x, y);

            if (shouldShowText()) {
                tick.setFontX(x + (boundingSize - textWidth) / 2);
                tick.setFontY(y + (boundingSize + textHeight) / 2);
            }
            ticks.add(tick);

            maxBoundingSize = Math.max(maxBoundingSize, boundingSize);
            maxRow = Math.max(maxRow, row);
            maxCol = Math.max(maxCol, col);
        }

        dimension.width = (maxCol + 1) * (maxBoundingSize + getHorizontalSpacing()) - getHorizontalSpacing();
        dimension.height = (maxRow + 1) * (maxBoundingSize + getVerticalSpacing()) - getVerticalSpacing();
        g.setFont(originalFont);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if(configChanged) {
            calculateCustomTickText();
            calculateSizes(graphics);
        }

        if(getExclusiveTab().getIndex() != -1 && client.getVarcIntValue(VarClientInt.INVENTORY_TAB) != getExclusiveTab().getIndex()) return null;
        if(ticks.size() < getNumberOfTicks() - 1) return null;

        Font originalFont = graphics.getFont();
        graphics.setFont(graphics.getFont().deriveFont((float) getTickTextSize()));

        for (int i = 0; i < getNumberOfTicks(); i++)
        {
            Tick tick = ticks.get(i);
            if (shouldShowTickShape()) {
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
            }
            if (shouldShowText()) {
                graphics.setColor(i == getCurrentTick() ? getCurrentTickTextColour() : getTickTextColour());
                graphics.drawString(getTickText(i), tick.getFontX(), tick.getFontY());
            }
        }

        graphics.setFont(originalFont);
        return new Dimension(dimension.width, dimension.height);
    }
}
