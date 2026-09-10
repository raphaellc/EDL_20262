package br.edu.unisinos.estruturadados.aulas.aula4;
import java.util.Arrays;
import java.util.Random;


public class Aula4 {
    
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
        int pivo = vetor[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (vetor[j] <= pivo) {
                i++;
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;
        return i + 1;
    }

    // Método auxiliar para gerar instâncias com dados aleatórios
    public static int[] gerarVetorAleatorio(int tamanho) {
        Random random = new Random();
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(100_000);
        }
        return vetor;
    }

    public static void main(String[] args) {
        // Testando com diferentes tamanhos de instâncias (n)
        int[] tamanhos = {5_000, 10_000, 20_000, 40_000};

        System.out.println("Tamanho (n) | Bubble Sort (ms) | Quick Sort (ms)");
        System.out.println("------------------------------------------------");

        for (int n : tamanhos) {
            int[] dadosOriginais = gerarVetorAleatorio(n);

            // Cada algoritmo recebe uma cópia da mesma instância, garantindo comparação justa
            int[] dadosBubble = Arrays.copyOf(dadosOriginais, dadosOriginais.length);
            int[] dadosQuick = Arrays.copyOf(dadosOriginais, dadosOriginais.length);

            long inicioBubble = System.currentTimeMillis();
            bubbleSort(dadosBubble);
            long tempoBubble = System.currentTimeMillis() - inicioBubble;

            long inicioQuick = System.currentTimeMillis();
            quickSort(dadosQuick);
            long tempoQuick = System.currentTimeMillis() - inicioQuick;

            System.out.printf("%-11d | %-16d | %d ms%n", n, tempoBubble, tempoQuick);
        }
    }
}

