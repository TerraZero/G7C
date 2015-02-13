package TZ.G7.Game.State;

import java.awt.Color;
import java.awt.Graphics;

import TZ.G7.Component.GButton;
import TZ.G7.Component.Mechnic.GCompAlt;
import TZ.G7.Handler.GInput;

/**
 * 
 * @author terrazero
 * @created Jan 12, 2015
 * 
 * @file GameState.java
 * @project G7C
 * @identifier TZ.G7.Game.State
 *
 */
public class GameState extends GState {
	
	public static final String NAME = "game";

	public GameState() {
		super(GameState.NAME);
	}

	// keine componenten umbauen zum direct rendern
	protected GCompAlt[] fields;
	protected int width;
	protected int field;
	protected int border;
	
	protected int gameborder;
	
	/* 
	 * @see TZ.G7.Game.State.GState#init()
	 */
	@Override
	protected void init() {
		super.init();
		this.width = 300;
		this.field = 200;
		this.border = 25;
		this.gameborder = 150;
		this.transparentEvent = false;
	}
	
	/* 
	 * @see TZ.G7.Game.State.GState#stateInit()
	 */
	@Override
	public void stateInit() {
		super.stateInit();
		fields = new GCompAlt[this.width * this.width];
		for (int i = 0; i < fields.length; i++) {
			int x = i % this.width;
			int y = i / this.width;
			this.fields[i] = new GButton();
			this.fields[i].setBounds(this.border + x * (this.border + this.field), this.border + y * (this.border + this.field), this.field, this.field).background(Color.CYAN).text(x + " - " + y);
		}
	}
	
	/* 
	 * @see TZ.G7.Game.State.GState#stateFinish(int)
	 */
	@Override
	public void stateFinish() {
		for (int i = 0; i < this.fields.length; i++) {
			this.add(this.fields[i]);
		}
	}
	
	float speed = 1;
	
	/* 
	 * @see TZ.G7.Game.State.GState#eventState(TZ.G7.Handler.GInput)
	 */
	@Override
	public void eventState(GInput input) {
		super.eventState(input);
		if (input.isPressed('e')) {
			System.exit(0);
		}
		boolean w = input.isPressed('w'); 
		boolean s = input.isPressed('s');
		boolean a = input.isPressed('a');
		boolean d = input.isPressed('d');
		
		if (w) {
			this.scrollY -= speed;
			if (this.scrollY < -this.gameborder) this.scrollY = -this.gameborder;
		}
		if (s) {
			this.scrollY += speed;
			if (this.scrollY > this.width * (this.field + this.border) - this.height() + this.gameborder) this.scrollY = this.width * (this.field + this.border) + this.gameborder - this.height();
		}
		if (a) {
			this.scrollX -= speed;
			if (this.scrollX < -this.gameborder) this.scrollX = -this.gameborder;
		}
		if (d) {
			this.scrollX += speed;
			if (this.scrollX > this.width * (this.field + this.border) + this.gameborder - this.width()) this.scrollX = this.width * (this.field + this.border) + this.gameborder - this.width();
		}
		
		if (w || s || a || d) {
			speed += 0.1;
			if (speed > 50) {
				speed = 49;
			}
		} else {
			speed = 1;
		}
	}
	
	public void renderContainer(Graphics g, int parentWidth, int parentHeight) {
		boolean line = false;
		for (int i = 0; i < fields.length; i++) {
			if (this.isRenderComponent(this.fields[i], parentWidth, parentHeight)) {
				line = true;
				fields[i].render(g.create(fields[i].x() - this.scrollX, fields[i].y() - this.scrollY, fields[i].width(), fields[i].height()), parentWidth, parentHeight);
				if (i % this.width == this.width - 1) line = false;
			} else if (line) {
				i = ((i / this.width) + 1) * this.width - 1;
				line = false;
			}
		}
	}
	
}
