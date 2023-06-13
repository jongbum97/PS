import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long S = sc.nextLong();
		long sum = 0;
		for(int i=1; ; i++){
			sum += i;
			if(sum>S){
				System.out.println(i-1);
				break;
			}
		}
		
	}
}