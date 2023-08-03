import java.util.*;
import java.io.*;

public class Main {

	static int S, P, ACGT[], count[], ans;
	static char[] pass;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		pass = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		ACGT = new int[4];
		for (int i = 0; i < 4; i++) {
			ACGT[i] = Integer.parseInt(st.nextToken());
		}
		count = new int[4];
		for (int i = 0; i < P; i++) {
			switch (pass[i]) {
			case 'A':
				count[0]++;
				break;
			case 'C':
				count[1]++;
				break;
			case 'G':
				count[2]++;
				break;
			default:
				count[3]++;
				break;
			}
		}
		if (ACGT[0]<=count[0]&&ACGT[1]<=count[1]&&ACGT[2]<=count[2]&&ACGT[3]<=count[3]) {
			ans++;
		}
		outer : for (int i = 1; i <= S - P; i++) {
			int a = 0;
			switch (pass[i-1]) {
			case 'A':
				a = 0;
				break;
			case 'C':
				a = 1;
				break;
			case 'G':
				a = 2;
				break;
			default:
				a = 3;
				break;
			}
			count[a]--;
			switch (pass[i+P-1]) {
			case 'A':
				a = 0;
				break;
			case 'C':
				a = 1;
				break;
			case 'G':
				a = 2;
				break;
			default:
				a = 3;
				break;
			}
			count[a]++;
			for (int j = 0; j < 4; j++) {
				if (ACGT[j]>count[j]) {
					continue outer;
				}
			}
			ans++;
		}
		System.out.println(ans);

	}

}
