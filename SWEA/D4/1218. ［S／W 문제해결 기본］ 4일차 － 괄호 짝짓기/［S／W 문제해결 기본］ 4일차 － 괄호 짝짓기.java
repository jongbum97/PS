import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int tc = 1; tc <= 10; tc++) {
			int ans = 1;
			Stack<Character> stack = new Stack<>();
			int N = Integer.parseInt(br.readLine());
			char[] c = br.readLine().toCharArray();
			for (int i = 0; i < N; i++) {
				if (check(c[i])<10) {
					stack.add(c[i]);
				}else {
					if (check(stack.pop())*10 != check(c[i])) {
						ans = 0;
						break;
					}
				}
			}

			bw.write("#" + tc+" "+ans+"\n");
		}

		bw.close();

	}

	static int check(char c) {
		switch (c) {
		case '(':
			return 1;
		case '[':
			return 2;
		case '{':
			return 3;
		case '<':
			return 4;
		case ')':
			return 10;
		case ']':
			return 20;
		case '}':
			return 30;
		case '>':
			return 40;
		}
		return -1;
	}


}