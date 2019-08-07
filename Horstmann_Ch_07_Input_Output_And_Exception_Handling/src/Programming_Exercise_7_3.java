import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

/**
 * "Repeat Exercise P7.2, but allow the user to specify the file name in the command-line.
 * If the user doesn't specify any file name, them prompt the user for the name."
 */
public class Programming_Exercise_7_3{
    public static void main(String[] args) {
        String inputFile;
        String outputFile;
        if (args.length < 2) {
            System.out.print("Missing arguments! Usage: command inputfile outputfile.\n");
            System.exit(0);
        }
        else {
            inputFile = args[0];
            outputFile = args[1];
            File inFile = new File(inputFile);
            try(Scanner lineReader = new Scanner(inFile);
                PrintWriter outFile = new PrintWriter(outputFile))
            {
                int lineNumber=1;
                while (lineReader.hasNextLine()) {
                    String line=lineReader.nextLine();
                    outFile.printf("/* %s */ %s%n", lineNumber, line);
                    lineNumber++;
                }
            }
            catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}

