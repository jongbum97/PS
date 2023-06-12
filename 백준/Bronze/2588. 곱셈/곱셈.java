import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		char[] bb = (b+"").toCharArray();
		for(int i=2; i>=0; i--){
			System.out.println(a*(bb[i]-'0'));
		}
		System.out.println(a*b);
	}
}