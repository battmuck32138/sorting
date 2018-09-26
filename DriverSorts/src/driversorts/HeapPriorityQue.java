/*
Mathew Buck
CIS 27 Lab 2
 */
package driversorts;

//Priority Que, heap implementation. 
public class HeapPriorityQue {
    
   private Comparable[] heap;
   private int heapSize;
   private int capacity;
   
   //-------------------------------------------------------------------------
   //Constructor
   public HeapPriorityQue(int capacity){
       this.capacity = capacity + 1;
       heap = new Comparable[this.capacity];
       heapSize = 0;
   }
    
   //-------------------------------------------------------------------------
   //Returns and deletes the item with the highest priority.
   public Comparable delMax(){
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
   //Sinks item from the top of the tree to its porpper position 
   //in the tree.
   public void sink(){
       int parent = 1;
       int child = 2;
       Comparable tmp = heap[heapSize--];
       heap[1] = null;
       while(child <= heapSize){
           if(child < heapSize && heap[child].compareTo(heap[child + 1]) < 0){
               child++;
           }
           if(heap[child].compareTo(tmp) <= 0){
               break;
           }
           heap[parent] = heap[child];
           parent = child;
           child *= 2;
       }
       heap[parent] = tmp;
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
       while(index > 1 && heap[index/2].compareTo(item) < 0){
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
 
//end class
}
