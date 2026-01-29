public class SelectionSort implements Sort {
    public SelectionSort() {}
    public String toString() {return "Selection Sort";}

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n-1; i++) {
            int minIndex = i;
            for (int j = i; j <= n-1; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
        return arr;
    }
}
