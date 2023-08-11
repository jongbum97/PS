import java.io.*;
import java.util.*;

public class Main {
	
	static int N, ans;
	static List<Integer> pn = new ArrayList<>();
	static List<Integer> mn = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a<=0) {
				mn.add(a);
			}else {
				pn.add(a);
			}
		}
		
		Collections.sort(mn);
		Collections.sort(pn,Collections.reverseOrder());
		
		for (int i = 0; i < mn.size(); i+=2) {
			if (mn.size()==i+1) {
				ans += mn.get(i);
			}else {
				ans += mn.get(i)*mn.get(i+1);
			}
		}
		for (int i = 0; i < pn.size(); i+=2) {
			if (pn.size()==i+1) {
				ans += pn.get(i);
			}else {
				ans += Math.max(pn.get(i)+pn.get(i+1), pn.get(i)*pn.get(i+1));
			}
		}
		
		
		System.out.println(ans);
		
	}

}