import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[]=new int[1000000];
		for(int i = 0; i<N; i++ ) {
			A[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		long answer = 0;
		for(int i =0; i<N; i++) {
			if(A[i]-B>0) {
				if((A[i]-B)%C==0) {
					answer+=(A[i]-B)/C+1;
				}else {
					answer+=(A[i]-B)/C+2;
				}
			}else {
				answer++;
			}
		}
		System.out.println(answer);
	}
}