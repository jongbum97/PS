import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N+1];
        nums[1] = 0;
        
        for(int i=2; i<=N; i++) {
            nums[i] = nums[i-1] + 1;
            if(i%2==0) {
                nums[i] = Math.min(nums[i], nums[i/2] + 1);
            }
            if(i%3==0) {
                nums[i] = Math.min(nums[i], nums[i/3] + 1);
            }
        }
        
        System.out.println(nums[N]);
    }
}