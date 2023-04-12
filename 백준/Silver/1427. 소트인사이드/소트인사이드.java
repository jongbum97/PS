import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] N = sc.next().split("");
		
		Arrays.sort(N);
		int ans = 0;
		
		int[] N2 = new int[N.length];
		for(int i=0; i<N.length; i++){
			N2[i] = Integer.parseInt(N[N.length-i-1]);
		}
		
		for(int i=0; i<N.length; i++){
			ans *= 10;
			ans += N2[i];
		}
		
		System.out.println(ans);
	}
}
