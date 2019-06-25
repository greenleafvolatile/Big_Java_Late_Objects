import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.logging.*;
import java.util.ArrayList;

/**
 * "Write a program that reads a file containing two columns of floating point numbers.
 * Prompt the user for the file name. Print the average of each column."
 */

public class programmingExercise74
{
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        System.out.print("Please provide a name for the input file: ");
        File inFile = new File(stdin.nextLine());
        ArrayList<Integer> columns = new ArrayList<Integer>();
        System.out.print("Please input the numbers of the columns the values of which you would like to average ('q' to quit): ");
        while(stdin.hasNextInt())
        {
            columns.add(stdin.nextInt());
        }
        Logger.getGlobal().info("Columns: " + columns);
        try
        {
            Scanner numberReader = new Scanner(inFile);

            try
            {
                ArrayList<Double> numbers = new ArrayList<Double>();
                int nrOfColumns = getNumberOfColumns(inFile);
                while(numberReader.hasNextDouble())
                {
                    double number = numberReader.nextDouble();
                    numbers.add(number);
                }
                for (int i = 0; i < columns.size(); i ++)
                {
                    System.out.printf("The average for column %d is %.2f%n", columns.get(i), printAverageColumn(numbers, columns.get(i), nrOfColumns));
                }


            }
            finally
            {
                numberReader.close();
            }
        }
        catch (IOException IOEx1)
        {
            IOEx1.printStackTrace();
        }
    }

    public static double printAverageColumn(ArrayList<Double> numbers, int columnNr, int nrOfColumns)
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

    public static int getNumberOfColumns(File inFile) throws IOException
    {
        Scanner lineReader  = new Scanner(inFile);
        String line = lineReader.nextLine();
        return line.split("\\s").length;
    }
}
