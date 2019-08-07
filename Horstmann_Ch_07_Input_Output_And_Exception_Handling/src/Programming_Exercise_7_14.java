import java.net.URL;
import java.io.PrintWriter;

import java.util.Scanner;

/**
 * "Using the mechanism described in Special Topic 7.1, write a program that reads all data from a web page and writes those to a file. Prompt the user for the web pae URL and the file."
 */
public class Programming_Exercise_7_14
{
    public static void main(String[] args)
    {

        System.out.print("Please provide a URL you want to read data from: ");
        try(Scanner in=new Scanner(System.in)){
            String url = in.next();
            URL pageLocation = new URL(url);
            Scanner urlReader = new Scanner(pageLocation.openStream());
            System.out.print("Please provide a file to write to: ");
            String outFile = in.next();
            PrintWriter out = new PrintWriter(outFile);
            try {
                while (urlReader.hasNextLine()) {
                    out.println(urlReader.nextLine());
                }
            }
            finally{
                urlReader.close();
                out.close();
            }
        }
        catch (Exception e)
        {
           System.out.print("Caught Exception");
        }


    }
}
