import java.util.*;

/** Program that draws a representation of a tree.
 * 
 * @author Kate Gilman
 */
public class DrawTree {
	/**
	 *  Builds an ASCII art representation of a tree.
	 *
	 * @param parents An integer array where element i gives the index of the parent of node i (indexed from 0),
	 *                and -1 marks the root.
	 * @param names A string array where element i of names corresponds to the name of node i.
	 * 
	 * @return A string representation of the tree as specified in the problem statement.
	 */
	private int curIndex = 0;
	public String[] draw(int[] parents, String[] names) {
		String[] output = new String[names.length];
		for(int i=0; i<parents.length; i++){
			if(parents[i]==-1){
				output[0] = "+=" + names[i];
				curIndex++;
				displayTree(output);
				parentCheck(parents, output, i, 1, names);
			}
		}
		return output;
	}
	private String[] parentCheck(int[] parents, String[] output, int parent, int depth, String[] names){
		for(int i=0; i<parents.length; i++){
			if(parents[i]==parent){
				String s = "";
				for(int k=0; k<depth; k++){
					s += "  ";
				}
				s = s + "+-" + names[i];
				output[curIndex] = s;
				curIndex++;
				displayTree(output);
				output = parentCheck(parents, output, i, depth + 1, names);
			}
		}
		return output;
	}

	private void displayTree(String[] output) {
		for(String s : output) {
			if(s != null) {
				System.out.println(s);
			}
		}
		System.out.println();
	}
	public static void main(String[] args){
		DrawTree dt = new DrawTree();
		int[] parents = {1, 2, 3, 4, 6, 6, -1}; //{-1,0,1,1,0,0,5,5};
		String[] names = {"A", "B", "C", "D", "E", "F", "G" }; //{"Root","SubB","LEAF1","LEAF2","LEAF3","SubA","LEAF4","LEAF5"};
		String[] answer = dt.draw(parents, names);
		for(String s : answer){
			System.out.println(s);
		}
	}
}
