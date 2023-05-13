import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			int[] one = {'A', 'D', 'O', 'P', 'Q', 'R'};
			int two = 'B';
			char[] first = sc.next().toCharArray();
			char[] second = sc.next().toCharArray();
			
			outer : for(int i=0; i<first.length; i++){
				if(first[i]==two){
					first[i] = 2;
					continue;
				}
				for(int j=0; j<6 ; j++){
					if(first[i]==one[j]){
						first[i] = 1;
						continue outer;
					}
				}
				first[i] = 0;
			}
			outer : for(int i=0; i<second.length; i++){
				if(second[i]==two){
					second[i] = 2;
					continue;
				}
				for(int j=0; j<6 ; j++){
					if(second[i]==one[j]){
						second[i] = 1;
						continue outer;
					}
				}
				second[i] = 0;
			}
			
			String ans = "SAME";
			if(first.length==second.length){
				for(int i=0; i<first.length; i++){
					if(first[i]!=second[i]){
						ans = "DIFF";
					}
				}
			}else {
				ans = "DIFF";
			}
			
			System.out.println("#"+tc+" "+ans);
			
			
			
			
		}
	}
	

}
