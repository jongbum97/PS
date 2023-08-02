import java.io.*;
import java.util.*;

public class Main {

	static int L, C, K=1, cnt;
	static char[] mo;
	static char[][] password;
	
    public static void main(String[] args) throws Exception {
       
    	Scanner sc = new Scanner(System.in);
    	
    	L = sc.nextInt();
    	C = sc.nextInt();
    	sc.nextLine();
    	mo = sc.nextLine().replace(" ", "").toCharArray();
    	K=1000;
//    	for (int i = C; i > C-L; i--) {
//			K *= i;
//		}
//    	for (int i = 1; i <= L; i++) {
//			K /= i;
//		}
    	password = new char[K][];
    	pass(0, 0, new char[L]);
    	String[] ans = new String[cnt];
    	for (int i = 0; i < cnt; i++) {
    		StringBuilder sb = new StringBuilder();
    		for (int j = 0; j < L; j++) {
				sb.append(password[i][j]);
			}
    		ans[i] = sb.toString();
		}
    	Arrays.sort(ans);
    	for (String string : ans) {
			System.out.println(string);
		}
    }
    
    static void pass(int n, int k, char[] pp) {
    	
    	if (n==L) {
    		if (check(pp)) {
    			char[] ppp = pp.clone();
    			Arrays.sort(ppp);
    			password[cnt++] = ppp;
			}
			return;
		}
    	
    	for (int i = k; i < C; i++) {
			pp[n] = mo[i];
			pass(n+1, i+1, pp);
		}
    	
    }
    
    static boolean check(char[] p) {
    	int a = 0;
    	int b = 0;
    	for (int i = 0; i < p.length; i++) {
			if (p[i]=='a' || p[i]=='e' || p[i]=='i' || p[i]=='o' || p[i]=='u') {
				a++;
			}else {
				b++;
			}
			if (a>0 && b>1) {
				return true;
			}
		}
    	return false;
    }
    


}