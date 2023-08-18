import java.io.*;
import java.util.*;

public class Solution {
	
	static int M, A, moveA[], moveB[], BC[][], dr[]= {0,-1,0,1,0},dc[]= {0,0,1,0,-1},a,b,c,d, ans;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			moveA = new int[M];
			moveB = new int[M];
			BC = new int[A][4];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int aa = Integer.parseInt(st.nextToken())-1;
				int bb = Integer.parseInt(st.nextToken())-1;
				int cc = Integer.parseInt(st.nextToken());
				int dd = Integer.parseInt(st.nextToken());
				BC[i][0] = bb;
				BC[i][1] = aa;
				BC[i][2] = cc;
				BC[i][3] = dd;
			}
			
			ans = 0;
			a=0;b=0;c=9;d=9;
			int t = 0;
			while (t<=M) {
				
				// -1을 제외한(전체)BC중 가장 쎈 BC를 찾음
				int p = check(a, b, -1);
				int q = check(c, d, -1);
				if(p==q&&p!=-1) {
					// 같다면 같은것을 제외하고 다음으로 쎈 BC를 찾음
					int pp = check(a, b, p);
					int qq = check(c, d, q);
					if (pp != -1 && qq != -1) {
						// 둘다 더 있으면 둘중 큰거와 맨처음찾은거를 더함
						ans += Math.max(BC[pp][3], BC[qq][3]);
						ans += BC[p][3];
					}else if (pp>=0) {
						// 하나만 더 있으면 그거랑 처음거
						ans += BC[pp][3] + BC[p][3];
					}else if (qq>=0) {
						// 하나만 더 있으면 그거랑 처음거
						ans += BC[qq][3] + BC[p][3];
					}else {
						// 둘다 더 없으면 공유
						ans += BC[p][3];
					} 
				}else {
					//같지 않다면 각각 BC의 범위에 있으면 더해줌
					if (p!=-1) {
						ans += BC[p][3];
					}
					if (q!=-1) {
						ans += BC[q][3];
					}
				}
				if (t!=M) {
					a += dr[moveA[t]];
					b += dc[moveA[t]];
					c += dr[moveB[t]];
					d += dc[moveB[t]];
				}
				t++;
			}
			bw.write("#"+tc+" "+ans+"\n");
		}
		bw.close();
	}
	
	// x,y의 위치에서 BC의 번호가 p인것을 제외하고 제일 강한 BC의 번호를 반환하는 메서
	static int check(int x, int y, int p) {
		int max_idx = -1;
		for (int i = 0; i < A; i++) {
			if(i==p) continue;
			if (Math.abs(x-BC[i][0])+Math.abs(y-BC[i][1])<=BC[i][2]) {
				if (max_idx==-1) {
					max_idx = i;
				}else {
					if(BC[max_idx][3]<BC[i][3]) max_idx = i;
				}
			}
		}
		return max_idx;
	}
	
}