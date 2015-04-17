package descartes.ia.deas.bpp;
import java.util.Vector;


public class Pan implements Cloneable {
	private Vector<Pancake> stack;
	private int top;	//index of the top (#pancake - 1)
	
	public Pan(Vector<Pancake> stack) {
		this.stack = new Vector<Pancake>(stack);
		this.top = this.stack.size() - 1;
	}
	
	/**
	 * Create a Pan with stackSize pancakes in the good order
	 * @param stackSize
	 */
	public Pan(int stackSize) {
		this.stack = new Vector<Pancake>();
		
		for(int i=stackSize; i>0; i--)
			this.stack.add(new Pancake(i));
		
		this.top = this.stack.size() -1;
	}
	
	/**
	 * Return a clone of the curant object
	 */
	public Pan clone() {
		return new Pan(this.stack);
	}
	
	/**
	 * Flip the stack from the pancake n°index (excluded) to the top
	 * @throws PancakeException 
	 */
	public void flipAbove(int index) throws PancakeException {
		if(index < 0 || index > this.top)
			throw new PancakeException("Impossible to flip the pancakes stack from this index !");
		
		Pan cp = this.clone();
		
		//Removing pancakes above the index
		for(int i=this.top; i>=index; i--)
			this.stack.remove(i);
		
		//Stack top pancakes from the new stack (cp.stack) to the original stack (this.stack)
		for(int i=cp.top; i>=index; i--) {
			this.stack.add(cp.stack.get(i));
		}
		
		//Do not forget to flip the side of the pancake
		for(int i=cp.top; i>=index; i--) {
			this.stack.get(i).flip();
		}
	}
	
	/**
	 * @return true if the burnt pancakes problem is solved 
	 */
	public boolean isBunrtCorrect() {
		for(int i=this.top; i>=0; i--) {
			if(this.stack.get(i).getSize() != this.top-i+1) return false;	//sides comparison
			//System.out.println("DEBUG : "this.stack.get(i).getSize()+" "+(this.top-i+1));
			if(this.stack.get(i).getSide() == false) return false;			//sizes comparison
		}
		
		return true;
	}
	
	/**
	 * @return true if the pancakes problem is solved 
	 */
	public boolean isCorrect() {
		for(int i=this.top; i>=0; i--) {
			if(this.stack.get(i).getSize() != this.top-i+1) return false;	//sides comparison
			//System.out.println("DEBUG : "this.stack.get(i).getSize()+" "+(this.top-i+1));
		}
		
		return true;
	}
	
	/**
	 * Flip the stack from the pancake n°index (included) to the top
	 * @throws PancakeException 
	 */
	public void flip(int index) throws PancakeException {
		this.flipAbove(index - 1);
	}
	
	/**
	 * Flip randomly hits times the pancakes stack
	 * @param hits
	 */
	public void mix(int hits) {
		int randomFlipIndex;
		
		for(int i=0; i<hits; i++) {
			randomFlipIndex = (int)(Math.random() * (this.top+1)); // random between 0 and top included
			//System.out.println("DEBUG random flip index value: " + randomFlipIndex);
			try {
				this.flipAbove(randomFlipIndex);
			} catch (PancakeException e) { e.printStackTrace(); }
		}
	}
	
	/**
	 * Show the pan stack where the lowest pancake is on the top
	 */
	public void show() {
		for(int i=0; i<this.stack.size(); i++)
			stack.get(i).show();
	}
	
	/**
	 * Show the pan stack where the lowest pancake is on the bottom
	 */
	public void showForHuman() {
		for(int i=this.top; i>=0; i--) {
			System.out.print((i+1) +" ");
			stack.get(i).show();
		}
	}

	public Vector<Pancake> getStack() {
		return stack;
	}

	public void setStack(Vector<Pancake> stack) {
		this.stack = stack;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

}
