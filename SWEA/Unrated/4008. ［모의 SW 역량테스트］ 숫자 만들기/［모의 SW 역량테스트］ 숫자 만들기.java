import java.io.*;
import java.util.*;

public class Solution {
	
	static int N, nums[], max, min;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int[] operator = new int[4];
			nums = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				operator[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			DFS(0, nums[0], operator);
			bw.write("#"+tc+" "+(max-min)+"\n");
			
			
			
		}
		bw.close();
		
		
	}

	static void DFS(int x, int sum, int[] oper) {
		
		if (x==N-1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		if(oper[0]>0) {
			int[] oper0 = oper.clone();
			oper0[0]--;
			DFS(x+1, sum+nums[x+1], oper0);
		}
		if(oper[1]>0) {
			int[] oper1 = oper.clone();
			oper1[1]--;
			DFS(x+1, sum-nums[x+1], oper1);
		}
		if(oper[2]>0) {
			int[] oper2 = oper.clone();
			oper2[2]--;
			DFS(x+1, sum*nums[x+1], oper2);
		}
		if(oper[3]>0) {
			int[] oper3 = oper.clone();
			oper3[3]--;
			DFS(x+1, sum/nums[x+1], oper3);
		}
		
	}

}
