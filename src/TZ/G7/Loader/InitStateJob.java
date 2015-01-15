package TZ.G7.Loader;

import TZ.G7.Game.State.GState;
import TZ.G7.Game.State.GState.GStateStates;

/**
 * 
 * @author Terra
 * @created 15.01.2015
 * 
 * @file InitStateJob.java
 * @project G7C
 * @identifier TZ.G7.Loader
 *
 */
public class InitStateJob implements InitJob {
	
	protected GState state;
	
	public InitStateJob(GState state) {
		this.state = state;
	}

	/* 
	 * @see TZ.G7.Loader.InitJob#init()
	 */
	@Override
	public void init() {
		state.stateState(GStateStates.INIT);
		state.stateInit();
	}

	/* 
	 * @see TZ.G7.Loader.InitJob#finished()
	 */
	@Override
	public void finished() {
		state.stateState(GStateStates.NORMAL);
	}

}
