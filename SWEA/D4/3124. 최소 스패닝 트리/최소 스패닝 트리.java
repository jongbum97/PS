import java.io.*;
import java.util.*;
 
public class Solution {
	
    static int V, E, parent[], line[][];
    static boolean visit[];
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
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
        	for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++) {
					line[i][j] = Integer.parseInt(st.nextToken());
				}
			}
        	Arrays.sort(line,(a,b)->a[2]-b[2]);
        	
        	int c = 0;
        	long ans = 0;
        	for (int i = 0; i < E; i++) {
				int a = find(line[i][0]);
				int b = find(line[i][1]);
				if (a!=b) {
					union(a, b);
					ans += line[i][2];
					c++;
					if(c==V-1) break;
				}
			}
        	bw.write("#"+tc+" "+ans+"\n");
        }
        
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
