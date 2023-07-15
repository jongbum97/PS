import java.util.*;
 
public class Solution {
    public static void main(String args[]) throws Exception {
 
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[][] lotation = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N ; j++){
                    lotation[i][j] = sc.nextInt();
                }
            }
             
            String[] ans = new String[N];
            for(int i=0; i<N; i++){
                ans[i] = "";
            }
             
            //90도
            for(int j=0; j<N; j++){
                for(int i=N-1; i>=0; i--){
                    ans[j] += lotation[i][j]+"";
                }
            }
             
            for(int i=0; i<N; i++){
                ans[i] += " ";
            }
             
            //180도
            for(int i=N-1; i>=0; i--){
                for(int j=N-1; j>=0 ; j--){
                    ans[N-i-1] += lotation[i][j]+"";
                }
            }
             
            for(int i=0; i<N; i++){
                ans[i] += " ";
            }
             
            //270도
            for(int j=N-1; j>=0; j--){
                for(int i=0; i<N; i++){
                    ans[N-j-1] += lotation[i][j]+"";
                }
            }
             
             
             
            System.out.println("#"+tc+" ");
            for(int i=0; i<N; i++){
                System.out.println(ans[i]);
            }
             
             
        }
 
    }
}