package TZ.G7.Animation;

import java.util.ArrayList;
import java.util.List;

import TZ.G7.Animation.I.GAni;

/**
 * 
 * @author Terra
 * @created 04.12.2014
 * 
 * @file AniTest.java
 * @project G7C
 * @identifier TZ.G7.Animation
 *
 */
public class AniTest {

	public List<GAni> animations = new ArrayList<GAni>();
	public boolean run = true;
	
	public void start() {
		Thread t = new Thread() {
			
			/* 
			 * @see java.lang.Thread#run()
			 */
			@Override
			public void run() {
				while (AniTest.this.run) {
					AniTest.this.animations.forEach((a) -> a.update());
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						System.out.println(e);
					}
				}
			}
			
		};
		t.start();
	}
	
	public void exit() {
		this.run = false;
	}
	
}
