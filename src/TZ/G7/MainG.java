package TZ.G7;

import java.awt.Color;

import javax.swing.JFrame;

import TZ.G7.Animation.AniTest;
import TZ.G7.Animation.GAnimation;
import TZ.G7.Animation.I.GAni;
import TZ.G7.Canvas.GCanvas;
import TZ.G7.Component.GComponent;
import TZ.G7.Component.I.GComp;

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
		AniTest t = new AniTest();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null);
		
		GCanvas c = new GCanvas();
		int layer = c.addLayer();
		c.getLayer(layer).add((g, w, h) -> {
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, w, h);
		});
		
		GComp comp = new GComponent();
		comp.bounds(50, 50, 50, 50);
		comp.add((g, w, h) -> {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, w, h);
		});
		c.add(layer, comp);
		
		c.setBounds(10, 10, 700, 400);
		frame.add(c);
		
		frame.setVisible(true);
		c.createBuffer();
		
		t.animations.add(new GAnimation() {
			
			int status = 0;
			int speed = 5;
			
			/* 
			 * @see TZ.G7.Animation.GAnimation#update()
			 */
			@Override
			public GAni update() {
				switch (status) {
					case 0 :
						this.component.x(this.component.x() + speed);
						if (this.component.x() > 600) status++;
						break;
					case 1 : 
						this.component.y(this.component.y() + speed);
						if (this.component.y() > 400) status++;
						break;
					case 2 :
						this.component.x(this.component.x() - speed);
						if (this.component.x() < 100) status++;
						break;
					case 3 :
						this.component.y(this.component.y() - speed);
						if (this.component.y() < 100) status++;
						break;
				}
				c.render();
				status = status % 4;
				return super.update();
			}
			
		}.component(comp));
		
		t.start();
		try {
			Thread.sleep(50000);
			t.exit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
