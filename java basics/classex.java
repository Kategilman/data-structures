public class classex {
    static double dnaCount(String sequence){
        double number = 0;
        for (int i=0; i<sequence.length(); i++){
            if(sequence.charAt(i)=='c' || sequence.charAt(i)=='g'){
                number++;
            }
        }
        return number / sequence.length();
    }
static int yahtzee(int[]toss){
    int max = 0;
    for(int i=0; i<toss.length; i++){
        int currentMax=0;
        for(int j=0; j<toss.length; j++){
            if(toss[j]==toss[i]){
                currentMax += toss[j];
            }
        }
if (currentMax> max){
    max=currentMax;
}
    }
    return max;

}
    public static void main(String[]args){
        System.out.println(dnaCount("atcgatcg"));
        int[] toss = {2,2,2,5,4};
        System.out.println(yahtzee(toss));
    }
    
}
