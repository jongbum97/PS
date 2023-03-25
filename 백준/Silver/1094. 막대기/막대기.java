import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int X = sc.nextInt();
			int answer = 0;
			String num = Integer.toBinaryString(X);
			for(int i = 0; i<num.length(); i++) {
				if(num.charAt(i)=='1') {
					answer++;
				}
			}
			
			System.out.println(answer);
			

	}
}