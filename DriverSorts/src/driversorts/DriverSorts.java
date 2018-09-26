/*
Mathew Buck
CIS 27 Lab 2
 */
package driversorts;

import java.util.Random;

public class DriverSorts {

    //Test code for multiple sorting algorithms and ques.
    public static void main(String[] args) {

        DLinkedList ll = new DLinkedList();
        MinPriorityQue mpq = new MinPriorityQue(20);
        HeapPriorityQue hpq = new HeapPriorityQue(20);
        Random rand = new Random();
        Integer[] arrI = new Integer[100];
        SortingMethods sm = new SortingMethods();
        String s = "zbbbbbbbbbbbbbbbbbbbbbbba";
        String s2 = "EASYSHELLSORTQUESTION";
        String s3 = "SORTINGISNOJOKE";
        String s4 = "THISISAGOODARRAYTOSORT";
        String s5 = "123456789";
        String s6 = "abcdefghijklmnopqrstuvwxyz";
        String s7 = "HEAPSORTISDRIVINGMECRAZY";
        String s8 = "PRIORITYQUEUE";
        String s9 = "3056749218";
        Character[] cArr;//Must convert to object to compare.
        double d3 = Math.pow(10, 3);
        double d4 = Math.pow(10, 4);
        double d5 = Math.pow(10, 5);
        double d6 = Math.pow(10, 6);
        double d7 = Math.pow(10, 7);

        //Runtime tests
        System.out.println("10^3");
        sm.testQuickSort(d3);
        sm.testOptQuickSort(d3);
        sm.testHeapSort(d3);
        sm.testNaturalMergeSort(d3);
        sm.testShellSort(d3);
        sm.testBuMergeSort(d3);
        sm.testTopDownMergeSort(d3);
        sm.testInsertionSort(d3);
        sm.testSelectSort(d3);
        System.out.println();
        System.out.println("10^4");
        sm.testQuickSort(d4);
        sm.testOptQuickSort(d4);
        sm.testHeapSort(d4);
        sm.testNaturalMergeSort(d4);
        sm.testShellSort(d4);
        sm.testBuMergeSort(d4);
        sm.testTopDownMergeSort(d4);
        sm.testInsertionSort(d4);
        sm.testSelectSort(d4);
        System.out.println();
        System.out.println("10^5");
        sm.testQuickSort(d5);
        sm.testOptQuickSort(d5);
        sm.testHeapSort(d5);
        sm.testNaturalMergeSort(d5);
        sm.testShellSort(d5);
        System.out.println();
        System.out.println("10^6");
        sm.testQuickSort(d6);
        sm.testOptQuickSort(d6);
        sm.testHeapSort(d6);
        sm.testNaturalMergeSort(d6);
        sm.testShellSort(d6);
        System.out.println();
        System.out.println("10^7");
        sm.testQuickSort(d7);
        sm.testOptQuickSort(d7);
        System.out.println();

        //Shell Sort tests.cArr = sm.toCharacterArray(s2);
        cArr = sm.toCharacterArray(s2);
        System.out.println("Median is "
                + sm.getMedian(cArr, 0, cArr.length - 1));
        System.out.println("Initial array: ");
        sm.displayArr(cArr);
        sm.shellSort(cArr);
        System.out.println("After Shell Sort: ");
        sm.displayArr(cArr);
        System.out.println();

        cArr = sm.toCharacterArray(s);
        System.out.println("Initial array: ");
        sm.displayArr(cArr);
        System.out.println("Median is "
                + sm.getMedian(cArr, 0, cArr.length - 1));
        //Insertion Sort tests.
        sm.insertionSort(cArr);
        System.out.println("After Insertion Sort: ");
        sm.displayArr(cArr);
        cArr = sm.toCharacterArray(s);
        sm.insertionSort(cArr, 0, cArr.length - 1);
        System.out.print("After Paramater Insertion Sort: ");
        sm.displayArr(cArr);
        System.out.println();

        cArr = sm.toCharacterArray(s3);
        System.out.println("Initial array: ");
        sm.displayArr(cArr);
        System.out.println("Median is "
                + sm.getMedian(cArr, 0, cArr.length - 1));
        //Select Sort tests.
        sm.selectSort(cArr);
        System.out.println("After Select Sort: ");
        sm.displayArr(cArr);
        System.out.println();

        cArr = sm.toCharacterArray(s4);
        System.out.println("Initial array: ");
        sm.displayArr(cArr);
        System.out.println("Median is "
                + sm.getMedian(cArr, 0, cArr.length - 1));
        //Bubble Sort tests.
        sm.bubbleSort(cArr);
        System.out.println("After Bubble Sort: ");
        sm.displayArr(cArr);
        System.out.println();

        cArr = sm.toCharacterArray(s5);
        System.out.println("Initial array: ");
        sm.displayArr(cArr);
        System.out.println("Median is "
                + sm.getMedian(cArr, 0, cArr.length - 1));
        //Top-Down Merge Sort tests.
        cArr = sm.toCharacterArray(s4);
        System.out.println("After Top-Down Merge Sort: ");
        sm.topDownMergeSort(cArr, 0, cArr.length - 1);
        sm.displayArr(cArr);
        System.out.println();

        cArr = sm.toCharacterArray(s4);
        System.out.println("Initial array: ");
        sm.displayArr(cArr);
        System.out.println("Median is "
                + sm.getMedian(cArr, 0, cArr.length - 1));
        //Bottom-Up Merge Sort tests.
        cArr = sm.toCharacterArray(s4);
        System.out.println("After Bottom-Up Merge Sort: ");
        sm.buMergeSort(cArr);
        sm.displayArr(cArr);
        System.out.println();

        //Shuffle tests.
        cArr = sm.toCharacterArray(s6);
        System.out.println("Initial array: ");
        sm.displayArr(cArr);
        System.out.println("After initial shuffle: ");
        sm.shuffle(cArr);
        sm.displayArr(cArr);
        System.out.println("Median is "
                + sm.getMedian(cArr, 0, cArr.length - 1));
        //Quicksort
        cArr = sm.toCharacterArray(s6);
        System.out.println("After Quicksort: ");
        sm.quickSort(cArr, 0, cArr.length - 1);
        sm.displayArr(cArr);

        //Optimaized Quicksort
        cArr = sm.toCharacterArray(s6);
        System.out.println("Median is "
                + sm.getMedian(cArr, 0, cArr.length - 1));
        System.out.println("After Optimized Quicksort: ");
        sm.optQuickSort(cArr, 0, cArr.length - 1);
        sm.displayArr(cArr);
        System.out.println();

        //Heap Sort tests
        cArr = sm.toCharacterArray(s7);
        System.out.println("Initial array: ");
        sm.displayArr(cArr);
        sm.heapSort(cArr);
        System.out.println("After Heapsort: ");
        sm.displayArr(cArr);
        System.out.println("Array of 100 randomly generated keys: ");
        for (int i = 0; i < arrI.length; i++) {
            arrI[i] = rand.nextInt(100);
            System.out.print(arrI[i]);
        }
        System.out.println();
        System.out.println("After Heapsort: ");
        sm.heapSort(arrI);
        sm.displayArr(arrI);
        System.out.println();

        //Priority Que tests
        System.out.print("Input for the Heap: ");
        cArr = sm.toCharacterArray(s8);
        sm.displayArr(cArr);
        //Load the heap.
        for (int i = 0; i < cArr.length; i++) {
            hpq.insert(cArr[i]);
        }
        hpq.displayHPQ();
        hpq.clearHeap();
        hpq.insert('P');
        hpq.displayHPQ();
        hpq.insert('R');
        hpq.displayHPQ();
        hpq.insert('I');
        hpq.displayHPQ();
        hpq.insert('O');
        hpq.displayHPQ();
        System.out.println("delMax(): " + hpq.delMax());
        hpq.displayHPQ();
        hpq.insert('R');
        hpq.displayHPQ();
        System.out.println("delMax(): " + hpq.delMax());
        hpq.displayHPQ();
        System.out.println("delMax(): " + hpq.delMax());
        hpq.displayHPQ();
        hpq.insert('I');
        hpq.displayHPQ();
        System.out.println("delMax(): " + hpq.delMax());
        hpq.displayHPQ();
        hpq.insert('T');
        hpq.displayHPQ();
        System.out.println("delMax(): " + hpq.delMax());
        hpq.displayHPQ();
        hpq.insert('Y');
        hpq.displayHPQ();
        System.out.println("delMax(): " + hpq.delMax());
        hpq.displayHPQ();
        System.out.println("delMax(): " + hpq.delMax());
        hpq.displayHPQ();
        System.out.println("delMax(): " + hpq.delMax());
        hpq.displayHPQ();
        hpq.insert('Q');
        hpq.displayHPQ();
        hpq.insert('U');
        System.out.println(hpq.getHeapSize());
        hpq.displayHPQ();
        hpq.insert('E');
        hpq.displayHPQ();
        System.out.println("delMax(): " + hpq.delMax());
        hpq.displayHPQ();
        System.out.println("delMax(): " + hpq.delMax());
        hpq.displayHPQ();
        System.out.println("delMax(): " + hpq.delMax());
        hpq.displayHPQ();
        hpq.insert('U');
        hpq.displayHPQ();
        System.out.println("delMax(): " + hpq.delMax());
        hpq.displayHPQ();
        hpq.insert('E');
        hpq.displayHPQ();
        System.out.println("delMax(): " + hpq.delMax());
        hpq.displayHPQ();
        System.out.println(hpq);

        //Priority Que tests
        System.out.print("Input for the Heap: ");
        cArr = sm.toCharacterArray(s9);
        sm.displayArr(cArr);
        //Load the heap.
        for (int i = 0; i < cArr.length; i++) {
            hpq.insert(cArr[i]);
        }
        hpq.displayHPQ();
        System.out.println(hpq);
        System.out.println("delMax: " + hpq.delMax());
        System.out.println("delMax: " + hpq.delMax());
        System.out.println("delMax: " + hpq.delMax());
        System.out.println("delMax: " + hpq.delMax());

        //MinPriority Que tests
        System.out.print("Input for the MinHeap: ");
        cArr = sm.toCharacterArray(s9);
        sm.displayArr(cArr);
        //Load the heap.
        for (int i = 0; i < cArr.length; i++) {
            mpq.insert(cArr[i]);
        }
        mpq.displayHPQ();
        System.out.println("delMin: " + mpq.delMin());
        System.out.println("Heap size: " + mpq.getHeapSize());
        System.out.println("delMin: " + mpq.delMin());
        System.out.println("Heap size: " + mpq.getHeapSize());
        System.out.println("delMin: " + mpq.delMin());
        System.out.println("Heap size: " + mpq.getHeapSize());
        System.out.println("delMin: " + mpq.delMin());
        System.out.println("Heap size: " + mpq.getHeapSize());
        System.out.println(mpq);

     //end main   
    }

//end class    
}

