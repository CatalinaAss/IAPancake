package descartes.ia.deas.bpp;

public class Pancake {
	private int size;
	private boolean side;
	
	public Pancake(int size, boolean side) {
		this.size = size;
		this.side = side;	//true if the burnt side down
	}
	
	public Pancake(int size) {
		this.size = size;
		this.side = true;
	}
	
	/**
	 * Display the pancake : + for good side, - for bad side
	 */
	public void show() {
		char look;
		
		if(this.side == true)
			look = '+';
		else
			look = '-';
		
		for(int i=0; i<size; i++)
			System.out.print(look);
		
		System.out.print(size +"\n");
	}
	
	/**
	 * Flip the side of the pancake
	 */
	public void flip() {
		if(this.side == true)
			this.side = false;
		else
			this.side = true;
	}
	
	/**
	 * 
	 * @return true if the pancake is a bit bigger or a bit smaller (by one)
	 */
	public boolean inOrderSize(Pancake pancake) {
		//if(this.side)
		return false;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean getSide() {
		return side;
	}

	public void setSide(boolean side) {
		this.side = side;
	}
}
