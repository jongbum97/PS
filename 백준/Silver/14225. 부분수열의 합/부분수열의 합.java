import java.io.*;
import java.util.*;

public class Main {
	
	static int N, S[];
	static boolean check[];

    public static void main(String[] args) throws Exception {
       
    	Scanner sc = new Scanner(System.in);
    	
    	N = sc.nextInt();
    	S = new int[N];
    	for (int i = 0; i < N; i++) {
			S[i] = sc.nextInt();
		}
    	Arrays.sort(S);
    	
    	check = new boolean[20*100000+10];
    	for (int i = 0; i < 1<<N; i++) {
    		int sum = 0;
			for (int j = 0; j < N; j++) {
				if ( (i & 1<<j) != 0) sum+= S[j];
			}
			check[sum] = true;
		}
    	
    	for (int i = 1; i < 20*100000+10; i++) {
			if(!check[i]) {
				System.out.println(i);
				break;
			}
		}
    	
    	
    	
    	
    	
    }

}