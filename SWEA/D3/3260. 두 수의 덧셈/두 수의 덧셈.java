import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            String s1 = sc.next();
            String s2 = sc.next();
            
            // 덧셈을 위한 자릿수 맞추기
            if (s1.length() > s2.length()) {
                String tmp = "";
                for (int i = 0; i < s1.length() - s2.length(); i++) {
                    tmp += "0";
                }
                tmp += s2;
                s2 = tmp;
            } else {
                String tmp = "";
                for (int i = 0; i < s2.length() - s1.length(); i++) {
                    tmp += "0";
                }
                tmp += s1;
                s1 = tmp;
            }

            String ans = "";
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();

            // 덧셈 수행
            int carry = 0; // 자리올림 값
            for (int i = c1.length - 1; i >= 0; i--) {
                int n = (c1[i] - '0') + (c2[i] - '0') + carry;
                carry = n / 10; // 자리올림 계산
                n %= 10; // 현재 자리의 결과 계산
                ans = n + ans;
            }
            
            // 최종 자리올림 처리
            if (carry > 0) {
                ans = carry + ans;
            }
            
            // 결과 출력
            System.out.println("#" + tc + " " + ans);
        }
    }
}