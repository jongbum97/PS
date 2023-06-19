import java.util.*;

public class Main {
	
	static char[] king = new char[2];
	static char[] stone = new char[2];
	static String[] direction = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};
	static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
	static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ki = sc.next();
		king[0] = ki.charAt(0);
		king[1] = ki.charAt(1);
		String st = sc.next();
		stone[0] = st.charAt(0);
		stone[1] = st.charAt(1);
		
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++){
			String s = sc.next();
			move(s);
		}
		
		System.out.println(king[0]+""+king[1]);
		System.out.println(stone[0]+""+stone[1]);
		
	}
	
	
	static void move(String s) {
		
		int i;
		for(i=0; i<8; i++){
			if(s.equals(direction[i])){
				king[0] += dx[i];
				king[1] += dy[i];
				break;
			}
		}
		
		if(king[0]<'A' || king[0]>'H' || king[1]<'1' || king[1]>'8'){
			king[0] -= dx[i];
			king[1] -= dy[i];
		}
		if(king[0]==stone[0] && king[1]==stone[1]){
			stone[0] += dx[i];
			stone[1] += dy[i];
		}
		if(stone[0]<'A' || stone[0]>'H' || stone[1]<'1' || stone[1]>'8'){
			stone[0] -= dx[i];
			stone[1] -= dy[i];
			king[0] -= dx[i];
			king[1] -= dy[i];
		}
		
		
	}
	
}