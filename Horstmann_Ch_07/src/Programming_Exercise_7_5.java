import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.logging.*;
import java.io.PrintWriter;

/**
 * This program counts the number of lines, words and chars in a given file inputted by the user.
 */

public class programmingExercise75
{
    public static void main(String[] args)
    {
        Logger.getGlobal().setLevel(Level.OFF);
        Scanner stdin = new Scanner(System.in);
        System.out.print("Please provide a file name: ");
        File inFile = new File(stdin.next());
        System.out.printf("The number of characters in this file is: %d%n", getCharacterCount(inFile));
        System.out.printf("The number of words in this file is: %d%n", getWordCount(inFile));
        System.out.printf("The number of lines in this file is: %d%n", getLineCount(inFile));
    }

    public static int getCharacterCount(File inFile)
    {
        int charCount = 0;
        try
        {
            Scanner charReader = new Scanner(inFile);
            charReader.useDelimiter("");
            {
                try
                {
                    while(charReader.hasNext())
                    {
                        char ch = charReader.next().charAt(0);
                        charCount ++;
                        Logger.getGlobal().info("" + charCount);

                    }
                }
                finally
                {
                    charReader.close();
                }
            }
        }
        catch(IOException IOEx1)
        {
           IOEx1.printStackTrace();
        }
        return charCount;
    }

    public static int getWordCount(File inFile)
    {

        int wordCount = 0;
        try
        {
            Scanner wordScanner = new Scanner(inFile);
            {
                try
                {
                    // count the number of words

                    while(wordScanner.hasNext())
                    {
                        String word = wordScanner.next();
                        wordCount ++;
                        Logger.getGlobal().info("WordCount: " + wordCount);
                    }
                    /* Another way to count the words:
                    while(wordScanner.hasNextLine())
                    {

                        String line = wordScanner.nextLine();
                        wordCount += line.split("\\s").length;
                    }
                    */
                }
                finally
                {
                    wordScanner.close();
                }
            }
        }
        catch(IOException IOEx2)
        {
            IOEx2.printStackTrace();
        }
        return wordCount;
    }

    public static int getLineCount(File inFile)
    {
        int lineCount = 0;
        try
        {
            Scanner lineReader = new Scanner(inFile);
            try
            {
                while(lineReader.hasNextLine())
                {
                    String line = lineReader.nextLine();
                    lineCount ++;
                }
            }
            finally
            {
                lineReader.close();
            }
        }
        catch(IOException IOEx3)
        {
            IOEx3.printStackTrace();
        }
        return lineCount;
    }


}
