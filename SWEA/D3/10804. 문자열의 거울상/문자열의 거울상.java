import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			char[] arr = sc.next().toCharArray();
			char[] arr2 = new char[arr.length];
			
			System.out.print("#"+tc+" ");
			for(int i=arr.length-1; i>=0; i--){
				if(arr[i]=='b'){
					System.out.print('d');
				}else if (arr[i]=='d') {
					System.out.print('b');
				}else if (arr[i]=='p') {
					System.out.print('q');
				}else if (arr[i]=='q') {
					System.out.print('p');
				}
			}
			System.out.println();
			
			
		}
	}
	

}
