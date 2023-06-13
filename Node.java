/**
 *  The node of a linked list of integers.
 * 
 * @author You!!!
 */
public class Node {
	// Data
	public int value;

	// Reference to the next node
	public Node next;

	/**
	 *  Constructs a new node with the specified value.
	 * The next pointer is set to null.
	 * 
	 * @param value the data to store in this node.
	 */
	public Node(int value) {
		this.value = value;
		this.next = null;
	}
	
	/**
	 * Returns a string representation of the node.
	 */
	public String toString() {
		return "" + value;
	}
}