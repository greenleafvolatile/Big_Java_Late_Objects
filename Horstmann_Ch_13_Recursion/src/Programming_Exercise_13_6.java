public class Programming_Exercise_13_6 {


    private static boolean find(String text, String string){
        if(string.length()<1){
            return false;
        }
        else{
            if(string.startsWith(text)){
                return true;
            }
            else{
                return find(text, string.substring(1));
            }
        }
    }

    public static void main(String[] args){

        String string="Mississippi";
        String text="sip";
        System.out.printf("The string %s contains the text %s: %b", string, text, find(text, string));
    }
}
