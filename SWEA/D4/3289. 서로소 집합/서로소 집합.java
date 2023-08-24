import java.io.*;
import java.util.*;
 
public class Solution {
	
    static int V, E, parent[], line[][], ans;
    static boolean visit[];
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
        	st = new StringTokenizer(br.readLine());
        	V = Integer.parseInt(st.nextToken());
        	E = Integer.parseInt(st.nextToken());
        	parent = new int[V+1];
        	for (int i = 1; i <= V; i++) {
				parent[i] = i;
			}
        	line = new int[E][3];
        	sb.append("#"+tc+" ");
        	for (int i = 0; i < E; i++) {	
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				if(a==0) {
					union(b, c);
				}else {
					if (find(b)==find(c)) sb.append(1);
					else sb.append(0);
				}
				
			}
        	sb.append("\n");
        	
        }
        bw.write(sb.toString());
        bw.close();
    }
    
    static int find(int x) {
    	if(parent[x] == x) return x;
    	return parent[x] = find(parent[x]);
    }
    
    static void union(int x, int y) {
    	x = find(x);
    	y = find(y);
    	parent[y] = x;
    }
    
}
