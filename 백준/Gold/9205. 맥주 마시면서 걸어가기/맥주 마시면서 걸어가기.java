import java.io.*;
import java.util.*;

public class Main {

	static int T, N;
	static List<Integer>[] line;
	static boolean visit[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++){
			N = Integer.parseInt(br.readLine());
			int[][] position = new int[N+2][2];

			for (int i=0; i<N+2; i++){
				String[] tmp = br.readLine().split(" ");
				position[i][0] = Integer.parseInt(tmp[0]);
				position[i][1] = Integer.parseInt(tmp[1]);
			}

			line = new ArrayList[N+2];
			for (int i=0; i<N+2; i++){
				line[i] = new ArrayList<>();
			}

			for(int i=0; i<N+2; i++){
				for(int j=i+1; j<N+2; j++){
					if(Math.abs(position[i][0]-position[j][0])+Math.abs(position[i][1]-position[j][1]) <= 1000){
						line[i].add(j);
						line[j].add(i);
					}
				}
			}

			boolean isHappy = bfs();
			if(isHappy) sb.append("happy");
			else sb.append("sad");
			sb.append("\n");
		}

		System.out.println(sb.toString());
		
	}

	public static boolean bfs(){
		visit = new boolean[N+2];
		Queue<Integer> queue = new LinkedList<>();
		visit[0] = true;
		queue.add(0);

		while (!queue.isEmpty()){

			int k = queue.poll();

			for(int n : line[k]){
				if(visit[n]) continue;
				if(n == N+1) return true;
				queue.add(n);
				visit[n] = true;
			}

		}

		return false;
	}

	

}