/*
OUTPUT

run:
10^3
Quicksort at 1000.0. Runtime:               0 milliseconds.
Optimized Quicksort at 1000.0. Runtime:     0 milliseconds.
Heapsort at 1000.0. Runtime:                0 milliseconds.
Natural Merge Site at 1000.0. Runtime:      0 milliseconds.
Initial gap size for Shellsort is: 364
Shellsort at 1000.0. Runtime:               16 milliseconds.
Bottom-Up Mergersor at 1000.0. Runtime:     6 milliseconds.
Top-Down Mergersor at 1000.0. Runtime:      0 milliseconds.
Insertion Sort at 1000.0. Runtime:          16 milliseconds.
Select Sort at 1000.0. Runtime:             0 milliseconds.

10^4
Quicksort at 10000.0. Runtime:               15 milliseconds.
Optimized Quicksort at 10000.0. Runtime:     0 milliseconds.
Heapsort at 10000.0. Runtime:                16 milliseconds.
Natural Merge Site at 10000.0. Runtime:      15 milliseconds.
Initial gap size for Shellsort is: 9841
Shellsort at 10000.0. Runtime:               16 milliseconds.
Bottom-Up Mergersor at 10000.0. Runtime:     424 milliseconds.
Top-Down Mergersor at 10000.0. Runtime:      416 milliseconds.
Insertion Sort at 10000.0. Runtime:          501 milliseconds.
Select Sort at 10000.0. Runtime:             586 milliseconds.

10^5
Quicksort at 100000.0. Runtime:               68 milliseconds.
Optimized Quicksort at 100000.0. Runtime:     63 milliseconds.
Heapsort at 100000.0. Runtime:                185 milliseconds.
Natural Merge Site at 100000.0. Runtime:      301 milliseconds.
Initial gap size for Shellsort is: 88573
Shellsort at 100000.0. Runtime:               227 milliseconds.

10^6
Quicksort at 1000000.0. Runtime:               1280 milliseconds.
Optimized Quicksort at 1000000.0. Runtime:     1247 milliseconds.
Heapsort at 1000000.0. Runtime:                3942 milliseconds.
Natural Merge Site at 1000000.0. Runtime:      4357 milliseconds.
Initial gap size for Shellsort is: 797161
Shellsort at 1000000.0. Runtime:               4018 milliseconds.

10^7
Quicksort at 1.0E7. Runtime:               13087 milliseconds.
Optimized Quicksort at 1.0E7. Runtime:     12419 milliseconds.

Median is O
Initial array: 
E, A, S, Y, S, H, E, L, L, S, O, R, T, Q, U, E, S, T, I, O, N, 
Initial gap size for Shellsort is: 13
After Shell Sort: 
A, E, E, E, H, I, L, L, N, O, O, Q, R, S, S, S, S, T, T, U, Y, 

Initial array: 
z, b, b, b, b, b, b, b, b, b, b, b, b, b, b, b, b, b, b, b, b, b, b, b, a, 
Median is b
After Insertion Sort: 
a, b, b, b, b, b, b, b, b, b, b, b, b, b, b, b, b, b, b, b, b, b, b, b, z, 
After Paramater Insertion Sort: a, b, b, b, b, b, b, b, b, b, b, b, b, b, b, 
b, b, b, b, b, b, b, b, b, z, 

Initial array: 
S, O, R, T, I, N, G, I, S, N, O, J, O, K, E, 
Median is I
After Select Sort: 
E, G, I, I, J, K, N, N, O, O, O, R, S, S, T, 

Initial array: 
T, H, I, S, I, S, A, G, O, O, D, A, R, R, A, Y, T, O, S, O, R, T, 
Median is T
After Bubble Sort: 
A, A, A, D, G, H, I, I, O, O, O, O, R, R, R, S, S, S, T, T, T, Y, 

Initial array: 
1, 2, 3, 4, 5, 6, 7, 8, 9, 
Median is 5
After Top-Down Merge Sort: 
A, A, A, D, G, H, I, I, O, O, O, O, R, R, R, S, S, S, T, T, T, Y, 

Initial array: 
T, H, I, S, I, S, A, G, O, O, D, A, R, R, A, Y, T, O, S, O, R, T, 
Median is T
After Bottom-Up Merge Sort: 
A, A, A, D, G, H, I, I, O, O, O, O, R, R, R, S, S, S, T, T, T, Y, 

Initial array: 
a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, 
After initial shuffle: 
z, b, v, q, s, f, d, h, a, m, o, n, x, r, c, j, g, u, l, y, t, i, p, e, w, k, 
Median is x
After Quicksort: 
a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, 
Median is m
After Optimized Quicksort: 
a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, 

Initial array: 
H, E, A, P, S, O, R, T, I, S, D, R, I, V, I, N, G, M, E, C, R, A, Z, Y, 
After Heapsort: 
A, A, C, D, E, E, G, H, I, I, I, M, N, O, P, R, R, R, S, S, T, V, Y, Z, 
Array of 100 randomly generated keys: 
83864025918586214373933751676095317997558848678987693590273585532553944256919
05176285485050702181651130153242581928638572352980673592326267140683811306996
295469003361897416201391393056461264
After Heapsort: 
0, 0, 1, 3, 3, 4, 5, 6, 6, 9, 11, 12, 13, 15, 16, 17, 19, 20, 21, 21, 23, 25,
25, 26, 26, 27, 28, 29, 30, 30, 31, 32, 33, 35, 35, 35, 37, 40, 40, 42, 42,
43, 46, 46, 48, 50, 50, 51, 53, 53, 55, 56, 56, 58, 59, 60, 61, 62, 62, 63, 
64, 65, 67, 68, 70, 71, 72, 73, 73, 74, 76, 78, 79, 80, 81, 81, 83, 85, 85, 
85, 85, 86, 86, 86, 88, 89, 90, 90, 90, 91, 91, 91, 93, 93, 94, 95, 95, 97,
98, 99, 

Input for the Heap: P, R, I, O, R, I, T, Y, Q, U, E, U, E, 
Heap: YUURTRIOQPEIE
Heap: P
Heap: RP
Heap: RPI
Heap: RPIO
delMax(): R
Heap: POI
Heap: RPIO
delMax(): R
Heap: POI
delMax(): P
Heap: OI
Heap: OII
delMax(): O
Heap: II
Heap: TII
delMax(): T
Heap: II
Heap: YII
delMax(): Y
Heap: II
delMax(): I
Heap: I
delMax(): I
Heap: 
Heap: Q
2
Heap: UQ
Heap: UQE
delMax(): U
Heap: QE
delMax(): Q
Heap: E
delMax(): E
Heap: 
Heap: U
delMax(): U
Heap: 
Heap: E
delMax(): E
Heap: 
HEAP[null]
Input for the Heap: 3, 0, 5, 6, 7, 4, 9, 2, 1, 8, 
Heap: 9872634015
HEAP[9, 8, 7, 2, 6, 3, 4, 0, 1, 5]
delMax: 9
delMax: 8
delMax: 7
delMax: 6
Input for the MinHeap: 3, 0, 5, 6, 7, 4, 9, 2, 1, 8, 
Heap: 0142759638
delMin: 0
Heap size: 9
delMin: 1
Heap size: 8
delMin: 2
Heap size: 7
delMin: 3
Heap size: 6
HEAP[4, 6, 5, 8, 7, 9]
BUILD SUCCESSFUL (total time: 48 seconds)


*/
