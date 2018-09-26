import java.util.TreeMap;

public class CountingSort {
    /**
     * Counting sort on the given int array, works with negative numbers.
     * Note, this code does not work for ranges of numbers greater
     * than 2 billion.
     * RANGE IS THE ALPHABET SIZE for a given array.
     * (non-destructive, stable method).
     *
     * @param arr int array that will be sorted
     */
    public static int[] countingSort(int[] arr) {
        TreeMap<Integer, Integer> indexMap = new TreeMap<>();
        int N = arr.length;
        int min = arr[0];
        int max = arr[0];
        int maxRange = Integer.MAX_VALUE;
        int range;
        int[] counts;
        int[] starts;
        int[] sorted;

        if (N == 0) {
            return arr;
        }

        //Find max and min values in arr
        for (int i = 0; i < N; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        range = max - min + 1;

        //Check to see if counting sort will use too much memory.
        if (range > maxRange) {
            System.out.println("Range exceeds two billion.  "
                    + "Use quicksort.");
            return arr;
        }
        counts = new int[range];
        starts = new int[range];
        sorted = new int[N];

        //Map each unique value to an index;
        int countsIndex = 0;
        for (int i = min; i < max + 1; i++) {
            indexMap.put(i, countsIndex);
            countsIndex++;
        }

        //Calc the count of each unique number in arr;
        for (int i = 0; i < N; i++) {
            counts[arr[i] - min]++;
        }

        //Calc starting positions for each unique number.
        int pos = 0;
        for (int i = 0; i < starts.length; i += 1) {
            starts[i] = pos;
            pos += counts[i];
        }

        //Populate sorted array.
        for (int i = 0; i < arr.length; i++) {
            int item = arr[i];
            int itemIndex = indexMap.get(item);
            int position = starts[itemIndex];
            sorted[position] = item;
            starts[itemIndex]++;
        }

        return sorted;
    }

}
