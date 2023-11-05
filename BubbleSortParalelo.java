package Questao5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BubbleSortParalelo {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int numProcessors = Runtime.getRuntime().availableProcessors();
        List<Integer> lista = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 80; i++) {
            lista.add(random.nextInt(1000));
        }

        int trabalho = lista.size() / numProcessors;

        List<SortThread> threads = new ArrayList<>();

        for (int i = 0; i < numProcessors; i++) {
            int start = i * trabalho;
            int end;
            if (i == numProcessors - 1) {
                end = lista.size() - 1;
            } else {
                end = start + trabalho - 1;
            }
            SortThread thread = new SortThread(lista, start, end);
            threads.add(thread);
            thread.start();
        }

        for (SortThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        boolean trocado;
        do {
            trocado = false;
            for (int i = 0; i < lista.size() - 1; i++) {
                if (lista.get(i) > lista.get(i + 1)) {
                    int aux = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, aux);
                    trocado = true;
                }
            }
        } while (trocado);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Tempo total: " + totalTime + " milissegundos");

        for (Integer element : lista) {
            System.out.print(element + " ");
        }

    }
}
