package com.visualticks;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

import javax.inject.Inject;
import java.awt.*;

@Slf4j
public class VisualTicksOverlay extends Overlay
{
    @Inject
    VisualTicksPlugin plugin;

    @Inject
    VisualTicksConfig config;

    @Inject
    public VisualTicksOverlay()
    {
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        int row = 0;
        for (int tick = 0, position = 0; tick < config.numberOfTicks(); tick++)
        {
            int x = position * config.sizeOfTickShapes() + position * config.tickPadding();
            int y = row * config.sizeOfTickShapes() + row * config.tickPadding();
            graphics.setColor(plugin.tick == tick ? config.currentTickColour() : config.tickColour());

            graphics.fillOval(x, y, config.sizeOfTickShapes(), config.sizeOfTickShapes());

            position++;
            if(position > config.amountPerRow() - 1) {
                position = 0;
                row++;
            }
        }

        int rowsRendered = (int) Math.ceil((double) config.numberOfTicks() / (double) config.amountPerRow());
        int height = (rowsRendered - 1) * config.tickPadding() + rowsRendered * config.sizeOfTickShapes();

        int ticksRenderedPerRow = config.amountPerRow() > config.numberOfTicks() ? config.numberOfTicks() : config.amountPerRow();
        int width = (ticksRenderedPerRow - 1) * config.tickPadding() + ticksRenderedPerRow * config.sizeOfTickShapes();

        return new Dimension(width, height);
    }
}
