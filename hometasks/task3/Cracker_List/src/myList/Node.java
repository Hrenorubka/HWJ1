package myList;

public class Node <E>{
    E element;
    Node<E> nextNode;


    Node() {
        nextNode = null;
        element = null;
    }

    Node(E element) {
        this.element = element;
        nextNode = null;
    }
}
