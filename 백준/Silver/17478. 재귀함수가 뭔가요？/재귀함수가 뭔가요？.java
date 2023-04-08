import java.util.*;

public class Main {

	static String[] str = new String[4];
	static String[] str2 = new String[2];
	static {
		str[0] = "\"재귀함수가 뭔가요?\"";
		str[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		str[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		str[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		str2[0] = "\"재귀함수가 뭔가요?\"";
		str2[1] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
	}
	static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		professor(0);
		System.out.println("라고 답변하였지.");
	}

	static void professor(int k) {

		if (k == N) {
			for (int i = 0; i < 2; i++) {

				for (int j = 0; j < k; j++) {
					System.out.print("____");
				}
				System.out.println(str2[i]);
			}
			return;
		}
		
		
		for(int i=0; i<4; i++){
			for(int j=0; j<k ; j++){
				System.out.print("____");
			}
			System.out.println(str[i]);
		}
		
		professor(k+1);
		
		for(int i=0; i<k+1; i++){
			System.out.print("____");
		}
		System.out.println("라고 답변하였지.");
		
		
		

	}
}
