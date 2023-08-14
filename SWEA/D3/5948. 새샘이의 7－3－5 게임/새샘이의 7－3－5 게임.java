import java.io.*;
import java.util.*;
 
public class Solution {
 
    static byte nums[], t;
    static int ans[];
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
         
        for (int tc = 1; tc <= T; tc++) {
            t = 0;
            nums = new byte[7];
            ans = new int[35];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 7; i++) {
                nums[i] = Byte.parseByte(st.nextToken());
            }
             
            a(0, 0, 0);
            Arrays.sort(ans);
            int k = 0;
            for (int i = 34; i >=0 ; i--) {
                if (ans[i] != ans[i-1]) {
                    k++;
                }
                if (k==4) {
                    System.out.println("#"+tc+" "+ans[i-1]);
                    break;
                }
            }
        }
    }
     
     
    static void a(int n, int m, int sum) {
         
        if (n==3) {
            ans[t++] = sum;
            return;
        }
         
        for (int i = m; i < 7; i++) {
            a(n+1, i+1, sum+nums[i]);
        }
    }
     
 
 
}