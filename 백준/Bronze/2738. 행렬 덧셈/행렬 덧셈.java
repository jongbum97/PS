import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int[][] i1 = new int[a][b];
		for(int i=0; i<a; i++){
			for(int j=0; j<b ; j++){
				i1[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<a; i++){
			for(int j=0; j<b ; j++){
				System.out.print(i1[i][j]+sc.nextInt()+" ");
			}
			System.out.println();
		}
		
		
	}
}