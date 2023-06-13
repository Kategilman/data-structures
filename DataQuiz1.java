import static java.lang.Math.min;
import static java.lang.Math.ceil;
//original class for quiz
public class DataQuiz1{
    //first method for finding how many letters are in common between two strings 
    public static int lettersInCommon(String string1, String string2){

        //making sure all strings are lowercase in order to use ascii values
        string1 = string1.toLowerCase();
        string2 = string2.toLowerCase();
        //setting up these variables of commonletters1 and 2, the two lists of the 26 values of whether there are any in common or not
        int[] commonletters1 = new int[26];
        int[] commonletters2 = new int[26];
        //first for loop going through 1st string letters
        for(int i=0; i<commonletters1.length; i++){
             commonletters1[i] = 0;
        }
        //second for loop going through second string letters
        for(int j=0; j<commonletters2.length; j++){
            commonletters2[j] = 0;
        }
        //third loop, making each letter assigned to an ascii value and subtracting 97 since that is a's ascii value
        for(int k=0; k<string1.length(); k++){
            char c = string1.charAt(k);
            int ascii = (int) c;
            commonletters1[ascii - 97]+=1;
        }
        //doing the same for the next list of integers 
        for(int l=0; l<string2.length(); l++){
            char c = string2.charAt(l);
            int ascii = (int) c;
            commonletters2[ascii - 97]+=1;
        }
        // setting up variable total
        int total = 0;
        //new for loop to add the minimum values of the 26 integers in the two lists 
        for(int m=0; m<26; m++){
        
            total += min(commonletters1[m], commonletters2[m]);
        }

        return total;
    }
    // next method for aim to ten function
   public static int aimToTen(int[] marks){
       //setting the sum to zero to begin and then going through the values in marks, and adding them up in a for loop
       int sum =0;
       for(int i = 0; i<marks.length; i++){
            sum = marks[i]+ sum;
       }
       //making sure the average grade isn't already 9.5 or higher
       if((sum/marks.length)>=9.5){
           System.out.println("None!");
           return 0;
       }
       //going through the equation to see when the average will become 9.5
       double grades = Math.ceil(19*(marks.length)-2*sum);
       int totalGrades = (int) grades;
       return totalGrades;

     }

        public static void main(String[] args){
        int test1 = lettersInCommon("watermelon", "cantaloupe");
        System.out.println(test1);
        int test2 = aimToTen(new int[] {9,10,10,9,0});
        System.out.println(test2);
        
    }


    
}
