package ru.job4j.list;

import ru.job4j.collection.list.SimpleLinkedList;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {
    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList() {
    }


    @Override
    public void add(T value) {

    }

    public T set(int index, T newValue) {
        T element = get(index);
        container[index] = newValue;
        return element;
    }

    public T remove(int index) {
        T element = get(index);
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[size - 1] = null;
        size--;
        modCount++;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int elCount = 0;

            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return elCount != size;
            }

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[elCount++];
            }
        };
    }

        public void checkSize(int size) {
        if (size + 1 > container.length && container.length == 0) {
            container = Arrays.copyOf(container, 1);
        } else if (size + 1 > container.length && container.length != 0) {
                container = Arrays.copyOf(container, container.length * 2);
            }
        }
    }