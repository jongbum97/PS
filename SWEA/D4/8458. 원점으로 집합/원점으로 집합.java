import java.io.*;
import java.util.*;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int N, point[];
        StringTokenizer st;
 
        outer : for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            point = new int[N];
            boolean even = false;
            int idx = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                point[i] = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
                idx = Math.max(idx, point[i]);
                if(i==0 && point[i]%2==0) even = true;
            }
            for (int i = 1; i < N; i++) {
                if((point[i]%2==0) != even) {
                	sb.append("#").append(tc).append(" ").append(-1).append("\n");
                	continue outer;
                }
			}
            
            int max = find(idx);
            int group = (max-1)/4;
            int type = (max-1)%4+1;
            int ans = 0;
            
            if(max==0) ans = 0;
            else if(even) {	
            	if(type<3) ans = 4*group+3;
            	else ans = max;
            }else {
            	if(type>2) ans = 4*group+5;
            	else ans = max;
            }
            
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
            
        }
        
        System.out.print(sb.toString());
        
    }
     
     
    static int find(int k) {
        double d = (Math.sqrt(1d+8L*k)-1)/2;
        return (int)Math.ceil(d);
    }
 
}