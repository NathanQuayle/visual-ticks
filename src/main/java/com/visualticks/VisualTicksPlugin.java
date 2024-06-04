package com.visualticks;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.OverlayManager;

import java.awt.*;

@Slf4j
@PluginDescriptor(
	name = "Visual Ticks"
)
public class VisualTicksPlugin extends Plugin
{
	@Inject
	private VisualTicksConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private VisualTicksOverlay overlay;
	public int tick = 0;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
		overlay.onConfigChanged();
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}


	@Subscribe
	private void onGameTick(GameTick gameTick) {
		tick++;
		if(tick > config.numberOfTicks() - 1) tick = 0;
	}

	@Subscribe
	private void onConfigChanged(ConfigChanged event) {
		if (!event.getGroup().equals(VisualTicksConfig.GROUP_NAME)) {
			return;
		}
		overlay.onConfigChanged();
	}

	@Provides
	VisualTicksConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(VisualTicksConfig.class);
	}
}
