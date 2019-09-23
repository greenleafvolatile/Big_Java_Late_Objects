import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.logging.Logger;

/**
 * "Write a method public static void reverse(LinkedList<String> strings) that reverses the entries in a linked list."
 *
 *
 */
public class Programming_Exercise_15_2 {

    public static void reverse(LinkedList<String> strings){
        int j=strings.size()-1;
        for(int i=0;i<strings.size();i++){
           String string=strings.poll();
           strings.add(j, string);
           j--;
        }
    }

    public static void main(String[] args){

        LinkedList<String> employeeNames=new LinkedList<>(Arrays.asList("Mike", "Dave", "George", "Lynn", "Monique", "John", "Samantha", "Pam", "Bernard", "Chris", "Eleanor"));
        reverse(employeeNames);
        for(String string : employeeNames){

            System.out.println(string);
        }

        // And then I came across Collections.reverse()l
    }
}
