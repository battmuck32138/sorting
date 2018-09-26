import edu.princeton.cs.algs4.Queue;

public class MergeSort {
    /**
     * Removes and returns the smallest item that is in q1 or q2.
     *
     * The method assumes that both q1 and q2 are in sorted order, with the smallest item first. At
     * most one of q1 or q2 can be empty (but both cannot be empty).
     *
     * @param   q1  A Queue in sorted order from least to greatest.
     * @param   q2  A Queue in sorted order from least to greatest.
     * @return      The smallest item that is in q1 or q2.
     */
    private static <Item extends Comparable> Item getMin(
            Queue<Item> q1, Queue<Item> q2) {
        if (q1.isEmpty()) {
            return q2.dequeue();
        } else if (q2.isEmpty()) {
            return q1.dequeue();
        } else {
            // Peek at the minimum item in each queue (which will be at the front, since the
            // queues are sorted) to determine which is smaller.
            Comparable q1Min = q1.peek();
            Comparable q2Min = q2.peek();
            if (q1Min.compareTo(q2Min) <= 0) {
                // Make sure to call dequeue, so that the minimum item gets removed.
                return q1.dequeue();
            } else {
                return q2.dequeue();
            }
        }
    }

    /** Returns a queue of queues that each contain one item from items. */
    private static <Item extends Comparable> Queue<Queue<Item>>
            makeSingleItemQueues(Queue<Item> items) {
        Queue<Queue<Item>> queuesQueue = new Queue<>();
        for (Item item : items) {
            Queue<Item> singleItemQ = new Queue<>();
            singleItemQ.enqueue(item);
            queuesQueue.enqueue(singleItemQ);
        }
        return queuesQueue;
    }

    /**
     * Returns a new queue that contains the items in q1 and q2 in sorted order.
     *
     * This method should take time linear in the total number of items in q1 and q2.  After
     * running this method, q1 and q2 will be empty, and all of their items will be in the
     * returned queue.
     *
     * @param   q1  A Queue in sorted order from least to greatest.
     * @param   q2  A Queue in sorted order from least to greatest.
     * @return      A Queue containing all of the q1 and q2 in sorted order, from least to
     *              greatest.
     *
     */
    private static <Item extends Comparable> Queue<Item> mergeSortedQueues(
            Queue<Item> q1, Queue<Item> q2) {
        Queue<Item> aux = new Queue<>();
        while (!q1.isEmpty() && !q2.isEmpty()) {
            aux.enqueue(getMin(q1, q2));
        }
        if (q1.isEmpty()) {
            for (Item item : q2) {
                aux.enqueue(q2.dequeue());
            }
        } else {
            for (Item item : q1) {
                aux.enqueue(q1.dequeue());
            }
        }
        return aux;
    }

    /** Returns a Queue that contains the given items sorted from least to greatest. */
    public static <Item extends Comparable> Queue<Item> mergeSort(
            Queue<Item> items) {
        if (items == null || items.size() == 1) {
            return items;
        }
        Queue<Item> firstHalf = new Queue<>();
        Queue<Item> secondHalf = new Queue<>();
        int half = items.size() / 2;
        while (half > 0) {
            firstHalf.enqueue(items.dequeue());
            half--;
        }
        while (!items.isEmpty()) {
            secondHalf.enqueue(items.dequeue());
        }
        firstHalf = mergeSort(firstHalf);
        secondHalf = mergeSort(secondHalf);
        return mergeSortedQueues(firstHalf, secondHalf);
    }




        public static int slowlyCountStairWays(int n) {
            if (n == 1) {
                return 1;
            }

            if (n == 2) {
                return 2;
            }

            return slowlyCountStairWays(n - 1) + slowlyCountStairWays(n - 2);

        }


    public static int countChange(int n) {
        int[] ways = new int[n + 1];
        ways[0] = 1;
        for (int coin = 1; coin <= n; coin *= 2) {
            for (int i = coin; i <= n; i++) {
                ways[i] += ways[i - coin];
            }
        }
        return ways[n];
    }








    public static void main(String[] args) {

        /*
        Queue<String> q = new Queue<>();
        q.enqueue("Vanessa");
        q.enqueue("Alice");
        q.enqueue("Ethan");
        q.enqueue("Matt");
        q.enqueue("Jay");
        q.enqueue("Zena");
        q.enqueue("Becky");
        System.out.println("q before: " + q.toString());
        Queue<String> sortedQ = MergeSort.mergeSort(q);
        System.out.println("q after: " + q.toString());
        System.out.println("sortedQ: " + sortedQ.toString());
        Queue<Integer> evens = new Queue<>();
        Queue<Integer> odds = new Queue<>();
        evens.enqueue(2);
        evens.enqueue(4);
        evens.enqueue(6);
        evens.enqueue(8);
        odds.enqueue(1);
        odds.enqueue(3);
        odds.enqueue(5);
        odds.enqueue(7);
        System.out.println("evens before: " + evens.toString());
        System.out.println("odds before: " + odds.toString());
        Queue<Integer> sortedNums = MergeSort.mergeSortedQueues(evens, odds);
        System.out.println(sortedNums.toString());
        System.out.println();
        */


        System.out.println(countChange(8));



    }



}
