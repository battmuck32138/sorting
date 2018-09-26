/*
Mathew Buck
CIS 27 Lab 2
 */
package drivernaturalmergesortlinkedlist;

import java.util.Random;

//Test code for natural merge sort on double linked list.
public class DriverNaturalMergeSortLinkedList {

    public static void main(String[] args) {
        DLinkedList ll1 = new DLinkedList();
        String s1 = "abcde";
        DLinkedList ll2 = new DLinkedList();
        String s2 = "SORTMEWITHNATURALMERGESORT";
        DLinkedList ll3 = new DLinkedList();//random numbers
        int size = 15;
        Random rand = new Random();
        DLinkedList ll4 = new DLinkedList();
        String s4 = "abcdefacfg";
        DLinkedList ll5 = new DLinkedList();
        DLinkedList ll6 = new DLinkedList();
        DLinkedList ll7 = new DLinkedList();


        //moveBefore() tests
        for (int i = 0; i < s1.length(); i++) {
            ll1.addLast(s1.charAt(i));
        }
        System.out.println(ll1);
        System.out.println("head=" + ll1.getNode(1) + " tail=" 
                + ll1.getNode(ll1.getSize()));
        System.out.print(ll1.getNode(5));
        System.out.println(ll1.getNode(1));
        ll1.moveBefore(ll1.getNode(5), ll1.getNode(1));
        System.out.println(ll1);
        System.out.println("head=" + ll1.getNode(1) + " tail=" 
                + ll1.getNode(ll1.getSize()));
        System.out.println();

        //merge() tests
        for (int i = 0; i < s4.length(); i++){
            ll4.addLast(s4.charAt(i));
        }
        System.out.println(ll4);
        ll4.mergeLL(ll4.getNode(1), 6, ll4.getNode(7), 4);
        System.out.println(ll4);
        System.out.println();
        ll6.addFirst(5);
        ll6.addLast(18);
        ll6.addLast(20);
        ll6.addLast(22);
        ll6.addLast(30);
        ll6.addLast(72);
        ll6.addLast(50);
        ll6.addLast(45);
        ll6.addLast(22);
        ll6.addLast(27);
        ll6.addLast(19);
        ll6.addLast(60);
        ll6.addLast(72);
        ll6.addLast(15);
        System.out.println(ll6);
        ll6.mergeLL(ll6.getNode(9), 2, ll6.getNode(11), 3);
        System.out.println(ll6);
        System.out.println("head= " + ll6.getHead() 
                + "  tail= " + ll6.getTail());
        System.out.println();

        //naturalMergeSort() tests
        ll5.addLast(5);
        ll5.addLast(20);
        ll5.addLast(30);
        ll5.addLast(18);
        ll5.addLast(22);
        ll5.addLast(72);
        ll5.addLast(50);
        ll5.addLast(45);
        ll5.addLast(22);
        ll5.addLast(27);
        ll5.addLast(19);
        ll5.addLast(60);
        ll5.addLast(72);
        ll5.addLast(15);
        System.out.println(ll5);
        ll5.naturalMergeSortLL(ll5);
        System.out.println(ll5);
        
        for (int i = 0; i < s2.length(); i++) {
            ll2.addLast(s2.charAt(i));
        }
        System.out.println(ll2);
        ll2.naturalMergeSortLL(ll2);
        System.out.println(ll2);
        System.out.println(ll2);
        
        for (int i = 0; i < size; i++) {
            ll3.addLast((Integer) rand.nextInt(100));
        }
        System.out.println(ll3);
        ll3.naturalMergeSortLL(ll3);
        System.out.println(ll3);
        System.out.println();
        
        for (int i = 0; i < size; i++) {
            ll7.addLast((Integer) rand.nextInt(100));
        }
        System.out.println(ll7);
        ll7.naturalMergeSortLL(ll7);
        System.out.println(ll7);

        //end main
    }

//end class    
}

/*
OUTPUT

run:
LL1 Sz:5 [a, b, c, d, e]
head=a tail=e
ea
LL1 Sz:5 [b, c, d, e, a]
head=b tail=a

LL4 Sz:10 [a, b, c, d, e, f, a, c, f, g]
LL4 Sz:10 [a, a, b, c, c, d, e, f, f, g]

LL6 Sz:14 [5, 18, 20, 22, 30, 72, 50, 45, 22, 27, 19, 60, 72, 15]
LL6 Sz:14 [5, 18, 20, 22, 30, 72, 50, 45, 19, 22, 27, 60, 72, 15]
head= 5  tail= 15

LL5 Sz:14 [5, 20, 30, 18, 22, 72, 50, 45, 22, 27, 19, 60, 72, 15]
LL5 Sz:14 [5, 15, 18, 19, 20, 22, 22, 27, 30, 45, 50, 60, 72, 72]
LL2 Sz:26 [S, O, R, T, M, E, W, I, T, H, N, A, T, U, R, A, L, M, E, R, G, E,
S, O, R, T]
LL2 Sz:26 [A, A, E, E, E, G, H, I, L, M, M, N, O, O, R, R, R, R, S, S, T, T,
T, T, U, W]
LL2 Sz:26 [A, A, E, E, E, G, H, I, L, M, M, N, O, O, R, R, R, R, S, S, T, T, 
T, T, U, W]
LL3 Sz:15 [62, 26, 70, 5, 34, 92, 52, 63, 14, 46, 45, 36, 42, 15, 54]
LL3 Sz:15 [5, 14, 15, 26, 34, 36, 42, 45, 46, 52, 54, 62, 63, 70, 92]

LL7 Sz:15 [35, 84, 9, 86, 40, 58, 85, 94, 27, 48, 6, 51, 3, 74, 43]
LL7 Sz:15 [3, 6, 9, 27, 35, 40, 43, 48, 51, 58, 74, 84, 85, 86, 94]
BUILD SUCCESSFUL (total time: 0 seconds)


 */