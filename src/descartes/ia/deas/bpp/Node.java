package descartes.ia.deas.bpp;
import java.util.Vector;


public class Node {
	private Node parent;
	private Vector<Node> sibling;
	private Pan pan;
	private int cost;
	
	public Node(Pan pan, Node parent, Vector<Node> sibling) {
		this.parent = parent;
		this.sibling = sibling;
		this.cost = 0;
	}
	
	public Node(Pan pan) {
		this.pan = pan;
		this.parent = this;
		this.sibling = null;
		this.cost = 0;
	}
	
	public void show(Node n) {
		
		//show the node
		System.out.println(n.getCost());
		n.getPan().showForHuman();
		
		//execute function for the sibling
		if(n.getSibling() == null)
			return;
		else
			for(int i=0; i<n.getPan().getTop(); i++) {
				System.out.print("\t");
				this.show(n.getSibling().get(i));
		}
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Vector<Node> getSibling() {
		return sibling;
	}

	public void setSibling(Vector<Node> sibling) {
		this.sibling = sibling;
	}

	public Pan getPan() {
		return pan;
	}

	public void setPan(Pan pan) {
		this.pan = pan;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
