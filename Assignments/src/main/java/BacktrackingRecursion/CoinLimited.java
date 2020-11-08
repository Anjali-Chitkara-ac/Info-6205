package BacktrackingRecursion;
import java.util.*;

/*
I have following coins 1,1,1,1,1,5,5,5,10,10,10,10, 25,25
Can I make a total of 73 cents?
if yes, how many combinations can I make, print them out
Hint- This is basically generate all sub sets (Binary sequence)
 */
public class CoinLimited {

    public static void getCoinCombinations(int[] coins, int total){
        if(coins.length==0)
            return;

        Set<List<Integer>> set = new HashSet<>();
        int[] result = new int[coins.length];
        getCoinCombinations(result,coins,0,set , total);
        System.out.println("Total combinations possible : " + set.size());
    }

    private static void getCoinCombinations(int[] result, int[] coins, int current,Set<List<Integer>> set, int total){
        if(current==result.length){
            printCombinations(result, coins, set, total);
            return;
        }

        for(int i=0;i<2;i++){
            result[current] = i;
            getCoinCombinations(result,coins, current+1,set, total);
        }
    }

    private static void printCombinations(int[] result, int[] coins, Set<List<Integer>> set, int total){
        int sum = 0;
        for(int i=0;i<result.length;i++){
            if(result[i]==1) { //that means we are selecting that value
                sum += coins[i];
            }
        }

        if(sum==total){
            //add this array to a set
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < result.length; i ++) {
                if(result[i] == 1) {
                    temp.add(coins[i]);
                }
            }

            if(!set.contains(temp)) {
                set.add(temp);
                System.out.println(temp.toString());
            }
        }
    }


    public static void main(String[] args) {
        int[] coins = {1,1,1,1,1,5,5,5,10,10,10,10, 25,25};
        getCoinCombinations(coins, 73);
    }
}
