import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++){
			
			int[] start = new int[2];
			int[] arrive = new int[2];
			for(int i=0; i<2; i++){
				start[i] = sc.nextInt();
			}
			for(int i=0; i<2; i++){
				arrive[i] = sc.nextInt();
			}
			int n = sc.nextInt();
			int[][] planets = new int[n][3];
			for(int i=0; i<n; i++){
				for(int j=0; j<3; j++){
					planets[i][j] = sc.nextInt();
				}
			}
			
			//풀이 시작
			
			int circle = 0;
			for(int i=0; i<n; i++){
				if(dis(start[0], start[1], planets[i][0], planets[i][1], planets[i][2])){
					if(dis(arrive[0], arrive[1], planets[i][0], planets[i][1], planets[i][2])){
						
					}else {
						circle++;
					}
				}else {
					if(dis(arrive[0], arrive[1], planets[i][0], planets[i][1], planets[i][2])){
						circle++;
					}
				}
			}
			
			System.out.println(circle);
		}
		
		
		
	}
	
	
	static boolean dis(int x, int y, int a, int b, int r) {
		if(((x-a)*(x-a)+(y-b)*(y-b))<(r*r)){
			return true;
		}
		return false;
		
	}
}
