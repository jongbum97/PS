import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		str = str.replaceAll("XXXX", "AAAA");
		str = str.replaceAll("XX", "BB");
		boolean ans = true;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i)!='A' && str.charAt(i)!='.' && str.charAt(i)!='B'){
				ans = false;
			}
		}
		
		if(ans){
			System.out.println(str);
		}else {
			System.out.println(-1);
		}
		
	}
}