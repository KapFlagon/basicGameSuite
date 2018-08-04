package com.jpgd.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jpgd.game.BasicGameSuite;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = BasicGameSuite.WIDTH;
		config.height = BasicGameSuite.HEIGHT;
		config.title = BasicGameSuite.TITLE;
		new LwjglApplication(new BasicGameSuite(), config);
	}
}
