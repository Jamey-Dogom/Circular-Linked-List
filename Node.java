/**
 * 
 * @author student
 * purpose: node of a CLL
 */

public class Node {
	Rider rider;
	Node next;
	
	public Node(Rider rider, Node next) {
		this.rider = rider;
		this.next = next;
	}
	
	public Node(Node n) {
		this.rider = n.rider;
		this.next = n.next;
	}
}
