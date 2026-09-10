package br.edu.unisinos.estruturadados.aulas.aula5;
import br.edu.unisinos.estruturadados.aulas.aula5.Node;
import br.edu.unisinos.estruturadados.aulas.aula5.LinkedList;
public class App {
    public static void main(String[] args) {
        LinkedList<Integer> lista_inteiros = new LinkedList<Integer>();
        lista_inteiros.addFirst(10);
        lista_inteiros.addFirst(20);
        lista_inteiros.addFirst(30);
        lista_inteiros.addLast(40);
        lista_inteiros.iterator();
        lista_inteiros.removeFirst();
        lista_inteiros.iterator();
    }
}
