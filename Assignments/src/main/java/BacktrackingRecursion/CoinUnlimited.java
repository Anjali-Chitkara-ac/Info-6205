package BacktrackingRecursion;

import java.util.*;

/*
There are 3 buckets of unlimited 5, 10 and 25 cents.
If we can pick 5 coins,
print all the combinations of the coins that can be made.
 */
public class CoinUnlimited {
    public static void getCombinations(int[] coins, int numCoins){
        if (coins.length==0)
            return;
        int[] result = new int[numCoins];

        getCombinations(result,coins,numCoins,0);
    }

    private static void getCombinations(int[] result,int[]coins, int size, int current){
        if(current==size){
            printArr(result, coins);
            return;
        }
        for(int i=0;i<coins.length;i++){
            result[current] = i;
            getCombinations(result, coins, size,current+1);
        }
    }

    private static void printArr(int[] result, int[] coins){
        for(int i=0;i<result.length;i++){
            System.out.print(coins[result[i]] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5,10,25};
        getCombinations(arr,5);
    }
}
