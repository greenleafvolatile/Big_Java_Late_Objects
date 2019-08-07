import java.util.Arrays;

/**
 * "Modify the selection sort algorithm to sort an array of integers in descending order."
 */
public class Programming_Exercise_14_1{

    public static void reverseSort(int[] array){

        for(int i=0;i<array.length;i++){
            int minPos = findMaxPos(i, array);
            swap(i, minPos, array);
        }
    }

    private static int findMaxPos(int from, int[] array){

        int maxPos=from;
        for (int i=from;i<array.length;i++){
            if(array[i]>array[from]){
                maxPos=i;
            }
        }
        return maxPos;
    }

    private static void swap(int i, int maxPos, int[] array){

        int temp=array[maxPos];
        array[maxPos]=array[i];
        array[i]=temp;
    }

    public static void main(String[] args) {


        int[] array = {2, 7, 9, 1};
        System.out.println("Before sort: " + Arrays.toString(array));
        Programming_Exercise_14_1.reverseSort(array);
        System.out.println("After sort: " + Arrays.toString(array));
    }


}
