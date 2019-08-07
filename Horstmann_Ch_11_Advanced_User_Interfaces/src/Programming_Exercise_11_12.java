import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Write a program that uses a timer to print the current time once a second.
 */

public class Programming_Exercise_11_12 {

    public static void main(String[] args){

        class printTime extends TimerTask {

            public void run(){
                DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
                System.out.println(formatter.format(LocalTime.now()));
            }
        }
        Timer t=new Timer();
        t.schedule(new printTime(), 0, 1000);
    }
}

