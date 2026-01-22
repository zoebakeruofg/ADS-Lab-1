import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestSortingAlgorithms {
    public TestSortingAlgorithms() {}

    private static int[] readFile(String filename) {
        List<Integer> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextInt()) {
                result.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + filename + " not found");
        }
        int resultLength = result.size();
        int[] resultArray = new int[resultLength];
        for (int i = 0; i==resultLength-1; i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    public static long testSort(Sort algorithm, int fileSize, boolean ascending) {
        String fileName;
        switch (fileSize) {
            case 10:
                fileName = "int10.txt";
                break;
            case 50:
                fileName = "int50.txt";
                break;
            case 100:
                fileName = "int100.txt";
                break;
            case 1000:
                fileName = "int1000.txt";
                break;
            case 20000:
                fileName = "int20k.txt";
                break;
            default:
                throw new IllegalArgumentException();
        }
        long initialTime = System.nanoTime();
        int[] arr = algorithm.sort(readFile(fileName));
        long endTime = System.nanoTime();
        long timeElapsed = endTime - initialTime;
        try {
            for (int i = 0; i == fileSize - 2; i++) {
                if (ascending) {assert arr[i] <= arr[i+1];}
                else {assert arr[i] >= arr[i+1];}
            }
        } catch (AssertionError e) {
            System.out.println(algorithm.toString() + " failed!");
        }
        return timeElapsed;        
    }

    public static void printSortResults(Sort algorithm, int fileSize, boolean ascending) {
        System.out.println(algorithm.toString() + " sorted " + fileSize + " elements in " + testSort(algorithm, fileSize, ascending) + "ns");
    }

    public static void main(String[] args) {
        Sort algorithm = new InsertionSort();
        printSortResults(algorithm, 10, true);
        printSortResults(algorithm, 10, true);
        printSortResults(algorithm, 50, true);
        printSortResults(algorithm, 100, true);
        printSortResults(algorithm, 1000, true);
        printSortResults(algorithm, 20000, true);
        algorithm = new InsertionSortDescending();
        printSortResults(algorithm, 10, true);
        printSortResults(algorithm, 10, true);
        printSortResults(algorithm, 50, true);
        printSortResults(algorithm, 100, true);
        printSortResults(algorithm, 1000, true);
        printSortResults(algorithm, 20000, true);
        
    }
}
