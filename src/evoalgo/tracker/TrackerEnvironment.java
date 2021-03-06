package evoalgo.tracker;

import evolalgo.problem.ctrnn.ITracker;

public class TrackerEnvironment {

	Tracker tracker;
	private VerticalFallingObject VFO;  //Only one falling object exists at any given moment.
	
	public TrackerEnvironment(ITracker it){
		tracker = new Tracker(it);		
	}

	boolean[] getShadowVector(){

		int[] trackerPos = tracker.getPosition();
		int[] fallingObjectPos = VFO.getPosition();
		boolean[] shadowVector = new boolean[tracker.getLength()];
		for (int i = 0; i < trackerPos.length; i++) {
			for (int j = 0; j < fallingObjectPos.length; j++) {
				if(trackerPos[i] == fallingObjectPos[j]) shadowVector[i] = true;
			}
		}
		return shadowVector;

	}

	private int awardPoints(){
		
		boolean[] sv = getShadowVector();

		if(VFO.getSize()>4){ //Item should be avoided
			for (boolean b : sv) {
				if(b) return 0; //If any part is on it, it has not avoided
			}
			return 1;
		}
		else{ //Tracker should catch it
			int c = 0;
			for (boolean b : sv) {
				if(b) c++;
			}

			return c == VFO.getSize() ? 1 : 0;

		}
	}

	public int run() {

		while(VFO.getYPosition()>0){
			tracker.updatePosition(getShadowVector());
			VFO.step();
		}

		return awardPoints();
	}

	Tracker getTracker(){
		return tracker;
	}

	void setTracker(ITracker it){
		tracker = new Tracker(it);
	}

	VerticalFallingObject getFallingObject(){
		return VFO;
	}

	void setFallingObject(VerticalFallingObject obj){
		this.VFO = obj;
	}	

}
