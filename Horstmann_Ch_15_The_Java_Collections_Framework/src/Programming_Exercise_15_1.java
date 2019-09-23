import java.util.*;

/**
 * "Write a method public static void downSize(LinkedList<String> employeeNames, int n) that removes every nth employee from a LinkedList."
 */

public class Programming_Exercise_15_1 {

    private static void downSize(LinkedList<String> employeeNames, int n){
        ListIterator<String> lIt=employeeNames.listIterator();
        int i=1;
        while(lIt.hasNext()){
            lIt.next();
            if(i%n==0){
                lIt.remove();
            }
            i++;
        }
    }

    public static void main(String[] args){
        LinkedList<String> employeeNames=new LinkedList<>(Arrays.asList("Dave", "George", "Lynn", "Monique", "John", "Samantha", "Pam", "Bernard", "Chris", "Eleanor"));
        downSize(employeeNames, 3);
        for(String string : employeeNames){
            System.out.println(string);
        }
    }
}
