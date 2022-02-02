package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable {
   private Node<T> head;

   public void add(T value) {
       Node<T> node = new Node<T>(value, null);
       if (head == null) {
           head = node;
           return;
       }
       Node<T> tail = head;
       while (tail.next != null) {
           tail = tail.next;
       }
       tail.next = node;
       }

    @Override
    public Iterator<T> iterator() {
    return new Iterator<T>() {
        Node<T> node = head;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = node.value;
            node = node.next;
            return value;
        }
     };
  }

   public static class Node<T> {
       T value;
       Node<T> next;

       public Node(T value, Node<T> next) {
           this.value = value;
           this.next = next;
       }
   }

   public T deleteFirst() {
       if (head == null) {
           throw new NoSuchElementException();
       } else {
           T value = head.value;
           Node<T> second = head.next;
           head.next = null;
           head = second;
           return value;
      }
   }
}
