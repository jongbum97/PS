import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		while (q.size()>1) {
			q.remove();
			q.add(q.remove());
		}
		
		System.out.println(q.remove());
		
	}
	
}