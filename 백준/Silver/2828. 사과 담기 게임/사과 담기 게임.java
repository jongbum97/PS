import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int start = 0;
		int end = M;
		int J = sc.nextInt();
		int ans = 0;
		for(int i=0; i<J; i++) {
			int a = sc.nextInt();
			if((a-1)<start){
				int b = start - (a-1);
				ans += b;
				start -= b;
				end -= b;
			}else if(a>end) {
				int b = a - end;
				ans += b;
				start += b;
				end += b;
			}
		}
		
		System.out.println(ans);
		
	}
}