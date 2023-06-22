import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] students = new int[30];
		for(int i=0; i<28; i++){
			students[sc.nextInt()-1]++;
		}
		
		for(int i=0; i<30; i++){
			if(students[i]==0){
				System.out.println(i+1);
			}
		}
		
		
		
		
	}
	
}