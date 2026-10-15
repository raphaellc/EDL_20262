public class ListaCircular<T> {
    private int tamanho = 0;
    private NoDuplo<T> head, tail = null;

    ListaCircular(){
        head = tail = null;
    }
    public void inserir(T dado){
        NoDuplo<T> no = new NoDuplo<T>(dado);
        if (tamanho == 0){
            head = tail = no;
            tamanho++;
            
        }else{
            no.setAnterior(tail);
            no.setProximo(head);
            tail.setProximo(no);
            head.setAnterior(no);
            tail = no;
            tamanho++;
        }
        return;
    }
    public void mostrarLista(){
        if(tamanho == 0){
            System.out.println("Lista Vazia");
        }else if(tamanho == 1){
            System.out.println("null <-" + head.getDado() + "-> null");
        }else{
            NoDuplo<T> no_aux = head;
            System.out.print(no_aux.getAnterior().getDado());
            while(no_aux != tail){
                System.out.print("<->" + no_aux.getDado());
                no_aux = no_aux.getProximo();
            }
            System.out.println("<->" + tail.getDado());
        }
    }   
}
