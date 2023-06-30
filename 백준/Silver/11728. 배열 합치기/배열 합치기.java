import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt()+sc.nextInt();
		int[] n= new int[a];
		for(int i=0; i<a; i++){
			n[i] = sc.nextInt();
		}
		Arrays.sort(n);
		StringBuilder sb = new StringBuilder();
		for(int e : n) {
			sb.append(e);
			sb.append(" ");
		}
		System.out.println(sb);
		
	}
	
}