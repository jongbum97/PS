import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // n 입력
        long k = Long.parseLong(st.nextToken()); // k 입력

        long numLen = 1; 
        long numCount = 9; 
        while (k > numCount * numLen) { 
            k -= (numLen * numCount);
            numLen++; 
            numCount *= 10; 
        }
        k -= 1; // k를 0부터 시작하도록 조정

        long num = (long)Math.pow(10, (numLen - 1)) + (k / numLen);
        if (num > n) { 
            System.out.println(-1);
        } else {
            System.out.println(String.valueOf(num).charAt((int)(k % numLen))); // 찾은 숫자의 k번째 자리 출력
        }
    }
}