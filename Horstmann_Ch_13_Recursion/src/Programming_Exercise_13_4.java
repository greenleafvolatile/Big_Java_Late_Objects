
/**
 * "Redo Exercise P13.3 with a recursive helper method that reverses  a substring of the message text".
 */

public class Programming_Exercise_13_4 {

    private static String myReverse(String aString, int subStringStartingIndex){

        if(subStringStartingIndex==aString.length()-1){
            return aString;
        }
        return myReverse(aString.substring(subStringStartingIndex+1)) + aString.charAt(subStringStartingIndex);
    }

    private static String myReverse(String aString){

        return myReverse(aString, 0);
    }

    public static void main(String[] args){

        System.out.println(myReverse("Hello"));



    }
}
