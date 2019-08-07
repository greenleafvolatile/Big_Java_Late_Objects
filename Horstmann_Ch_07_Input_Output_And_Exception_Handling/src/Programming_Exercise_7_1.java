import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * "Write a program that carries out the following tasks:
 * -Open a file with the name hello.txt.
 * -Store the message "Hello, World!" in a file.
 * -Close the file.
 * -Open the same file again.
 * -Read the message into a string variable and print it."
 */

public class Programming_Exercise_7_1
{
    public static void main(String[] args)
    {
        File file = writeToFile();
        readFromFile(file);
    }


    public static File writeToFile()
    {
        File file = new File("/path_to_hello.txt");
        try (PrintWriter out = new PrintWriter(file))
        {
            out.println("Hello, world!");
        }
        catch (IOException exception)
        {
            System.out.print("File not found!");
        }
        return file;
    }

    public static void readFromFile(File file)
    {
        try(Scanner fileScanner = new Scanner(file))
        {
            String message = fileScanner.nextLine();
            System.out.print(message);
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }
}

