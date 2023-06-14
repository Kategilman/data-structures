import java.util.*;

public class Graph {
	public Graph() {
        //key is vertex, value is edges 
        //create map here 
        //all nodes are integers 
        Map<Integer, ArrayList<Integer>> vertexEdge = new Map<Integer, ArrayList<Integer>>;
	}

	/**
	 * Add a vertex to the graph.
	 * 
	 * @param id Id of the vertex.
	 * 
	 * @return True if and only if the vertex with this ID was
	 *         not present in the graph before.
	 */
	public boolean addVertex(int id) {
        if(vertexEdge.containsKey(id)){
            vertexEdge.put(id);
            return true;
        }
		return false;
	}

	/**
	 * Adds an edge to the graph.
	 * 
	 * @param source Id of the source vertex.
	 * @param target Id of the target vertex.
	 * 
	 * @return Returns true if and only if both source and target
	 *         vertices exist in the graph, and an edge linking
	 *         source -> target did not exist before.
	 */
	public boolean addEdge(int source, int target) {
        if(vertexEdge.containsKey(source) && vertexEdge.containsKey(target)){
            
        }
		return false;
	}

	/**
	 * Returns true if the vertex is present in the graph.
	 * 
	 * @param vertexId ID of the vertex being checked.
	 * 
	 * @return True if the vertex with the provided ID is in the graph.
	 */
	public boolean hasVertex(int vertexId) {
		return false;
	}

	/**
	 * Returns the in-degree of the provided vertex,
	 * or -1 if the provided vertex does not exist.
	 * 
	 * @param vertexId ID of the vertex being checked for in-degree.
	 * 
	 * @return In-degree of the vertex with the provided ID, or -1
	 *         if a non-existent vertex has been provided.
	 */
	public int inDegree(int vertexId) {
		return -1;
	}

	/**
	 * Returns the out-degree of the provided vertex,
	 * or -1 if the provided vertex does not exist.
	 * 
	 * @param vertexId ID of the vertex being checked for out-degree.
	 * 
	 * @return Out-degree of the vertex with the provided ID, or -1
	 *         if a non-existent vertex has been provided.
	 */
	public int outDegree(int vertexId) {
		return -1;
	}

	public static void main(String[] args) {
		Graph graph = new Graph();

		// Makes a cycle

		System.out.println("Adding 1: " + graph.addVertex(1));
		System.out.println("Adding 2: " + graph.addVertex(2));
		System.out.println("Adding 3: " + graph.addVertex(3));
		System.out.println("Adding 4: " + graph.addVertex(4));

		System.out.println("Adding 1 (vertex already present): " + graph.addEdge(1, 7));

		System.out.println("Adding 1->2: " + graph.addEdge(1, 2));
		System.out.println("Adding 2->3: " + graph.addEdge(2, 3));
		System.out.println("Adding 3->4: " + graph.addEdge(3, 4));
		System.out.println("Adding 4->1: " + graph.addEdge(4, 1));

		System.out.println("Adding 1->7 (inexistent vertex): " + graph.addEdge(1, 7));

		System.out.println("In-degree of 2: " + graph.inDegree(2));
		System.out.println("Out-degree of 2: " + graph.outDegree(2));

		System.out.println("Out-degree of 7 (inexistent vertex): " + graph.outDegree(7));
	}
}