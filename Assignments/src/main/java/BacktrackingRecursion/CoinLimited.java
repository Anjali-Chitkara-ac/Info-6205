package BacktrackingRecursion;
import java.util.*;

/*
I have following coins 1,1,1,1,1,5,5,5,10,10,10,10, 25,25
Can I make a total of 73 cents?
if yes, how many combinations can I make, print them out
Hint- This is basically generate all sub sets (Binary sequence)
 */
public class CoinLimited {

    public static void getCoinCombinations(int[] coins){
        if(coins.length==0)
            return;

        int[] result = new int[coins.length];
        getCoinCombinations(result,coins,0);
    }

    private static void getCoinCombinations(int[] result, int[] coins, int current){
        if(current==result.length){
            printCombinations(result, coins);
            return;
        }

        for(int i=0;i<2;i++){
            result[current] = i;
            getCoinCombinations(result,coins, current+1);
        }
    }

    private static void printCombinations(int[] result, int[] coins){
        int sum = 0;
        for(int i=0;i<result.length;i++){
            if(result[i]==1) {
                sum += coins[i];
            }
        }

        if(sum==73){
            for(int i=0;i<result.length;i++){
                if(result[i]==1) {
                    System.out.print(coins[i] + " ");
                }
            }
            System.out.println();
        }
    }

//    private static int[] getCombinations(int[] result, int[]coins){
//        int[] coinCombination = new int[coins.length];
//        int sum = 0;
//        for(int i=0;i<result.length;i++){
//            if(result[i]==1) {
//                sum += coins[i];
//            }
//        }
//
//        if(sum==73){
//            int idx = 0;
//            for(int i=0;i<result.length;i++){
//                if(result[i]==1) {
//                    //add it to the arr
//                    coinCombination[idx] = coins[i];
//                }
//            }
//            //set.add(coinCombination);
//        }
//        return coinCombination;
//    }

    public static void main(String[] args) {
        int[] coins = {1,1,1,1,1,5,5,5,10,10,10,10, 25,25};
        getCoinCombinations(coins);
    }
}
