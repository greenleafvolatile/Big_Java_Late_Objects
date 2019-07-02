import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 * "Write a program that checks the spelling of all words in a file. It should read each word of a file
 * and check whether it is contained in a word list [...]. The program should print out all words that it cannot find in the word list"
 */

public class Programming_Exercise_7_7
{
    public static void main(String[] args)
    {
        File inFile;
        JOptionPane.showMessageDialog(null,"Please choose a file in the next window.");
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            inFile = chooser.getSelectedFile();
            try(Scanner wordReader = new Scanner(inFile))
            {
                while(wordReader.hasNext())
                {
                    String word = wordReader.next().toLowerCase();
                    dictChecker(word);
                }
            }
            catch (IOException IOEx1)
            {
                IOEx1.printStackTrace();
            }
        }
    }

    private static void dictChecker(String word)
    {
        File dictFile = new File("/path_to_word_list");
        try(Scanner dictChecker = new Scanner(dictFile)){
            while(dictChecker.hasNextLine()) {
                String string = dictChecker.nextLine().toLowerCase();
                if (string.equals(word)) {
                    return;
                }
            }
            System.out.printf("The word \"%s\" was not found in the dictionary file!%n", word);
        }
        catch(IOException IOExdictChecker)
        {
            IOExdictChecker.printStackTrace();
        }
    }
}
