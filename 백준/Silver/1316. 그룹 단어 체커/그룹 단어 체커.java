import java.util.*;

public class Main {
    public static void main(String[] args){
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	int ans = 0;
    	for(int i=0; i<N; i++){
    		String str = sc.next();
    		if(check(str)){
				ans++;
			}
		}
    	
    	System.out.println(ans);
    	
    }
    
    static boolean check(String str) {
    	int[] alpa = new int[26];
    	for(int i=0; i<str.length(); i++){
			if(alpa[str.charAt(i)-'a']!=0){
				if(str.charAt(i-1)!=str.charAt(i)){
					return false;
				}
			}
			alpa[str.charAt(i)-'a']++;
		}
    	return true;
    }
}