package br.edu.unisinos.estruturadados.aulas.aula5;

public class LinkedList<E> {
    private Node<E> head, tail;
    private int size;
    LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    public void addFirst(E element){
        if (size == 0){
            tail = new Node<E>(element);
            head = tail;
            size++;
        } else if (size > 0){
            Node<E> new_node = new Node<E>(element);
            new_node.setNext(head);
            head = new_node;
            size++;
        }
    }
    public void addLast(E element){
        if(size == 0){
            tail = new Node<E>(element);
            head = tail;
            size++;
        }else if(size > 0){
            Node<E> new_node = new Node<E>(element);
            tail.setNext(new_node);
            tail = new_node;
            size++;
        }
    }
    public boolean removeFirst(){
        if (size == 0) return false;
        if (size > 0 ){
            if(head.getNext() != null){
                head = head.getNext();
            }else{
                head = tail = null;
            }
            size--;        
        }
        return true;
    }
    public boolean removeLast(){
        if(size == 0) return false;
        if(size > 0){
            
        }
        return true;
    }    
    public void iterator(){
        if (size == 0){
            System.out.println("lista vazia!");
        }else if(size > 0){
            System.out.println(this.size);
            Node<E> node_aux = head;
            while(node_aux != null){
                System.out.println(node_aux.getElement());
                node_aux = node_aux.getNext();
            }
            
            System.out.println("outra forma de imprimir");
        }
    }
}
