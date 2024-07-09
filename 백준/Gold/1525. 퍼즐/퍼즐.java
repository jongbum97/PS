import java.io.*;
import java.util.*;

public class Main {

	static int nums[][], ans;
	static Set<Integer> result;
	static final int end = 1985229328, dr[] = {-1, 0, 1, 0}, dc[] = {0, 1 ,0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nums = new int[3][3];
		for(int i=0; i<3; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++){
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = -1;
		result = new HashSet<>();
		int t = arrToBit(nums);

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{t, 0});
		result.add(t);

		while(!q.isEmpty()){

			int[] n = q.remove();

			if(n[0] == end){
				ans = n[1];
				break;
			}

			int[][] arr = bitToArr(n[0]);
			for(int i=0; i<3; i++){
				for(int j=0; j<3; j++){
					if(arr[i][j] == 0){
						for(int k=0; k<4; k++){
							int a = i + dr[k];
							int b = j + dc[k];
							if(a<0 || a>2 || b<0 || b>2) continue;

							arr[i][j] = arr[a][b];
							arr[a][b] = 0;
							int tmp = arrToBit(arr);
							if(!result.contains(tmp)){
								result.add(tmp);
								q.add(new int[]{tmp, n[1]+1});
							}
							arr[a][b] = arr[i][j];
							arr[i][j] = 0;
						}
					}
				}
			}

		}

		System.out.println(ans);

	}


	static int arrToBit(int[][] arr){
		int a = 0;
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(arr[i][j] == 0) continue;
				a |= i*3+j << (arr[i][j]-1)*4;
			}
		}
		return a;
	}

	static int[][] bitToArr(int bit){
		int[][] result = new int[3][3];
		for(int i=0; i<8; i++){
			int k = (bit >> i*4) & 15;
			result[k/3][k%3] = i+1;
		}
		return result;
	}

}
