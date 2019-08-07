import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * "Write a program Find that searches all files specified on the command line and prints out all lines containing a specified word"
 */
public class Programming_Exercise_7_6
{
    public static void main(String[] args)
    {

        if (args.length < 1)
        {
            printUsage();
        }
        else
        {
            String searchString = args[0];
            for (int i = 1; i < args.length; i ++)
            {
                File file = new File(args[i]);
                printLine(file, searchString);
            }
        }
    }

    /**
     * This method prints all lines in a given file containing the given search string.
     * @param file the file to search
     * @param searchString the string to search for
     */
    private static void printLine(File file, String searchString)
    {
        try(Scanner lineReader = new Scanner(file)) {
            while (lineReader.hasNextLine()) {
                String line = lineReader.nextLine();
                if (line.contains(searchString)) {
                    System.out.println(line);
                }
            }
        }
        catch (IOException IOEx1)
        {
            IOEx1.printStackTrace();
        }
    }

    /**
     * This method prints a usage message when less than one parameter is provided.
     */
    private static void printUsage()
    {
        System.out.print("Please provide a search string and one or more files to be searched!");
    }

}
