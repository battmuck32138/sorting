/*
Mathew Buck
CIS 27 Lab 2
 */
package drivernaturalmergesortlinkedlist;

//Double Linked List with Natural Mergesort Method.
//Linked list holds data in nodes 1 to n (index 0 is out of bounds).
public class DLinkedList {

    private Node first = null;
    private Node last = null;
    private int size = 0;
    public static int id = 1;
    private final int listNum = id;

    //default constructor
    DLinkedList() {
        first = null;
        last = null;
        size = 0;
        id++;
    }

    //Sorts a linked list 
    public void naturalMergeSortLL(DLinkedList ll) {
        Node head1;
        Node head2 = null;
        Node current = first;
        int size1 = 1;
        int size2 = 1;
        Node tmp;
        boolean done = false;
        //Break down list until bo more sublists exist.
        while (!done) {
            current = first;
            //Break down the list into sublists and merge them.
            while (current != null && current.next != null) {
                //Get first sub list.
                head1 = current;
                while (current.next != null
                        && current.compareTo(current.next) <= 0) {
                    size1++;
                    current = current.next;
                }
                current = current.next;
                head2 = current;
                //Get 2nd sublist.
                while (current != null && current.next != null
                        && current.compareTo(current.next) <= 0) {
                    size2++;
                    current = current.next;
                }
                if (current == null) {
                    tmp = current;
                } else {
                    tmp = current.next;
                }
                current = tmp;
                if (head2 != null) {
                    mergeLL(head1, size1, head2, size2);
                }
                //List is sorted at this point, the 2 sublists from the last
                //merge combine to = the list size.
                if (size1 + size2 >= ll.size) {
                    done = true;
                }
                size1 = 1;
                size2 = 1;
            }
        }
    }

    //Helper for mergeSort.
    //Merges 2 sorted lists of given sizes.
    public void mergeLL(Node head1, int size1, Node head2, int size2) {
        Node tmp;
        while (size1 > 0 && size2 > 0) {
            //Case: head of second list is smaller.
            if (head2.compareTo(head1) < 0) {
                tmp = head2.next;
                moveBefore(head1, head2);
                head2 = tmp;
                size2--;
            } //Case: head of 1st list is smaller.
            else {
                head1 = head1.next;
                size1--;
            }
        }
    }

    public void moveAfter(Node stays, Node moves) {
        //Case: nodes are the same, do nothing.
        if (stays.prev == moves.prev && stays.next == moves.next
                && stays.data == moves.data) {
            return;
        } //Case: moves is tail.
        else if (moves.next == null) {
            (moves.prev).next = null;
            last = moves.prev;
            moves.next = stays.next;
            stays.next = moves;
            moves.prev = stays;
        } //Case: moves is head.
        else if (moves.prev == null) {
            first = moves.next;
            moves.next = stays.next;
            (stays.next).prev = moves;
            stays.next = moves;
            moves.prev = stays;
        } //Case: moves is head, stays is tail.
        else if (moves.prev == null && stays.next == null) {
            first = moves.next;
            stays.next = moves;
            moves.prev = stays;
            moves.next = null;
            last = moves;
        } //Case: stays is tail.
        else if (stays.next == null) {
            stays.next = moves;
            moves.prev.next = moves.next;
            moves.next.prev = moves.prev;
            moves.prev = stays;
            moves.next = null;
            last = moves;
        } //Case: moves and stays are both between nodes.
        else {
            moves.prev.next = moves.next;
            moves.next.prev = moves.prev;
            moves.next = stays.next;
            stays.next = moves;
            moves.prev = stays;
        }
    }

