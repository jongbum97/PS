import java.io.*;
import java.util.*;
  
public class Solution {
     
    static int ans;
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
  
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] tmp = new int[N];
            for (int i = 0; i < N; i++) {
                tmp[i] = Integer.parseInt(st.nextToken());
            }
            ans = 0;
            boolean[] visit = new boolean[N];
            DFS(0,0,0, tmp, visit, N);
            
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
         bw.write(sb.toString());
         bw.close();
         
    }
 
     
    static void DFS(int x, int L, int R, int[] choo, boolean[] visit, int N) {
         
        if(x==N) {
            ans++;
            return;
        }
         
        for (int i = 0; i < N; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            DFS(x+1, L+choo[i], R, choo, visit, N);
            if(L>=R+choo[i]) {
                DFS(x+1, L, R+choo[i], choo, visit, N);
            }
            visit[i] = false;
        }
    }
     
     
}