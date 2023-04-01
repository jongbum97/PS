import java.util.*;

public class Solution{
	public static void main(String args[]) throws Exception
         {
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        for (int testCase = 1; testCase <= numTestCases; testCase++) {
            int arraySize = sc.nextInt();
            Integer[] array = new Integer[arraySize];
            for (int i = 0; i < arraySize; i++) {
                array[i] = sc.nextInt();
            }
            Arrays.sort(array, Collections.reverseOrder());
            System.out.println("#" + testCase + " " + calculateProduct(array));
        }
    }

    private static int calculateProduct(Integer[] array) {
        int maxProduct = -1;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int product = array[i] * array[j];
                if (product <= maxProduct) {
                    break;
                }
                if (isDecreasingOrder(product)) {
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }

    private static boolean isDecreasingOrder(int number) {
        int previousDigit = 10;
        while (number > 0) {
            int digit = number % 10;
            if (digit > previousDigit) {
                return false;
            }
            previousDigit = digit;
            number /= 10;
        }
        return true;
    }
}