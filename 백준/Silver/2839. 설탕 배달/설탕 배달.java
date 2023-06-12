import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		List<Integer> list = new ArrayList();
		for(int i=0; i<=N/5+1; i++){
			for(int j=0; j<=N/3+1; j++){
				if(5*i+3*j==N){
					list.add(i+j);
				}
			}
		}
		Collections.sort(list);
		if(list.isEmpty()){
			System.out.println(-1);
		}else {
			System.out.println(list.get(0));
		}
		
		
	}
}