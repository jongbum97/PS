import java.util.*;
 
public class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
         
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] price = new int[N];
            for(int i=0; i<N; i++){
                price[i] = sc.nextInt();
            }
            long ans = 0;
            for(int i=N-1; i>=1; i--){
                for(int j=i-1; j>=0; j--){
                    if(price[j] > price[i]){
                        i = j+1;
                        break;
                    }else {
                        ans += price[i]-price[j];
                    }
                    if(j==0){
                        i = 0;
                    }
                }
            }
             
            System.out.println("#"+tc+" "+ans);
 
        }
    }
}
