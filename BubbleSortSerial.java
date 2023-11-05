package Questao5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BubbleSortSerial {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 80; i++) {
            list.add(random.nextInt(1000));
        }

        int listSize = list.size();

        for (int i = 0; i < listSize - 1; i++) {
            for (int j = 0; j < listSize - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int aux = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, aux);
                }
            }
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Tempo total: " + totalTime + " milissegundos");

        for (Integer elements : list) {
            System.out.print(elements + " ");
        }
    }
}

