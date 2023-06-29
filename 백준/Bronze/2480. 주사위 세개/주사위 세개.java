import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dise = new int[7];
		for(int i=0; i<3; i++){
			dise[sc.nextInt()]++;
		}
		
		int flag=0;
		for(int i=0; i<7; i++){
			if(dise[i]==3){
				System.out.println(10000+1000*i);
				flag=3;
				break;
			}
		}
		if(flag==0){
			for(int i=0; i<7; i++){
				if(dise[i]==2){
					System.out.println(1000+100*i);
					flag=2;
					break;
				}
			}
		}
		if(flag==0){
			for(int i=6; i>0; i--){
				if(dise[i]==1){
					System.out.println(100*i);
					break;
				}
			}
		}
		
	}
	
}