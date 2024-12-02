package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public static void main(String[] args) throws IOException {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        readFile("/home/tejas/A0c2024/src/Day1/input.txt", leftList, rightList);

        int similarityScore = 0;
        for (int leftNumber : leftList) {
            int count = countOccurrences(rightList, leftNumber);
            similarityScore += leftNumber * count;
        }

        System.out.println("Similarity score: " + similarityScore);
    }

    private static void readFile(String input, List<Integer> leftList, List<Integer> rightList) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line;
        while ((line = br.readLine()) != null) {
            String[] numbers = line.split("\\s+");
            leftList.add(Integer.parseInt(numbers[0]));
            rightList.add(Integer.parseInt(numbers[1]));
        }
    }

    private static int countOccurrences(List<Integer> list, int number) {
        int count = 0;
        for (int value : list) {
            if (value == number) {
                count++;
            }
        }
        return count;
    }
}

