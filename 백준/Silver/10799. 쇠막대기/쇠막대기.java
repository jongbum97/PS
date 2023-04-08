import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char[] sign = sc.nextLine().toCharArray();
		
		int ans = 0;
		int count = 0;
		int bar = 0;
		
		for(int i=0; i<sign.length-1; i++){
			if(sign[i]=='('){
				bar++;
				if(sign[i+1]=='('){
					count++;
				}else {
					ans += count;
					bar--;
				}
			}else {
				if(sign[i+1]=='('){
					
				}else {
					count--;
				}
			}
		}
		
		System.out.println(ans+bar);
		
		
		
		
		
	}
	
}
