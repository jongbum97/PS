import java.io.*;
import java.util.*;

public class Main {

	static int N, nums[], size, arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			nums[i] = Integer.parseInt(st.nextToken());
		}

		arr = new int[N];
		arr[0] = nums[0];
		size = 1;
		for(int i=1; i<N; i++){
			if(arr[size-1] < nums[i]){
				arr[size++] = nums[i];
			}else{
				int idx = binarySearch(arr, 0, size, nums[i]);
				if(idx < 0){
					arr[-1-idx] = nums[i];
				}
			}
		}

		System.out.println(N-size);

	}

	static int binarySearch(int[] arr, int left, int right, int key){

		while(left <= right){
			int mid = (left+right) / 2;

			if(key < arr[mid])
				right = mid - 1;
			else if(key > arr[mid])
				left = mid + 1;
			else
				return mid;

		}

		return -left-1;

	}

}
