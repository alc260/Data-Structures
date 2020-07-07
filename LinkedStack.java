//Ava Chong
//0445 Assignment 2
//Due 1/31

//implement a stack backed by linked chain of objects (Nodes)
public class LinkedStack<T> implements Stack<T>{

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

Node<T> nullNode = new Node(null, null);
Node<T> head = new Node(null, nullNode);
int size = 0; 

    //remove and return
    public T pop(){ 
        if (size != 0){
            Object headValue = head.value;
            //System.out.println(headValue);
            head = head.next; 
            size = size - 1; 
           // System.out.println(size);
            return(T) headValue;
        }
        else{
            throw new UnsupportedOperationException();
        }
    }
    //get
    public T peek(){
        if (size != 0){
            return(T) head.value;
        }
        else{
            return null;
        }
        //throw exception if size = 0
    }
    //add to the top
    public void push(T thing){
        Node<T> n = new Node(thing, head);
        head = n; 
        size = size + 1;
       // System.out.println("Push" + size);
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
