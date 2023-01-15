import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Collectors.toList;

/**
 * The Hourglass Sum problem.
 * https://www.hackerrank.com/challenges/java-2d-array/problem
 *
 */
public class Solution {
    public static int maxValue(int[] array) {
        int max = -Integer.MIN_VALUE;;
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            System.out.println(array[i] > max);
            if (array[i] > max) {
                max = array[i];
            }
        }
        
        return max;
    }
    
    public static int maxValue(List<Integer> array) {
        int max = -Integer.MIN_VALUE;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
        }
        
        return max;
    }
    
    public static int generateHourGlassSum(List<List<Integer>> array, int startRowIndex, int startColumnIndex) {
        int row1Sum = array.get(startRowIndex).get(startColumnIndex) +
            array.get(startRowIndex).get(startColumnIndex + 1) +
            array.get(startRowIndex).get(startColumnIndex + 2);
        
        int row2Sum = array.get(startRowIndex + 1).get(startColumnIndex + 1);
        
        int row3Sum = array.get(startRowIndex + 2).get(startColumnIndex) +
            array.get(startRowIndex + 2).get(startColumnIndex + 1) +
            array.get(startRowIndex + 2).get(startColumnIndex + 2);
        
        return row1Sum + row2Sum + row3Sum;
    }

    public static int maximumHourGlassSum(List<List<Integer>> array) {
        List<Integer> hourGlassSums = new ArrayList<Integer>(16);
        for (int rowIndex = 0; rowIndex <= array.size() - 3; rowIndex++) {
            for (int columnIndex = 0; columnIndex <= array.get(rowIndex).size() - 3; columnIndex++) {
            hourGlassSums.add(generateHourGlassSum(array, rowIndex, columnIndex));
        }
        }

        System.out.println(hourGlassSums);
        return maxValue(hourGlassSums);
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        try {
            IntStream.range(0, 6).forEach(i -> {
                try {
                    arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(toList())
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            System.out.println(maximumHourGlassSum(arr));

            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}

