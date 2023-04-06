import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String num = sc.next();
	
		String[] arr = new String[N];
		arr = num.split("");
		
		
		int sum = 0;
		for(int i=0; i<N; i++){
			sum += Integer.parseInt(arr[i]);
		}
		
		System.out.println(sum);

	}
}