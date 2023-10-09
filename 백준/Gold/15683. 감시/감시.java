import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N, M, K;
	// 상0우1하2좌3
	static int [] dr= {-1,0,1, 0};
	static int [] dc= { 0,1,0,-1};
	
	static ArrayList<int[]> locs=new ArrayList<>();
	static int result;
	
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		locs.clear();
		int[][] map=new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=scann.nextInt();
				if(map[i][j]>=1 && map[i][j]<=5) {
					locs.add(new int[] {i, j, map[i][j]});
				}
			}
		}
		result=Integer.MAX_VALUE;
		K=locs.size();// CCTV 개수
		dfs(0,map); // CCTV를 모두 방문 
		System.out.println(result==Integer.MAX_VALUE?0:result);
	}

	private static void dfs(int idx, int[][] nMap) {
		if(idx==K) {
			int tot=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(nMap[i][j]==0) {
						tot++;
					}
				}
			}
			result=Math.min(result, tot);
			return ;
		}
		
		int[] cur=locs.get(idx);  
		int cr=cur[0];
		int cc=cur[1];
		int cctvType=cur[2];
		
		int [][] vMap=new int[N][M];
		
		if(cctvType==1) {
			for (int d = 0; d <4; d++) {
				// 현재의 배열 복사
				for (int i = 0; i < N; i++) {
					vMap[i]=Arrays.copyOf(nMap[i], M);
				}
				gosharp(cr, cc, d, vMap);
				dfs(idx+1, vMap);
			}
		}else if(cctvType==2) {
			for (int d = 0; d <2; d++) {
				// 현재의 배열 복사
				for (int i = 0; i < N; i++) {
					vMap[i]=Arrays.copyOf(nMap[i], M);
				}
				gosharp(cr, cc, d, vMap);
				gosharp(cr, cc, (d+2)%4, vMap);
				dfs(idx+1, vMap);
			}
		}else if(cctvType==3) {
			for (int d = 0; d <4; d++) {
				// 현재의 배열 복사
				for (int i = 0; i < N; i++) {
					vMap[i]=Arrays.copyOf(nMap[i], M);
				}
				gosharp(cr, cc, d, vMap);
				gosharp(cr, cc, (d+1)%4, vMap);
				dfs(idx+1, vMap);
			}
		}else if(cctvType==4) {
			for (int d = 0; d <4; d++) {
				// 현재의 배열 복사
				for (int i = 0; i < N; i++) {
					vMap[i]=Arrays.copyOf(nMap[i], M);
				}
				gosharp(cr, cc, d, vMap);
				gosharp(cr, cc, (d+1)%4, vMap);
				gosharp(cr, cc, (d+2)%4, vMap);
				dfs(idx+1, vMap);
			}
		}else if(cctvType==5) {
			for (int d = 0; d <1; d++) {
				// 현재의 배열 복사
				for (int i = 0; i < N; i++) {
					vMap[i]=Arrays.copyOf(nMap[i], M);
				}
				gosharp(cr, cc, d, vMap);
				gosharp(cr, cc, (d+1)%4, vMap);
				gosharp(cr, cc, (d+2)%4, vMap);
				gosharp(cr, cc, (d+3)%4, vMap);
				dfs(idx+1, vMap);
			}
		}
		
	}

	private static void gosharp(int r, int c, int d, int[][] mm) {
		// 한방향으로 진행하면서 0을 #으로 
		while(true) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(!check(nr,nc)) break;
			if(mm[nr][nc]==6) break;
			if(mm[nr][nc]==0) mm[nr][nc]=9;
			r=nr;
			c=nc;
		}
		
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
