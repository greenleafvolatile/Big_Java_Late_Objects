import java.util.Arrays;

/**
 * "Modify the merge sort algorithm to sort an array of strings in lexicographic order."
 */

public class Programming_Exercise_14_4 {

    static class MergeSorter {

        public static void sort(String[] array) {
            if (array.length < 2) {
                return;
            }
            String[] first = new String[array.length / 2];
            String[] second = new String[array.length - first.length];
            for (int i = 0; i < first.length; i++) {
                first[i] = array[i];
            }
            for (int i = 0; i < second.length; i++) {
                second[i] = array[first.length + i];
            }
            sort(first);
            sort(second);
            merge(array, first, second);
        }

        public static void merge(String[] array, String[] first, String[] second) {
            int iFirst = 0;
            int iSecond = 0;
            int j = 0;
            while (iFirst < first.length && iSecond < second.length) {
                if (first[iFirst].compareToIgnoreCase(second[iSecond]) == 1) {
                    array[j] = first[iFirst];
                    iFirst++;
                } else {
                    array[j] = second[iSecond];
                    iSecond++;
                }
                j++;
            }
            while (iFirst < first.length) {
                array[j++] = first[iFirst++];
            }
            while (iSecond < second.length) {
                array[j++] = second[iSecond++];
            }
        }
    }

    public static void main(String[] args){

        String[] array={"Zebra", "Donkey", "Ape"};
        MergeSorter.sort(array);
        System.out.print(Arrays.toString(array));
    }
}


