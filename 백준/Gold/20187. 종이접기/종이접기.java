import java.io.*;
import java.util.*;

public class Main {

	static int K, M, paper[][], x, y, tmp[][];
	static char[] f;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		K = Integer.parseInt(br.readLine());
		f = br.readLine().replace(" ", "").toCharArray();
		M = Integer.parseInt(br.readLine());
		paper = new int[1 << K][1 << K];

		aaa();
		
		bbb(0, 0, K-1);
		
		for (int i = 0; i < 1<<K ; i++) {
			for (int j = 0; j < 1<<K ; j++) {
				bw.write(paper[i][j]+" ");
			}bw.write("\n");
		}
		bw.close();

	}

	static void aaa() {
		tmp = new int[2][2];
		if (f[2 * K - 1] == 'D' || f[2 * K - 2] == 'D') {
			x = 1;
		}
		if (f[2 * K - 1] == 'R' || f[2 * K - 2] == 'R') {
			y = 1;
		}
		int a = (M>1)? 2:0;
		tmp[x][y] = M;
		tmp[(x+1)%2][y] = (M+2)%4;
		tmp[x][(y+1)%2] = (M+1)%2+a;
		tmp[(x+1)%2][(y+1)%2] = ((M+1)%2+a+2)%4;
		
	
	}
	
	static void bbb(int a, int b, int p) {
		
		if (p==0) {
			paper[a][b] = tmp[0][0];
			paper[a+1][b] = tmp[1][0];
			paper[a][b+1] = tmp[0][1];
			paper[a+1][b+1] = tmp[1][1];
			return;
		}
		
		bbb(a, b, p-1);
		bbb(a+(1<<p), b, p-1);
		bbb(a, b+(1<<p), p-1);
		bbb(a+(1<<p), b+(1<<p), p-1);
		
		
	}

}