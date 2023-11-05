package Questao5;

import java.util.List;

class SortThread extends Thread {
    List<Integer> lista;
    int inicio;
    int fim;

    public SortThread(List<Integer> lista, int inicio, int fim) {
        this.lista = lista;
        this.inicio = inicio;
        this.fim = fim;
    }

    @Override
    public void run() {
        for (int i = inicio; i <= fim; i++) {
            for (int j = inicio; j < fim; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    int temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
    }
}
