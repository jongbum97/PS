import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.nextLine();
            if (input.equals("0")) {
                break;
            }

            boolean isPalindrome = true;
            int len = input.length();
            for (int i = 0; i < len / 2; i++) {
                if (input.charAt(i) != input.charAt(len - i - 1)) {
                    isPalindrome = false;
                    break;
                }
            }

            System.out.println(isPalindrome ? "yes" : "no");
        }

        sc.close();
    }
}