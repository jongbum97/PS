import java.io.*;
import java.util.*;

public class Main {

	static int A, B, dp[][];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());

		double pA = probability(A/100d, 1d, 0, 0);
		double pB = probability(B/100d, 1d, 0, 0);
		double ans = 1 - (1-pA)*(1-pB);

		System.out.println(ans);

	}

	private static double probability(double pWin, double pRecent, int score, int cnt) {

		if(cnt == 18){
			if(prime(score))
				return pRecent;
			else
				return 0;
		}

		double a = probability(pWin, pRecent*pWin, score+1, cnt+1);
		double b = probability(pWin, pRecent*(1-pWin), score, cnt+1);

		return a+b;
	}

	private static boolean prime(int x){
		if(x<=1) return false;

		for (int i=2; i<=Math.sqrt(x); i++){
			if(x%i == 0) return false;
		}
		return true;
	}


}
