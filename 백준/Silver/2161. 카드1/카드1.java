import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Queue<Integer> que = new LinkedList<>();
		
		for(int i=1; i<=N; i++){
			que.add(i);
		}
		while(true){
			System.out.println(que.poll());
			if(que.isEmpty()){
				break;
			}
			que.add(que.poll());
		}
		
		
		
	}
}