public class InsertionSortDescending implements Sort {
    public InsertionSortDescending() {}
    public int[] sort(int[] arr) {
        int n = arr.length;
        for (int j = 1; j <= n-1; j++) {
            int key = arr[j];
            int i = j-1;
            while (i >= 0 && arr[i] < key) {
                arr[i+1] = arr[i];
                i = i-1;
            }
            arr[i+1] = key;
        }
        return arr;
    }
    public String toString() {
        return "Insertion Sort Descending";
    }
}
