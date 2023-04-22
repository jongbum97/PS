import java.util.*;

public class Solution {
	
	public static void main(String[] args) {
		
		for(int i=2; i<1000000; i++){
			int count = 0;
			for(int j=2; j<=(int)Math.pow(i, 0.5); j++){
				if(i%j==0){
					count++;
					break;
				}
			}
			if(count==0){
				System.out.print(i+" ");
			}
		}
		
		
			
		
		
		
	}
}
