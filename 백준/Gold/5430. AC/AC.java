import java.io.*;
import java.util.*;

public class Main {

	static int T, N, list[];
	static char function[];
	static boolean isReverse;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++){
			function = br.readLine().toCharArray();
			N = Integer.parseInt(br.readLine());
			list = new int[N];
			isReverse = false;
			int frontCnt = 0, backCnt = 0;

			String[] tmp = br.readLine().replace("[","").replace("]","").split(",");
			for (int i=0; i<N; i++) {
				list[i] = Integer.parseInt(tmp[i]);
			}

			for (int i=0; i<function.length; i++){
				if (function[i] == 'R'){
					isReverse = !isReverse;
				} else if (function[i] == 'D') {
					if(isReverse){
						backCnt++;
					}else {
						frontCnt++;
					}
				}
			}
			if(backCnt + frontCnt > N){
				sb.append("error").append("\n");
				continue;
			}
			sb.append("[");
			if(isReverse){
				for(int n=list.length-backCnt-1; n>=frontCnt; n--){
					sb.append(list[n]);
					if(n != frontCnt) sb.append(",");
				}
			}else {
				for(int n=frontCnt; n<list.length-backCnt; n++){
					sb.append(list[n]);
					if(n != list.length-backCnt-1) sb.append(",");
				}
			}
			sb.append("]").append("\n");

		}

		System.out.println(sb.toString());

		
	}
	



	

}
