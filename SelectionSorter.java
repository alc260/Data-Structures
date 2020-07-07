
//Ava Chong
//0445 assignment 4

public class SelectionSorter implements IntSorter {

    //looks for the smallest things and swaps it to the beginning 
    private int[] array = null;
    private int moves = 0;
    private long startTime = 0;
    private long endTime = 0;
     /**
   * This method should initialize your class - reset the # of moves and perform any setup necessary.
   */
  public void init(int[] a){
      this.array = a;
      moves = 0; 
  }

  /**
   * This method should sort the values from init.
   */
  public void sort(){
    startTime = System.nanoTime();
    int smallest = array[0]; 
    int smallestIndex = 0;

      for (int i = 0; i < array.length - 1; i++){
        smallest = array[i];
        smallestIndex = i;
        //find smallest number 
        for (int j = i; j < array.length; j++){
          if (array[j] < smallest) {
            smallest = array[j];
            smallestIndex = j;
          }
        }
        //swap smallest to the front
        swap(array, i, smallestIndex);
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