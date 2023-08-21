import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		// 버튼마다 시간 설정
		int[] button = {300, 60, 10};
		int ans[] = new int[3];
		
		// 10의 배수가 아니면 불가능하므로 바로 -1 출력
		if(T%10!=0) {
			bw.write(-1+"\n");
		}else {
			// 버튼마다 몫을 추가하고 나눠버림
			for (int i = 0; i < 3; i++) {
				ans[i] = T/button[i];
				T %= button[i];
				bw.write(ans[i]+" ");
			}
		}
		
		bw.close();
		
	}
}
