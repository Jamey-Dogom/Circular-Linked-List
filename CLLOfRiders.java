/**
 * 
 * @author Jamey Dogom
 * purpose: implement a cicular linked list
 */

public class CLLOfRiders {
	private Node tail;
	
	public CLLOfRiders() {
		tail = null;
	}
	
	public void addRider(Rider rider) {
		if (tail == null) {
			tail = new Node(rider, null);
			tail.next = tail;
			return;
		} 
		Node n = new Node(rider, null);
		if (rider.speedPassStatus == 'N') {
			n.next = tail.next;
			tail.next = n;
			tail = n;
		} else {
			n.next = tail.next;
			tail.next = n;
		}
	}
	
	public void processRiders(int number) {
		for (int i=0; i<number; i++) {
			Node n = removeRider();
		}
	}
	
	public Node removeRider() {
		if (tail == null)
			return null;
		if (tail.next == tail) {
			Node n = new Node(tail);
			tail = null;
			return n;
		}
		Node n = new Node(tail.next);
		tail.next = tail.next.next;
		return n;
	}
	
	
	public void showWaiting() {
		Node start = tail.next;
		Node n = start;
		while (n.next != start) {
			System.out.println(n.rider.name);
			n = n.next;
		} 
		System.out.println(n.rider.name);
	}
	
	public String listString() {
		String s = new String();
		Node start = tail.next;
		Node n = start;
		while (n.next != start) {
			s += n.rider.name + " - " + n.rider.speedPassStatus + "\n";
			n = n.next;
		} 
		s += n.rider.name + " - " + n.rider.speedPassStatus + "\n";
		return s;
	}
}