    //Moves a node to the position before another node.
    public void moveBefore(Node stays, Node moves) {
        //Case: nodes are the same, do nothing.
        if (stays.prev == moves.prev && stays.next == moves.next
                && stays.data == moves.data) {
            return;
        } //Tested Case: stays is head and moves is tail.
        else if (stays.prev == null && moves.next == null) {
            (moves.prev).next = null;
            last = moves.prev;
            stays.prev = moves;
            moves.next = stays;
            moves.prev = null;
            first = moves;
        } //Tested Case: stays is tail and moves is head.
        else if (stays.next == null && moves.prev == null) {
            first = moves.next;
            moves.next = null;
            stays.next = moves;
            moves.prev = stays;
            last = moves;
        } //Tested Case: stays is between 2 nodes, moves is head.
        else if (stays.prev != null && stays.next != null
                && moves.prev == null) {
            first = moves.next;
            moves.next = stays;
            stays.prev.next = moves;
            moves.prev = stays.prev;
            stays.prev = moves;
        } //Tested Case: stays is between 2 nodes, moves is tail.
        else if (stays.prev != null && stays.next != null
                && moves.next == null) {
            (moves.prev).next = null;
            last = moves.prev;
            (stays.prev).next = moves;
            moves.prev = stays.prev;
            moves.next = stays;
            stays.prev = moves;
        } //Tested Case: stays is head moves is between 2 nodes.
        else if (stays.prev == null) {
            (moves.prev).next = moves.next;
            (moves.next).prev = moves.prev;
            moves.prev = null;
            moves.next = stays;
            stays.prev = moves;
            first = moves;
        } //Tested Case: stays is between 2 nodes, moves is between 2 nodes.
        else {
            (moves.prev).next = moves.next;
            (moves.next).prev = moves.prev;
            (stays.prev).next = moves;
            moves.prev = stays.prev;
            stays.prev = moves;
            moves.next = stays;
        }
    }

