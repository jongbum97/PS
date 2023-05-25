import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for(int i=1; i<=N; i++){
			String s = i+"";
			int count = 0;
			for(int j=0; j<s.length(); j++){
				if(s.charAt(j)=='3' || s.charAt(j)=='6' || s.charAt(j)=='9' ){
					count++;
					System.out.print("-");
				}
			}
			if(count==0){
				System.out.print(i);
			}
			System.out.print(" ");
		}
	}
}
