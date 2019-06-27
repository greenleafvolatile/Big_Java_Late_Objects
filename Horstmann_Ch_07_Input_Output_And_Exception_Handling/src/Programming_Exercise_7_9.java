import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 * "Write a program that reads each line in a file, reverses its lines, and writes them to another file."
 */

public class programmingExercise79
{
    public static void main(String[] args)
    {
        if (args.length < 1)
        {
            printUsage();
        }
        else
        {
            File inFile = new File(args[0]);
            File outFile = new File(args[1]);
            try
            {
                PrintWriter writeLines = new PrintWriter(outFile);
                try
                {
                    ArrayList<String> linesRead = readLines(inFile);
                    for (int i = linesRead.size() - 1; i >= 0; i --)
                    {
                        writeLines.write(linesRead.get(i));
                    }
                }
                finally
                {
                    writeLines.close();
                }

            }
            catch(IOException IOExlineWriter)
            {
                IOExlineWriter.printStackTrace();
            }
        }
    }

    public static ArrayList<String> readLines(File file)
    {
        ArrayList<String> linesRead = new ArrayList<String>();
        try
        {
            Scanner lineReader = new Scanner(file);
            try
            {
               while(lineReader.hasNextLine())
               {
                   String line = lineReader.nextLine();
                   linesRead.add(String.format("%s%n", line));
               }
            }
            finally
            {
                lineReader.close();
            }

        }
        catch(IOException IOExlineReader)
        {
            IOExlineReader.printStackTrace();
        }
        return linesRead;
    }

    public static void printUsage()
    {
        System.out.print("Please provided two files. One to read from and one to write to.");
    }
}
