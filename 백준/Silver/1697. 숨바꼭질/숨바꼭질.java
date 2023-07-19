import java.util.*;

public class Main {

	static int N, K, M;
	static boolean[] visit;
	static int[] dis;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		M = Math.max(N, K);
		visit = new boolean[100001];
		dis = new int[100001];
		
		BFS(N);
		System.out.println(dis[K]);
	}
	
	
	static void BFS(int x) {
		
		visit[x] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		
		while(!queue.isEmpty()){
			
			int t = queue.remove();
			if(t==K){
				break;
			}
			if(t-1>=0 && !visit[t-1]){
				queue.add(t-1);
				visit[t-1] = true;
				dis[t-1] = dis[t]+1;
			}
			if(t+1<=100000 && !visit[t+1]){
				queue.add(t+1);
				visit[t+1] = true;
				dis[t+1] = dis[t]+1;
			}
			if(2*t<=100000 && !visit[2*t]){
				queue.add(2*t);
				visit[2*t] = true;
				dis[2*t] = dis[t]+1;
			}
			
		}
		
	}


}