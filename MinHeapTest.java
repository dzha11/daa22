package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinHeapTest {

    @Test
    public void testInsertAndExtractMin() {
        MinHeap heap = new MinHeap();
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);

        assertEquals(5, heap.extractMin());
        assertEquals(10, heap.extractMin());
        assertEquals(20, heap.extractMin());
    }

    @Test
    public void testDecreaseKey() {
        MinHeap heap = new MinHeap();
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);

        heap.decreaseKey(1, 3); // уменьшаем значение на индексе 1
        assertEquals(3, heap.extractMin());
    }

    @Test
    public void testMerge() {
        MinHeap heap1 = new MinHeap();
        heap1.insert(10);
        heap1.insert(20);

        MinHeap heap2 = new MinHeap();
        heap2.insert(5);
        heap2.insert(30);

        heap1.merge(heap2);

        assertEquals(5, heap1.extractMin());
        assertEquals(10, heap1.extractMin());
        assertEquals(20, heap1.extractMin());
        assertEquals(30, heap1.extractMin());
    }
}
