import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

			
			
			for(int i=0; i<3; i++){
				
				int N = sc.nextInt();
				BigInteger[] arr = new BigInteger[N];
				for(int j=0; j<N; j++){
					arr[j] = sc.nextBigInteger();
				}
				BigInteger ans = new BigInteger("0");
				for(int j=0; j<N; j++){
					ans = ans.add(arr[j]);
				}
				BigInteger zero = new BigInteger("0");
				
				int A = ans.compareTo(zero);
				if(A==-1){
					System.out.println("-");
				}else if (A==0) {
					System.out.println(0);
				}else {
					System.out.println("+");
				}
				
				
				
				
				
				
			}
			
	}
}
