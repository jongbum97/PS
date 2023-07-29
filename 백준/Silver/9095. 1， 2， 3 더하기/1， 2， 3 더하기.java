import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(bf.readLine());
			int[] nums = new int[11];
			nums[0] = 1;
			nums[1] = 2;
			nums[2] = 4;
			for (int i = 3; i < n; i++) {
				nums[i] = nums[i-1] + nums[i-2] + nums[i-3];
			}
			
			bw.write(nums[n-1]+"\n");
			
		}
		bw.close();
		
		
		
		
		
	}	
		
}
