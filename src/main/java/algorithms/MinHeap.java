package algorithms;

import metrics.PerformanceTracker;
import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;
    private static final int CAPACITY = 10;  // Начальная вместимость
    private PerformanceTracker tracker;

    public MinHeap() {
        heap = new int[CAPACITY];
        size = 0;
        tracker = new PerformanceTracker();
    }

    // Вставка элемента
    public void insert(int value) {
        if (size >= heap.length) {
            // Увеличиваем размер массива в 2 раза, если куча заполнилась
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
        heap[size] = value;
        int current = size;
        size++;
        while (heap[current] < heap[parent(current)]) {
            tracker.incrementComparisons(); // Считаем сравнение
            swap(current, parent(current));
            tracker.incrementSwaps(); // Считаем обмен
            current = parent(current);
        }
    }

    // Уменьшение ключа
    public void decreaseKey(int index, int newValue) {
        if (newValue > heap[index]) {
            throw new IllegalArgumentException("New value is greater than the current value");
        }
        heap[index] = newValue;
        while (index > 0 && heap[index] < heap[parent(index)]) {
            tracker.incrementComparisons(); // Считаем сравнение
            swap(index, parent(index));
            tracker.incrementSwaps(); // Считаем обмен
            index = parent(index);
        }
    }

    // Извлечение минимального элемента
    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = heap[0];
        heap[0] = heap[--size];
        minHeapify(0);
        return min;
    }

    // Слияние двух куч
    public void merge(MinHeap other) {
        for (int i = 0; i < other.size; i++) {
            insert(other.heap[i]);
        }
    }

    // Вспомогательные методы
    private void minHeapify(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int smallest = index;
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            tracker.incrementComparisons(); // Считаем сравнение
            swap(index, smallest);
            tracker.incrementSwaps(); // Считаем обмен
            minHeapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Получение метрик
    public PerformanceTracker getTracker() {
        return tracker;
    }
}