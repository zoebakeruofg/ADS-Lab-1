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

    public static long testSort(Sort algorithm, int fileSize) {
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
        long initialTime = System.currentTimeMillis();
        int[] arr = algorithm.sort(readFile(fileName));
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - initialTime;
        try {
            for (int i = 0; i == fileSize - 2; i++) {
                assert arr[i] <= arr[i+1];
            }
        } catch (AssertionError e) {
            System.out.println(algorithm.toString() + " failed!");
        }
        return timeElapsed;        
    }

    public static void printSortResults(Sort algorithm, int fileSize) {
        System.out.println(algorithm.toString() + " sorted " + fileSize + " elements in " + testSort(algorithm, fileSize) + "ms");
    }

    public static void main(String[] args) {
        Sort algorithm = new InsertionSort();
        printSortResults(algorithm, 10);
        printSortResults(algorithm, 10);
        printSortResults(algorithm, 50);
        printSortResults(algorithm, 100);
        printSortResults(algorithm, 1000);
        printSortResults(algorithm, 20000);
        
    }
}
