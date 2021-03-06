import javax.swing.JOptionPane;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

/**
 * "Write a program that reads a file containing text. Read each line and send it to the output file, preceded by line numbers."
 */

public class Programming_Exercise_7_2
{
    public static void main(String[] args)
    {
        String inputFile = JOptionPane.showInputDialog("Please enter the input filename: ");
        String outputFile = JOptionPane.showInputDialog("Please enter the output filename: ");
        File inFile = new File(inputFile);
        try (Scanner lineReader = new Scanner(inFile); PrintWriter outFile = new PrintWriter(outputFile)) {
            int count = 1;
            while (lineReader.hasNextLine()) {
                String line = lineReader.nextLine();
                outFile.printf("/* %s */ %s%n", count, line);
                count++;
            }
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}
