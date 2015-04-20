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
	
	public boolean resolve(int depth) {
		boolean result;
		
		for(int i=0; i<=depth; i++) {
			result = idaStar(i, this.pan);
			//System.out.println("DEBUG resolve: Depth="+i);
			//System.out.println("DEBUG resolve: result="+result);
			
			if(result == true) {
				System.out.println("STOP");
				return result;				
			}
			
			this.actions.removeAllElements();	//delete actions
		}
		
		return false;
	}

	public boolean idaStar(int depth, Pan pan) {
		System.out.println("DEBUG idaStar: Depth="+depth+" Heuristic="+pan.getHeuristic());
		int d = depth; 
		
		if(depth==0)
			return pan.isCorrect();
		if(depth<pan.getHeuristic())	// comment !
			return false;
		
		for(int i=0; i<pan.getStack().size(); i++) {
			Pan pan2 = pan.clone();
			
			System.out.println("DEBUG Flip:"+i);
			try { pan2.flip(i); } catch (PancakeException e) { e.printStackTrace(); }
			actions.add(i);
			
			//pan2.showForHuman(depth-d);
			
			boolean result = this.idaStar(depth-1, pan2);
			
			if(result == true) {
				System.out.println("DEBUG idaSar: FOUND !");
				return true;
			}
		}
		
		System.out.println("DEBUG idaSar: false !");
		return false;
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
