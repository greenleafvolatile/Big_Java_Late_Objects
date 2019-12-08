public class Programming_Exercise_13_3 {

    private static String reverseString(String aString){

        if(aString.length()==1){
            return aString;
        }
        return reverseString(aString.substring(1)) + aString.charAt(0);
    }

    public static void main(String[] args){

        System.out.println(reverseString("Hello"));
    }


}
