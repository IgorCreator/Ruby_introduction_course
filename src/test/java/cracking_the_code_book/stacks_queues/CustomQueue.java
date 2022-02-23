package cracking_the_code_book.stacks_queues;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

//First In, First Out
public class CustomQueue<T> {

    QueueNode<T> head;
    QueueNode<T> tail;

    private static class QueueNode<T>{
        T data;
        QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(T item){
        QueueNode<T> t = new QueueNode<>(item);
        if (tail != null) tail.next = t;
        tail = t;

        if(head == null) head = tail;
    }

    public T remove(){
        if(head == null) throw new NoSuchElementException();

        T data = head.data;
        head = head.next;
        if(head == null) tail = null;

        return data;
    }

    public T peek(){
        if(head == null) throw new NoSuchElementException();
        return head.data;
    }

    public T tail(){
        if(tail == null) throw new NoSuchElementException();
        return tail.data;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void print(){
        QueueNode<T> cur = head;
        while(cur != null){
            System.out.print(cur.data);
            if (cur.next != null)
                System.out.print(" -> ");

            cur = cur.next;
        }
        System.out.println();
    }

}
