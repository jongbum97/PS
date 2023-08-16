import java.io.*;
import java.util.*;

public class Main {

	static int result[][];
	static boolean state;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		outer : for (int tc = 0; tc < 4; tc++) {
			result = new int[6][3];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 6; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				if ((a+b+c)==5) {
					result[i][0] = a;
					result[i][1] = b;
					result[i][2] = c;
				}else {
					bw.write(0+" ");
					continue outer;
				}
				
			}
			state = false;
			judge(0, -1);
			
			if (state) {
				bw.write(1+" ");
			}else {
				bw.write(0+" ");
			}
			
		}
		
		bw.close();
		
	}
	
	static void judge(int x, int y) {
		for (int i = x; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if(i==x&&j<=y) continue;
				if(i>=j)continue;
				for (int k = 0; k < 3; k++) {
					if(state) return;
					if(result[i][k]>0) {
						if (result[j][2-k]>0) {
							result[i][k]--;
							result[j][2-k]--;
							judge(i, j);
							result[i][k]++;
							result[j][2-k]++;
						}
					}
				}
				return;
			}
		}
		
		state = true;
		
	}
	
}