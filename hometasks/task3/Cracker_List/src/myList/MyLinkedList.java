package myList;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedList<E> implements ILinkedList<E>{
    int size;
    Node<E> first;
    Node<E> last;

    MyLinkedList() {
        size = 0;
        first = new Node<E>(null);
        last = first;
    }

    @Override
    public void add(E element) {
        last.nextNode = new Node<E>(element);
        last = last.nextNode;
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index >= size) {
            System.out.println("Index bigger than size of list");
            return;
        }
        if (index == size - 1) {
            add(element);
        } else {
            Node<E> stepNode = first;
            for (int i = 0; i < index; i++){
                stepNode = stepNode.nextNode;
            }
            Node<E> stepNodeNext = stepNode.nextNode;
            stepNode.nextNode = new Node<E>(element);
            stepNode.nextNode.nextNode = stepNodeNext;
            size++;
        }
    }

    @Override
    public void clear() {
        if (size == 0)
            return;
        for (Node<E> Del = first; Del != null;) {
            Node<E> DelNext = Del.nextNode;
            Del.nextNode = null;
            Del = DelNext;
        }
        size = 0;
        last = first;
    }

    @Override
    public E get(int index) {
        if (index >= size) {
            System.out.println("Index bigger than size of list");
            return null;
        }
        if (index == size - 1) {
            return last.element;
        }
        Node<E> stepNode = first.nextNode;
        for (int i = 0; i < index; i++){
            stepNode = stepNode.nextNode;
        }
        return stepNode.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> stepNode = first.nextNode;
        int outIndex = 0;
        while (stepNode != null) {
            if (stepNode.element == element) {
                return outIndex;
            }
            outIndex++;
            stepNode = stepNode.nextNode;
        }
        return -1;
    }

    private E remove(Node<E> delNode) {
        if (delNode == first.nextNode) {
            return remove(0);
        }
        Node<E> stepNode = first.nextNode;
        while (stepNode.nextNode != delNode) {
            stepNode = stepNode.nextNode;
        }
        stepNode.nextNode = stepNode.nextNode.nextNode;
        return delNode.element;
    }

    @Override
    public E remove(int index) {
        if (index >= size) {
            System.out.println("Index bigger than size of list");
            return null;
        }
        Node<E> stepNode = first;
        for (int i = 0; i < index; i++) {
            stepNode = stepNode.nextNode;
        }
        Node<E> deletedNode = stepNode.nextNode;
        stepNode.nextNode = stepNode.nextNode.nextNode;
        size--;
        // System.out.println(index);
        return deletedNode.element;
    }

    @Override
    public E set(int index, E element) {
        if (index >= size) {
            System.out.println("Index bigger than size of list");
            return null;
        }
        Node<E> stepNode = first.nextNode;
        for (int i = 0; i < index; i++) {
            stepNode = stepNode.nextNode;
        }
        E replacedElement = stepNode.element;
        stepNode.element = element;
        return replacedElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray(E[] a) {
        if (a.length != size)
            a = (E[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        Object[] result = a;
        Node<E> stepNode = first.nextNode;
        for (int i = 0; i < size; i++) {
            a[i] = stepNode.element;
            stepNode = stepNode.nextNode;
        }
        return a;
    }

    /*@Override
    public E[] toArray(E[] elements) {
        Node<E> stepNode = first.nextNode;
        for (int i = 0; i < size; i++) {
            elements[i] = stepNode.element;
            stepNode = stepNode.nextNode;
        }
        return elements;
    }*/

    @Override
    public Iterator<E> iterator() {
        MyLinkedList<E> list = this;
        Iterator<E> outIter = new Iterator<E>() {
            private Node<E> curNode = first;

            @Override
            public boolean hasNext() {
                return (curNode.nextNode != null);
            }

            @Override
            public E next() {
                curNode = curNode.nextNode;
                return curNode.element;
            }
            @Override
            public void remove() {
                list.remove(curNode);
            }
        };
        return outIter;
    }
}
