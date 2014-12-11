package TZ.G7;

import java.awt.Color;
import java.awt.Graphics;

import TZ.G7.Actions.GKeyAction;
import TZ.G7.Animation.SizeAnimation;
import TZ.G7.Component.GComponent;
import TZ.G7.Config.GConfig;
import TZ.G7.Exception.GException;
import TZ.G7.Game.GFrame;
import TZ.G7.Game.GLoop;
import TZ.G7.Game.State.MenuState;

/**
 * 
 * @author TerraZero
 * @created 02.12.2014
 * 
 * @file MainG.java
 * @project V7S
 * @identifier TZ.G7.MainG
 *
 */
public class MainG {

	public static void main(String[] args) {
		try {
			MainG.start();
		} catch (GException e) {
			System.out.println(e);
		}
	}
	
	public static void start() {
		GConfig.singleton().initSettings();
		GFrame.singleton().start();
		
		GComponent g = new GComponent() {
			
			/* 
			 * @see TZ.G7.Component.GComponent#render(java.awt.Graphics)
			 */
			@Override
			public void render(Graphics g) {
				super.render(g);
				g.setColor(Color.RED);
				g.fillRect(0, 0, this.width, this.height);
			}
			
		};
		g.bounds(20, 20, 50, 50);
		MenuState.singleton().add(g);
		
		MenuState.singleton().addAction(new GKeyAction("s+d", (d) -> {
			new SizeAnimation(MenuState.singleton(), g, 150, 200, 200);
		}));
		
		GLoop.singleton().start();
	}
	
}
