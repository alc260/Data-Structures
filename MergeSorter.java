//Ava Chong
//0445 Assignment 4

public class MergeSorter implements IntSorter
{
   private int[] array = null;
   private int moves = 0;
   private long startTime = 0;
   private long endTime = 0;
   
   public void init(int[] a){
      this.array = a;
      moves = 0;
   }
   
   public void sort(){
      mergeSort(array, 0, array.length-1);
   }
   
   //sort method to mergesort
   public void mergeSort(int[] a, int start, int end){
       //repeat until subarrays of size 1
      if(start >= end)
      {
         return;
      }
      
      int mid = (start+end)/2;
      mergeSort(a,start,mid);
      mergeSort(a,mid+1,end);
      //merge two sorted arrays
      merge(a,start,mid,end);
   }
   //merge two arrays into a temp array
   public void merge(int[] a, int start, int mid, int end){
      int leftSide = mid - start + 1;
      int rightSide = end - mid;
      
      //create new arrays: one for each side
      int[] leftSideArray = new int[leftSide];
      int[] rightSideArray = new int[rightSide];
            
      for(int i = 0; i < leftSide; i++)
      {
         leftSideArray[i] = a[start+i];
         
      }
      
      for(int j = 0; j < rightSide; j++)
      {
         rightSideArray[j] = a[mid+1+j];
      }
      
      //merge two arrays into one
      int left = 0;
      int right = 0;
      int index = start;
      
      while(left < leftSide  && right < rightSide)
      {
         if(leftSideArray[left] <= rightSideArray[right])
         {
            a[index] = leftSideArray[left];
            left++;
            moves++;
         }
         else
         {
            a[index] = rightSideArray[right];
            right++;
            moves++;
         }
         index++;
      }
      //place remainder numbers into the array
      while(left < leftSide)
      {
         a[index] = leftSideArray[left];
         left++;
         index++;
      }
      while(right < rightSide)
      {
         a[index] = rightSideArray[right];
         right++;
         index++; 
      }
   }
   
   public int getMoves(){
      return moves;
   }
   
   public long getSortTime(){
      return startTime - endTime;
   }
}
