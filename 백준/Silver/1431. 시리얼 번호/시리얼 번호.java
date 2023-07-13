import java.util.*;

public class Main {
	
	static String[] words;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = sc.next();
		}
		
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < N-i-1; j++) {
				if (words[j].length()>words[j+1].length()) {
					change(j, j+1);
				}else if(words[j].length()==words[j+1].length()){
					int a = 0;
					int b = 0;
					for (int k = 0; k < words[j].length(); k++) {
						if (words[j].charAt(k)>='0' && words[j].charAt(k)<='9') {
							a += words[j].charAt(k)-'0';
						}
					}
					for (int k = 0; k < words[j+1].length(); k++) {
						if (words[j+1].charAt(k)>='0' && words[j+1].charAt(k)<='9') {
							b += words[j+1].charAt(k)-'0';
						}
					}
					if (a>b) {
						change(j, j+1);
					}else if(a==b) {
						String[] tmp = new String[2];
						tmp[0] = words[j];
						tmp[1] = words[j+1];
						Arrays.sort(tmp);
						if (!tmp[0].equals(words[j])) {
							change(j, j+1);
						}
					}
				}
			}
		}
		
		for (String s : words) {
			System.out.println(s);
		}
		
		
	}
	
	static void change(int i, int j) {
		String tmp = words[i];
		words[i] = words[j];
		words[j] = tmp;
	}
	
}
