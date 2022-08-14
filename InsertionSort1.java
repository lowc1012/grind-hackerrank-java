import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class InsertionSort1Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int j, val;
        for (int i = 1; i < n; i++) {
            j = i - 1;
            val = arr.get(i);

            while (j >= 0 && arr.get(j) > val) {
                arr.set(j+1, arr.get(j));
                j--;
       cd      }
            arr.set(j+1, val);
        }
    }

}

public class InsertionSort1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
gi
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        InsertionSort1Result.insertionSort1(n, arr);

        System.out.println(arr);

        bufferedReader.close();
    }
}
