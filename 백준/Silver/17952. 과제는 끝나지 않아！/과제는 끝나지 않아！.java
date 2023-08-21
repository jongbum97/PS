import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] work = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())==0) continue;
			work[i][0] = Integer.parseInt(st.nextToken());
			work[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 작업을 저장하고 꺼내올 스택을 생성.
		Stack<int[]> workspace = new Stack<>();
		
		int ans = 0;
		int t = 0;
		
		// 시간별로 업무 실행
		while (t<N) {
			
			// 만약 추가된 업무가 없다면
			if(work[t][0]==0) {
				
				//가장 최근에 하던 업무를 가져와서 하고
				if (!workspace.isEmpty()) {
					int[] tmp = workspace.pop();
					tmp[1]--;
					// 업무가 완료되면 점수를 획득하고, 아니면 작업을 저장한다.
					if(tmp[1]==0) {
						ans += tmp[0];
					}else {
						workspace.add(tmp);
					}
				}else {
					t++;
					continue;
				}
				
				// 추가된 업무가 있다면
			}else {
				// 그 업무를 하고
				work[t][1]--;
				
				// 완료되었으면 점수를 획득하고, 아니면 작업을 저장한다.
				if(work[t][1]==0) {
					ans += work[t][0];
				}else {
					workspace.add(work[t]);
				}
			}
			t++;
		}
		
		bw.write(ans+"\n");
		
		bw.close();
		
	}
}
