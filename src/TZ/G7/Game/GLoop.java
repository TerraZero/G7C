package TZ.G7.Game;

import TZ.G7.Handler.GHandler;
import TZ.G7.Loader.InitLoader;

/**
 * 
 * @author Terra
 * @created 10.12.2014
 * 
 * @file GLoop.java
 * @project G7C
 * @identifier TZ.G7
 *
 */
public class GLoop {
	
	private static GLoop singleton;
	
	protected float deltaTime;
	
	protected boolean stop;
	
	public static GLoop singleton() {
		if (GLoop.singleton == null) {
			GLoop.singleton = new GLoop();
		}
		return GLoop.singleton;
	}
	
	public GLoop() {
		this.deltaTime = 1000f / 60f;
	}
	
	public void start() {
		this.loop();
		this.exit();
	}
	
	public void exit() {
		
	}

	public void loop() {
		long nextTime = 0;
		long frameTime = 0;
		long current = System.currentTimeMillis();
		float delta = 0;
		
		while (!this.stop) {
			nextTime = System.currentTimeMillis();
			frameTime = nextTime - current;
			current = nextTime;
			
			while (frameTime > 0) {
				delta = (frameTime > this.deltaTime ? this.deltaTime : frameTime);
				this.update(delta);
				frameTime -= delta;
			}
			this.render();
		}
	}
	
	public void stop() {
		this.stop = true;
	}
	
	public void update(float delta) {
		InitLoader.singleton().jobFinish();
		GStates.singleton().event(GHandler.singleton().getInput());
		GStates.singleton().update(delta);
	}
	
	public void render() {
		GStates.singleton().render();
	}
	
}
