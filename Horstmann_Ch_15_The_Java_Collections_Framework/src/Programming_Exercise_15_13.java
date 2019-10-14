import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * "Insert all words from a large file (such as the novel "War and Peace", whicj is available on the Internet) into a
 * hashset and a treeset. Time the results. Which data structure is faster?"
 */
public class Programming_Exercise_15_13 {

    private static long getTime(Set<String> set) throws FileNotFoundException{
        File file=new File("/PATH/TO/War_And_Peace.txt");

        Scanner in=new Scanner(file);
        in.useDelimiter("[\\W]+");

        long startTime=System.currentTimeMillis();

        while(in.hasNext()){
            set.add(in.next());
        }

        long endTime=System.currentTimeMillis();

        return endTime-startTime;
    }

    public static void main(String[] args) throws FileNotFoundException {

        Set<String> hash = new HashSet<>();
        Set<String> tree = new TreeSet<>();

        long hashTime=getTime(hash);
        long treeTime=getTime(tree);

        if(hashTime>treeTime){
            System.out.printf("In this case a tree set (%d milliseconds) is the faster data structure", treeTime);
        }
        else{

            System.out.printf("In this case a hash set (%d milliseconds) is the faster data structure", hashTime);
        }
    }
}
