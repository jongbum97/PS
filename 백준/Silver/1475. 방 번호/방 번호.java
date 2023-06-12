import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] ch = sc.next().toCharArray();
		int[] nums = new int[10];
		for(int i=0; i<ch.length; i++){
			nums[ch[i]-'0']++;
		}
		int max = 0;
		for(int i=0; i<10; i++){
			if((i!=6 && i!=9) && nums[i]>max){
				max = nums[i];
			}
		}
		
		if(max*2<(nums[6]+nums[9])){
			if((nums[6]+nums[9])%2==0){
				max = (nums[6]+nums[9])/2;
			}else {
				max = (nums[6]+nums[9])/2+1;
			}
		}
		System.out.println(max);
	}
}