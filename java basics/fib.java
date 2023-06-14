public class fib {
    public static int helper(int a, int b){
        return (a+b);

    }
    public static void main(String[]args){
        int start= 1;
        int next = 1; 
        int current = helper (start,next);
        for (int i=0;i<12;i++){
            current = helper(start,next);
            System.out.println(current);
            start = next;
            next = current; 
        }
    }
}
