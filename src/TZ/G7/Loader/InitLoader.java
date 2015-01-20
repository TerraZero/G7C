package TZ.G7.Loader;

import java.util.ArrayList;
import java.util.List;

import TZ.G7.GObj;
import TZ.G7.Exception.GException;
import TZ.G7.Loader.Jobs.InitJob;

/**
 * 
 * @author Terra
 * @created 15.01.2015
 * 
 * @file InitLoader.java
 * @project G7C
 * @identifier TZ.G7.Loader
 *
 */
public class InitLoader extends GObj implements Runnable {
	
	private static InitLoader singleton;
	
	public static InitLoader singleton() {
		if (InitLoader.singleton == null) {
			InitLoader.singleton = new InitLoader();
			InitLoader.singleton.start();
		}
		return InitLoader.singleton;
	}

	protected Thread thread;
	protected List<InitJob> jobs;
	protected Object sync;
	protected Object syncFinish;
	
	protected boolean finish;
	protected boolean hold;
	protected boolean run;
	
	/* 
	 * @see TZ.G7.GObj#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.thread = new Thread(this);
		this.jobs = new ArrayList<InitJob>();
		this.sync = new Object();
		this.syncFinish = new Object();
	}
	
	public void start() {
		this.run = true;
		this.thread.start();
	}
	
	public void stop() {
		this.run = false;
	}
	
	/* 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		do {
			try {
				if (this.jobs.size() == 0) {
					synchronized (this.sync) {
						this.hold = true;
						this.sync.wait();
					}
				}
				InitJob job = this.getNextJob();
				job.init();
				synchronized (this.syncFinish) {
					this.finish = true;
					this.syncFinish.wait();
					job.finished();
				}
			} catch (InterruptedException e) {
				throw new GException(e, "Synchronized error in InitLoader!", "Synchronized error in InitLoader!");
			}
		} while (this.run);
	}
	
	public void addJob(InitJob job) {
		synchronized (this.sync) {
			this.jobs.add(job);
			if (this.hold) {
				this.hold = false;
				this.sync.notifyAll();
			}
		}
	}
	
	protected InitJob getNextJob() {
		synchronized (this.sync) {
			InitJob job = this.jobs.get(0);
			this.jobs.remove(0);
			return job;
		}
	}
	
	public void jobFinish() {
		synchronized (this.syncFinish) {
			if (this.finish) {
				this.finish = false;
				this.syncFinish.notifyAll();
			}
		}
	}
	
	
}
