import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i<N; i++){
				arr[i] = sc.nextInt();
			}
			
			ArrayList<Integer> arrl = new ArrayList<>();
			for(int i=0; i<N; i++){
				outer : for(int j=i+1; j<N ; j++){
					int k = arr[i]*arr[j];
					String ks = k+"";
					for(int p=0; p<ks.length()-1; p++){
						if(ks.charAt(p+1)!=ks.charAt(p)+1){
							continue outer;
						}
					}
					arrl.add(k);
				}
			}
			
			arrl.sort(null);
			
			if(arrl.isEmpty()){
				System.out.println("#"+tc+" "+(-1));
			}else {
				System.out.println("#"+tc+" "+arrl.get(arrl.size()-1));
			}
			
			
		}
	}
	

}
