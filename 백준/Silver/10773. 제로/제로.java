import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int K = sc.nextInt();
		Stack<Integer> st = new Stack<>();
		int[] nums = new int[K];
		for(int i=0; i<K; i++){
			int x = sc.nextInt();
			if(x!=0){
				st.add(x);
			}else {
				st.pop();
			}
		}
		BigInteger bi = new BigInteger("0");
		for(int i=0; i<st.size(); i++){
			bi = bi.add(BigInteger.valueOf(st.get(i)));
		}
		System.out.println(bi);
	}
}