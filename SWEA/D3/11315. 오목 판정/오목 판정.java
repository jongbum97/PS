import java.util.*;

public class Solution {
	
	static String[][] map;
	static int N;
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new String[N][N];
			for(int i=0; i<N; i++){
				map[i] = sc.next().split("");
			}
			
			if(row() || col() || diagonal_L() || diagonal_R()){
				System.out.println("#"+tc+" YES");
			}else {
				System.out.println("#"+tc+" NO");
			}
		}
	}
	
	
	static boolean row() {
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N-4; j++){
				int ans = 0;
				for(int k=j; k<j+5; k++){
					if(map[i][k].equals("o")){
						ans++;
					}
				}
				if(ans>=5){
					return true;
				}
			}
		}
		return false;
	}
	
	static boolean col() {
			
			for(int j=0; j<N; j++){
				for(int i=0; i<N-4; i++){
					int ans = 0;
					for(int k=i; k<i+5; k++){
						if(map[k][j].equals("o")){
							ans++;
						}
					}
					if(ans>=5){
						return true;
					}
				}
			}
			return false;
		}
	
	static boolean diagonal_R() {
		
		for(int i=4; i<N; i++){
			for(int j=0; j<N ; j++){
				int ans = 0;
				for(int k=0; k<5; k++){
					if(i-k>=N || i-k<0 || j+k>=N || j+k<0){
						break;
					}
					if(map[i-k][j+k].equals("o")){
						ans++;
					}
				}
				if(ans>=5){
					
					return true;
				}
			}
		}
		return false;
	}
	
	
	static boolean diagonal_L() {
		
		for(int i=4; i<N; i++){
			for(int j=0; j<N ; j++){
				int ans = 0;
				for(int k=0; k<5; k++){
					if(i-k>=N || i-k<0 || j-k>=N || j-k<0){
						break;
					}
					if(map[i-k][j-k].equals("o")){
						ans++;
					}
				}
				if(ans>=5){
					return true;
				}
			}
		}
		return false;
	}
	
	
}
