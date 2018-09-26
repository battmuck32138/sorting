/*
Mathew Buck
CIS 27 Lab 2
 */
package driversorts;

import java.util.Random;

//Group of generic sorting algorithms that can be used 
//or modified for use on future projects. 
public class SortingMethods {

    //------------------------------------------------------------------------
    //O(nlogn), Inplace, Not Stable 
    //Heapsort is the next best thing to Qucksort.
    //Performs a little better than shellsort. 
    public void heapSort(Comparable[] arr){
        int heapSize = arr.length - 1;
        heapify(arr);
        for(int i = heapSize; i > 0; i--){
            swap(arr, 0, i);
            heapSize = heapSize - 1;
            sink(arr, 0, heapSize);
        }
    }
    
    //Builda a heap data structure.
    public void heapify(Comparable[] arr){
        //First element in a heap is always empty.
        int heapSize = arr.length - 1;
        for(int i = heapSize/2; i >= 0; i--){
            sink(arr, i, heapSize);
        }
    }
    
    //Swaps argument with the largest element (at the top of the heap)
    //and sinks it down to its propper position.
    public void sink(Comparable[] arr, int i, int heapSize) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int max = i;
        if(left <= heapSize && arr[i].compareTo(arr[left]) < 0){
            max = left;
        }
        if(right <= heapSize && arr[max].compareTo(arr[right]) < 0){
            max = right;
        }
        if(max != i){
            swap(arr, i, max);
            sink(arr, max, heapSize);
        }
    }
    
    
    //------------------------------------------------------------------------
    //Not much difference in perfomance from normal quicksort.
    //Worst case is a sorted list. Array should be shuffled
    //before entering it as an argument if the array is 
    //suspected to be ordered. 
    public void optQuickSort(Comparable[] arr, int lo, int hi) {
        //The + 7 is the sweet spot for my enviiornment. 
        //Beats regular quicksort by about 10% for very large arrays. 
        //Not much better for smaller arrays. 
        //Could be differnet elswhere.
        if (hi <= lo + 7) {
            insertionSort(arr, lo, hi);
            return;
        }
        //Partitians the array at a pivot point extablished by
        //taking the median value or a sample of 3.
        int j = getMedianPivot(arr, lo, hi);
        //Sorts left half.
        optQuickSort(arr, lo, j - 1);
        //Sorts right half.
        quickSort(arr, j + 1, hi);
    }

    //Best sorting alogorithm for most cases O(nlogn) after shuffle.
    //Worst case is a sorted list. Array should be shuffled
    //before entering it as an argument if the array is 
    //suspected to be ordered. 
    public void quickSort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        //Partitians the array at pivot point.
        int j = getPivot(arr, lo, hi);
        //Sorts left half.
        quickSort(arr, lo, j - 1);
        //Sorts right half.
        quickSort(arr, j + 1, hi);
    }

    //Helper for quicksort.
    //Particians the array 
    public int getPivot(Comparable[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable pivot = arr[lo];
        while (true) {
            while (arr[++i].compareTo(pivot) < 0) {
                if (i == hi) {
                    break;
                }
            }
            while (pivot.compareTo(arr[--j]) < 0) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    //Particians the array at the median of a sample of 3 comparables.
    //Helper for optimised quicksort.
    public int getMedianPivot(Comparable[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        //Pivot is set to median value.
        Comparable pivot = getMedian(arr, lo, hi);
        //If pivot was found at mid position, put Pivot at index 0.
        if (arr[hi / 2] == pivot) {
            swap(arr, 0, hi / 2);
        }
        //If pivot was found at hi positiion, put pivot at index 0.
        if (arr[hi] == pivot) {
            swap(arr, 0, hi);
        }
        //if pivot was foud at lo position do nothing, i = lo.
        while (true) {
            while (arr[++i].compareTo(pivot) < 0) {
                if (i == hi) {
                    break;
                }
            }
            while (pivot.compareTo(arr[--j]) < 0) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    //Helper for getPivotMedian().
    //Helper for optQuickdort().
    //Returns the median value from a sample of 3 comparables.
    public Comparable getMedian(Comparable[] arr, int lo, int hi) {
        Comparable pivot = arr[lo];
        Comparable mid = arr[hi / 2];
        //Pivot is set to the larger value.
        if (pivot.compareTo(mid) < 0) {
            pivot = mid;
        }
        //Pivot is set to smaller value.
        if (pivot.compareTo(arr[hi]) > 0) {
            pivot = mid;
        }
        return pivot;
    }
    
    //Use prior to entering an argument for quicsort.
    //Shuffles an array of Comparable items.
    public void shuffle(Comparable[] arr) {
        Random rand = new Random();
        int size = arr.length;
        int index;
        for (int i = size - 1; i > 0; i--) {
            index = rand.nextInt(i + 1);
            if (index != i) {
                swap(arr, i, index);
            }
        }
    }

    
    //------------------------------------------------------------------------
    //Bottom-Up Merge Sort
    //O(nlogn), Stable Sort, Not Inplace (uses an auxillary array);
    //Very effiecient for sorting large lists.  As good as it gets. 
    //hi is the highest index IE size - 1, low is index 0.
    public void buMergeSort(Comparable[] arr) {
        int size = arr.length;
        //cuts list in half, doubling the size of the lists.
        for (int sz = 1; sz < size; sz = sz + sz) {
            for (int lo = 0; lo < size - sz; lo += sz + sz) {
                //Merge lists back together as 1 sorted list. 
                merge(arr, lo, lo + sz - 1,
                        Math.min(lo + sz + sz - 1, size - 1));
            }
        }
    }

    //Top-Down Merge Sort (Recursive)
    //O(nlogn), Stable Sort, Not Inplace (uses an auxillary array);
    //Very effiecient for sorting large lists.  As good as it gets. 
    //hi is the highest index IE size - 1, low is index 0.
    public void topDownMergeSort(Comparable[] arr, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        //return if the list is size 1.
        if (hi <= lo) {
            return;
        }
        //Recursively sort left half;
        topDownMergeSort(arr, lo, mid);
        //Recursively sort right half;
        topDownMergeSort(arr, mid + 1, hi);
        //Merge lists back together.
        merge(arr, lo, mid, hi);
    }

    //Merges to sorted lists into 1 sorted list. 
    public static void merge(Comparable[] arr, int lo, int mid, int hi) {
        Comparable[] aux = new Comparable[arr.length];
        int i = lo;
        int j = mid + 1;
        //Copy contents into auxilary array
        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > hi) {
                arr[k] = aux[i++];
            } else if (aux[j].compareTo(aux[i]) < 0) {
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }
    }

    
    //------------------------------------------------------------------------
    //Shell Sort (Generic)
    //O n(logn)^2 ,Stable Sort, Inplace
//A big step up from selection and insertion sort.
//Works well on very large lists, short code.
//Shell Sort is an improved version of insertion sort.
    public <T extends Comparable<T>> void shellSort(Comparable[] arr) {
        int size = arr.length;
        int gap = 1;
        //Establishes increment sequence based on array size.
        //1, 4, 13, 40, 121, 364, 1093,...
        //Most books just use n/2.
        while (gap < size / 3) {
            gap = 3 * gap + 1;
        }
        //Info only
        System.out.println("Initial gap size for Shellsort is: " + gap);
        //Each pass
        while (gap >= 1) {
            for (int i = gap; i < size; i++) {
                //compareTo() returns -1 if j < j - gap 
                //compareTo() returns -1 if the calling object is < argument.
                for (int j = i; j >= gap
                        //Gap gets smaller each pass.
                        && arr[j].compareTo(arr[j - gap]) < 0; j -= gap) {
                    //Swap if a smaller value is found.
                    swap(arr, j - gap, j);
                }
            }
            gap = gap / 3;
        }
    }

    //------------------------------------------------------------------------
    //Insertion Sort (Generic)
    //O(n^2) ,Stable Sort, Inplace
    //Works well if majority or the items are expected to be in 
    //order, worthless otherwise.
    //Best case is O(n)
    public <T extends Comparable<T>> void insertionSort(T[] arr) {
        int size = arr.length;
        //Start at i = 1 becauase the first element will represent the 
        //sorted portion of the array.
        //Iterate through the unsorted portion normaly.
        for (int i = 1; i < size; i++) {
            //compareTo() returns -1 if j < j-1 
            //compareTo() returns -1 if the calling object is < argument.
            //Iterate through the sorted portion backwards (right to left).
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                //Swap if a smaller value is found.
                swap(arr, j - 1, j);
            }
        }
    }

    //------------------------------------------------------------------------
    //Insertion Sort (Comparable)
    //O(n^2) ,Stable Sort, Inplace
    //Works well if majority or the items are expected to be in 
    //order, worthless otherwise.
    //Best case is O(n)
    public void insertionSort(Comparable[] arr, int lo, int hi) {
        //Start at i = 1 becauase the first element will represent the 
        //sorted portion of the array.
        //Iterate through the unsorted portion normaly.
        for (int i = lo + 1; i < hi + 1; i++) {
            //compareTo() returns -1 if j < j-1 
            //compareTo() returns -1 if the calling object is < argument.
            //Iterate through the sorted portion backwards (right to left).
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                //Swap if a smaller value is found.
                swap(arr, j - 1, j);
            }
        }
    }

    //------------------------------------------------------------------------
    //Select Sort (Genetic)
    //O(N^2), Inplace Sorting, Unstable
    //Finds the minimum and swaps it with the element at current position.
    public <T extends Comparable<T>> void selectSort(Comparable[] arr) {
        int size = arr.length;
        int min = 0;
        for (int i = 0; i < size; i++) {
            min = i;
            //Moves to next index.
            for (int j = i + 1; j < size; j++) {
                //Swaps if a smaller item is found.
                if (arr[min].compareTo(arr[j]) > 0) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    
    //------------------------------------------------------------------------
    public Character[] toCharacterArray(String s) {
        if (s == null) {
            return null;
        }
        int len = s.length();
        Character[] arr = new Character[len];
        for (int i = 0; i < len; i++) {
            arr[i] = s.charAt(i);
        }
        return arr;
    }

    //------------------------------------------------------------------------
    //Bubble Sort, O(n^2), Inplace, Stable
    //Never use, worst sorting algorithm.
    public <T extends Comparable<T>> void bubbleSort(Comparable[] arr) {
        int size = arr.length;
        int swapOccurred = 1;
        int outCounter;
        int inCounter;
        // swapOccurred helps to stop iterating if the array gets sorted before 
        // outCounter reaches to size
        for (outCounter = size - 1; outCounter > 0
                && swapOccurred == 1; outCounter--) {
            swapOccurred = 0;
            for (inCounter = 0; inCounter < outCounter; inCounter++) {
                if (arr[inCounter].compareTo(arr[inCounter + 1]) > 0) {
                    swap(arr, inCounter, inCounter + 1);
                    swapOccurred = 1;
                }
            }
        }
    }

    //------------------------------------------------------------------------
    //Helper Method for sorts.
    public void swap(Comparable[] arr, int i, int j) {
        Comparable tmp;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //Helper for test purposes only. 
    public void displayArr(Comparable[] arr) {
        for (Comparable element : arr) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }

    //Creates an array of random doubles.
    public Double[] randArr(double size) {
        Double[] arr = new Double[(int) size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextDouble();
        }
        return arr;
    }

    //------------------------------------------------------------------------
    public void testOptQuickSort(double arrSize) {
        Double[] arr = randArr(arrSize);
        final long start = System.currentTimeMillis();
        optQuickSort(arr, 0, arr.length - 1);
        final long end = System.currentTimeMillis();
        System.out.println("Optimized Quicksort at " + arrSize
                + ". Runtime:     " + (end - start) + " milliseconds.");
    }

    public void testQuickSort(double arrSize) {
        Double[] arr = randArr(arrSize);
        final long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        final long end = System.currentTimeMillis();
        System.out.println("Quicksort at " + arrSize
                + ". Runtime:               "
                + (end - start) + " milliseconds.");
    }

    public void testShellSort(double arrSize) {
        Double[] arr = randArr(arrSize);
        final long start = System.currentTimeMillis();
        shellSort(arr);
        final long end = System.currentTimeMillis();
        System.out.println("Shellsort at " + arrSize
                + ". Runtime:               "
                + (end - start) + " milliseconds.");
    }

    public void testBuMergeSort(double arrSize) {
        Double[] arr = randArr(arrSize);
        final long start = System.currentTimeMillis();
        buMergeSort(arr);
        final long end = System.currentTimeMillis();
        System.out.println("Bottom-Up Mergersor at " + arrSize
                + ". Runtime:     "
                + (end - start) + " milliseconds.");
    }

    public void testTopDownMergeSort(double arrSize) {
        Double[] arr = randArr(arrSize);
        final long start = System.currentTimeMillis();
        topDownMergeSort(arr, 0, arr.length - 1);
        final long end = System.currentTimeMillis();
        System.out.println("Top-Down Mergersor at " + arrSize
                + ". Runtime:      "
                + (end - start) + " milliseconds.");
    }

    public void testInsertionSort(double arrSize) {
        Double[] arr = randArr(arrSize);
        final long start = System.currentTimeMillis();
        insertionSort(arr);
        final long end = System.currentTimeMillis();
        System.out.println("Insertion Sort at " + arrSize
                + ". Runtime:          "
                + (end - start) + " milliseconds.");
    }

    public void testSelectSort(double arrSize) {
        Double[] arr = randArr(arrSize);
        final long start = System.currentTimeMillis();
        selectSort(arr);
        final long end = System.currentTimeMillis();
        System.out.println("Select Sort at " + arrSize
                + ". Runtime:             "
                + (end - start) + " milliseconds.");
    }

    public void testHeapSort(double arrSize) {
        Double[] arr = randArr(arrSize);
        final long start = System.currentTimeMillis();
        heapSort(arr);
        final long end = System.currentTimeMillis();
        System.out.println("Heapsort at " + arrSize
                + ". Runtime:                "
                + (end - start) + " milliseconds.");
    }
    
    public void testNaturalMergeSort(double listSize) {
        DLinkedList ll = new DLinkedList();
        Random rand = new Random();
        for (int i = 0; i < listSize; i++) {
            ll.addLast( rand.nextDouble());
        }
        
        final long start = System.currentTimeMillis();
        ll.naturalMergeSortLL(ll);
        final long end = System.currentTimeMillis();
        System.out.println("Natural Merge Sort at " + listSize
                + ". Runtime:      "
                + (end - start) + " milliseconds.");
    }
    
//end class    
}
