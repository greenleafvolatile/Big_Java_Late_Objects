/**
 * "Use recursion to implement a method public static int indexOf(String text, String str)
 *  that returns the starting position of the first substring of the text that matches str. Return -1 if str is not a substring
 *  of the text.
 *  For example, s.indexOf("Mississippi", "sip") returns 6.
 *  Hint: This is a bit trickier than Exercise P13.6, because you must keep track of how far
 *  the match is from the beginning of the text. Make that value a parameter variable of a helper method."
 */

public class Programming_Exercise_13_7 {

    private static int indexOf(String text, String string){

        return indexOf(text, string, 0);


    }

    private static int indexOf(String text, String string, int value){
        if(text.length()>string.length()){

            if(text.startsWith(string)){
                return value;
            }
            return indexOf(text.substring(1), string, value + 1);
        }
        else{
            return -1;
        }
    }




    public static void main(String[] args){

        String text="Mississipp";
        String string="sip";
        System.out.println(indexOf(text, string));

    }
}
