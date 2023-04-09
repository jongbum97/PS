import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

			int N = sc.nextInt();
			int[] time = new int[N];
			for(int i=0; i<N; i++){
				time[i] = sc.nextInt();
			}
			
			int Y = 0;
			int M = 0;
			
			
			for(int i=0; i<N; i++){
				Y += ((time[i]/30)+1)*10;
				M += ((time[i]/60)+1)*15;
			}
			
			
			if(Y>M){
				System.out.println("M "+M);
			}else if(Y==M){
				System.out.println("Y M "+M);
			}else {
				System.out.println("Y "+Y);
			}
			
		
	}
}
