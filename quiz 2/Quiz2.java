import java.util.Set;
import java.util.Stack;
import java.util.Collections;

public class Quiz2{
	/**
	 * Returns the index (0-based) of the first element of "orders"
	 * that only requests ingredients contained in "available".
	 * 
	 * @param available An array listing ingredients available in the sandwich bar.
	 * @param orders An array of orders, each a space-separated description of ingredients.
	 * 
	 * @return The first index of "orders" (0-based) that only describes ingredients present
	 *         in the "available" array.
	 */
	public static int sandwich(String[] available, String[] orders) {
        //new empty set
        Set<String> listOrder = new HashSet<String>();
        //need to add each element of available into this empty set 
        for(int i = 0; i<available.length; i++){
            listOrder.add(available[i]);
        }
        //need to split orders at each space and then for loop to see if the list of available contains each element of the order
        for(int i=0; i<orders.length; i++){
            //int n = 0;
            boolean works = true;
            String posOrder = orders[i];
            String[] splitOrders = posOrder.split(" ");
            for(int j = 0; j<splitOrders.length; j++){
                works &= listOrder.contains(splitOrders[j]); 
                if(works){
                    return i;
                }
                return -1;
            }
        }

	}

	/**
	 * Determine if the equation is balanced using (), [] and {}.
	 * 
	 * @param equation a String containing characters using (, ), [, ], {, and }.
	 * @return a boolean - true if the equation is balanced; false otherwise.
	 */
	public static boolean balanced(String equation){
		return false;
        //I know that I want to have a stack and as I go through this array 
        //list, equation, I want to push each opening bracket to the bottom 
        //of the Stack, and once I get to a closed bracket I want to check that
        //the last thing I pushed was an opening bracket of the same type. 
	}

	
	// For testing. Comment it back when you are done.

    // public static void main(String[] args) {
	// 	Quiz2 q = new Quiz2();
	// 	// ... test ...
	// }

}