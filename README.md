# EDL_20262 
Repoistório da AA de Estrutura de Dados Lineares

## Cheat sheet — Aulas 2 a 5

Guia de consulta rápida com os conteúdos trabalhados até aqui, compilado a partir do código em `estruturas-dados-java/`.

### Aula 2 — Primeiros passos em Java

Todo programa parte da mesma estrutura mínima: um pacote (`package`), uma classe e um método `main` — o ponto de entrada que a JVM chama para iniciar a execução.

```java
package br.edu.unisinos.estruturadados.aulas.aula2;

class Aula2 {
    public static void main() {
        IO.println("HelloWorld Aula2 ");
    }
}
```

> **Nota:** `IO.println(...)` é um atalho de console mais novo do JDK — dispensa escrever `System.out`. Em código "tradicional" o equivalente é `System.out.println(...)`, que continua funcionando em qualquer versão.

### Aula 3 — Classes, objetos e o retorno null

Uma **classe** descreve atributos e comportamentos; um **objeto** é a instância concreta criada com `new`. Uma "classe amiga" é apenas uma classe auxiliar que outra classe instancia e usa como colaboradora — Java não tem `friend` como C++, então essa colaboração é feita por composição normal.

```java
public class ClasseAmiga {
    public String classe_amiga = "classe amiga";

    public ClasseAmiga(){
        this.classe_amiga = "Classe Amiga ";
    }
    public String getClasseAmiga(){
        return this.classe_amiga;
    }
    public String retornoNull(){
        return null;
    }
    public String retornoNotNull(){
        return "String Retorno";
    }
}
```

- **`retornoNull()`** — devolve `null` propositalmente; usar o resultado sem checar antes (ex.: chamar um método nele) estoura `NullPointerException`.
- **`retornoNotNull()`** — sempre devolve um `String` válido; seguro para encadear chamadas ou concatenar direto.

### Aula 4 — Complexidade de algoritmos: Bubble Sort × Quick Sort

**Big-O** descreve como o custo de um algoritmo cresce em função do tamanho da entrada *n*, ignorando constantes. O mesmo problema — ordenar um vetor — foi resolvido com duas estratégias de crescimento bem diferentes.

| Algoritmo   | Ideia                                                                                           | Pior caso | Caso médio  |
|-------------|---------------------------------------------------------------------------------------------------|-----------|-------------|
| Bubble Sort | Compara pares adjacentes e troca; o maior valor "borbulha" até o fim a cada passada.               | O(n²)     | O(n²)       |
| Quick Sort  | Escolhe um **pivô**, particiona o vetor em menores/maiores e ordena as duas metades recursivamente. | O(n²)     | O(n log n)  |

```java
// Algoritmo com complexidade quadrática O(n^2) - Bubble Sort
public static void bubbleSort(int[] vetor) {
    int n = vetor.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (vetor[j] > vetor[j + 1]) {
                int temp = vetor[j];
                vetor[j] = vetor[j + 1];
                vetor[j + 1] = temp;
            }
        }
    }
}
```

```java
// Algoritmo com complexidade O(n log n) em média - Quick Sort
public static void quickSort(int[] vetor) {
    quickSort(vetor, 0, vetor.length - 1);
}

private static void quickSort(int[] vetor, int inicio, int fim) {
    if (inicio < fim) {
        int posicaoPivo = particionar(vetor, inicio, fim);
        quickSort(vetor, inicio, posicaoPivo - 1);
        quickSort(vetor, posicaoPivo + 1, fim);
    }
}

private static int particionar(int[] vetor, int inicio, int fim) {
    int pivo = vetor[fim];      // pivô = último elemento (Lomuto)
    int i = inicio - 1;
    for (int j = inicio; j < fim; j++) {
        if (vetor[j] <= pivo) {
            i++;
            int temp = vetor[i]; vetor[i] = vetor[j]; vetor[j] = temp;
        }
    }
    int temp = vetor[i + 1]; vetor[i + 1] = vetor[fim]; vetor[fim] = temp;
    return i + 1;
}
```

