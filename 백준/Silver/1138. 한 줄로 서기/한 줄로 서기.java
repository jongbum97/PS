import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] line = new int[N];
		for(int i=0; i<N; i++){
			line[i] = sc.nextInt();
		}
		
		int[] ans = new int[N];
		for(int i=0; i<N; i++){
			
			int k = line[i];
			for(int j=0; j<=k; j++){
				if(ans[j]>0){
					k++;
				}
			}
			
			ans[k] = i+1;
			
			
		}
	
		for (int e : ans) {
			System.out.print(e+" ");
		}
		
	
	
	
	
	
	

	}
}
