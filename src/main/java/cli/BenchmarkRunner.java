package cli;

import algorithms.MinHeap;
import metrics.PerformanceTracker;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 10000, 100000};
        PerformanceTracker tracker = new PerformanceTracker();

        for (int size : sizes) {
            MinHeap heap = new MinHeap();
            // Заполнение кучи случайными числами для бенчмарков
            for (int i = 0; i < size; i++) {
                heap.insert((int) (Math.random() * 1000));
            }

            // Измерение времени для операций
            long startTime = System.nanoTime();
            heap.extractMin();
            long endTime = System.nanoTime();

            // Получаем и выводим результаты
            tracker = heap.getTracker(); // Получаем метрики из MinHeap
            System.out.println("Size: " + size);
            System.out.println("Execution time: " + (endTime - startTime) + " ns");
            System.out.println("Comparisons: " + tracker.getComparisons());
            System.out.println("Swaps: " + tracker.getSwaps());
            System.out.println("-------------------------");
        }
    }
}