No benchmark de `Aula4.main` (vetores de 5 mil a 40 mil elementos), o Bubble Sort chega a realizar milhares de vezes mais operações que o Quick Sort no mesmo tamanho de entrada — a diferença entre O(n²) e O(n log n) na prática.

### Aula 5 — Lista encadeada (`LinkedList<E>`)

Em vez de posições contíguas como um array, cada elemento vive num **nó** que aponta para o próximo. A lista só guarda as referências `head` (início), `tail` (fim) e o `size` atual.

```java
public class Node<E> {
    private E element;
    private Node<E> next;

    Node(E element){
        this.element = element;
        next = null;
    }
    public E getElement(){ return element; }
    public void setNext(Node<E> next){ this.next = next; }
    public Node<E> getNext(){ return this.next; }
}
```

| Operação        | O que faz                                                                                                   | Custo  |
|------------------|--------------------------------------------------------------------------------------------------------------|--------|
| `addFirst(e)`    | Cria um nó e o encaixa antes do `head` atual.                                                                 | O(1)   |
| `addLast(e)`     | Cria um nó e o encaixa depois do `tail` atual — rápido porque a lista já guarda o `tail`.                     | O(1)   |
| `removeFirst()`  | Move `head` para `head.getNext()`.                                                                            | O(1)   |
| `removeLast()`   | **Ainda não implementado em aula.** Sem ponteiro para o nó anterior ao `tail`, exige percorrer a lista toda.  | O(n)*  |
| `iterator()`     | Percorre nó a nó desde o `head` até `null`, imprimindo cada elemento.                                         | O(n)   |

> **Pendente:** `removeLast()` em `LinkedList.java` ainda retorna `true` sem alterar a lista — o corpo do `if (size > 0)` está vazio. É o próximo método a implementar: será preciso percorrer até o penúltimo nó para religar o `tail`.

Estado da lista ao final de `App.main` — três nós ligados por referências `next`, com `head` e `tail` apontando para as pontas:

```
head                                    tail
 │                                        │
 ▼                                        ▼
[20 | •] ──▶ [10 | •] ──▶ [40 | •] ──▶ null
```

```java
LinkedList<Integer> lista = new LinkedList<Integer>();
lista.addFirst(10);
lista.addFirst(20);
lista.addFirst(30);
lista.addLast(40);
lista.iterator();
lista.removeFirst();
lista.iterator();
```

Rastreamento passo a passo:

| # | Chamada         | Estado da lista     |
|---|------------------|----------------------|
| 1 | `addFirst(10)`   | `[10]`               |
| 2 | `addFirst(20)`   | `[20, 10]`           |
| 3 | `addFirst(30)`   | `[30, 20, 10]`       |
| 4 | `addLast(40)`    | `[30, 20, 10, 40]`   |
| 5 | `removeFirst()`  | `[20, 10, 40]`       |

### Vocabulário rápido

- **Big-O** — notação para descrever como o custo de um algoritmo cresce em função do tamanho da entrada *n*, ignorando constantes.
- **Nó (Node)** — unidade básica de uma lista encadeada: guarda um elemento e uma referência para o próximo nó.
- **Encadeamento** — ligar objetos por referência (ponteiros), em vez de posições contíguas de memória como num array.
- **Classe amiga** — classe auxiliar instanciada e usada de dentro de outra classe, por composição; não é um recurso da linguagem Java.
- **Pivô** — elemento escolhido no Quick Sort para particionar o vetor em "menores" e "maiores" antes da recursão.
- **NullPointerException** — erro em tempo de execução ao usar uma referência que vale null sem checá-la antes.

*Guia também disponível como página formatada: https://claude.ai/code/artifact/fba4d439-b23e-43db-a1ec-97d1c75e9d43*
