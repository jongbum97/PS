import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n-i-1; j++) {
				sb.append(" ");
			}
			for (int j = n-i-1; j < n; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		
	}
}
