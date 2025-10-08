package metrics;

public class PerformanceTracker {
    private int comparisons;
    private int swaps;
    private int arrayAccesses;
    private int memoryAllocations;

    public PerformanceTracker() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        memoryAllocations = 0;
    }

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementSwaps() {
        swaps++;
    }

    public void incrementArrayAccesses() {
        arrayAccesses++;
    }

    public void incrementMemoryAllocations() {
        memoryAllocations++;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }

    public int getArrayAccesses() {
        return arrayAccesses;
    }

    public int getMemoryAllocations() {
        return memoryAllocations;
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        memoryAllocations = 0;
    }
}