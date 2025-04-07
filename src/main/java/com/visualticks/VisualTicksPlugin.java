package com.visualticks;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.ProfileChanged;
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
    @Inject
    private ConfigManager configManager;
    public int tickOne = 0;
    public int tickTwo = 0;
    public int tickThree = 0;

    @Override
    protected void startUp() throws Exception {
        updateOverlays();
        keyManager.registerKeyListener(this);
        migrate();
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
            tickOne = (tickOne + 1) % config.numberOfTicksOne();
        }

        if(config.isEnabledTwo()) {
            tickTwo = (tickTwo + 1) % config.numberOfTicksTwo();
        }

        if(config.isEnabledThree()) {
            tickThree = (tickThree + 1) % config.numberOfTicksThree();
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

    @Subscribe
    public void onProfileChanged(ProfileChanged profileChanged) {
        migrate();
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

    private void migrate() {
        String[][] migrationMap = {
                {"paddingBetweenTicksOne", "horizontalSpacingOne,verticalSpacingOne"},
                {"tickPaddingTwo", "horizontalSpacingTwo,verticalSpacingTwo"},
                {"tickPaddingThree", "horizontalSpacingThree,verticalSpacingThree"}
        };

        for (String[] migration : migrationMap) {
            String oldKey = migration[0];
            String[] newKeys = migration[1].split(",");

            for (String newKey : newKeys) {
                if (configManager.getConfiguration(VisualTicksConfig.GROUP_NAME, oldKey) != null) {
                    String value = configManager.getConfiguration(VisualTicksConfig.GROUP_NAME, oldKey);
                    configManager.setConfiguration(VisualTicksConfig.GROUP_NAME, newKey, value);
                }
            }

            configManager.unsetConfiguration(VisualTicksConfig.GROUP_NAME, oldKey);
        }
    }

    private void resetTicks() {
        tickOne = 0;
        tickTwo = 0;
        tickThree = 0;
    }
}
