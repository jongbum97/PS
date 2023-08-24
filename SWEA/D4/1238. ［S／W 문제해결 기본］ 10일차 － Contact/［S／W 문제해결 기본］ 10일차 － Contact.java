import java.io.*;
import java.util.*;
 
public class Solution {
	
    static int n, m, dis[];
    static List<Integer>[] list;
    static boolean visit[];
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        for (int tc = 1; tc <= 10; tc++) {
        	st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	dis = new int[101];
        	list = new ArrayList[101];
        	visit = new boolean[101];
        	for (int i = 1; i < 101; i++) {
				list[i] = new ArrayList<>();
			}
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < n/2; i++) {
				list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}
        	
        	Queue<Integer> q = new LinkedList<>();
        	visit[m] = true;
        	q.add(m);
        	
        	while (!q.isEmpty()) {
				
        		int n = q.remove();
        		
        		for (int x : list[n]) {
					if(visit[x]) continue;
					visit[x] = true;
					dis[x] = dis[n] + 1;
					q.add(x);
				}
        		
			}
        	int max_idx = 0;
        	for (int i = 1; i < 101; i++) {
				if(dis[max_idx]<=dis[i]) max_idx = i;
			}
        	
        	bw.write("#"+tc+" "+max_idx+"\n");
        }
        bw.close();
    }
    
}
