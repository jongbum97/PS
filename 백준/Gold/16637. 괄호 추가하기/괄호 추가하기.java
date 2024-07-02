import java.io.*;
import java.util.*;

public class Main {

	static int N, nums[];
	static char operator[];
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		nums = new int[N/2+1];
		operator = new char[N/2+1];
		operator[0] = '+';
		char[] tmp = br.readLine().toCharArray();
		for(int i=0; i<N; i++){
			if(i%2==0) nums[i/2] = tmp[i]-'0';
			else operator[i/2+1] = tmp[i];
		}

		ans = Long.MIN_VALUE;
		calculate(0, 0);

		System.out.println(ans);

	}

	static void calculate(int cnt, long result){

		if(cnt == N/2+1){
			ans = Math.max(ans, result);
			return;
		}

		calculate(cnt+1, operate(result, nums[cnt], operator[cnt]));

		if(cnt != N/2){
			calculate(cnt+2, operate(result, operate(nums[cnt], nums[cnt+1], operator[cnt+1]), operator[cnt]));
		}


	}

	static long operate(long a, long b, char c){

        switch (c) {
			case '+' :
				return a + b;
            case '-' :
				return a - b;
            case '*' :
				return a * b;
        };

		return -1;

    }

}
