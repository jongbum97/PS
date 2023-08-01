import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		if (k<=20) {
			System.out.println(dpI(k));
			top(k, 1, 2, 3);
			System.out.print(sb);
		}else {
			System.out.println(dpB(k));
		}
	}
	
	
	
	static void top(int N, int start, int tmp, int end) {
		
		if (N==1) {
			sb.append(start+" "+end+"\n");
			return;
		}
		
		top(N-1, start, end, tmp);
		sb.append(start+" "+end+"\n");
		top(N-1, tmp, start, end);
		
	}
	
	static BigInteger dpB(int N) {
		
		if (N==1) {
			return BigInteger.ONE;
		}
		
		return dpB(N-1).multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(1));
		
	}
	
	static int dpI(int N) {
		
		if (N==1) {
			return 1;
		}
		
		return 2*dpI(N-1)+1;
		
	}
	
	
}