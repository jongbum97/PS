import java.io.*;
import java.util.*;

public class Main {

	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++){

			String[] tmp = br.readLine().split(" ");
			N = Integer.parseInt(tmp[1]) - Integer.parseInt(tmp[0]);

			sb.append(Math.min(odd(), even())).append("\n");

		}

		System.out.println(sb.toString());
		
	}

	public static long odd(){
		long sum = 0;
		for(int i=1; i<2147483647; i++){
			sum += 2L*i-1;
			if(sum >= N)
				return 2L*i-1;
		}
		return 1;
	}

	public static long even(){
		long sum = 0;
		for(int i=1; i<2147483647; i++){
			sum += 2L*i;
			if(sum >= N)
				return 2L*i;
		}
		return 0;
	}


}
