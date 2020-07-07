//0445 Assignment 4 
//Ava Chong

public class InsertionSorter implements IntSorter {

    //Iterate through the array, 
    //every value that’s not in the right place, 
    //keep swapping backwards until its in the right place

    private int[] array = null;
    private int moves = 0;
    private long startTime = 0;
    private long endTime = 0;

  public void init(int[] a){
    this.array = a;
    moves = 0; 
  }

//Sort array using Insertion Sort
public void sort() {
  startTime = System.nanoTime();
  boolean done = false;
  int k = 0;
  while (!done) {
    done = true;
    for (int i = 0; i < array.length - 1; i++) {
      k = i; 
      while (array[k] > array[k + 1]) {
        swap(array, k, k + 1);
        if (k!=0){
          k --;
          done = false;
        }
      }
    }
  }
  endTime = System.nanoTime();
}

  //Swaps values in array
  private void swap(int[] values, int p1, int p2) {
    int temp = values[p1];
    values[p1] = values[p2];
    values[p2] = temp;
    moves++;
  }

   //Returns the number of moves (swaps) made in your sort.
  public int getMoves(){
    return moves;
  }

  //Return the number of nanoseconds it took to *only* perform your sort.
  public long getSortTime(){
    return endTime - startTime;
  }

}