import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			char[] arr = sc.next().toCharArray();
			Arrays.sort(arr);
			for(int i=arr.length-1; i>0; i--){
				if(arr[i]==arr[i-1]){
					arr[i] = 200;
					arr[i-1] = 200;
				}
			}
			Arrays.sort(arr);
			if(arr[0]==200){
				System.out.println("#"+tc+" Good");
			}else {
				System.out.print("#"+tc+" ");
				for(int i=0; i<arr.length; i++){
					if(arr[i]!=200){
						System.out.print(arr[i]);
					}else {
						break;
					}
				}
				System.out.println();
			}
			
			
			
		}
	}
	

}
