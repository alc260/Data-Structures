//Ava Chong
//James 0445 Assignment 1
//Due 1/22/18

import java.util.*;

public class StringArrayList implements StringList {

String[] StringArrayList = new String[10];
int size = 0;
int capacity = 10;

private void ensureCapactiy(){
    if (size == capacity){
      capacity = capacity*2;
      String[] arrayCopy = new String[capacity];
      System.arraycopy(StringArrayList, 0, arrayCopy, 0, size);
      StringArrayList = arrayCopy;
  }
}

private void print() {
  String s = "";
  for (int i = 0; i < size(); i++) {
    System.out.print(s);
    System.out.print(StringArrayList[i]);
    s = ",";
  }
  System.out.println();
}
  /**
  * Add a String to this list.
   @return the index where this String was inserted.
  */

  public int add(String s){
  ensureCapactiy();
  StringArrayList[size] = s;
  size ++;
  return size-1;
  }
  /**
  * Retrieve the String at position i.
  */
  public String get(int i){
  String word = StringArrayList[i];
  return word;
  }
  /**
  * Return true if this list contains String s.
  */
  public boolean contains(String s){
  return indexOf(s) != -1;
  }
  /**
  * Return the index of String s in this list, or -1 if s is not in this list.
  */

  public int indexOf(String s){
  int index = -1;
  for (int i = 0; i < size; i++){
    if (s.equals(StringArrayList[i])){
      index = i;
      i = size;
    }
  }
  return index;
  }

  /**
  * Return the current size of this list.
  */

  public int size(){
  return size;
  }
  /**
  * Insert a string into this list in the specified index.
  * Note that this should move the rest of the values in the list.
  * @return the index where this String was inserted.
  */
  public int add(int index, String s){

  ensureCapactiy();
  int n = size-index;
  String[] Copy = new String[n];
  System.arraycopy(StringArrayList, index, Copy, 0, n);
  System.arraycopy(Copy, 0, StringArrayList, index+1, n);
  StringArrayList[index] = s;
  size++;
  return index;

  }
  /**
  * Remove all strings from this list.
  */
  public void clear(){
  size = 0;
  }
  /**
  * Return true if this list is empty, false otherwise.
  */
  public boolean isEmpty(){
  boolean empty = false;
  if (size == 0)
  {
    empty = true;
  }
  return empty;
  }

  /**
  * Remove a String at the specified position.
  * Note that all other values should move to fill the gap.
  */
  public String remove(int index){
  ensureCapactiy();
  String word = StringArrayList[index];
  int copySize = size - index;
  String[] Copy = new String[copySize];
  int n = size-index-1;
  System.arraycopy(StringArrayList, index+1, Copy, 0, n);
  System.arraycopy(Copy, 0, StringArrayList, index, n);
  size = size - 1;
  return word;
  }

  /**
  * Set the value of the String in position index.
  */
  public void set(int index, String s){
  ensureCapactiy();
  StringArrayList[index] = s;
  }
  /**
    * Return an array representation of this list.
  */
  public String[] toArray(){
  String[] StringArrayListCopy = new String[size];
  System.arraycopy(StringArrayList, 0, StringArrayListCopy, 0, size);
  return StringArrayListCopy;
  }
}
