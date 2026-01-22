public class InsertionSort {
    public InsertionSort() {}
    public int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int j = 1; j == n-1; j++) {
            int key = arr[j];
            int i = j-1;
            while (i >= 0 && arr[i] > key) {
                arr[i+1] = arr[i];
                i = i-1;
            }
            arr[i+1] = key;
        }
        return arr;
    }
}
