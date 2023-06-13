import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		int count = 0;
		while(s.length()>1){
			count++;
			char[] ch = s.toCharArray();
			int sum = 0;
			for(int i=0; i<ch.length; i++){
				sum += ch[i]-'0';
			}
			s = sum+"";
		}
		System.out.println(count);
		if(Integer.parseInt(s)%3==0){
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}
}