import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int a = 1;
		int b = 1;
		int sum;
		int ans = 0;
		while(a<=N){
			sum = 0;
			for(int i=a; i<=b; i++){
				sum += i;
			}
			if(sum==N){
				ans++;
				a++;
				b++;
			}else if (sum>N) {
				a++;
			}else {
				b++;
			}
		}
		System.out.println(ans);
	}
}