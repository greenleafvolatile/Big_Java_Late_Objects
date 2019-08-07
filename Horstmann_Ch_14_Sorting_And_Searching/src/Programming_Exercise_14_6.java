import java.util.Random;

/**
 * "Implement a program that measures the performance of the insertion algorithm described in Special Topic 14.2."
 */

public class Programming_Exercise_14_6{

    public static void main(String[] args){

        final int RANDOM_VALUES_UPPER_BOUND=100;
        Random generator=new Random();
        int arraySizeLowerBound=10000;
        int arraySizeUpperBound=100000;
        int measurements=10;
        for (int i=0;i<measurements;i++){

            // Create an array of size n with values between 0 and 100
            int n=arraySizeLowerBound+ i * (arraySizeUpperBound-arraySizeLowerBound) / (measurements-1);
            int[] array=new int[n];
            for(int j=0;j<n;j++){
                array[j]=generator.nextInt(RANDOM_VALUES_UPPER_BOUND);
            }

            // Save current time in variable start time
            long startTime=System.currentTimeMillis();

            // Insertion sort array
            for(int k=1;k<n;k++){
                int next=array[k];
                int l=k;
                while(l>0 && array[l-1]>next){
                    array[l]=array[l-1];
                    l--;
                }
                array[l]=next;
            }

            // Save the current time as end time
            long endTime=System.currentTimeMillis();

            // Print the difference between start and end time as the time it took to sort the array
            System.out.printf("Time to sort an array of length %d: %f seconds %n", n, (endTime-startTime)*0.001);
        }
    }
}
