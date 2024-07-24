import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int l = (int) Math.log10(N) + 1;
		boolean[][] check = new boolean[1_000_001][K+1];
		if(l==1 || (l==2 && N%10==0)){
			System.out.println(-1);
			return;
		}

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{N, 0});
		check[N][0] = true;

		while(!q.isEmpty()){

			int[] n = q.remove();
			if(n[1] == K) continue;

			for(int i=0; i<l; i++){
				int a = (n[0] / (int)Math.pow(10, l-1-i)) % 10;
				for(int j=i+1; j<l; j++){
					int b = (n[0] / (int)Math.pow(10, l-1-j)) % 10;
					if(i!=0 || b!=0){
						int tmp = n[0] + (int) Math.pow(10, l-1-i)*(b-a) + (int) Math.pow(10, l-1-j)*(a-b);
						if(!check[tmp][n[1]+1]){
							q.add(new int[]{tmp, n[1]+1});
							check[tmp][n[1]+1] = true;
						}
					}
				}
			}

		}

		for(int i=1_000_000; i>=0; i--){
			if(check[i][K]){
				System.out.println(i);
				break;
			}
		}


	}

}
