import java.io.*;
import java.util.*;

public class Main {

	static int green[][], blue[][], ans, total;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		green = new int[6][4];
		blue = new int[6][4];
		while(N-- > 0){
			String[] input = br.readLine().split(" ");
			int t = Integer.parseInt(input[0]);
			int x = Integer.parseInt(input[1]);
			int y = Integer.parseInt(input[2]);
			put(x, y, t);
			down();
			score();
			remove();
		}

		for(int i=0; i<6; i++){
			for(int j=0; j<4; j++){
				if(green[i][j] == 1) total++;
				if(blue[i][j] == 1) total++;
			}
		}
		System.out.println(ans);
		System.out.println(total);
	}

	static void put(int x, int y, int t){
		if(t == 1){
			green[0][y] = 1;
			blue[0][x] = 1;
		}else if(t == 2){
			green[0][y] = green[0][y+1] = 1;
			blue[0][x] = blue[1][x] = 1;
		}else{
			green[0][y] = green[1][y] = 1;
			blue[0][x] = blue[0][x+1] = 1;
		}
	}

	static void down(){
		for(int i=1; i>=0; i--){
			int cnt = 5;
			outer : for(int j=i+1; j<6; j++){
				for(int k=0; k<4; k++){
					if(green[i][k]==1 && green[j][k]==1) {
						cnt = j-1;
						break outer;
					}
				}
			}
			for(int k=0; k<4; k++){
				if(green[i][k]==1){
					green[i][k] = 0;
					green[cnt][k] = 1;
				}
			}

		}
		for(int i=1; i>=0; i--){
			int cnt = 5;
			outer : for(int j=i+1; j<6; j++){
				for(int k=0; k<4; k++){
					if(blue[i][k]==1 && blue[j][k]==1) {
						cnt = j-1;
						break outer;
					}
				}
			}

			for(int k=0; k<4; k++){
				if(blue[i][k]==1){
					blue[i][k] = 0;
					blue[cnt][k] = 1;
				}
			}
		}
	}

	static void score(){
		outer: for(int i=2; i<6; i++){
			for(int j=0; j<4; j++){
				if(green[i][j] != 1) continue outer;
			}
			ans++;
			for(int k=i-1; k>=0; k--){
				for(int j=0; j<4; j++){
					green[k+1][j] = green[k][j];
				}
			}
		}
		outer: for(int i=2; i<6; i++){
			for(int j=0; j<4; j++){
				if(blue[i][j] != 1) continue outer;
			}
			ans++;
			for(int k=i-1; k>=0; k--){
				for(int j=0; j<4; j++){
					blue[k+1][j] = blue[k][j];
				}
			}
		}
	}

	static void remove(){
		int cnt = 0;
		outer: for(int i=0; i<2; i++){
			for(int j=0; j<4; j++){
				if(green[i][j] == 1){
					cnt = 2-i;
					break outer;
				}
			}
		}
		if(cnt != 0){
			for(int i=5; i>1; i--){
				for(int j=0; j<4; j++){
					green[i][j] = green[i-cnt][j];
					green[i-cnt][j] = 0;
				}
			}
		}
		cnt = 0;
		outer: for(int i=0; i<2; i++){
			for(int j=0; j<4; j++){
				if(blue[i][j] == 1){
					cnt = 2-i;
					break outer;
				}
			}
		}
		if(cnt != 0){
			for(int i=5; i>1; i--){
				for(int j=0; j<4; j++){
					blue[i][j] = blue[i-cnt][j];
					blue[i-cnt][j] = 0;
				}
			}
		}
	}

}