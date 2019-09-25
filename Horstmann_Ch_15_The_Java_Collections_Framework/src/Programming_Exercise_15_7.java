import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * "Write a program that reads text from a file and breaks it up into individual words.
 * Insert the words into a tree set. At the end of the input file, print all the words,
 * followed by the size of the resulting set. This program determines how many unique words
 * the text file has."
 */
public class Programming_Exercise_15_7 {

    public static void main(String[] args){

        try(FileReader file=new FileReader("/home/daan/IdeaProjects/Horstmann/Horstmann_Ch_15_The_Java_Collections_Framework/Mary.txt")){
            Scanner in=new Scanner(file);
            Set<String> set=new TreeSet<>();
            int nrOfWords=0;
            while(in.hasNext()){
                nrOfWords++;
                set.add(in.next());
            }
            for(String string : set){
                System.out.println(string);
            }
            System.out.println("Number of words in text file: " + nrOfWords);
            System.out.println("Number of unique words in text file: " + set.size());
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
