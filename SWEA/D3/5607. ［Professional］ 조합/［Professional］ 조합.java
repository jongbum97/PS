import java.io.*;
import java.util.*;
   
public class Solution {
      
	static int P = 1234567891;
   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int N, R;
        
        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            
            long num = (factorial(N-R)*factorial(R))%P;
            long ans = (mmm(num, P-2)*factorial(N))%P;
            
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
            
        }
        
        System.out.print(sb.toString());
          
    }
    
    
    static long mmm(long num, int n) {
    	
    	if(n==1) return num;
    	
    	if(n%2==0) {
    		long k = mmm(num, n/2);
    		return (k*k)%P;
    	}else {
    		long k = mmm(num, (n-1)/2);
    		return (((k*k)%P)*num)%P;
    	}
    	
    	
    	
    }
      
    static long factorial(int n) {
    	
    	long cnt = 1;
    	
    	for (int i = 2; i <= n; i++) {
			cnt *= i;
			cnt %= P;
		}
    	
    	return cnt;
    	
    }
    
    
}