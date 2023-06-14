import java.util.*;
/**
 * This file contains five different exercises to practice
 * coding algorithms that involve recursion and
 * differentiate between solving algorithms
 * with recursion and with iteration.
 * 
 * @author Kate Gilman
 * @author Jaelyn Taylor
 */
public class Recursion {
    /**
     * Purpose - Recursively implements the McCarthy 91
     * algorithm on a given integer
     * @param n - the given integer
     * @return - the solution to the McCarthy 91 probelm
     * with the given integer
     */
    public static int mcCarthy91(int n) {
        if (n > 100)
           return n - 10;
        return mcCarthy91(mcCarthy91(n+11));
     }
     
    /**
     * Purpose - converts a decimal number into a 
     * binary number by using recursion.
     * @param num - the given, non-negative integer
     * @return binary - the binary version of the 
     * integer, as a string
     */
    public static String toBinary(int num){
        String binary = "";
        if (num == 0){
            return "0";
        }
        else{
           binary = toBinary(num/2);
           binary += (num%2); 
        }
        return binary;
    }

     /**
     * Purpose - A recursive algorithm that when given a
     * a specified number of stairs, calculates the number
     * of ways to climb using a combination of small strides
     * that go up by 1 step and large strides that go up
     * by 2 steps.
     * @param numStairs
     * @return - A recursive call of countWays that returns
     * the number of different ways a given number of stairs
     * can be climbed
     */
    public static int countWays(int numStairs){
        if(numStairs == 1){
            return numStairs;
        }
        if(numStairs==2){
            return numStairs;
        }
        else{
            return countWays(numStairs-1)+countWays(numStairs-2);
        }
    }
    
    /**
     * Purpose - A recursive algorithm that checks to see if
     * the puzzle is solvable. For
     * an integer value at a given position, the user can either move
     * to the right that number of spaces or to the left. The goal
     * is to reach the value 0 at the end of the array.
     * @param puzzle - an integer Array representing the puzzle board
     * @return true if puzzle is solvable and false if it is not
     */
    public static boolean solvable2(int [] puzzle, int i){
        if(i>=puzzle.length || i<0){
           return false;
       }
       if(i==puzzle.length-1){
           return true;
       }
       if(puzzle[i] < 0){
           return false;
       }
        if(puzzle[i]>0){
            puzzle[i]*=(-1);
        }
        boolean newPosLeft = solvable2(puzzle,i-puzzle[i]);
        boolean newPosRight = solvable2(puzzle,i+puzzle[i]);
        if(puzzle[i]<0){
            puzzle[i]*=(-1);
        }
        return newPosRight || newPosLeft;
    }
    public static boolean solvable(int[] puzzle){
        return solvable2(puzzle,0);
    }

    /**
     * Purpose - An iterative version of the above algorithm, that
     * checks to see if a given input of numbers can be solved. For
     * an integer value at a given position, the user can either move
     * to the right that number of spaces or to the left. The goal
     * is to reach the value 0 at the end of the array.
     * @param puzzle2 - an integer array representing the puzzle board.
     * @return boolean - Returns true if the puzzle is solvable, 
     * else false.
     */
    public static boolean iterativeSolvable(int[] puzzle2){
        Stack<Integer> puzzleStack = new Stack<Integer>();
        char [] visitedPositions = new char [puzzle2.length];
        for (int i = 0; i < puzzle2.length; i++){
            visitedPositions[i] = ' ';
        }
        puzzleStack.push(0);
        
        while (!puzzleStack.isEmpty()){
            int topValue = puzzleStack.peek();
            // int newPosLeft =  topValue - puzzle2[topValue];
            // int newPosRight = topValue + puzzle2[topValue];
            if(topValue == puzzle2.length - 1){
                return true;
            }
            if (topValue > puzzle2.length-1 || topValue < 0){
                return false;
            }
             if(visitedPositions[topValue] == ' '){
                int newPosLeft =  topValue - puzzle2[topValue];
                int newPosRight = topValue + puzzle2[topValue];
                if(newPosRight >= 0 && newPosRight < puzzle2.length && 
                visitedPositions[newPosRight] == ' '){
                    puzzleStack.push(newPosRight);
                    visitedPositions[topValue] = 'r';
                }
                else if(newPosLeft >= 0 && newPosLeft < puzzle2.length && 
                visitedPositions[newPosLeft] == ' '){
                    
                    puzzleStack.push(newPosLeft);
                    visitedPositions[topValue] = 'l';
                }
                else{
                    puzzleStack.pop();
                }
            }
            else if(visitedPositions[topValue] == 'l'){
                int newPosRight = topValue + puzzle2[topValue];
                visitedPositions[topValue] = 'r';
                if(newPosRight >= 0 && newPosRight < puzzle2.length){
                    puzzleStack.push(newPosRight);
                }
            }
            else{
                puzzleStack.pop();
                visitedPositions[topValue] = ' ';
            }
        }
        return false;
    }
    public static void main(String args[]){
        System.out.println(countWays(4));
        int [] list = {3,6,4,1,3,4,2,5,3,0};
        int [] list2 = {3,1,2,3,0};
        System.out.println(solvable(list));
        System.out.println(iterativeSolvable(list));
        System.out.println(iterativeSolvable(list2));
    }
}