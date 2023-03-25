package com.visualticks;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class VisualTicksPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(VisualTicksPlugin.class);
		RuneLite.main(args);
	}
}