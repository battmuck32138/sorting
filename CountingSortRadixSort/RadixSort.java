

/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 * Note: A difference between sorting numbers and strings using a radix sort
 * is that we naturally sort Strings lexicographically (a.k.a. dictionary order;
 * “2” is after “100” so “2” is considered equivalently as “2__”, where “_” is a
 * placeholder that comes before any other character), but sort numbers in numerically
 * ascending order (2 is before 100 and is considered equivalently as 002).
 *
 * To sort Strings, we would pad them on the right with empty values,
 * but to sort numbers, we would pad them on the left with empty values
 * Tip: Remember ASCII codes range from 0 to 255.
 *
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] radixSort(String[] arr) {
        int N = arr.length;
        String[] aux = new String[N];
        int W = findWidest(arr, aux);

        //Call subroutine from the right side (LSD) and work left.
        for (int digit = W - 1; digit >= 0; digit--) {
            aux = countingSort(aux, digit);
        }

        return aux;
    }

    /**
     * LSD helper method that performs a destructive counting sort on the array of
     * Strings based off the characters at a specific index (sortOnIndex).
     * @param aux Input array of Strings
     * @param sortOnIndex The position to sort the Strings on.
     */
    public static String[] countingSort(String[] arr, int sortOnIndex) {
        int N = arr.length;
        int R = 256;  //The size of the alphabet is the number of ascii codes.
        int[] counts = new int[R];
        int[] starts = new int[R];
        String[] sorted = new String[N];

        if (N == 0) {
            return arr;
        }

        //Calc the count of each ascii code in arr.
        for (int i = 0; i < N; i++) {
            String item = arr[i];
            counts[getAsciiAtPos(item, sortOnIndex)]++;
        }

        //Calc starting positions for each ascii code.
        int pos = 0;
        for (int i = 0; i < starts.length; i += 1) {
            starts[i] = pos;
            pos += counts[i];
        }

        //Populate sorted array.
        for (int i = 0; i < arr.length; i++) {
            String item = arr[i];
            int itemIndex = getAsciiAtPos(item, sortOnIndex);
            int position = starts[itemIndex];
            sorted[position] = item;
            starts[itemIndex]++;
        }

        return sorted;
    }


    //Helper finds the length of the longest String in a String[]
    private static int findWidest(String[] arr, String[] aux) {
        int widest = 0;
        for (int i = 0; i < arr.length; i++) {
            widest = arr[i].length() > widest ? arr[i].length() : widest;
            aux[i] = arr[i];
        }
        return widest;
    }


    //Helper pads the back of a string with zeros if it's shorter than the desired position.
    private static int getAsciiAtPos(String word, int position) {
        if (word.length() <= position) {
            return 0;
        }
        return (int) word.charAt(position);
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }
}
