import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String[] name = new String[N];
		int[] age = new int[N];
		for(int i=0; i<N; i++){
			name[i] = sc.next();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			age[i] = (2023-c)*360+(12-b)*30+(30-1);
		}
		
		int min_idx = 0;
		int max_idx = 0;
		for(int i=0; i<N; i++){
			if(age[min_idx]>age[i]){
				min_idx = i;
			}
			if(age[max_idx]<age[i]){
				max_idx = i;
			}
		}
		System.out.println(name[min_idx]);
		System.out.println(name[max_idx]);
	}
	
}