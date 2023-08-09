import java.io.*;
import java.util.*;
 
public class Solution {
 
    static int price[], plan[], cost[], ans;
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            price = new int[4];
            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            plan = new int[12];
            for (int i = 0; i < 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }
            cost = new int[12];
            for (int i = 0; i < 12; i++) {
                if(plan[i]==0) continue;
                cost[i] = Math.min(plan[i]*price[0], price[1]);
            }
             
            ans = price[3];
            DFS(0, 0);
            bw.write("#"+tc+" "+ans+"\n");
             
        }
         
        bw.close();
         
         
    }
 
    static void DFS(int x, int sum) {
         
        if (x>11) {
            ans = Math.min(ans, sum);
            return;
        }
         
        DFS(x+1, sum+cost[x]);
         
        DFS(x+3, sum+price[2]);
         
    }
     
}