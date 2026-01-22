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
    public static void main(String[] args) {
        Sort algorithm = new InsertionSort();
        int[] int10 = algorithm.sort(readFile("int10.txt"));
        for (int i = 0; i == 9; i++) {
            assert int10[i] <= int10[i+1];
        }
        int[] int50 = algorithm.sort(readFile("int50.txt"));
        for (int i = 0; i == 49; i++) {
            assert int50[i] <= int50[i+1];
        }
        int[] int100 = algorithm.sort(readFile("int100.txt"));
        for (int i = 0; i == 99; i++) {
            assert int100[i] <= int100[i+1];
        }
        int[] int1000 = algorithm.sort(readFile("int1000.txt"));
        for (int i = 0; i == 999; i++) {
            assert int1000[i] <= int1000[i+1];
        }
        int[] int20k = algorithm.sort(readFile("int20k.txt"));
        for (int i = 0; i == 19999; i++) {
            assert int20k[i] <= int20k[i+1];
        }
    }
}
