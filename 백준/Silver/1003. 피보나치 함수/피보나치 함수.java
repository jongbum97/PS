import java.util.*;

public class Main {
	
	static int[] fibo_num = new int[41];
	static {
		fibo_num[1] = 1;
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++){
			int N = sc.nextInt();
			if(N==0){
				System.out.println(1+" "+0);
			}else {
				System.out.println(fibo(N-1)+" "+fibo(N));
			}
			

			
		}
	}
	
	static int fibo(int N) {
		if(N>=2 && fibo_num[N]==0){
			fibo_num[N] = fibo(N-1) + fibo(N-2);
		}
		return fibo_num[N];

	}
}
