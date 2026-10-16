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
    public void removerNo(int posicao){
        if (tamanho == 0){ return;}
        else if(tamanho == 1){
            head = tail = null;
            tamanho--;
        }
        else if(tamanho > 0 && posicao < tamanho){
            NoDuplo<T> aux = head;
            for (int i = 0; i < tamanho; i++){
                if(i == posicao){
                    var anterior = aux.getAnterior();
                    var proximo = aux.getProximo();
                    if(anterior == tail){
                        //primeiro
                        head.getProximo().setAnterior(tail);
                        tail.setProximo(head.getProximo());
                        head = head.getProximo();
                    }
                    else if(proximo == head){
                        //último
                        tail.getAnterior().setProximo(head);
                        head.setAnterior(tail.getAnterior());
                        tail = tail.getAnterior();        
                    }
                    else{
                        proximo.setAnterior(aux.getAnterior());
                        anterior.setProximo(aux.getProximo());
                    }
                    System.out.println(aux.getDado());
                    tamanho--;
                    return;
                }else{
                    aux = aux.getProximo();
                }
            }
        }
    }
}
 