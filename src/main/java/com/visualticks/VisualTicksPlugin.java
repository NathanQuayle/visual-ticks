package com.visualticks;

import com.google.inject.Provides;

import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.KeyListener;
import java.awt.event.KeyEvent;

@Slf4j
@PluginDescriptor(
        name = "Visual Ticks"
)
public class VisualTicksPlugin extends Plugin implements KeyListener {
    @Inject
    private VisualTicksConfig config;
    @Inject
    private OverlayManager overlayManager;
    @Inject
    private VisualTicksOverlayOne overlayOne;
    @Inject
    private VisualTicksOverlayTwo overlayTwo;
    @Inject
    private VisualTicksOverlayThree overlayThree;
    @Inject
    private KeyManager keyManager;
    public int tickOne = 0;
    public int tickTwo = 0;
    public int tickThree = 0;

    @Override
    protected void startUp() throws Exception {
        updateOverlays();
        keyManager.registerKeyListener(this);
    }

    @Override
    protected void shutDown() throws Exception {
        overlayManager.remove(overlayOne);
        overlayManager.remove(overlayTwo);
        overlayManager.remove(overlayThree);
        keyManager.unregisterKeyListener(this);
    }

    @Subscribe
    private void onGameTick(GameTick gameTick) {
        if (!config.isEnabledOne() && !config.isEnabledTwo() && !config.isEnabledThree()) {
            return;
        }

        if(config.isEnabledOne()) {
            tickOne++;
            if (tickOne > config.numberOfTicksOne() - 1) tickOne = 0;
        }

        if(config.isEnabledTwo()) {
            tickTwo++;
            if (tickTwo > config.numberOfTicksTwo() - 1) tickTwo = 0;
        }

        if(config.isEnabledThree()) {
            tickThree++;
            if (tickThree > config.numberOfTicksThree() - 1) tickThree = 0;
        }
    }

    @Subscribe
    private void onConfigChanged(ConfigChanged event) {
        if (!event.getGroup().equals(VisualTicksConfig.GROUP_NAME)) {
            return;
        }

        updateOverlays();
    }

    private void updateOverlays() {
        overlayManager.remove(overlayOne);
        overlayManager.remove(overlayTwo);
        overlayManager.remove(overlayThree);

        if (config.isEnabledOne()) {
            overlayManager.add(overlayOne);
        }
        if (config.isEnabledTwo()) {
            overlayManager.add(overlayTwo);
        }
        if (config.isEnabledThree()) {
            overlayManager.add(overlayThree);
        }

        overlayOne.onConfigChanged();
        overlayTwo.onConfigChanged();
        overlayThree.onConfigChanged();
    }

    @Provides
    VisualTicksConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(VisualTicksConfig.class);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No implementation needed
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (config.tickResetHotkey().matches(e)) {
            resetTicks();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // No implementation needed
    }

    private void resetTicks() {
        tickOne = 0;
        tickTwo = 0;
        tickThree = 0;
    }
}
