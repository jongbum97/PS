import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++){
			int[] arr = new int[10];
			int idx = 0;
			for(int j=0; j<10; j++){
				arr[j]=sc.nextInt();
				if(arr[idx]<arr[j]) {
					idx = j;
				}
			}
			System.out.println("#"+(tc+1)+" "+arr[idx]);
		}
		
	}
}