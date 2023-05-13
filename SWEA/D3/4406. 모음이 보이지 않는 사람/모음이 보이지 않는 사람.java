import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			char[] word = sc.next().toCharArray();
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<word.length; i++){
				switch (word[i]) {
				case 'a': 
					break;
				case 'e' :
					break;
				case 'i' :
					break;
				case 'o' :
					break;
				case 'u' :
					break;
				default :
					System.out.print(word[i]);
				}
			}
			System.out.println();
			
			
		}
	}
	

}
