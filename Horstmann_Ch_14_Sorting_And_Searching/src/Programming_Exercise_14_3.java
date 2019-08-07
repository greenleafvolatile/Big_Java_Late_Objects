import java.util.Random;
import java.util.Scanner;

/**
 * "Write a program that automatically generates the table of sample run times for the selection sort algorithm. The
 * program should ask for the smallest and the largest value of n and the number of measurements and then make
 * all sample runs."
 */

public class Programming_Exercise_14_3{

    public static void main(String[] args){

        Scanner in=new Scanner(System.in);

        System.out.println("Please enter array length lower bound: ");
        while(!in.hasNextInt()){

            System.out.print("Numbers only! Enter a value for n: ");
            in.next();
        }
        int smallest=in.nextInt();

        System.out.println("Please enter array length upper bound: ");
        while(!in.hasNextInt()){
            System.out.print("Numbers only! Enter a value for n: ");
            in.next();
        }
        int largest=in.nextInt();


        int measurements=0;
        do{
            System.out.println("Please enter a number of measurements greater than 2: ");
            if(in.hasNextInt()){
                measurements=in.nextInt();
            }
            else if(!in.hasNextInt()){
                in.next();
            }
        }
        while(measurements<2);
        in.close();

        for(int i=0;i<measurements;i++){

            int n=smallest + i * (largest-smallest) / (measurements-1);

            // Create an array of random numbers between 0 and 100
            int[] array=new int[n];
            Random generator=new Random();
            for(int j=0;j<array.length;j++){
                array[j]=generator.nextInt(100);
            }

            // Get the time before the sort
            long startTime=System.currentTimeMillis();

            //Selection sort the array
            for(int k=0;k<array.length;k++){
                int minPos=k;
                for(int l=k;l<array.length;l++){
                    if(array[l]<array[minPos]){
                        minPos=l;
                    }
                }
                int temp=array[minPos];
                array[minPos]=array[k];
                array[k]=temp;
            }

            // Get the time after the sort
            long stopTime=System.currentTimeMillis();

            // Print the time it took to sort the array

            System.out.printf("It takes %.2f seconds to sort %d number of elements using selection sort.\n", (stopTime-startTime)*0.001, smallest);
        }
    }
}
