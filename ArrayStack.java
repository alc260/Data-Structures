//Ava Chong
//0445 Assignment 2
//Due 1/31

//implements a stack back by an array
public class ArrayStack<T> implements Stack<T>{

Object[] arrayStack = new Object[20];
int capacity = 20;
int size = 0;

    //remove and return
    public T pop(){ 
        if (size != 0)
        { 
            //temp value
            Object temp = arrayStack[size-1];
            arrayStack[size-1] = null;
            size --;  
            return(T) temp;
        }
        else {
            throw new UnsupportedOperationException();
        }
        //else return what?
    }
    //get
    public T peek(){
        if (size !=0){
            return(T) arrayStack[size-1];
        }
        else{
            return null;
        }
    }
    //add to the top
    public void push(T thing){
        //ensure cap
        ensureCap();
        arrayStack[size] = thing;
        size ++;
    }
    //check if empty
    public boolean isEmpty(){
        boolean empty = false;
        if (size == 0)
        {
          empty = true;
        }
        return empty;
    }
    //returns size
    public int size(){
        return size;
    }
    public void ensureCap(){
        if (size == capacity){
            capacity = capacity*2;
            Object[] arrayCopy = new Object[capacity];
            System.arraycopy(arrayStack, 0, arrayCopy, 0, size);
            arrayStack = arrayCopy;
        }
    }
}
