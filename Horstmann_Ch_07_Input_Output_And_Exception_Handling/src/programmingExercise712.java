import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * "Write a program that reads a file in the same format as baby_names.txt and prints all names that are both boy and girl names."
 */
public class programmingExercise712
{
    public static void main(String[] args)
    {
        File baby_names=new File("/home/daan/baby_names.txt");
        try(Scanner lineReader = new Scanner(baby_names)){

            ArrayList<String> boyNames = new ArrayList<>();
            ArrayList<String> girlNames = new ArrayList<>();

            while(lineReader.hasNextLine()) {
                String[] line = lineReader.nextLine().trim().split("\\s+");
                boyNames.add(line[1]);
                girlNames.add(line[4]);
            }
            for (String name : boyNames) {
                for (String girlName : girlNames) {
                    if (girlName.equals(name)) {
                        System.out.println(name);
                    }

                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
