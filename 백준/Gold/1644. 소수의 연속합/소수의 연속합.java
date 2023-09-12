import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static boolean[] nums;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		nums = new boolean[N+1];
		for (int i = 2; N >= i*i; i++) {
			for (int j = 2; i*j <= N; j++) {
				nums[i*j] = true;
			}
		}
		
		int ans = 0;
		int head = 2;
		int tail = 3;
		int sum = 5;
		if(N==1) {
			System.out.println(0);
			return;
		}else if(N==2) {
			System.out.println(1);
			return;
		}
		while (tail > head) {
			if(sum<N) {
				for (int i = tail+1; i <= N; i++) {
					if(!nums[i]) {
						tail = i;
						break;
					}
				}
				sum += tail;
			}else if(sum>N){
				sum -= head;
				for (int i = head+1; i <= N; i++) {
					if(!nums[i]) {
						head = i;
						break;
					}
				}
			}else {
				ans++;
				for (int i = tail+1; i <= N; i++) {
					if(!nums[i]) {
						tail = i;
						break;
					}
				}
				sum += tail;
			}
		}
		if(!nums[N]) ans++;
		System.out.println(ans);
		
	}
}