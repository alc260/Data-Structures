import java.util.*;

public class MaxHeap {

  private static final int DEFAULT_CAPACITY = 20;
  private int nextPosition = 0;
  private long[] values;
  
  public MaxHeap() {
    values = new long[DEFAULT_CAPACITY];
  }
  
  public MaxHeap(int initialCapacity) {
    values = new long[initialCapacity];
  }
  
  public MaxHeap(long[] array) {
    this.values = array;
    for (int i = 1; i < values.length; i++) {
      reheapUp(i);
    }
    nextPosition = values.length;
  }
  
  public static void heapsort(long[] array) {
    // TODO: implement the heap sort algorithm. "array" should be sorted in place - i.e., don't create a copy.
    // NOTE: since this method is static, you can instantiate a MaxHeap using the array parameter.
    int n = array.length;
    MaxHeap mh = new MaxHeap(array);
    for (int i = n - 1; i>=0; i--){
      //move root to end (index i)
      long temp = array[0];
      array[0] = array[i];
      array[i] = temp;

      //re max heap
      mh.heapify(array, 0, i);

      //print array
      /*System.out.println("Array is");
        for (int k=0; k<n; ++k)
            System.out.print(array[k]+" ");
        System.out.println(); */
    }
  }

  public void heapify(long[] arr, int i, int j){
    for(int k = i; k < j; k++){
      reheapUp(k);
    }s
  }

  public long remove(){ // remove largest value
    for (int i = 1; i < values.length; i++) {
      reheapUp(i);
    }
    long max = values[0];
    values = Arrays.copyOfRange(values, 1, values.length);
    nextPosition--;
    for (int i = 1; i < values.length; i++) {
      reheapUp(i);
    }
    return max;
  }
  
  public boolean isEmpty() {
    return nextPosition == 0;
  }
  
  public void add(long value) {
    ensureCapacity();
    values[nextPosition] = value;
    reheapUp(nextPosition);
    nextPosition++;
  }
  
  public long getMax() {
    if (this.isEmpty()) {
      throw new UnsupportedOperationException("Heap is empty.");
    }
    return values[0];
  }
  
  private void reheapDown(int i) {
    int maxChild = getMaxChildIndex(i);
    if (maxChild > -1) {
      if (values[i] < values[maxChild]) {
        swap(i, maxChild);
        reheapDown(maxChild);
      }
    }
  }
  
  private void reheapUp(int i) {
    int parent = (i - 1) / 2;
    if (parent >= 0) {
      if (values[parent] < values[i]) {
        swap(i, parent);
        reheapUp(parent);
      }
    }
  }
    
  private void ensureCapacity() {
    if (nextPosition >= values.length) {
      long[] temp = new long[values.length * 2 + 1];
      System.arraycopy(values, 0, temp, 0, values.length);
      values = temp;
    }
  }
  
  private void swap(int a, int b) {
    long temp = values[a];
    values[a] = values[b];
    values[b] = temp;
  }

  private int getMaxChildIndex(int i) {
    int left = 2 * i + 1;
    if (left >= nextPosition) {
      return -1;
    } else {
      int right = 2 * i + 2;
      if (right >= nextPosition || values[left] > values[right]) {
        return left;
      } else {
        return right;
      }
    }
  }
}

/* For this assignment, your goal is to complete a MaxHeap and implement a heapsort algorithm.  A mostly-implemented MaxHeap has been provided for you.

25 points: code compiles
15 points: working implementation of heapsort
5 points: proper implementation of remove method
5 points: grader's discretion
*/