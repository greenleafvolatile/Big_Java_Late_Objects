/**
 * A coin with a monetary value
 */
public enum Programming_Exercise_12_1_Coin {
        DOLLAR(100),
        QUARTER(25),
        DIME(10),
        PENNY(1);

        private final int value;

        Programming_Exercise_12_1_Coin(int value){
            this.value=value;
        }

        public int getValue(){
            return value;
        }


    }



