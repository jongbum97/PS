import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		
		int k =0;
		int j = 0;
		for(int i=1; i<5000; i++){
			if(k<X){
				k+=i;
				j = i;
			}
		}
		
		int m = k-X;

		
		if(j%2==0){
			System.out.println(j-m+"/"+(j-(j-m-1)));
		}else {
			System.out.println((j-(j-m-1))+"/"+(j-m));
		}
		
	}
}
