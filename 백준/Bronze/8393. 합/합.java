import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ans = 0;
		int k = sc.nextInt();
		for(int i=1; i<=k; i++){
			ans += i;
		}
		System.out.println(ans);
	}
}