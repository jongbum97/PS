import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		List list = new ArrayList<>();
		for(int i=0; i<N; i++){
			list.add(sc.nextInt());
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(N/2));
		
	}
}
