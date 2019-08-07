import java.io.*;
import java.util.Scanner;
import java.util.logging.*;
import java.util.regex.Pattern;

/**
 * This program counts the number of lines, words and chars in a given file inputted by the user.
 */
public class Programming_Exercise_7_5
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
        try(Scanner charReader = new Scanner(inFile))
        {
            charReader.useDelimiter("");
            while(charReader.hasNext())
            {
                char ch = charReader.next().charAt(0);
                charCount ++;
                Logger.getGlobal().info("" + charCount);

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
        try(Scanner wordScanner = new Scanner(inFile))
        {
             while(wordScanner.hasNext())
                    {
                        String word = wordScanner.next();
                        if(Pattern.matches("\\D+", word)){
                            wordCount ++;
                            Logger.getGlobal().info("WordCount: " + wordCount);
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

        try(FileReader fr=new FileReader(inFile); LineNumberReader lnr=new LineNumberReader(fr))
        {
            while(lnr.readLine()!=null)
            {
                lineCount ++;
            }
        }
        catch(IOException IOEx3)
        {
            IOEx3.printStackTrace();
        }
        return lineCount;
    }


}
