import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

/**
 * "Write a program that reads in baby_names.txt and produces two files, boy_names.txt and girl_names.txt, separating the data for boys and girls."
 */
public class Programming_Exercise_7_11 {

    public static void main(String[] args) {
        File babyNames = new File("/path_to_baby_names.txt");
        try (Scanner in = new Scanner(babyNames); PrintWriter boyOut = new PrintWriter("/path_to_boy_names.txt"); PrintWriter girlOut = new PrintWriter("/path_to_girl_names.txt")) {
            String format = "%-5s %-8s %-10s %-10s";
            boyOut.print(String.format(format, "Rank", "Name", "Frequency", "Percentage\n"));
            girlOut.print(String.format(format, "Rank", "Name", "Frequency", "Percentage\n"));

            while (in.hasNextLine()) {
                String[] line = in.nextLine().trim().split("\\s+");

                for (int i = 0; i < line.length; i++) {
                    if (i == 0) {
                        boyOut.printf("%-5s ", line[i]);
                        girlOut.printf("%-5s ", line[i]);
                    } else if (i < 4) {
                        boyOut.printf("%-15s", line[i]);
                    } else {
                        girlOut.printf("%-15s", line[i]);
                    }
                }
                boyOut.append("\n");
                girlOut.append("\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}