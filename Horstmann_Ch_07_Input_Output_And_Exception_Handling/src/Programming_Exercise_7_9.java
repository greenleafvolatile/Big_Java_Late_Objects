import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * "Write a program that reads each line in a file, reverses its lines, and writes them to another file."
 */
public class Programming_Exercise_7_9
{
    public static void main(String[] args)
    {
        if (args.length < 1)
        {
            printUsage();
            System.exit(0);
        }
        else
        {
            File inFile = new File(args[0]);
            File outFile = new File(args[1]);
            try(PrintWriter out = new PrintWriter(outFile)){
                ArrayList<String> linesRead = readLines(inFile);
                for (int i = linesRead.size() - 1; i >= 0; i --)
                {
                    out.write(linesRead.get(i));
                }
            }
            catch(IOException IOExlineWriter)
            {
                IOExlineWriter.printStackTrace();
            }
        }
    }

    private static ArrayList<String> readLines(File file)
    {
        ArrayList<String> linesRead = new ArrayList<>();
        try(Scanner in = new Scanner(file)){
            while(in.hasNextLine())
            {
                String line =in.nextLine();
                linesRead.add(String.format("%s%n", line));
            }
        }
        catch(IOException IOExlineReader)
        {
            IOExlineReader.printStackTrace();
        }
        return linesRead;
    }

    private static void printUsage()
    {
        System.out.print("Please provide two files. One to read from and one to write to.");
    }
}
