package TZ.G7.Loader;

import TZ.G7.GObj;

/**
 * 
 * @author terrazero
 * @created Dec 19, 2014
 * 
 * @file GLoader.java
 * @project G7C
 * @identifier TZ.G7.Loader
 *
 */
public class GLoader extends GObj implements Runnable {
	
	protected Thread thread;
	protected boolean load;
	protected boolean startloading;
	
	/* 
	 * @see TZ.G7.GObj#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.thread = new Thread(this);
	}

	/* 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		this.loading();
		this.load = false;
	}
	
	protected void loading() {
		
	}

	public boolean load() {
		if (!this.startloading) {
			this.thread.start();
			this.startloading = true;
			this.load = true;
		}
		return this.load;
	}
	
	public boolean isLoad() {
		return this.load;
	}
	
	public boolean isLoaded() {
		return this.startloading;
	}
	
}
