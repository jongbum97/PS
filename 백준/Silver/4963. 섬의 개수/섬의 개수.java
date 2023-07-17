import java.util.*;

public class Main {
	
	static int w, h, ans;
	static int[][] field;
	static boolean visit[][];
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		w = sc.nextInt();
		h = sc.nextInt();
		while(w!=0 || h!=0){
			ans = 0;
			field = new int[h][w];
			visit = new boolean[h][w];
			for(int i=0; i<h; i++){
				for(int j=0; j<w; j++){
					field[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<h; i++){
				for(int j=0; j<w; j++){
					if(!visit[i][j] && field[i][j]==1){
						ans ++;
						BFS(i, j);
					}
				}
			}
			System.out.println(ans);
			w = sc.nextInt();
			h = sc.nextInt();
			
		}
		
		
		
	}
	
	static void BFS(int x, int y) {
		visit[x][y] = true;
		
		for(int i=0; i<8; i++){
			if(x+dr[i]<0 || x+dr[i]>h-1 || y+dc[i]<0 || y+dc[i]>w-1){
				continue;
			}else {
				if(!visit[x+dr[i]][y+dc[i]] && field[x+dr[i]][y+dc[i]]==1){
					BFS(x+dr[i], y+dc[i]);
				}
			}
		}
		
	}
	
}