    //Returns a node at any index.
    public Node getNode(int position) {
        //case 1: nonexistant node
        if (position < 1 || position > size) {
            System.out.println("Nonexistant node.");
            return null;
        } //case 2: position is 1
        else if (position == 1) {
            return first;
        } //case: 3 position is last
        else if (position == size) {
            return last;
        }
        //case 4 position is in between 2 elements
        Node current = first;
        int count = 1;

        while (position > count) {
            current = current.next;
            count++;
        }
        return current;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int getSize() {
        return size;
    }

    //displays the size and contents of the nodes
    public void displayQue() {
        Node current = first;
        System.out.print("Size " + size + ": ");
        while (current != null) {
            current.displayNode();
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println();
    }

    //adds node to begining of the que
    public void addFirst(Comparable data) {
        Node newNode = new Node(data);
        //case 1: que is empty
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } //case 2: que is not empty
        else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;
    }

    //adds a node to end of the que
    public void addLast(Comparable data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    //removes node from the front of the que
    public void removeFirst() {
        //case 1: is empty
        if (isEmpty()) {
            System.out.println("DeQue is empty.");
        } //case 2: only one node in que
        else if (first.next == null) {
            first = null;
            last = null;
        } //case 3: multiple nodes in que
        else {
            first = first.next;
            first.prev = null;
        }
        if (size != 0) {
            size--;
        }
    }

    //removes node from the end of the que
    public void removeLast() {
        //case 1: is empty
        if (isEmpty()) {
            System.out.println("DeQue is empty.");
        } //case 2: only one node in que
        else if (first.next == null) {
            first = null;
            last = null;
        } //case 3: multiple nodes in que
        else {
            last = last.prev;
            last.next = null;
        }
        if (size != 0) {
            size--;
        }
    }

    //Adds a new node to a specifed index in the que
    //Enter the desired positon of the new node as first argument
    public void insertBefore(Comparable data, int position) {
        //case 1: que is empty
        if (isEmpty()) {
            addFirst(data);
            return;
        } //case 2: insert at the front of que
        else if (position <= 1 || first.next == null) {
            addFirst(data);
            return;
        } //case 3: insert at the end of que
        else if (position > size) {
            addLast(data);
            return;
        }
        //case 4: insert between 2 elements
        Node newNode = new Node(data);
        Node current = first;
        Node tmpPrev = null;
        int count = 1;
        while (position > count) {
            tmpPrev = current;
            current = current.next;
            count++;
        }
        newNode.prev = tmpPrev;
        newNode.next = current;
        tmpPrev.next = newNode;
        current.prev = newNode;
        size++;
    }

    //Inserts a node after the position in the argument.
    //Argument is data, not a node.
    public void insertAfter(Comparable data, int position) {
        int pos = position + 1;
        insertBefore(data, pos);
    }

    //removes a node from a given position in the que
    public void removeNode(int position) {
        //case 1: nonexistant node
        if (position < 1 || position > size) {
            System.out.println("Nonexistant node.");
        } //case 2: position is 1
        else if (position == 1) {
            removeFirst();
            return;
        } //case: 3 position is last
        else if (position == size) {
            removeLast();
            return;
        }

        //case 4 position is in between 2 elements
        Node current = first;
        Node tmpPrev = null;
        Node tmpNext = null;
        int count = 1;

        while (position > count) {
            tmpPrev = current;
            current = current.next;
            tmpNext = current.next;
            count++;
        }
        //All refrences are removed.
        tmpNext.prev = tmpPrev;
        tmpPrev.next = tmpNext;
        current = null;
        size--;
    }

    //Moves a node to the front of the que
    public void moveFront(int position) {
        //condition 1: position is 1 or nonexistant
        if (position <= 1 || position > size) {
            return;
        }
        //condition 2: postition is last
        if (position == size) {
            last.next = first;
            first.prev = last;
            first = last;
            last = first.prev;
            first.prev = null;
            last.next = null;
        } //case 2: postion is in between 2 nodes
        else {
            Node tmpPrev = null;
            Node current = first;
            Node tmpNext = null;
            int count = 1;

            while (count < position) {
                current = current.next;
                tmpPrev = current.prev;
                tmpNext = current.next;
                count++;
            }
            first.prev = current;
            current.prev = null;
            current.next = first;
            first = current;
            tmpPrev.next = tmpNext;
            tmpNext.prev = tmpPrev;
        }
    }

    //moves node to the end of the que
    public void moveEnd(int position) {
        //case 1: position is end of the que or nonexistant
        if (position >= size || position < 1) {
            return;
        }
        //case 2: position is first
        if (position == 1) {
            last.next = first;
            first.prev = last;
            first.next.prev = null;
            first = first.next;
            last = last.next;
            last.next = null;
        } else {
            //case 3: position is in between two nodes
            Node current = first;
            Node tmpPrev = null;
            Node tmpNext = null;
            int count = 1;

            while (position > count) {
                current = current.next;
                tmpPrev = current.prev;
                tmpNext = current.next;
                count++;
            }
            last.next = current;
            current.prev = last;
            last = current;
            last.next = null;
            tmpPrev.next = tmpNext;
            tmpNext.prev = tmpPrev;
        }
    }

    public Node getHead() {
        return first;
    }

    public Node getTail() {
        return last;
    }

    @Override
    public String toString() {
        String s = "LL" + listNum + " Sz:" + size + " [";
        Node current = first;
        while (current != null) {
            s += current.data;
            if (current != last) {
                s += ", ";
            }
            current = current.next;
        }
        s += "]";
        return s;
    }

    //helper class////////////////////////////////////////////////////////////
    private class Node implements Comparable<Node> {

        private Comparable data;
        private Node prev = null;
        private Node next = null;

        public Node(Comparable data) {
            this.data = data;
        }

        public Node getlinkNext() {
            return next;
        }

        public Node getLinkPrev() {
            return prev;
        }

        public void setLinkNext(Node node) {
            next = node;
        }

        public void displayNode() {
            System.out.print(data);
        }

        @Override
        public String toString() {
            return data.toString();
        }

        @Override
        public int compareTo(Node otherNode) {
            if (data.compareTo(otherNode.data) < 0) {
                return -1;
            }
            if (data.compareTo(otherNode.data) == 0) {
                return 0;
            } else {
                return 1;
            }
        }

    }//end helper class    

}//end class

