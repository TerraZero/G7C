package TZ.G7;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import TZ.G7.Canvas.GCanvas;
import TZ.G7.Component.DefaultBackground;
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
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null);
		
		GCanvas c = new GCanvas();
		int layer = c.addLayer();
		c.getLayer(layer).background(new DefaultBackground(Color.RED));
		
		GComp g = new GComponent();
		g.bounds(50, 50, 50, 50);
		c.add(layer, g);
		
		c.setBounds(10, 10, 700, 400);
		frame.add(c);
		
		frame.setVisible(true);
		
		try {
			Thread.sleep(5000);
			JOptionPane.showMessageDialog(null, "Buffer on");
			c.getLayer(layer).setBuffer(true);
			c.repaint();
			Thread.sleep(5000);
			JOptionPane.showMessageDialog(null, "Color change");
			c.getLayer(layer).background(new DefaultBackground(Color.BLUE));
			g.background(new DefaultBackground(Color.ORANGE));
			c.repaint();
			Thread.sleep(5000);
			JOptionPane.showMessageDialog(null, "Color change");
			c.getLayer(layer).background(new DefaultBackground(Color.BLACK));
			g.background(new DefaultBackground(Color.CYAN));
			c.repaint();
			Thread.sleep(5000);
			JOptionPane.showMessageDialog(null, "refresh");
			c.getLayer(layer).refresh();
			c.repaint();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
