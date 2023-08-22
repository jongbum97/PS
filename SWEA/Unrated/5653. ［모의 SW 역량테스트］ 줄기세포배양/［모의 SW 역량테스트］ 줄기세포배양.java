import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Solution {
	
    static int N, M, K, dr[]= {-1,0,1,0}, dc[]= {0,1,0,-1}, ans;
    static Cell[][] map;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	map = new Cell[N+2*K][M+2*K];
        	for (int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int a = Integer.parseInt(st.nextToken());
					if (a!=0) {
						map[i+K][j+K] = new Cell(a, false);
					}
				}
			}
			int time = 0;
        	while (time<K) {

        		for (int i = K-time; i < K+N+time; i++) {
    				for (int j = K-time; j < K+M+time; j++) {
    					if(map[i][j]==null) continue;
    					if(map[i][j].state()==1 && !map[i][j].isNew) {
							for (int k = 0; k < 4; k++) {
								int a = i + dr[k];
								int b = j + dc[k];
								if(a<0||a>N+2*K-1||b<0||b>M+2*K-1) continue;
								if(map[a][b]==null) {
									map[a][b] = new Cell(map[i][j].max_life);
								}else if (map[a][b].isNew) {
									if (map[a][b].max_life<map[i][j].max_life) {
										map[a][b] = new Cell(map[i][j].max_life);
									}
								}
							}
						}
    					if(!map[i][j].isNew) map[i][j].go();
    				}
    			}
        		for (int i = K-time; i < K+N+time; i++) {
    				for (int j = K-time; j < K+M+time; j++) {
    					if(map[i][j]==null) continue;
    					if(map[i][j].isNew) map[i][j].isNew = false;
    				}
        		}
        		time++;
        	}
        	ans = 0;
        	for (int i = 0; i < N+2*K; i++) {
				for (int j = 0; j < M+2*K; j++) {
					if(map[i][j]==null) continue;
					if(map[i][j].state()>=0) ans++;
				}
    		}
        	System.out.println("#"+t+" "+ans);
        	
        }
    } 
}

class Cell{
	int max_life;
	int life;
	boolean isNew;
	
	Cell(int x){
		max_life = life = x;
		isNew = true;
	}Cell(int x, boolean b){
		max_life = life = x;
		isNew = b;
	}
	int state() {
		if (-1*max_life>=life) {
			return -1;
		}else if (life<=0) {
			return 1;
		}else {
			return 0;
		}
	}
	void go() {
		isNew = false;
		life--;
	}
}