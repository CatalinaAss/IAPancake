package descartes.ia.deas.bpp;

import java.util.Vector;

public class AI {
	private Pan pan;
	private Node tree;
	private Vector<Integer> actions;
	
	public AI(Pan pan) {
		this.pan = pan;
		this.tree = new Node(pan);
		this.actions = new Vector<Integer>();
	}
	
	public void resolve() {
		
		for(int i=0; i<10000; i++) {
			
		}
	}

	public boolean idaStar(int depth) {
		if(depth==0)
			return this.pan.isCorrect();
		if(depth<this.getHeuristic())
			return false;
		
		return false;
	}
	
	/**
	 * @return how many hits we have to do minimum
	 */
	public int getHeuristic() {
		int hits = 0;
		
		for(int i=0; i<pan.getTop(); i++) {
			
		}
		
		return hits;
	}
	
	public void show() {
		this.tree.show(this.tree);
	}

	public Pan getPan() {
		return pan;
	}

	public void setPan(Pan pan) {
		this.pan = pan;
	}

	public Node getTree() {
		return tree;
	}

	public void setTree(Node tree) {
		this.tree = tree;
	}

	public Vector<Integer> getActions() {
		return actions;
	}

	public void setActions(Vector<Integer> actions) {
		this.actions = actions;
	}
}