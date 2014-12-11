package TZ.G7.Game;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import TZ.G7.Canvas.GCanvas;

/**
 * 
 * @author Terra
 * @created 10.12.2014
 * 
 * @file GFrame.java
 * @project G7C
 * @identifier TZ.G7.Game
 *
 */
public class GFrame {

	private static GFrame singleton;
	
	protected JFrame frame;
	protected JPanel cp;
	
	public static GFrame singleton() {
		if (GFrame.singleton == null) {
			GFrame.singleton = new GFrame();
		}
		return GFrame.singleton;
	}
	
	public GFrame() {
		this.init();
	}
	
	protected void init() {
		this.frame = new JFrame();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(800, 600);
		this.frame.setLocationRelativeTo(null);
		
		this.cp = new JPanel();
		this.cp.setLayout(null);
		this.frame.setContentPane(this.cp);
		
		this.frame.add(GCanvas.singleton());
		
		this.frame.addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				GCanvas.singleton().setBounds(0, 0, GFrame.this.cp.getWidth(), GFrame.this.cp.getHeight());
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
			}
			
		});
	}
	
	public void start() {
		GFrame.this.frame.setVisible(true);
		GCanvas.singleton().createBuffer();
	}
	
}
