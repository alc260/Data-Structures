//Ava Chong
//0445 Assignment 5

public class StudentHashSet {

  int capacity = 100; 
  int size = 0;
  Student[] myArray; 

  public StudentHashSet(int n)
  {
    myArray = new Student[n];
    capacity = n;
  }

  public StudentHashSet()
  {
    myArray = new Student[100];
  }

  public void add(Student s) {
    boolean contains = contains(s);
    if (contains == false){
      if (size == capacity){ //resize array
        size = 0;
        int oldCapacity = capacity; 
        capacity = capacity * 2;
        Student[] newArray = new Student[capacity];
        for (int i = 0; i < oldCapacity; i++){
          Student s2 = myArray[i];
          if (s2 != null){
            int hashCode2 = s2.hashCode();
            int index2 = Math.abs(hashCode2) % capacity;
            boolean loop = true;
            do {
              if (newArray[index2] == null){
                newArray[index2] = s;
                size ++;
                loop = false;
                }
                if (index2 == (capacity-1)){
                  index2 = 0; 
                }
                else{
                  index2++;
                }
              } while (loop == true);
          }
        }
        myArray = newArray;
      }

      int hashCode = s.hashCode();
      int index = Math.abs(hashCode) % capacity;
      
      boolean loop = true;
      do {
        if (myArray[index] == null){
          myArray[index] = s;
          size ++;
          loop = false;
        }
        if (index == (capacity-1)){
          index = 0; 
        }
        else{
          index++;
        }
      } while (loop == true);
    }
    else{
      System.out.println("Cannot add the same student twice");
    }
  }
  
  public boolean remove(Student s) {
    boolean remove = false;
    int foundIndex = 0;
    boolean contains = contains(s);
    if (contains == true){
      int hashCode = s.hashCode();
      int index = Math.abs(hashCode) % capacity; 
      int counter = 0;
      boolean loop = true;
      do{
        if(myArray[index].equals(s)){
          foundIndex = index;
          loop = false;
          remove = true;
        }
        if (index == (capacity-1)){
          index = 0;
          counter++;
        }
        else{
          index++;
          counter++;
        }
      } while (loop == true && counter != size);
      if (remove == true){
        myArray[foundIndex] = null;
        size --;
      }
      Student[] newArray = new Student[capacity];
      for (int i = 0; i < capacity; i++){
        Student s2 = myArray[i];
        if (s2 != null){
          int hashCode2 = s2.hashCode();
          int index2 = Math.abs(hashCode2) % capacity;
          boolean loop2 = true;
          do {
            if (newArray[index2] == null){
              newArray[index2] = s;
              size ++;
              loop2 = false;
              }
              if (index2 == (capacity-1)){
                index2 = 0; 
              }
              else{
                index2++;
              }
            } while (loop2 == true);
        }
      }
      myArray = newArray;
      }
      return remove;
  }

  public boolean contains(Student s) {
    int hashCode = s.hashCode();
    int index = Math.abs(hashCode) % capacity; 
    boolean contains = false;
    int counter = 0; 
    boolean loop = true;    
    do{
      if (myArray[index] == null){
        contains = false;
        loop = false;
      }
      else if(myArray[index] == s){
        contains = true;
        loop = false;
      }
      if (index == (capacity-1)){
        index = 0;
        counter++;
      }
      else{
        index++;
        counter++;
      }
    } while (loop == true && counter != size);
    return contains;
  }
  
  public int size() {
    return size;
  }
}

/*
The purpose of this assignment is to give you practice writing hashing functions and storing objects in a Hash Set.

Attached you will find 3 classes.  For ProductRecord and Student, review the code and try to understand what the class might be used for.  
Think about how a hash function should be implemented for each of the classes.  Implement the hashCode method for each of these.

Once you've finished writing a hashCode method for Student and ProductRecord, create a Hash Set class for storing Student objects.  
This Hash Set should use a linear probing collision resolution strategy.

When you're finished, submit your 3 Java files and the answers to the following questions in a .txt file:

Why do we implement hashCode on individual objects, instead of centrally?  For example, why don't we create a new class with a method like getHashCodeFor(Object obj) for many different objects, or implement hashing functions in the hash table itself?
Can you create a hashing function for an object that only has transient / mutable data?  Why or why not?
Let's say we have an object that has limited variability in its data - say, only 1000 possible combinations of values.  Can we create a hash code for such an object?  Why or why not?
Grading:

25 points - code compiles and public method names are unchanged
3 points - Hash code for ProductRecord: is repeatable, has few collisions
3 points - Hash code for Student: is repeatable, has few collisions
8 points - StudentSet is implemented properly with linear probing and passes tests
2 points - answer to question 1
2 points - answer to question 2
2 points - answer to question 3
5 points - style / grader's discretion

*/ 
