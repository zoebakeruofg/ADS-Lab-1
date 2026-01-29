public class DoNothingSort implements Sort {
    public DoNothingSort() {}
    public String toString() {return "Do Nothing Sort";}

    public int[] sort(int[] arr) {
        return arr;
    }
}
