import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * "Write a program that replaces each line of a file with its reverse".
 */

public class Programming_Exercise_7_8
{
    public static void main(String[] args)
    {
        JOptionPane.showMessageDialog(null, "In the next window please select a file");
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            File inFile = chooser.getSelectedFile();
            try(Scanner lineReader = new Scanner(inFile)){
                ArrayList<String> list =new ArrayList<>();
                while(lineReader.hasNextLine())
                {
                    String line = lineReader.nextLine();
                    list.add(reverseLine(line));
                }
                try(PrintWriter writer=new PrintWriter(inFile)){

                    for (String s : list) {
                        System.out.println(s);
                        writer.println(s);
                    }
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


    private static String reverseLine(String line)
    {
        StringBuilder reverseLine = new StringBuilder();
        for (int i = line.length() - 1; i >= 0; i --)
        {
            char ch = line.charAt(i);
            reverseLine.append(ch);
        }
        return reverseLine.toString();
    }
}
