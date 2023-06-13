import java.util.*;
import java.lang.String;

/** Program that finds a short circuit (a list of integers forming a cycle) if one exists.
 * 
 * @author Kate Gilman
 */
public class Circuit {
	/**
	 * Returns a short circuit or an empty list if no short circuit exists.
	 * 
	 * @param graph An array of strings, where the string at index i is a
	 *              whitespace-separated list of integers.
	 * 
	 * @return A list containing the nodes forming short circuit, or an empty list
	 *         if no short circuit exists.
	 */
	public int[][] a;
	public ArrayList<String> findShortCircuit(String[] graph) {
		ArrayList<int[]> tempArray = new ArrayList<int[]>();
		for(String s : graph) {
			String[] stringArray = s.split(" ");
			if(stringArray[0] != "") {
				int[] ints = new int[stringArray.length];
				for(int i = 0; i < stringArray.length; i++) {
					try {
						ints[i] = Integer.parseInt(stringArray[i]);
					}
					catch(Exception e) {}
				}
				tempArray.add(ints);
			}
			tempArray.add(new int[0]);
		}
		int[][] a = new int[graph.length][];
		for(int w = 0; w < a.length; w++) {
			a[w] = tempArray.get(w);
		}
		//String [] splitGraph = new String[graph.length];
		// for(int j=0; j<graph.length; j++){
		// 		String[] splitGraph = graph[j].split(" ");
		// 		if(splitGraph.length>0){
		// 			for(int k=0; k<splitGraph.length; k++){
		// 				a[j][k] = Integer.parseInt(splitGraph[k]);
		// 			}
		// 		}
		// }
		// System.out.println(a.length);
		// for(int[] row : a) {
		// 	String rowString = "";
		// 	for(int i : row) {
		// 		rowString += String.valueOf(i) + ", ";
		// 	}
		// 	// System.out.println(rowString);
		// }
		for(int i = 0; i<a.length; i++){
			ArrayList<Integer> r = new ArrayList<Integer>();
			r.add(i);
			ArrayList<Integer> circuit = new ArrayList<Integer>();
			circuit = recMethod(i,i, r, 0, new ArrayList<ArrayList<Integer>>());
			ArrayList<String> circuitString = new ArrayList<String>();
			for(int k : circuit){
				circuitString.add(String.valueOf(k));
			}
			if(!circuit.isEmpty()){
				return circuitString;
			}
		}
		return new ArrayList<String>(); 
	}
	private ArrayList<Integer> recMethod(int i, int cur, ArrayList<Integer> circuit, int count, ArrayList<ArrayList<Integer>> possCircuits){
		count++;
		if(a[cur].length>0){
			for(int k=0; k<a[cur].length;k++){
				int curNeighbor = a[cur][k];
				if(curNeighbor == i){
					return circuit;
				}
				else if(count==a.length){
					return new ArrayList<Integer>();
				}
			}
			for(int j=0; j<a[cur].length;j++){
				circuit.add(a[cur][j]);
				possCircuits.add(recMethod(i,a[cur][j],circuit,count+1,possCircuits));
			}
		}
		if(count==1){
			for(ArrayList<Integer> array : possCircuits){
				if(!array.isEmpty()){
					return circuit;
				}
			}
		}
		return new ArrayList<Integer>();
	}
	/** Main tester method */
	public static void main(String[] args) {
		String[] circuit1 = {"1", "3 2", "", ""};
		String[] circuit2 = {"1", "3", "1 4", "", "", "1 3", ""};
		String[] circuit3 = {"1", "2", "0"};
		String[] circuit4 = {"1", "2", "3", "7", "1", "1 2", "3 7", "8", ""};
		String[] circuit5 = {"1", "2", "3", "7", "1", "1 2", "3 7", "8", "5"};

		Circuit circuit = new Circuit();

		System.out.println(circuit.findShortCircuit(circuit1)); // []
		// System.out.println(circuit.findShortCircuit(circuit2)); // []
		// System.out.println(circuit.findShortCircuit(circuit3)); // [0, 1, 2, 0] or [1, 2, 0, 1] etc
		// System.out.println(circuit.findShortCircuit(circuit4)); // []
		// System.out.println(circuit.findShortCircuit(circuit5)); // [1, 2, 3, 7, 8, 5, 1]
	}
}
