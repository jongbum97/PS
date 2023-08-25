import java.io.*;
import java.util.*;

public class Solution {
      
    static int N, island[][];
    static double E, ans;
    static boolean visit[];
   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            island = new int[N][2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
            	island[i][0] = Integer.parseInt(st.nextToken());
			}
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
            	island[i][1] = Integer.parseInt(st.nextToken());
			}
            E = Double.parseDouble(br.readLine());
            visit = new boolean[N];
            
            PriorityQueue<Node> q = new PriorityQueue<>((a,b)->Double.compare(a.cost, b.cost));
            q.add(new Node(0,0));
            ans = 0;
            
            while (!q.isEmpty()) {
            	
            	Node n = q.remove();
            	if(visit[n.x]) continue;
            	visit[n.x] = true;
            	ans += n.cost;
            	for (int i = 0; i < N; i++) {
            		if(visit[i]) continue;
            		double c = Math.pow(island[i][0]-island[n.x][0], 2) + Math.pow(island[i][1]-island[n.x][1], 2);
            		q.add(new Node(i, c));
				}
			}
            
            bw.write("#"+tc+" "+String.format("%.0f", ans*E)+"\n");
            
        }
         bw.close();
          
    }
      
}
class Node{
	int x;
	double cost;
	Node(int x, double cost){
		this.x = x;
		this.cost = cost;
	}
}