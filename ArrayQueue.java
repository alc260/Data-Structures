
//Ava Chong
//0445 Assignment 3
//Due 2/9

public class ArrayQueue<T> implements Queue<T>{

    Object[] arrayQueue = new Object[20];
    int capacity = 20; 
    int size = 0;
    int front = 0;
    int back = 0; 
    
        //remove and return
        public T remove(){ 
            if (size != 0)
            { 
                //temp value
                Object temp = arrayQueue[front];
                incrementFront();
                size --;
                return(T) temp;
            }
            else {
                throw new UnsupportedOperationException();
            }
        }

        //get
        public T peek(){
            if (size !=0){
                return(T) arrayQueue[front];
            }
            else{
                throw new UnsupportedOperationException();
            }
        }

        //add to the top
        public void add(T thing){
            //ensure cap
            ensureCap();
            arrayQueue[back] = thing;
            size ++;
            incrementBack();
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
            if ((back == front) && size != 0){
                capacity = (capacity*2)+1;
                Object[] arrayCopy = new Object[capacity];
                int copySize = (arrayQueue.length - 1) - front; 
                System.arraycopy(arrayQueue, front, arrayCopy, 0, copySize);
                System.arraycopy(arrayQueue, copySize + 1, arrayCopy, copySize + 1, front);
                arrayQueue = arrayCopy;
                front = 0;
                back = size;
            }
        }

        public void incrementBack(){
            if (back == (capacity-1)){
                back = 0;
            }
            else{
                back++;
            }
        }

        public void incrementFront(){
            if (front == capacity){
                front = 0;
            }
            else{
                front++;
            }
        }
}