import java.io.*;
import java.util.*;

public class Main {
	
	static int N, nums[], size;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		nums[0] = Integer.parseInt(st.nextToken());
		size = 1;
//		System.out.println(Arrays.toString(nums)); 
		for (int i = 1; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			int idx = bSearch(x);
			if(nums[size-1] < x) nums[size++] = x;
			else nums[idx] = x;
//			System.out.println(Arrays.toString(nums)); 
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if(nums[i]==0) break;
			ans = i+1;
		}
		System.out.println(ans);
		
		
	}
	
	
	
	static int bSearch(int n) {
		
		int left = 0;
		int right = size;
		int mid = (left+right)/2;
		
		while (left<=right) {
			if(nums[mid]>n) right = mid -1;
			else if(nums[mid]<n) left = mid + 1 ;
			else break;
			
			mid = (right+left)/2;
			
		}
		
		while(nums[mid]<n && nums[mid]>0) {
			mid++;
		}
//		if(nums[mid]<n) mid++;
		
		return mid;
		
	}
	
}