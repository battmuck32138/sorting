/*
Mathew Buck
CIS 27 Lab 2
 */
package driversorts;

//Heap that is ordered with the smallest value at the top of the tree.
//Can be used to get item with the lowest value. 
public class MinPriorityQue {
    
   private Comparable[] heap;
   private int heapSize;
   private int capacity;
   
   //-------------------------------------------------------------------------
   //Constructor
   public MinPriorityQue(int capacity){
       this.capacity = capacity + 1;
       heap = new Comparable[this.capacity];
       heapSize = 0;
   }
    
   //-------------------------------------------------------------------------
   //Deletes returns and deletes the item with the hights priority.
   public Comparable delMin(){
       //Preserve item to be deleted.
       Comparable item = heap[1];
       if(isEmpty()){
           System.out.println("Heap is empty.");
           return null;
       }
       sink();
       return item;
   }
   
   //-------------------------------------------------------------------------
   //Sinks item from the top of the tree to it's porpper position 
   //in the tree.
   public void sink(){
       int oldTop = 1;//Top of the heap.
       int newTop = 2;//New top of the heap after deletion will be left child.
       Comparable tmp = heap[heapSize];//tmp is the last node in the heap.
       heapSize--;
       heap[1] = null;//Null out the deleted element.
       while(newTop <= heapSize){
           //If newTop (left child) > right child. 
           if(newTop < heapSize 
                   && heap[newTop].compareTo(heap[newTop + 1]) > 0){
               //The smaller value (right child) becomes the new top.
               newTop++;
           }
           //If new top >= the last node in the tree I'm done.
           if(heap[newTop].compareTo(tmp) >= 0){
               break;
           }
           //swap old top for new top.
           heap[oldTop] = heap[newTop];
           oldTop = newTop;
           newTop *= 2;
       }
       heap[oldTop] = tmp;
   }
   
   //-------------------------------------------------------------------------
   public boolean isEmpty(){
       return heapSize == 0;
   }
   
   //-------------------------------------------------------------------------
   public int getHeapSize(){
       return heapSize;
   }
   
   //-------------------------------------------------------------------------
   public void clearHeap(){
       heap = new Comparable[capacity];
       heapSize = 0;
   }
   
   //-------------------------------------------------------------------------
   //Adds an item the bottom of the HPQ tree and swimms it up to 
   //it's propper place.
   public void insert(Comparable item){
       heap[++heapSize] = item;
       swim(heapSize);
   }
   
   //-------------------------------------------------------------------------
   //Swimms the last item in the HPQ up to it's 
   //propper position on the tree.
   public void swim(int index){   
       Comparable item = heap[index];
       //Change < to > to convert into a minPriorityQue.
       while(index > 1 && heap[index/2].compareTo(item) > 0){
           Comparable tmp = heap[index/2];
           heap[index/2] = item;
           heap[index] = tmp;
           index /=2;
       }
   }
   
   public String toString(){
       String s = "HEAP[";
       for(int i = 1; i < heapSize; i++ ){
           s += heap[i];
           s += ", ";
       }
       s += heap[heapSize];
       s += "]";
       return s;
   }
    
   //-------------------------------------------------------------------------
   public void displayHPQ(){
       System.out.print("Heap: ");
       //First element of Heap is always empty.
       for(int i = 1; i <= heapSize; i++ ){
           System.out.print(heap[i]);
       }
       System.out.println();
   }
}

