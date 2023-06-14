import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count = 1;
		while(N>0){
			String[] s = new String[N];
			sc.nextLine();
			for(int i=0; i<N; i++){
				s[i] = sc.nextLine();
			}
			int[] phone = new int[N];
			for(int i=0; i<2*N-1; i++){
				int a = sc.nextInt()-1;
				String b = sc.next();
				if(phone[a]==0){
					phone[a]=1;
				}else {
					phone[a]=0;
				}
			}
			
			for(int i=0; i<N; i++){
				if(phone[i]==1){
					System.out.println(count+++" "+s[i]);
					break;
				}
			}
			N = sc.nextInt();
		}
			
		
	}
}