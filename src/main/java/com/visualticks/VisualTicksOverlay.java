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
        setResizable(true);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        Dimension preferredSize = getPreferredSize();

        if (preferredSize == null)
        {
            preferredSize = new Dimension(config.numberOfTicks() * 32, 32);
        }
        int circleWidth = (preferredSize.width - config.tickPadding() * (config.numberOfTicks() - 1)) / config.numberOfTicks();
        int circleHeight = config.maintainAspectRatio() ? circleWidth : preferredSize.height;

        for (int i = 0; i < config.numberOfTicks(); i++)
        {
            graphics.setColor(plugin.tick == i ? config.currentTickColour() : config.tickColour());

            graphics.fillOval(i * circleWidth + i * config.tickPadding(), 0, circleWidth, circleHeight);
        }

        return config.maintainAspectRatio() ? new Dimension(preferredSize.width, circleHeight) : preferredSize;
    }
}
