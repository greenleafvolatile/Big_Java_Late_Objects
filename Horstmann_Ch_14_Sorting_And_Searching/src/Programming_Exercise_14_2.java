import java.util.Arrays;

/**
 * Modify the selection sort algorithm to sort an array of coins by their value."
 */

public class Programming_Exercise_14_2 {

    public class Programming_Exercise_14_2_Coin {
        private int value;
        private String name;

        private Programming_Exercise_14_2_Coin(int aValue, String aName) {
            value = aValue;
            name = aName;
        }

        private int getValue() {
            return value;
        }

        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {

        Programming_Exercise_14_2_Coin[] coins = new Programming_Exercise_14_2_Coin[5];
        coins[2] = new Programming_Exercise_14_2().new Programming_Exercise_14_2_Coin(1, "cent");
        coins[3] = new Programming_Exercise_14_2().new Programming_Exercise_14_2_Coin(5, "nickel");
        coins[4] = new Programming_Exercise_14_2().new Programming_Exercise_14_2_Coin(10, "dime");
        coins[1] = new Programming_Exercise_14_2().new Programming_Exercise_14_2_Coin(25, "penny");
        coins[0] = new Programming_Exercise_14_2().new Programming_Exercise_14_2_Coin(100, "dollar");

        System.out.println("Before sort: " + Arrays.toString(coins));

        // Selection sort coins by their value.
        for (int i = 0; i < coins.length; i++) {
            int minPos = i;
            for(int j=i;j<coins.length;j++){
                if(coins[j].getValue()<coins[minPos].getValue()){
                    minPos=j;
                }
            }
            Programming_Exercise_14_2_Coin temp=coins[minPos];
            coins[minPos]=coins[i];
            coins[i]=temp;
        }

        System.out.println("After sort: " + Arrays.toString(coins));
    }
}
