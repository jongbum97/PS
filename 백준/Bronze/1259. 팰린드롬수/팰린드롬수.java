import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String word = sc.nextLine();
            if (word.equals("0"))
                break;

            // 맨 앞의 0 제거
            while (word.startsWith("0")) {
                word = word.substring(1);
            }

            int N = word.length();
            boolean isPalindrome = true;
            for (int j = 0; j < N / 2; j++) {
                if (word.charAt(j) != word.charAt(N - 1 - j)) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}