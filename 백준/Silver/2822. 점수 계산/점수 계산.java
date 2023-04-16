import java.util.*;

public class Main {
    public static void main(String[] args){
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int[] score = new int[8];
    	int[] score2 = new int[8];
    	int[] index = new int[5];
    	int key = 0;
    	for(int i=0; i<8; i++){
    		int k = sc.nextInt();
			score[i] = k;
			score2[i] = k;
		}
    	Arrays.sort(score2);
    	int ans = 0;
    	
    	for(int i=7; i>=3; i--){
    		ans += score2[i];
			for(int j=0; j<8 ; j++){
				if(score2[i]==score[j]){
					index[key++] = j;
					break;
				}
			}
		}
    	Arrays.sort(index);
    	
			
    	System.out.println(ans);
    	for (int e : index) {
			System.out.print((e+1)+" ");
		}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}