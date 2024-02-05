package com.visualticks;

import com.google.inject.Provides;
import javax.inject.Inject;

import com.visualticks.utils.ResetUtils;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Skill;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.StatChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

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
	private boolean isReset = false;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onStatChanged(StatChanged statChanged)
	{
		if (statChanged.getSkill() == config.getResetSkill())
		{
			if (config.isResetCounter()) {
				isReset = true;
			}
		}
	}

	@Subscribe
	private void onGameTick(GameTick gameTick) {
		if (isReset) {
			tick = ResetUtils.calculateOffset(config.getOffset(), config.numberOfTicks());
			isReset = false;
		} else {
			tick++;
		}
		if(tick > config.numberOfTicks() - 1) tick = 0;
	}

	@Provides
	VisualTicksConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(VisualTicksConfig.class);
	}
}
