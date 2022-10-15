package edu.upc.dsa.queue;

import edu.upc.dsa.queue.EmptyQueueException;
import edu.upc.dsa.queue.FullQueueException;

public class QueueImplementation<E> implements Queue<E> {
    private static class QueueNode<E>{
        private E obj;
        private QueueNode<E> next;
        public QueueNode(E e){
            this.obj=e;

        }
    }
    private QueueNode<E> first;
    private QueueNode<E> last;

    public void push(E e) throws FullQueueException {
        QueueNode<E> n =new QueueNode<E>(e);
        if (last!=null){
            last.next=n;
        }
        last=n;
        if(first==null) {
            first = last;
        }

    }

    public E pop() throws EmptyQueueException {
        //Checking if the edu.upc.dsa.queue.Queue is empty.
        if (first==null){
            throw new EmptyQueueException();
        }
        //Creating a new data object with the first element of the queue.
        E data=first.obj;
        first=first.next;
        //If the first element is null, the last will also be null.
        if(first==null){
            last=null;
        }
        return data;
    }

    public int size() {
        QueueNode<E> current = first;
        int size=0;
        while(current!=null){
            size++;
            current=current.next;

        }
        return size;
    }
}
