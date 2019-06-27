import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.logging.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * "Write a program that replaces each line of a file with its reverse".
 */

public class programmingExercise78
{
    public static void main(String[] args)
    {
        JOptionPane.showMessageDialog(null, "In the next window please select a file");
        JFileChooser chooser = new JFileChooser();
        File inFile = null;
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            inFile = chooser.getSelectedFile();
            try
            {
                Scanner lineReader = new Scanner(inFile);
                try
                {
                    while(lineReader.hasNextLine())
                    {
                        String line = lineReader.nextLine();
                        printReverseLine(line);
                    }
                }
                finally
                {
                    lineReader.close();
                }
            }
            catch(IOException lineReaderMain)
            {
                lineReaderMain.printStackTrace();
            }
        }
        else if (chooser.showOpenDialog(null) == JFileChooser.CANCEL_OPTION)
        {
            System.out.print("You decided to cancel.");
        }
    }


    public static void printReverseLine (String line)
    {
        String reverseLine = "";
        for (int i = line.length() - 1; i >= 0; i --)
        {
            char ch = line.charAt(i);
            reverseLine += ch;
        }
        System.out.println(reverseLine);
    }
}
