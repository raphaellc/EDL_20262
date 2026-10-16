public class App {
    public static void main(String[] args) {
        ListaCircular<Integer> lista_circ = new ListaCircular<Integer>();
        
        lista_circ.removerNo(0);
        lista_circ.mostrarLista();


        lista_circ.inserir(10);
        lista_circ.mostrarLista();
        lista_circ.removerNo(0);
        lista_circ.mostrarLista();

        lista_circ.inserir(12);
        lista_circ.inserir(16);
        lista_circ.inserir(25);
        lista_circ.inserir(32);
        lista_circ.mostrarLista();

        
        lista_circ.removerNo(2);
        lista_circ.mostrarLista();

        
        lista_circ.removerNo(3);
        lista_circ.mostrarLista();

        lista_circ.removerNo(0);
        lista_circ.mostrarLista();

    }
    
}
