package br.edu.unisinos.estruturadados.aulas.aula5;

public class Node<E> {
    private E element;
    private Node<E> next;

    Node(E element){
        this.element = element;
        next = null;
    }
    public void setElement(E el){
        element = el;
    }
    public E getElement(){
        return element;
    }
    public void setNext(Node<E> next){
        this.next = next;
    }
    public Node<E> getNext(){
        return this.next;
    }
}
