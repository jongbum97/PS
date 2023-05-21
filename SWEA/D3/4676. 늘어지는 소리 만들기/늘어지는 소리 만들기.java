import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			ArrayList<Character> list = new ArrayList<>();
			char[] ch = sc.next().toCharArray();
			for(int i=0; i<ch.length; i++){
				list.add(ch[i]);
			}
			int H = sc.nextInt();
			Integer[] arr = new Integer[H];
			for(int i=0; i<H; i++){
				arr[i] = sc.nextInt();
			}
			String ans = "";
			Arrays.sort(arr,Collections.reverseOrder());
			for(int i=0; i<H; i++){
				list.add(arr[i], '-');
			}
			for(int i=0; i<list.size(); i++){
				ans += list.get(i);
			}
			
			
			
			System.out.println("#"+tc+" "+ans);
			
			
			
		}
	}
}
