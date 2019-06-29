import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.logging.*;
import java.util.ArrayList;

/**
 * "Write a program that reads a file containing two columns of floating point numbers.
 * Prompt the user for the file name. Print the average of each column."
 */

public class Programming_Exercise_7_4
{
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        System.out.print("Please provide a name for the input file: ");
        File inFile = new File(stdin.nextLine());
        ArrayList<Integer> columns = new ArrayList<>();
        System.out.print("Please input the numbers of the columns the values of which you would like to average ('q' to quit): ");
        while(stdin.hasNextInt())
        {
            columns.add(stdin.nextInt());
        }
        Logger.getGlobal().info("Columns: " + columns);
        try(Scanner numberReader=new Scanner(inFile))
        {
            ArrayList<Double> numbers = new ArrayList<>();
            int nrOfColumns = getNumberOfColumns(inFile);
            while(numberReader.hasNextDouble())
            {
                double number = numberReader.nextDouble();
                numbers.add(number);
            }
            for (Integer column : columns) {
                System.out.printf("The average for column %d is %.2f%n", column, printAverageColumn(numbers, column, nrOfColumns));
            }
        }
        catch (IOException IOEx1)
        {
            IOEx1.printStackTrace();
        }
    }

    private static double printAverageColumn(ArrayList<Double> numbers, int columnNr, int nrOfColumns)
    {
        double count = 0;
        double total = 0;
        int i = columnNr - 1;
        while (i < numbers.size())
        {
            total += numbers.get(i);
            count ++;
            i += nrOfColumns;
        }
        return total / count;
    }

    private static int getNumberOfColumns(File inFile) throws IOException
    {
        Scanner lineReader  = new Scanner(inFile);
        String line = lineReader.nextLine();
        return line.split("\\s").length;
    }
}
