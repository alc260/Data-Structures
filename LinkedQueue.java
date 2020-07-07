//Ava Chong
//0445 Assignment 3
//Due 2/9

public class LinkedQueue<T> implements Queue<T>{
    
    //private node class only to be used by LinkedQueue
    private class Node<T>{
        Node next;
        T value;
        public Node (T value, Node next)
        {
            this.value = value;
            this.next = next; 
        }
        public boolean hasNext(){
            return this.next != null;
        }
        public Node getNext(){
            return this.next;
        }
        public void setNext(Node nextThing){
            this.next = nextThing;
        }
        public T getValue(){
            return this.value;
        }
        public void setValue(T newValue){
            this.value = newValue;
        }
        public void move(Node head, Node newHead){
            head = newHead;
        }
    }

    //create head and back node
    Node<T> head = new Node(null, null);
    Node<T> back = new Node(null, null); 
    int size = 0; 

        //remove and return
        public T remove(){ 
            if (size != 0){
                Object headValue = head.value;
                head = head.next; 
                size = size - 1; 
                return(T) headValue;

            }
            else{
                throw new UnsupportedOperationException();
            }
        }
        //get from top (head)
        public T peek(){
            if (size != 0){
                return(T) head.value;
            }
            else{
                throw new UnsupportedOperationException();
            }
        }
        //add to the back of the queue
        public void add(T thing){
            //first item is head and back
            if (size == 0)
            {
                Node<T> n = new Node(thing, null); 
                head = n; 
                back = n;
                size ++;
            }
            else {
                Node<T> n = new Node(thing, null); 
                back.setNext(n);
                back = n; 
                size ++;
            }
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
        //get size
        public int getSize(){
            return size;
        }

}