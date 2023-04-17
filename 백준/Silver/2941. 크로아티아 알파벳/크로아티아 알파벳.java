import java.util.*;

public class Main {
    public static void main(String[] args){
    	
    	Scanner sc = new Scanner(System.in);
    
    	char[] alpa = sc.next().toCharArray();
    	int N = alpa.length;
    	String[] croatia = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};
    	String str = "dz=";
    	int ans = 0;
    	
    	for(int i=0; i<N; i++){
			if(i==N-1){
				ans++;
				break;
			}
    		
    		for(int j=0; j<7; j++){
				if((alpa[i]+""+alpa[i+1]).equals(croatia[j])){
					ans++;
					i++;
					break;
				}
				if(j==6 && i<N-2){
					if((alpa[i]+""+alpa[i+1]+alpa[i+2]).equals(str)){
						ans++;
						i+=2;
						break;
					}
				}
				if(j==6){
					ans++;
					break;
				}
			}
		}
    	
    	
    	System.out.println(ans);
    	
    	
    	
    	
    	
    	
    	
    	
    }
}