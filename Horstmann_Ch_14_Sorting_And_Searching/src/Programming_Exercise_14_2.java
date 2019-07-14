import java.util.Arrays;

/**
 * Modify the selection sort algorithm to sort an array of coins by their value."
 */

public class Programming_Exercise_14_2 {

    public static void main(String[] args) {

        Programming_Exercise_14_2_Coin[] coins = new Programming_Exercise_14_2_Coin[5];
        coins[2] = new Programming_Exercise_14_2_Coin(1, "cent");
        coins[3] = new Programming_Exercise_14_2_Coin(5, "nickel");
        coins[4] = new Programming_Exercise_14_2_Coin(10, "dime");
        coins[1] = new Programming_Exercise_14_2_Coin(25, "penny");
        coins[0] = new Programming_Exercise_14_2_Coin(100, "dollar");

        System.out.println("Before sort: " + Arrays.toString(coins));

        for (int i = 0; i < coins.length; i++) {
            int minPos = findMinPos(i, coins);
            swap(coins, i, minPos);
        }

        System.out.println("After sort: " + Arrays.toString(coins));
    }

    private static int findMinPos(int from, Programming_Exercise_14_2_Coin[] coins){
        int minPos=from;
        for(int i = from; i<coins.length; i++){
            if(coins[i].getValue()<coins[minPos].getValue()){
                minPos=i;
            }
        }
        return minPos;
    }

    private static void swap(Programming_Exercise_14_2_Coin[] coins, int i, int minPos){

        Programming_Exercise_14_2_Coin temp=coins[i];
        coins[i]=coins[minPos];
        coins[minPos]=temp;
    }


}
