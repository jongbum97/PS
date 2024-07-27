import java.io.*;
import java.util.*;

public class Main {

	static int N, size[], sum[], sumColor[][], ans[];
	static Node whole[], color[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		size = new int[N+1];
		whole = new Node[N];
		color = new Node[N+1][];
		for(int i=0; i<N; i++){
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			whole[i] = new Node(i, a, b);
			size[a]++;
		}
		sumColor = new int[N+1][];
		for(int i=0; i<=N; i++){
			color[i] = new Node[size[i]];
			sumColor[i] = new int[size[i]];
		}
		for(Node n : whole){
			color[n.color][--size[n.color]] = n;
		}
		Arrays.sort(whole, (a,b) -> a.size-b.size);
		for(Node[] n : color){
			Arrays.sort(n, (a,b) -> a.size-b.size);
		}

		sum = new int[N];
		for(int i=1; i<N; i++){
			sum[i] = sum[i-1] + whole[i-1].size;
		}
		for(int i=1; i<=N; i++){
			for(int j=1; j<sumColor[i].length; j++){
				sumColor[i][j] = sumColor[i][j-1] + color[i][j-1].size;
			}
		}
		ans = new int[N];
		for(int i=0; i<N; i++){
			Node n = whole[i];
			int idx = i;
			while(idx != 0 && whole[idx-1].size == whole[idx].size){
				idx--;
			}
			ans[n.n] = sum[idx] - sumColor[n.color][binarySearch(color[n.color], n.size)];
		}

		for(int n : ans){
			sb.append(n).append("\n");
		}

		System.out.println(sb);

	}

	static int binarySearch(Node[] arr, int size){
		int left = 0;
		int right = arr.length;
		while(left <= right){
			int mid = (left + right) / 2;

			if(arr[mid].size < size)
				left = mid + 1;
			else
				right = mid - 1;

		}
		return left;
	}

	static class Node{
		int n;
		int color;
		int size;
		Node(int n, int color, int size){
			this.n = n;
			this.color = color;
			this.size = size;
		}
	}

}
