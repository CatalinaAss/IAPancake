package descartes.ia.deas.bpp;

import java.util.Vector;

public class AI {
	private Pan pan;
	private Vector<Integer> actions;
	private int hits = 0;
	
	public AI(Pan pan) {
		this.pan = pan;
		this.actions = new Vector<Integer>();
	}
	
	public boolean resolve(int depth) {
		boolean result;
		
		for(int i=0; i<=depth; i++) {
			result = idaStar(i, this.pan, 0);
			
			if(result == true) {
				System.out.println("\n!!! STOP !!!");
				return result;				
			}
		}
		
		return false;
	}

	public boolean idaStar(int depth, Pan pan, int rec) {
		hits++;
		
		if(depth==0)
			return pan.isCorrect();
		if(depth<pan.getHeuristic()) {	// comment !
			System.out.println("---DEBUG IDASTAR--- Depth < Heuristic");
			return false;
		}
		
		for(int i=0; i<pan.getStack().size(); i++) {
			Pan pan2 = pan.clone();
			
			System.out.println("---DEBUG IDASTAR--- Depth:"+ depth +" Heuristic:"+ pan.getHeuristic() +" Flip:"+ i +" Hits:"+ hits +" Rec :"+ rec);
			try { pan2.flip(i); } catch (PancakeException e) { e.printStackTrace(); }
			
			pan2.show();
			
			boolean result = this.idaStar(depth-1, pan2, rec+1);
			
			if(result == true) {
				actions.add(i);
				return true;
			}
		}
		
		System.out.println("\n---DEBUG IDASTAR--- The algorithm didn't not found at this level("+depth+"), let's try deeper !\n");
		return false;
	}
	
	/**
	 * Show 
	 */
	public void redevelop() {
		pan.show();
		
		for(int i=this.actions.size()-1; i>=0; i--) {
			try { pan.flip(this.actions.get(i)); } catch (PancakeException e) { e.printStackTrace(); }
			pan.show();
		}
		
	}

	public Pan getPan() {
		return pan;
	}

	public void setPan(Pan pan) {
		this.pan = pan;
	}

	public Vector<Integer> getActions() {
		return actions;
	}

	public void setActions(Vector<Integer> actions) {
		this.actions = actions;
	}
}
