package com.visualticks;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class VisualTicksOverlay extends Overlay
{
    @Inject
    VisualTicksPlugin plugin;

    @Inject
    VisualTicksConfig config;

    private boolean configChanged = true;

    // arraylist of x and y values for each tick
    private final List<Tick> ticks = new ArrayList<>();

    // track dimension values
    private final Dimension dimension = new Dimension();

    public void onConfigChanged() {
        configChanged = true;
    }

    private void calculateSizes(Graphics2D g) {
        configChanged = false;
        ticks.clear();

        for (int tick = 0, position = 0, row = 0; tick < config.numberOfTicks(); tick++)
        {

            int x = position * (config.sizeOfTickShapes() + config.tickPadding());
            int y = row * (config.sizeOfTickShapes() + config.tickPadding());

            position++;
            if(config.shouldShowText()) {
                FontMetrics fm = g.getFontMetrics();

                int textWidth = fm.stringWidth(String.valueOf(tick + 1));
                int textHeight = fm.getHeight();

                int fontX = x + (config.sizeOfTickShapes() / 2) - (textWidth / 2);
                int fontY = y + (config.sizeOfTickShapes() / 2) + (textHeight / 2);

                ticks.add(new Tick(x, y, fontX, fontY));
            } else {
                ticks.add(new Tick(x, y, 0, 0));
            }
            if(position > config.amountPerRow() - 1) {
                position = 0;
                row++;
            }
        }

        int rowsRendered = (int) Math.ceil((double) config.numberOfTicks() / (double) config.amountPerRow());
        dimension.height = (rowsRendered - 1) * config.tickPadding() + rowsRendered * config.sizeOfTickShapes();

        int ticksRenderedPerRow = config.amountPerRow() > config.numberOfTicks() ? config.numberOfTicks() : config.amountPerRow();
        dimension.width = (ticksRenderedPerRow - 1) * config.tickPadding() + ticksRenderedPerRow * config.sizeOfTickShapes();
    }

    @Inject
    public VisualTicksOverlay()
    {
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if(configChanged) {
            calculateSizes(graphics);
        }

        if(ticks.size() < config.numberOfTicks() - 1) return null;

        for (int i = 0; i < config.numberOfTicks(); i++)
        {
            Tick tick = ticks.get(i);
            if (i == plugin.tick)
            {
                graphics.setColor(config.currentTickColour());
            }
            else
            {
                graphics.setColor(config.tickColour());
            }
            graphics.fillOval(tick.getShapeX(), tick.getShapeY(), config.sizeOfTickShapes(), config.sizeOfTickShapes());
            if(config.shouldShowText()) {
                // set font size to match config
                graphics.setColor(config.textColour());
                graphics.drawString(String.valueOf(i + 1), tick.getFontX(), tick.getFontY());
            }
        }
        return dimension;
    }
}
