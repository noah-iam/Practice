import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import static java.util.Arrays.asList;
/*
Asked in Morgan stanley
*/
public class TestDemo {
    private static List<String> allCombinations = new ArrayList<String>();
    public static void main(String[] args) {
        /*
        Asked in Morgan stanley
         */
        String word = "abc";
        System.out.println(getAllCombinations(word, 0, word.length() - 1));


        List<Integer> numbers = asList(new Integer[]{4, 19, 20 ,17,16, 14,20,5});
        System.out.print(getOutPut(numbers));

    }


    private static Stack<Integer> getOutPut(List<Integer> numbers) {
        Stack<Integer> stack = new Stack<Integer>();
        for ( int i = 0; i < numbers.size() ; i++ ) {
            if( numbers.get(i) == 20) {
                stack.pop();
                stack.push(numbers.get(i));
            } else {
                 if (!stack.isEmpty() && stack.peek() != 20){
                    System.out.println("Current Number:" + numbers.get(i));
                    stack.push(numbers.get(i));
                   // System.out.println("Stack Size: "+stack.size());
                } else if( stack.isEmpty()){
                     stack.push(numbers.get(i));
                 }
            }
        }

        return stack;
    }

    private static  List<String> getAllCombinations(String word, int start, int end) {
            if(start == end )
                allCombinations.add(word);
        else
        for(int index = start; index <=end; index++){

            //swap : abc
            word = swap(word, start, index);

            //call
            getAllCombinations(word, start + 1,end);

            //swap again
           //swap(word,start,index);

        }

        return allCombinations;
    }

    public static String swap(String word, int swapLeftIndex, int swapRightIndex){
       //swapping logic
        char[] wordToArray = word.toCharArray();
        char temp = wordToArray[swapRightIndex];
        wordToArray[swapRightIndex] = wordToArray[swapLeftIndex];
        wordToArray[swapLeftIndex] = temp;
        return String.valueOf(wordToArray);
    }
}
